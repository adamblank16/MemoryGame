package MemoryGame.controller;
import MemoryGame.model.*;

public interface MemoryUserInterface
{
  public void showFace(int c); //image side
  public void showBack(int c); //back of card
  public boolean playAgain();
  public void disableButtons(int c);
  public void enableButtons(int c);
  public void closeFrame();

}
