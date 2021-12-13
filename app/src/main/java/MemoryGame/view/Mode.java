package MemoryGame.view;

import java.awt.event.*;
import MemoryGame.model.*;
import MemoryGame.controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.*;
import java.net.URL;

public class Mode extends JPanel implements MemoryUserInterface
{
	private JPanel mainPanel = new JPanel();
	private JPanel mainRulePanel;
	public JFrame mainFrame;
	private JFrame mainRuleFrame;
	private JPanel buttons = new JPanel();
	private JLabel title;
	private JLabel ruleTitle;
	private JLabel rulesText;
	private JLabel footer;
	private JLabel leaderBoard;
	private JLabel left;
	private JLabel right;
	private JTextArea field1;
	private CardButton card;
	public ArrayList<CardButton> ButtonList = new ArrayList<CardButton>();
	private CardFace face = new CardFace();
	private Dimension window;
	private int numButtons;
	private String mode;
	public Board board;
	public ArrayList<ImageIcon> cardFaces;
	public int highScore;


	public void Level(int level, Board board)
	{
		this.board = board;
		 switch (level){
			case 1: numButtons = 12;
					mode = "Easy";
					window = new Dimension(900,1100);
					cardFaces = face.HalloweenCards();
					try{
						URL readScore = this.getClass().getClassLoader().getResource("easyBestAttempt.txt"); // getting to this file
						String path = readScore.getPath(); // returns path of the file
						File score = new File(path); // new file -- using the file fond through path 
						Scanner sr = new Scanner(score); // scanning
						this.highScore = Integer.parseInt(sr.nextLine()); //parses the string argument as a signed decimal integer object
						System.out.println(highScore);
					}
					catch(Exception e){}
					break;
			case 2: numButtons = 16;
					mode = "Medium";
					window = new Dimension(900,1100);
					cardFaces = face.ThanksgivingCards();
					try{
						URL readScore = this.getClass().getClassLoader().getResource("mediumBestAttempt.txt");
						String path = readScore.getPath();
						File score = new File(path);
						Scanner sr = new Scanner(score);
						this.highScore = Integer.parseInt(sr.nextLine());
						System.out.println(highScore);
					}
					catch(Exception e){}
					break;
			case 3: numButtons = 20;
					mode = "Hard";
					window = new Dimension(1000,1100);
					cardFaces = face.ChristmasCards();
					try{
						URL readScore = this.getClass().getClassLoader().getResource("hardBestAttempt.txt");
						String path = readScore.getPath();
						File score = new File(path);
						Scanner sr = new Scanner(score);
						this.highScore = Integer.parseInt(sr.nextLine());
						System.out.println(highScore);
					}
					catch(Exception e){}
					break;

			case 4: numButtons = 0;
					mode = "Rules";
					createRuleFrame();
					break;
				}

		mainFrame = new JFrame("Memory Game - "+ mode);
        mainFrame.setPreferredSize(window);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        layout.setVgap(50);
        
        mainPanel.setBackground(new Color(80, 109, 132));
        mainPanel.setLayout(layout);

        title = new JLabel("Level: "+mode, SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 30));
        //title.setOpaque(true);
        title.setForeground(Color.WHITE);
        mainPanel.add(title, BorderLayout.PAGE_START);

        left = new JLabel("                  ");
        right = new JLabel("                 ");
       // sides.setOpaque(true);
        mainPanel.add(left, BorderLayout.LINE_START);
		mainPanel.add(right, BorderLayout.LINE_END);


		footer = new JLabel("Best Attempt: "+highScore, SwingConstants.CENTER); //the number will change later
		footer.setFont(new Font("Serif", Font.BOLD, 20));
		footer.setForeground(Color.WHITE);
		footer.setSize(500,500);
		//footer.setLocation(0,650);
		mainPanel.add(footer, BorderLayout.PAGE_END);

		GridLayout bLayout = new GridLayout(4,3);
		bLayout.setHgap(10);
		bLayout.setVgap(10);
		buttons.setLayout(bLayout);
		buttons.setOpaque(true);


		for (int i = 0; i <numButtons; i++)
		{
			int k = board.cards.get(i);
			card = new CardButton(i, board, cardFaces.get(k), face.frontCard, true);
			card.setBackground(new Color(212, 180, 153));
			card.setSize(10, 10);
			card.setOpaque(true);
			card.setBorderPainted(false);
			buttons.add(card);
			this.ButtonList.add(card);
		}


		mainPanel.add(buttons, BorderLayout.CENTER);

		mainFrame.add(mainPanel);
		mainFrame.pack();
        mainFrame.setVisible(true);


	}//end level
	
	// Rule Frame
	public void createRuleFrame()
	{
		mainRuleFrame = new JFrame("Welcome to the Rules Page");
		mainRuleFrame.setPreferredSize(new Dimension(400, 500));
		mainRuleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		layout.setVgap(50);
		mainRulePanel = new JPanel();
		mainRulePanel.setBackground(new Color(80,109,132));
		mainRulePanel.setLayout(layout);
		ruleTitle = new JLabel("Rules!", SwingConstants.CENTER);
		ruleTitle.setFont(new Font("Serif", Font.BOLD, 30));
		ruleTitle.setForeground(Color.WHITE);
		mainRulePanel.add(ruleTitle, BorderLayout.PAGE_START);
		field1 = new JTextArea(100,100);
		String text = ("Choose a difficulty level. You will be given a certain amount of time depending on the level to memorize the faced up cards. " +
			"Once all the cards flip back, you can click one card to flip and click a different card to match the first selected card. " +
			"Once all cards are matched, you can play again by choosing 'Yes' or exit the game by choosing'No'");
		field1.setText(text);
		field1.setLineWrap(true);
		field1.setBackground(new Color(80,109,132));
		field1.setFont(new Font("Serif", Font.BOLD, 13));
		field1.setForeground(Color.WHITE);
		mainRulePanel.add(field1);
		
		rulesText = new JLabel("Good Luck!", SwingConstants.CENTER);
		rulesText.setFont(new Font("Serif", Font.BOLD, 20));
		rulesText.setForeground(Color.WHITE);
		rulesText.setSize(500,500);
		mainRulePanel.add(rulesText, BorderLayout.PAGE_END);
		
		mainRuleFrame.add(mainRulePanel);
		mainRuleFrame.pack();
		mainRuleFrame.setVisible(true);

	}


	@Override
	public boolean playAgain()
	{
		int choice = JOptionPane.showConfirmDialog(mainFrame, "It Took You "+board.AttemptCounter+ " Attempts \nDo You Want To Play Again?", "Results", JOptionPane.YES_NO_OPTION);
       return choice == JOptionPane.YES_OPTION;
	}
	
	
	@Override
	public void showBack(int c)
	{
		for (CardButton button : ButtonList){
			if(c == button.getButtonNumber()){
				button.setFront();
			}
		}
	}
	
	
	@Override
	public void showFace(int c)
	{
		for (CardButton button : ButtonList){
			if(c == button.getButtonNumber()){
				button.setFace();
				button.revalidate();
				button.setVisible(true);
			}
		}
	}
	
	
	@Override
	public void disableButtons(int c)
	{
		for (CardButton button : ButtonList){
			if(c == button.getButtonNumber()){
				button.setEnabled(false);
				//System.out.println("disabled");
				
			}
		}
	}
	
	
	@Override
	public void enableButtons(int c){
		for (CardButton button : ButtonList){
			if(c == button.getButtonNumber()){
				button.setEnabled(true);
			}
		}
	}
	
	// No option
	@Override
	public void closeFrame(){
		this.mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
	}
}
