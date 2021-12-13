package MemoryGame.view;

import MemoryGame.controller.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class StartButton extends JButton implements ActionListener
{
	private int buttonNumber;
	public boolean flag = false;
	private StartScreen menu;
    public StartButton(int buttonNumber, String s, StartScreen m)
    {
        super(s);
        this.buttonNumber = buttonNumber;
        this.menu =m;
        addActionListener(this);
	}

	@Override
    public void actionPerformed(ActionEvent e)
    {
        if (this.buttonNumber == 1){
			menu.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			menu.mainFrame.dispatchEvent(new WindowEvent(menu.mainFrame, WindowEvent.WINDOW_CLOSING));
			menu.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("opening easy mode");
			Mode easy = new Mode();
			MemoryUserInterface ui = easy;
			MemoryController controller = new MemoryController(ui);
			controller.startNewGame(1, easy);
			final Timer timer = new Timer();
			timer.schedule(new TimerTask(){
				@Override
				public void run(){//had to source the internet for help with this https://www.youtube.com/watch?v=hhnkP2bR5EI minute 5:30
					//flip for 10 second
					for (CardButton button : easy.ButtonList)
					{
						button.setFront();
					}
					timer.cancel();
				}
			}, 4000);
		} 
		else if (this.buttonNumber == 2){

			menu.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			menu.mainFrame.dispatchEvent(new WindowEvent(menu.mainFrame, WindowEvent.WINDOW_CLOSING));
			menu.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("opening medium mode");
			Mode medium = new Mode();
			MemoryUserInterface ui = medium;
			MemoryController controller = new MemoryController(ui);
			controller.startNewGame(2, medium);
			final Timer timer = new Timer();
			timer.schedule(new TimerTask(){
				@Override
				public void run(){//had to source the internet for help with this https://www.youtube.com/watch?v=hhnkP2bR5EI minute 5:30
					//flip for 10 second
					for (CardButton button : medium.ButtonList)
					{
						button.setFront();
					}
					timer.cancel();
				}
			}, 3000);
		}
		else if (this.buttonNumber == 3) {
			menu.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			menu.mainFrame.dispatchEvent(new WindowEvent(menu.mainFrame, WindowEvent.WINDOW_CLOSING));
			menu.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("opening hard mode");
			Mode hard = new Mode();
			MemoryUserInterface ui = hard;
			MemoryController controller = new MemoryController(ui);
			controller.startNewGame(3, hard);
			final Timer timer = new Timer();
			timer.schedule(new TimerTask(){
				@Override
				public void run(){//had to source the internet for help with this https://www.youtube.com/watch?v=hhnkP2bR5EI minute 5:30
					//flip for 10 second
					for (CardButton button : hard.ButtonList)
					{
						button.setFront();
					}
					timer.cancel();
				}
			}, 4000);
		}
		else if (this.buttonNumber == 4) {
			Mode rulesPage = new Mode();
			rulesPage.createRuleFrame();
			System.out.println("opening rules text box");
		}
    }
    }
