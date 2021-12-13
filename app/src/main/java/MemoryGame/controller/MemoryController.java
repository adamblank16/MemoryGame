package MemoryGame.controller;
import MemoryGame.model.*;
import MemoryGame.view.*;

import java.util.*;
import java.util.Timer;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.nio.file.*;


public class MemoryController
{

  public Board board;
  private StartScreen menu;
  protected MemoryUserInterface userInterface;
  private Mode mode;
  private int level;


  public MemoryController(MemoryUserInterface ui)
  {
    //this.board = b;
    this.userInterface = ui;
    //System.out.println("MemoryController Constructor");
  }
  
  
  public void startNewGame(int level, Mode m)
  {
	//create board and shuffle 
    this.board = new Board(level, this);
    this.mode = m;
    this.level = level;
    board.shuffle();
    mode.Level(level, board);
    System.out.println("New Game Mode started");
  }

  public void onFlipCard(int buttonID) // this will change the button in the view part
  {
    // use a showFace method in interface

	userInterface.showFace(buttonID);
	userInterface.showFace(buttonID);

   
  }
  
  
  
  public void onCompare(int c1, int c2, int c1ID, int c2ID)
  {
	final Timer timer = new Timer();
			timer.schedule(new TimerTask(){
				@Override
				public void run(){
	
					if ( c1 != c2 )
					{
						userInterface.showBack(c1ID);
						userInterface.showBack(c2ID);
						board.AttemptCounter++;//attempts counter
						//System.out.println("c1 "+c1+"!= c2 " + c2);
					}
					else if(c1 == c2 && c1ID != c2ID) // this counts attempt
					{
						//System.out.println("c1 "+c1+"= c2 " + c2);
						board.AttemptCounter++;//attempts counter
						onMatch(c1ID, c2ID);
					}
					else{//this allows for the double click of the card not to be counted as an attempt
						onFlipCard(c1ID);
						board.pressCounter = 1;
					}
					timer.cancel();
				}
			}, 500);
	  
  }

  public void onMatch(int c1ID, int c2ID)
  {
	  board.numMatches--;
	  userInterface.disableButtons(c1ID);
	  userInterface.disableButtons(c2ID);
	  if (board.numMatches == 0){
		  this.onEndGame();
	  }

  }



  public void onEndGame()
  {
	  // when game knows that all pairs have been found
	  // call .playAgain() method -- has # of attempts and play again option
	  boolean playAgain = userInterface.playAgain();
	  if(board.AttemptCounter < mode.highScore){
		 switch(level){
			 case 1: 
				  try{
						URL readScore = this.getClass().getClassLoader().getResource("easyBestAttempt.txt");
						String path = readScore.getPath();
						BufferedWriter f_writer = new BufferedWriter(new FileWriter(path));
						f_writer.write(String.valueOf(board.AttemptCounter));
						f_writer.flush();
						f_writer.close();

					}
					catch(Exception e){};
					break;
			case 2:
				try{
						URL readScore = this.getClass().getClassLoader().getResource("mediumBestAttempt.txt");
						String path = readScore.getPath();
						BufferedWriter f_writer = new BufferedWriter(new FileWriter(path));
						f_writer.write(String.valueOf(board.AttemptCounter));
						f_writer.flush();
						f_writer.close();

					}
					catch(Exception e){};
					break;	
			case 3:
				try{
						URL readScore = this.getClass().getClassLoader().getResource("hardBestAttempt.txt");
						String path = readScore.getPath();
						BufferedWriter f_writer = new BufferedWriter(new FileWriter(path));
						f_writer.write(String.valueOf(board.AttemptCounter));
						f_writer.flush();
						f_writer.close();

					}
					catch(Exception e){};
					break;
				}
	  }
	  if(playAgain){
		 mode.mainFrame.dispatchEvent(new WindowEvent(mode.mainFrame, WindowEvent.WINDOW_CLOSING));
		 try{
			menu = new StartScreen();
		 }
		 catch(Exception e){}
	  }
	  else if(!playAgain){
		  userInterface.closeFrame();
	  }
	  
  }



}//end MemoryController
