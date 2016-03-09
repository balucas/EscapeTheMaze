
/**
 * @author 		Bernard Lucas & Harsh Patel
 * @date		June 10th 2014
 * @filename	Main.java
 * @description	main class; initializes game and creates end message when game is finished
 */

import java.awt.*;
import javax.swing.*;

public class Main {
	
	public static int lvl=1;										//declares and initializes lvl variable
	
	/**
	 * calls makeLevel class (mainly for testing purposes)
	 * @param args
	 */
	public static void main(String[] args) {
		makeLevel();
	}
	
	/**
	 * initializes game and creates end message
	 */
	public static void makeLevel(){
		if(lvl <= 3){
			GameMain.running = true;
			new Thread(new GameMain(lvl)).start();
		}else{
			//For the Frame
			JFrame end = new JFrame("Game Finished");				//Creating the Frame
			end.setSize(400,200);									//Setting the size of the Frame as 200 pixels long and 400 pixels across
			end.setLocation(500, 200);								//Setting the Location of the frame on the screen as 200 pixels down and 500 pixels across
			end.setResizable(false);								//Restricting the window/frame from being maximized or stretching the window
			end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Closing the window//frame when clicking the 'x' button at the top right
			end.setVisible(true);									//Making the frame visible
			
			//For the first panel
			JPanel panel = new JPanel();							//Creating the Panel
			panel.setSize(400,100);									//Setting the size of the panel as 100 pixels long and 400 pixels across
			panel.setBackground(Color.black);						//Setting the color of the panel as black
			panel.setLocation(0,50);								//Moving the panel down 50 pixels
			end.add(panel);											//Adding the panel to the frame	
			
			//For the second panel
			//This is created in order for the first panel locations to work, the location doesn't work if we don't do this
			JPanel panel2 = new JPanel();							//Creating the second panel
			panel2.setSize(400,100);								//Setting the size of the second panel as 100 pixels long and 400 pixels across
			panel2.setBackground(Color.black);						//Setting the color of the panel as black 
			end.add(panel2);										//Adding the second panel to the frame										
			
			//For the label
			JLabel label = new JLabel("YOU FINISHED THE GAME!");	//Creating the label
			Font setfont = new Font("Agency FB", Font.BOLD, 40);	//Making a font as the font of 'Agency FB', bold and 40 pixels in size
			label.setFont(setfont);									//Setting the label font as the font created above
			label.setForeground(Color.white);						//Setting the color of the font in the label as white
			label.setSize(400,100);									//Setting the size of the label as 100 long and 400 across
			panel.add(label);										//Adding the label to the first panel
						
		}
	}
}
