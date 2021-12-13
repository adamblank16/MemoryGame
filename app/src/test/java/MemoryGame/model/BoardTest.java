// Test Cases for Board class in model


import MemoryGame.model.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.*;

public class BoardTest
{

  private Board board;

  @After
  public void tearDown()
  {
    board = null;
  }

  @Test
  public void boardEasy()
  {
    board = new Board(1); //Easy
    int easyCardSize = board.cards.size();
    assertEquals("Should have been 12 cards in Easy Mode", 12, easyCardSize);
  }


  @Test
  public void boardMed()
  {
    board = new Board(2); //Medium
    int medCardSize = board.cards.size();
    assertEquals("Should have been 16 cards in Easy Mode", 16, medCardSize);
  }

  @Test
  public void boardHard()
  {
    board = new Board(3); //Hard
    int hardCardSize = board.cards.size();
    assertEquals("Should have been 20 cards in Easy Mode", 20, hardCardSize);
  }


  @Test
  public void selectedCardTestC1()
  {
    board = new Board(1); //testing with east
    board.pressCounter++;
    board.selectedCard(3);
    assertEquals("C1 should be 2", 2, board.c1);
  }

  @Test
  public void selectedCardTestC2()
  {
    board = new Board(1); //testing with east
    board.pressCounter++;
    board.selectedCard(3);
    board.pressCounter++;
    board.selectedCard(4);
    assertEquals("C2 should be 3", 3, board.c2);
  }


  @Test
  public void pressCounterResetTest()
  {
    board = new Board(1); //testing with east
    board.pressCounter++;
    board.pressCounter++;
    board.selectedCard(3);
    assertEquals("press counter should have been reset", 0, board.pressCounter);
  }
}//end BoardTest
