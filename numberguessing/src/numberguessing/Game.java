package numberguessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game extends JFrame {

	 private JPanel thepanel;
	 private JButton InsertGuess;
	 private Starting starterframe;
	 private JTextField guessing = new JTextField(10);
	 private JLabel userguess = new JLabel("Your guessing: ");
	 private JLabel messageLabel =  new JLabel("");
	 private JLabel timeLabel;
	 private int randomnum =(int) Math.random()*2;
	 private int guess = randomnum+1;
	 private int gametimeleft= 30;
	 private Timer timer;
	 private Game gameframe = this;
	 
	 public  Game(Starting starter,int starttime)
	 {
		 
		 this.starterframe = starter;
		 thepanel = new JPanel();
		 timeLabel = new JLabel("Time left: " + gametimeleft + " seconds");
	     timeLabel.setBounds(20, 20, 200, 30);
	     thepanel.add(timeLabel);
	     messageLabel.setBounds(20, 100, 250, 30);
	     thepanel.add(messageLabel);
		 InsertGuess = new JButton("OK");
		 InsertGuess.setBounds(20, 60, 100, 30);
		 thepanel.add(userguess);
		 thepanel.add(guessing);
		 thepanel.add(InsertGuess);
		 this.setContentPane(thepanel);
		 ButtonListener alistener = new ButtonListener();
		 InsertGuess.addActionListener(alistener);
		 this.setTitle("Number Guessing Game");
		 this.setSize(800,500);
		 this.setResizable(false);
		 this.setVisible(false);
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 timer = new Timer(1000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	gametimeleft--;
	                timeLabel.setText("Time left: " + gametimeleft + " seconds");

	                if (gametimeleft <= 0) {
	                	gameframe.setVisible(false);
	                	gameframe.dispose();
						JOptionPane.showMessageDialog(null,"Your time is over you lost :( .\n");
						starterframe.setVisible(true);
						timer.stop();
	                }
	            }
	        });
	        timer.start();
		
		 }
	
	 
	 public static int getInputfromUser(String userguess) {
			int someguess = 0;
			      try {
			    	  someguess = Integer.parseInt(userguess);		          
			      }
			      catch (Exception e)
			      {
			    	  someguess=-1;
			      }
			     
			return someguess;
		}

	 class ButtonListener implements ActionListener {

			@Override 
			public void actionPerformed(ActionEvent e1)
		{
				
				if(e1.getSource()==InsertGuess )
				{
					guess = getInputfromUser(guessing.getText());
					if(guess!=-1) {
					if (guess == randomnum) {
						JOptionPane.showMessageDialog(null,"The random number was: "+randomnum+ "! Gongratulations you won!");
						gameframe.setVisible(false);
	                	gameframe.dispose();
	                	starterframe.setVisible(true);
						timer.stop();
						
					}
					else {
						JOptionPane.showMessageDialog(null,"That was not it :( . Try again!\n");
					}}
					else {
						guessing.setText("");
						 JOptionPane.showMessageDialog(null,"Your guess was not an integer number, please try again");
					}
				
				}
					
		}
		
	 }		
	
}