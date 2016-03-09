/** * 
 * @author 		Bernard Lucas & Harsh Patel
 * @date 		June 10th 2014
 * @filename	Collision.java
 * @description	collision code takes player movement status and determines whether player can move in 
 * 				intended direction based on map data and updates map data accordingly
 */
public class Collision {
	//declaring variables
	private static int ycoord, xcoord;
	private static boolean keyTaken;
	
	/**
	 * sets ycoord
	 * @param y y coordinate
	 */
	public static void setY(int y) {		
		ycoord=y;
	}
	
	/**
	 * 
	 * @return y coordinate
	 */
	public static int getY() {		
		return ycoord;
	}

	/**
	 * sets xcoord
	 * @param x x coordinate
	 */
	public static void setX(int x) {		
		xcoord=x;
	}

	/**
	 * 
	 * @return x coordinate
	 */
	public static int getX() {		
		return xcoord;
	}
	
	/**
	 * sets keyTaken
	 * @param taken 
	 */
	public static void setTaken(boolean taken) {		
		keyTaken = taken;
	}
	
	/**
	 * 
	 * @return keyTaken
	 */
	public static boolean getTaken() {		
		return keyTaken;
	}	
	
	/**
	 * Collision algorithm determines whether player can move in intended direction
	 * and determines what happens if player moves
	 * @param map	map data
	 * @param pX	player x coordinate
	 * @param pY	player y coordinate
	 * @param xst	x movement status
	 * @param yst	y movement status
	 * @return		map data
	 */
	public static int[][] moveXY(int[][] map, int pX, int pY,int xst, int yst){
		
		//checks adjacent tile if y movement status is not 0
		if(yst != 0){
			//switch statement checks what is in the adjacent tile and determines whether player can move
			switch(map[pY+yst][pX]){
				//moves player if nothing is in the way
				case 0:
					pY = pY+(yst);
					break;
				//does nothing if a wall is in the way
				case 1:
					break;
				//moves player and erases wall if a false wall is in the way
				case 2:
					map[pY+(yst)][pX]=0;
					pY = pY+(yst);
					break;
				//moves player, erases key and sets keyTaken to true if player moves into key
				case 3:
					map[pY][pX]=0;
					setTaken(true);
					pY = pY+(yst);
					break;
				//moves player and moves movable wall if player moves into a single movable wall
				case 4:
					if(map[pY+(yst*2)][pX]==0){
						map[pY+(yst)][pX]=0;
						map[pY+(yst*2)][pX]=4;
						pY = pY+(yst);
					}
					break;
			}
		}
		
		//checks adjacent tiles if x movement status is not 0
		if(xst != 0){
			//switch statement checks what is in the adjacent tile and determines whether player can move
			switch(map[pY][pX+xst]){
				//moves player if nothing is in the way
				case 0:
					pX = pX+xst;
					break;
				//does nothing if a wall is in the way
				case 1:
					break;
				//moves player and erases wall if a false wall is in the way
				case 2:
					map[pY][pX+(xst)]=0;
					pX = pX+(xst);
					break;
				//moves player, erases key and sets keyTaken to true if player moves into key
				case 3:
					map[pY][pX]=0;
					pX = pX+(xst);
					setTaken(true);
					break;
				//moves player and moves movable wall if player moves into a single movable wall
				case 4:
					if(map[pY][pX+(xst*2)]==0){
						map[pY][pX+(xst)]=0;
						map[pY][pX+(xst*2)]=4;
						pX = pX+(xst);
					}
					break;
			}
		}
		
		//sets player x and y coordinate
		setX(pX);
		setY(pY);
		return map;					//returns updated map data
	}
	
	
	
	
}
