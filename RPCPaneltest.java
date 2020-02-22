
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.Random;


public class RPCPaneltest extends JPanel 
{
	private JButton Rock, Paper, Scissor, Reset;
	private JLabel label, label1, label2, label3, label4, label5, label6;
	private JPanel buttonPanel, choicePanel1, choicePanel2, outcomePanel;
	private JPanel pwinsPanel, cwinsPanel, tiesPanel, Computer, Player, Tie;
	
	
   //--------------------------------------------------------------------------------------------------------------------------
   // Constructor Sets up the GUI
   //------------------------------------------------------------------------------------------------------------------------- 

   public RPCPaneltest ()
	{
		//----------------------------------------------- 
		// Sets up Buttons on JPanel
		//----------------------------------------------- 
		
		Rock = new JButton ("Rock");			
		Paper = new JButton ("Paper");
		Scissor = new JButton ("Scissor");
		Reset = new JButton ("Reset Scoreboard");
		
		
		//----------------------------------------------- 
		// Sets up Listeners for Buttons
		//-----------------------------------------------		 
		
		ButtonListener listener = new ButtonListener();
		Rock.addActionListener (listener);
		Paper.addActionListener (listener);
		Scissor.addActionListener (listener);
	    Reset.addActionListener (listener);
	  
		
		//----------------------------------------------- 
		// Sets up Rock Paper Scissor Buttons
		//-----------------------------------------------
		
		label = new JLabel ("Make Your Selection ");
		label.setBackground(Color.white);
	   
		 // RPC Button Panel
		buttonPanel = new JPanel ();
		buttonPanel.setPreferredSize (new Dimension(390,40));
		buttonPanel.setBackground (Color.LIGHT_GRAY );
		buttonPanel.add (Rock);
		buttonPanel.add (Paper);
		buttonPanel.add (Scissor);
		
		 // Player Choice Panel
		label1 = new JLabel ("");
		choicePanel1 = new JPanel();
		choicePanel1.setPreferredSize (new Dimension(192,100));
		choicePanel1.setBackground (Color.gray);
		JLabel labelPC = new JLabel ("Player's Choice");
		choicePanel1.add (labelPC);
		choicePanel1.add (label1);
		label1.setFont (new Font("Arial", Font.BOLD, 16));
				
		// Computer Choice Panel
		label2 = new JLabel ("");
		choicePanel2 = new JPanel();
		choicePanel2.setPreferredSize (new Dimension(193,100));
		choicePanel2.setBackground (Color.gray);		
		JLabel labelCC = new JLabel ("Computer's Choice");
		choicePanel2.add (labelCC);
		choicePanel2.add (label2);
		label2.setFont (new Font("Arial", Font.BOLD, 16));
		 
		// Outcome Panel
		label3 = new JLabel ("");
		outcomePanel = new JPanel();
		outcomePanel.setPreferredSize (new Dimension(390,30));
		outcomePanel.setBackground (Color.LIGHT_GRAY);		
		//JLabel labelResult = new JLabel ("No Results");
		outcomePanel.add (label3);
		label3.setFont (new Font("Arial", Font.BOLD, 16));
		
		// Player Wins Panel
		label4 = new JLabel ("");
		pwinsPanel = new JPanel();
		pwinsPanel.setPreferredSize (new Dimension(126,60));
		pwinsPanel.setBackground (Color.white);		
		JLabel labelPW = new JLabel ("Player Wins");
		pwinsPanel.add (labelPW);
		pwinsPanel.add (label4);
		
		// Computer Wins Panel
		label5 = new JLabel ("");
		cwinsPanel = new JPanel();
		cwinsPanel.setPreferredSize (new Dimension(126,60));
		cwinsPanel.setBackground (Color.white);		
		JLabel labelCW = new JLabel ("Computer Wins");
		cwinsPanel.add (labelCW);
		cwinsPanel.add (label5);
		
		// Ties Panel
		label6 = new JLabel ("");
		tiesPanel = new JPanel();
		tiesPanel.setPreferredSize (new Dimension(127,60));
		tiesPanel.setBackground (Color.white);		
		JLabel labelTie = new JLabel ("Ties\n\n");
		tiesPanel.add (labelTie);
		tiesPanel.add (label6);
		
		// Default Panel
		setPreferredSize (new Dimension(400, 305));
		setBackground (Color.black);
		add (label);
		add (buttonPanel);
		add (choicePanel1);
		add (choicePanel2);
		add (outcomePanel);
		add (pwinsPanel);
		add (cwinsPanel);
		add (tiesPanel);		
		add (Reset);
		
		
	}
	
   //------------------------------------------------------------------------------------------------------------------------- 
   // Represents a Listener for RPC Buttons
   //------------------------------------------------------------------------------------------------------------------------- 
	
   public class ButtonListener implements ActionListener , KeyListener
   {
	  //----------------------------------------------- 
	  // Determines which button was pushed and outputs text accordingly
	  //----------------------------------------------- 
	  Random generate= new Random();
	  int Computer=0, Player=0, Tie=0, compic, playpic;
	  
	  public void actionPerformed (ActionEvent event)
	  {
		   compic=generate.nextInt(3)+1; 
			if( event.getSource() == Reset ){
				Player = 0 ;
				Tie = 0 ;
				Computer = 0 ;
				compic = 0 ;
			}
	   
		  // Computer Choice
		  if (compic== 1)
			label2.setText("					Rock				   ");
		  else  if ( compic== 2)
			label2.setText("					Paper					");
		  else if( compic == 3 )
			label2.setText("				  Scissor					");
		  
		   
					 
		 // Player Choice   
		  if (event.getSource () == Rock)
			  label1.setText("					Rock				   ");
		  else if (event.getSource () == Paper)
			  label1.setText("					Paper					");	
		  else 
			  label1.setText("				  Scissor					");
			  
		   if (event.getSource () == Rock)
			  playpic = 1;
		  else if (event.getSource () == Paper)
			  playpic = 2;	
		  else 
			  playpic = 3;
		  
			  
					
		 
	
   //------------------------------------------------------------------------------------------------------------------------- 
   // Compares Computer and Players choice 
   //------------------------------------------------------------------------------------------------------------------------- 
		
		   switch (playpic)
				{
					case 1:
					{ 
						if (compic==2)
						{
							label3.setText ("Paper covers Rock - computer wins");
							Computer++;
						 }
						else if (compic==3)
						{ 
							 label3.setText  ("Rock breaks Scissors - player wins");
							Player++;
						 }
						 else 
						 {
							 label3.setText  ("Tie");
							 Tie++;
						  }
						break;
					}
				   
					case 2:
					{
						if (compic==1)
						{
							 label3.setText  ("Paper covers Rock - player wins");
							Player++;
						 }
						else if (compic==3)
						{ 
							 label3.setText  ("Scissors cut Paper - computer wins");
							Computer++;
						 }   
						 else 
						 { 
							 label3.setText  ("Tie");
							Tie++;
						 }
						break;
					}
					case 3:
					{
						if (compic==1)
						{
							 label3.setText  ("Rock breaks Scissors - computer wins");
							Computer++;
						 }
						else if (compic==2)
						{ 
							 label3.setText  ("Scissors cuts Paper - player wins");
							Player++;
						} 
						else 
						{
							label3.setText  ("Tie");
							Tie++;
					 }
						break;

				  }
			}
			label4.setText("Player: " + Player);
			label5.setText("Computer: " + Computer);
			label6.setText("\nTie: "+ Tie);
			
		}
		public void keyPressed(KeyEvent e){
	
		}
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
}
}


