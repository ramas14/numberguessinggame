package numberguessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class Starting extends JFrame {

	private JPanel thepanel;
	 private JButton StartGame;
	 private Game thegameframe;
	 private JTextArea welcome = new JTextArea("Welcome to the number guessing game.\nWhen you press the 'Start the game' button a random number is being generated.\n"
	 		+ "You have 30 seconds to guess the right number. Good luck!\n");
	
	 private Starting thisframe;
	
	 public  Starting()
	 {
		 thepanel = new JPanel();
		 StartGame = new JButton("Start the game");
		 welcome.setEditable(false);
		 welcome.setBackground(new Color(238, 238, 238, 238));
		 welcome.repaint();
		 thisframe = this;
		 thepanel.setLayout(new BoxLayout(thepanel, BoxLayout.PAGE_AXIS));
		 thepanel.add(welcome);
		 thepanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		 thepanel.add(StartGame);
		 thepanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
		 this.setContentPane(thepanel);
		  
		ButtonListener alistener = new ButtonListener();
		
		StartGame.addActionListener(alistener);
		 
		 this.setTitle("Number Guessing Game");
		 this.setSize(800,600);
		 this.setResizable(true);
		 this.setVisible(false);
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		 }

	 class ButtonListener implements ActionListener {

			@Override 
			public void actionPerformed(ActionEvent e1)
		{
				
				
				
				if(e1.getSource()==StartGame )
				{
					
					thegameframe = new Game(thisframe,- (int) System.currentTimeMillis() / 1000);
					thisframe.setVisible(false);
					thegameframe.setVisible(true);
					
					
				}
				
				
				
		}
	 }
		

}