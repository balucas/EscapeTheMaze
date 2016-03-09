
/**
 * @author 		Bernard Lucas & Harsh Patel
 * @date		June 11th 2014
 * @filename	FinalInstructions.java
 * @description	Instructions class; creates frame, panels, label textarea and button
 * 				provides user instructions on how to play the game
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalInstructions extends JFrame implements ActionListener {

	
	JButton button;												//declaring the start button(JButton) as 'button'
	JFrame frame;												//declaring the JFrame as 'frame'
	
	//Main Method
	public static void main (String[] args){	
		//Calls the constructor made
		new FinalInstructions();
		
	}
//Constructor the FinalInstructions() class
	FinalInstructions() {
		//For the Frame
		frame = new JFrame("Instructions");						//Creating the frame
		frame.setSize(500,450);									//Setting the size of the frame at 500 pixels across and 450 pixels in height
		frame.setLocation(300,50);								//Setting the location of the frame at 300 across and 50 down								
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Closes the frame if clicked the 'x' button at the top right
		  
		//For the First Panel
		JPanel panel1 = new JPanel();							//Creating the first panel
		panel1.setSize(500,100);								//Setting the size of the first panel as 500 pixels across and 100 pixels in height 
		panel1.setLocation(0,0);								//Setting the location of the first panel at 0 across and 0 down (origin)
		panel1.setBackground(Color.black);						//Setting the color of the first panel as black
		
		//For the Second Panel
		JPanel panel2 = new JPanel();							//Creating the second panel
		panel2.setSize(500,250);								//Setting the size of the second panel as 500 pixels across and 250 pixels in height   
		panel2.setLocation(0,100);								//Setting the location of the second at 0 pixels across and 100 pixels down
		panel2.setBackground(Color.black);						//Setting the color of the second panel as black
		
		//For the Third Panel
		JPanel panel3 = new JPanel();							//Creating the third panel
		panel3.setSize(500,100);								//Setting the size of the third panel as 500 pixels across and 100 pixels in height 								
		panel3.setBackground(Color.black);						//Setting the color of the third panel as black
		
		//For the Fourth Panel
		JPanel panel4 = new JPanel();							//Creating the fourth panel
		panel4.setSize(500, 450);								//Setting the size of the fourth panel as 500 pixels across and 450 pixels in height 
		panel4.setBackground(Color.black);						//Setting the color of the fourth panel as black
		
		frame.add(panel1);										//Adding the first panel to the frame
		frame.add(panel2);										//Adding the second panel to the frame
		frame.add(panel3);										//Adding the third panel to the frame
		frame.add(panel4);										//Adding the fourth panel to the frame
		
		//For the label (On the first panel)	
		JLabel label = new JLabel("Instructions");				//Creating the label
		Font setfont = new Font("Agency FB", Font.BOLD, 45);	//Creating the font for the label
		label.setFont(setfont);									//Setting the created font to the label
		label.setForeground(Color.white);						//Setting the color of the text as white	
		
		
		//For the button (On the third panel)
		button = new JButton("START");							//Creating the button
		Font buttonfont = new Font("Courier New", Font.BOLD, 20);	//Creating the font
		button.setFont(buttonfont);								//Setting the created font to the button
		button.setBackground(Color.green);						//Setting the background color for the button as green						
		button.setForeground(Color.black);						//Setting the background color for the button as black
		button.setPreferredSize(new Dimension(100, 30));		//Setting the size of the button as 100 pixels across and 30 pixels in height 
		button.addActionListener(this);							//Adding the actionlistener to the button
		panel1.add(label);										//Adding the label to the first panel
		panel3.add(button);										//Adding the button to the third panel
		
		//For the panel of the button
		JPanel panelbutton = new JPanel();						//Creating the panel for the button 
		frame.add(panelbutton);									//Adding the panel to the frame
		panel3.setLocation(80,360);								//Setting the location of the panel as 80 pixels across and 360 pixels down
		panel3.setSize(600, 200);								//Setting the size of the panel as 600 pixels across and 200 pixels in height 
		panel3.setBackground(Color.black);						//Setting the color of the panel as black

		//For the textarea of Instructions
		JTextArea textarea = new JTextArea("The objective of the game is to get to the key which is located in the maze. " + 
		"The key can be anywhere in the mazeand you are to get to it using the arrow keys." + "There willbe obstacles such as " +
		"barriers, moving blocks and crackedblocks. You can move the moving blocks by pushing       against them and you can " 
		+ "break the cracked blocks by    moving into them. " + "Your objective is to get to the key bymoving the blocks and/or " +
		" breaking the blocks. At any   time if you are stuck you can reset by pressing the     spacebar.");
		textarea.setFont(new Font("Courier New", Font.BOLD, 14));//The font of the textarea
		textarea.setLineWrap(true); 							//Setting the linewrap true for the textarea
		textarea.setSize(450,200);								//Setting the size of the textarea as 450 pixels across and 200 pixels in height									
		textarea.setBackground(Color.black);					//Setting the background color of the textarea as black
		textarea.setForeground(Color.red);						//Setting the text color of the textarea in the color read
		textarea.setEditable(false);							//Not allowing the user to change the textarea
		panel2.add(textarea);									//adding the textarea to the second panel
		
			
		frame.setVisible(true);									//Setting the frame to be visible
	}

//Coding for adding ActionEvents on Buttons so that new Classes can be opened with the button
@Override
public void actionPerformed(ActionEvent e) {	//action is performed/created...
	if (e.getSource() == button) {				//If that action equals to the second button (Instructions) being pressed
		Main.makeLevel();						//opens the game class
		frame.setVisible(false);				//hides the frame for this class
	
	}
}
}
