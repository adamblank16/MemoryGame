package MemoryGame.view;
import MemoryGame.model.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CardButton extends JButton implements ActionListener
{
	public int buttonNumber;
	private int pressCounter = 0;
	public Board board;
	private Icon front;
	private Icon face;
    public CardButton(int buttonNumber, Board b, Icon face, Icon front, boolean enable)
    {
        super(face);
        this.front = front;
        this.face = face;
        this.buttonNumber = buttonNumber;
        this.board =b;
        setEnabled(enable);
        addActionListener(this);
	}
	public int getButtonNumber(){
		return this.buttonNumber;
	}
	public void setFace(){
		this.setIcon(this.face);
	}
	public void setFront(){
		this.setIcon(this.front);
	}
	
	@Override
    public void actionPerformed(ActionEvent e)
    {
	
		board.pressCounter++;
		board.selectedCard(this.buttonNumber); //buttonID 


			
	}
}
