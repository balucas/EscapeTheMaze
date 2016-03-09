
/**
 * @author 		Bernard Lucas & Harsh Patel
 * @date		June 11th 2014
 * @filename	Menu.java
 * @description	class for main menu; creates frame, panels, labels buttons for main menu
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//The class of menu extends to the Frames (so it could be opened) and implements ActionListener (to open the frames)
public class Menu extends JFrame implements ActionListener {

	
	JButton button2;		//declaring the instructions button(button2) as 'button2'
	JButton button1;		//declaring the menu button(button1) as 'button1'
	JFrame frame;			//declaring the frame as 'frame'
	
	//Main Method
	public static void main (String[] args){	
		
		new Menu();													//Called the constructor to open in the main method
		
	}
	
	 
	//Constructor
	Menu() {
	
	//For the frame
	frame = new JFrame("Main Menu");								//Creating the frame
	frame.setVisible(true);											//Making the frame visible
	frame.setSize(600,500);											//Setting the size of the frame as 600 across and 500 in height 
	frame.setLocation(400, 80);										//Setting the location of the frame on the screen at 400 across and 80 down 										
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//For the first panel
	JPanel panellabel = new JPanel();								//Creating the first panel
	frame.add(panellabel);											//Adding the panel to the frame
	panellabel.setLocation(0, 0);									//Setting the location of the first panel at 0 across and 0 down from the frame	
	panellabel.setSize(600, 100);									//Setting the size of the first panel as 100 in height and 600 across 
	panellabel.setBackground(Color.black);							//Setting the color of the background for the label panel as black 
	
	//For the label (The label on the First Panel)
	JLabel label = new JLabel("ESCAPE THE MAZE");					//Creating the label with the name of panel as 'Escape the Maze'
	panellabel.add(label);											//Adding the label to the first panel
	label.setLocation(300,50);										//Setting the location of the label at 300 across and 50 down on the second panel
	label.setForeground(Color.green);								//Setting the text color of the label as green
	Font fontlabel = new Font("Agency FB", Font.BOLD, 40);			//Setting the font of the label as 'Agency FB', bold and size 40
	label.setFont(fontlabel);										//Setting the font of the label as created above
	
	//For the third panel (For button1)
	JPanel panelbutton1 = new JPanel();								//Creating the second panel
	frame.add(panelbutton1);										//Adding the second panel to the frame 
	panelbutton1.setLocation(0, 200);								//Setting the location of the second panel as 300 down
	panelbutton1.setSize(600, 50);									//Setting the size of the second panel as 600 across and 50 down	
	panelbutton1.setBackground(Color.black);						//Setting the color of the second panel as black 
	
	//For the First Button (For starting game)
	button1 = new JButton("Play Game");								//Creating the first button
	button1.setPreferredSize(new Dimension(200, 50));				//Resizing the button as 200 across and 50 in height
	button1.setBackground(Color.yellow);							//Setting the background color of the first button as yellow
	Font button1font = new Font("Courier New", Font.BOLD, 22);		//Creating the font for the text in the first button
	button1.setFont(button1font);									//Setting the font of the button text as the created font above
	panelbutton1.add(button1);										//Adding the first button to the third panel
	button1.addActionListener(this);								//Adding an actionlistener for the first button so that other forms can be accessed
	
	//For the Third Panel (For button2)
	JPanel panelbutton2 = new JPanel();								//Creating the third panel		
	frame.add(panelbutton2);										//Adding the third panel to the frame
	panelbutton2.setLocation(0, 310);								//Setting the location of the third panel as 310 pixels down
	panelbutton2.setSize(600, 200);									//Setting the size of the third panel as 600 pixels across and 200 pixels in height
	panelbutton2.setBackground(Color.black);						//Setting the color of the panel as black	

	//For the Second Button (Instructions Button)
	button2 = new JButton("Instructions");							//Creating the second button
	button2.setPreferredSize(new Dimension(200, 50));				//Resizing the button as 200 across and 50 in height
	button2.setBackground(Color.cyan);								//Setting the background color of the second button as cyan
	Font button2font = new Font("Courier New", Font.BOLD, 20);		//Creating the font for the text in the second button
	button2.setFont(button2font);									//Setting the font of the button text as created font above								
	panelbutton2.add(button2);										//Adding the second button to the third panel
	button2.addActionListener(this);
	
	JPanel panel = new JPanel();									//Creating the fourth panel
	frame.add(panel);												//Adding the fourth panel to the frame
	panel.setBackground(Color.black);								//Setting the color of the fourth panel as black
	 }
	
	//Coding for adding ActionEvents on Buttons so that new Classes can be opened with the button
	@Override
	public void actionPerformed(ActionEvent e) {		//action is performed/created...
		if (e.getSource() == button2) {					//If that action equals to the second button (Instructions) being pressed
			new FinalInstructions();					//opens the constructor made in the FinalInstructions() class
			frame.setVisible(false);					//Hides the frame for this class
		}
		if (e.getSource() == button1) {					//If that action equals to the first button (Menu) being pressed
			Main.makeLevel();							//opens the game class
			frame.setVisible(false);					//Hides the frame for this class
		}
		}
	}
	
	
	


	

	

