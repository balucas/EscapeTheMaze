
/**
 * @author 		Bernard Lucas & Harsh Patel
 * @date		June 10th 2014
 * @filename	GameMain.java
 * @description	main game class; controls the graphics, user input, frame and gameplay
 */

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.event.*;
import javax.swing.*;

public class GameMain implements Runnable{
	
	//Declaring objects and variables
	
    JFrame frame;								//Initializing frame, canvas and 			
    Canvas canvas;								//BufferStrategy(to work with canvas)
    BufferStrategy bufferStrategy;
    
    int pY,pX;									//Player x,y coordinate, x,y movement status
    int xst, yst;
    public static boolean running;				//'running' controls whether thread is running or not
    public static boolean keyTaken = false;		//keyTaken indicates whether player has taken the key
    
	int map[][];								//map stores the maze data in 2D array
	Maze m;										//Maze object determines the maze data and color
    Dimension gamesize = new Dimension(1040,650);
    
    public GameMain(int lvl){
    	
    	setUp(lvl);								//calls setUp method to initialize map and player coordinates
        frame = new JFrame("ESCAPE THE MAZE");	//initializing JFrame, JPanel, and canvas
        canvas = new Canvas();
        JPanel panel = (JPanel) frame.getContentPane();
        
        //setting frame, panel, and canvas size and layout
        frame.setLocation(150,10);
        panel.setPreferredSize(gamesize);
        panel.setLayout(null);
        canvas.setBounds(0, 0, gamesize.width + 10, gamesize.height +10);
        
        canvas.setIgnoreRepaint(true);			//sets canvas to ignore paint messages from operating system
                
        panel.add(canvas);						//adds canvas to panel
        
        //sets frame characteristics
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
        //sets frame size to the preferred size of its subcomponents (panel)
        frame.pack();
        
        //initializes bufferstrategy
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        
        canvas.requestFocus();					//gives canvas input focus
        
        //adds key listener to allow player to control character
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
               userInput(evt);					//calls userInput method
            }
        });
    }
    
    /**
     * Initializes map and player coordinates
     * @param lvl	current game level
     */
    public void setUp(int lvl){
    	m = new Maze(lvl);
     	map = m.getMap();
     	for(int x = 0; x <=20; x++){
         	for(int y = 0; y <=12; y++){
         		if(map[y][x]==9){
         			pY = y;
         			pX = x;
         			map[y][x]=0;
         		}         		
         	}
         }
    }
    
    /**
     * Repeatedly calls paint, move and check methods while 'running' is true
     */
    public void run() {
        while (running == true) {
            try {								//try catch statement catches interruptedexceptions
            	paint();
            	Move();
            	Check();
                Thread.sleep(2);				//pauses for 2 milliseconds
            } catch (InterruptedException e) {
            }
        }
    }
    
    /**
     * Checks whether key has been taken or not; if so, disposes frame and creates next level
     */
    private void Check() {
		if(keyTaken){
			
			running = false;					//stops thread
			keyTaken = false;					//sets keyTaken as false
			Collision.setTaken(false);	
			
			Main.lvl++;							//creates next level
			Main.makeLevel();
			
			frame.dispose();					//closes frame
		}
	}
    
    /**
     * moves character
     */
    public void Move(){
    	//Calls collision method and sets player coordinates
    	map = Collision.moveXY(map, pX, pY, xst, yst);
    	
    	pX = Collision.getX();
    	pY = Collision.getY();
    	
    	//Resets x and y movement status
    	xst=0;
    	yst=0;
    	
    	//determines whether key was taken or not
    	keyTaken = Collision.getTaken();
    }
    
    /**
     * clears canvas
     */
    public void paint() {
    	//try catch statement catches exception from bufferStrategy
    	try{
	        Graphics g = (Graphics) bufferStrategy.getDrawGraphics();
	        g.clearRect(0,0,1050,650);        	//clears canvas
	        paint(g);							//calls other Paint method
	        bufferStrategy.show();
    	}catch(Exception e){
    		
    	}
    }
    
    /**
     * paints canvas
     * @param g graphics
     */
    protected void paint(Graphics g) {
    	
    	//calls paint method in class 'Maze' to paint map and player
    	m.paint(g,map);    	
    	m.paintPlayer(g,pX,pY);
    }
        
    /**
     * processes key inputs
     * @param evt
     */
    public void userInput(KeyEvent evt){
     switch (evt.getKeyCode()) {
     
     		//changes x and y movement statuses when arrow keys are pressed
            case KeyEvent.VK_DOWN:
            	yst = 1;
            	xst = 0;
                break;
            case KeyEvent.VK_UP:
                yst = -1;
                xst = 0;
                break;
            case KeyEvent.VK_LEFT:
                yst = 0;
                xst = -1;
                break;
            case KeyEvent.VK_RIGHT:
            	yst = 0;
            	xst = 1;
                break;
                
            //resets frame and map when space is pressed
            case KeyEvent.VK_SPACE:
            	Main.makeLevel();
            	frame.dispose();
            default:
            	yst = 0;
            	xst = 0;
            	
            	
        }         
    }
}