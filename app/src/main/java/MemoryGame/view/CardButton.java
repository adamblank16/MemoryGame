package MemoryGame.view;
import MemoryGame.model.*;
import MemoryGame.controller.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CardButton extends JButton implements ActionListener
{
	public int buttonNumber;
	private int pressCounter = 0;
	public MemoryController controller;
	public Board board;
	private Icon front;
	private Icon face;
    public CardButton(int buttonNumber, Board b, Icon face, Icon front, MemoryController c, boolean enable)
    {
        super(face);
        this.front = front;
        this.face = face;
        this.buttonNumber = buttonNumber;
        this.board =b;
        this.controller = c;
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
	
		controller.pressCounter++;
		controller.selectedCard(this.buttonNumber); //buttonID 


			
	}
}
