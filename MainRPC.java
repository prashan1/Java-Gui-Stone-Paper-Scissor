import javax.swing.JFrame;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.util.Scanner;

import java.util.Random;

 
 

public class MainRPC
{

   //-----------------------------------------------------------------

   //  Creates the main program frame.

   //-----------------------------------------------------------------

   public static void main (String[] args)

   {

     JFrame frame = new JFrame ("Rock, Paper, Scissor");
	 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	 frame.setBounds(10,10,1005,700);
	 frame.add(new RPCPaneltest());
	 frame.setResizable(false);
	 frame.pack();
     frame.setVisible(true);
 
   }
 
}
 
 
 
