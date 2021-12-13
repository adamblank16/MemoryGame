package MemoryGame.view;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class StartScreen extends JPanel
{
    private JPanel menu;
    private JPanel mainPanel;
    private JLabel pic;
    public JFrame mainFrame;
    private StartButton easy;
    private StartButton medium;
    private StartButton hard;
    private StartButton rules;
    private JPanel modes;
    private JLabel leaderBoard;

    public StartScreen() throws IOException
    {
		mainFrame = new JFrame("Memory Game");
        mainFrame.setPreferredSize(new Dimension(400, 600));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        layout.setVgap(50);
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(80, 109, 132));
        mainPanel.setLayout(layout);

		this.menu = new JPanel();
		menu.setBackground(new Color(80, 109, 132));
		menu.setOpaque(true);
		menu.setLayout(new GridLayout(2,1));


		JLabel titleLabel = new JLabel("Holiday Memories", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        menu.add(titleLabel);

       // Image holidayPic = ImageIO.read(new File("HALLOWTHANKSMAS.jpg"));
        URL resource = this.getClass().getClassLoader().getResource("HALLOWTHANKSMAS.jpg");
        Image holidayPic = ImageIO.read(resource);
        holidayPic = holidayPic.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        pic = new JLabel(new ImageIcon(holidayPic));
        menu.add(pic);

        this.modes = new JPanel();
        modes.setBackground(new Color(80, 109, 132));
        modes.setOpaque(true);

        easy = new StartButton(1,"Easy", this);
        modes.add(easy);
        medium = new StartButton(2, "Medium", this);
        modes.add(medium);
        hard = new StartButton(3, "Hard", this);
        modes.add(hard);


        rules = new StartButton(4, "Rules", this);

        mainPanel.add(menu, BorderLayout.PAGE_START);
        mainPanel.add(modes, BorderLayout.CENTER);
        mainPanel.add(rules, BorderLayout.PAGE_END);

        mainFrame.add(mainPanel);
        mainFrame.pack();

        mainFrame.setVisible(true);
       // this.add(menu, BorderLayout.NORTH);



	}
}
