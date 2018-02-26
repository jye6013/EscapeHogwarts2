package caveExplorer;

import java.util.Scanner;

import areejJessRoom.AreejRoom;
import areejJessRoom.StoreRoom;
import jiVickieRoom.JiRoom;
import jiVickieRoom.VickieFrontEnd;
import jiVickieRoom.VickieRoom;
import kevinStephRoom.KevinRoom;
import kevinStephRoom.StephFrontEnd;
import kevinStephRoom.StephanieRoom;

public class CaveRoom {

	private String description;
	private String directions;//tells you which doors can be used
	private String contents;//a symbol showing you what is in the room... 
	//...('X' when you are in the room)
	private String defaultContents;//what is in the room when you aren't in the room
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	

	public static boolean isKRoom() {
		return KRoom;
	}


	public static boolean isJiRoom() {
		return JiRoom;
	}


	public static boolean isSRoom() {
		return SRoom;
	}


	public static boolean isStore() {
		return Store;
	}


	public static boolean isMagicSquare() {
		return magicSquare;
	}


	public static boolean isConnect4() {
		return Connect4;
	}


	public static boolean isLightsOut() {
		return LightsOut;
	}
	public static boolean isARoom() {
		return ARoom;
	}

	public static boolean ARoom;
	public static boolean JiRoom;
	public static boolean KRoom;
	public static boolean SRoom;
	public static boolean Store;
	public static boolean magicSquare;
	public static boolean Connect4;
	public static boolean LightsOut;

	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//NOTE: Arrays are instantiated with 'null' values
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	
	/**
	 * for every Door in doors[] that is not null,
	 * this method appends a String to "directions" describing the door and where it is. For example:
	 *     There is a (passage) to (the North)
	 *     There is a (passage) to (the East)
	 * If there are no doors that are not null, this sets directions to:
	 *     "There is no way out. You are trapped in this room"
	 */
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "There is a "+doors[i].getDescription()+" to the "+
				toDirection(i)+". \n"; //+doors[i].getDetails()+"\n"
			}
		}
		if(!doorFound) {
			directions = "There is no way out. You are trapped in this room";
		}
		//hint: to check if a door is null (or not null), use:
		//doors[0] == null   (OR USE   doors[0] != null)
	}
	
	/**
	 * converts an int to a direction:
	 *    0 -> "the North"
	 *    1 -> "the East"
	 * hint: complete this method without using an if statement
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] direction = {"the North","the East","the South","the West"};
		//NOTE: when I say "no long if-else" statements,
		//this is how you should be thinking
		return direction[dir];
	}
	

	
	public void enter() {
		if(CaveExplorer.currentRoom.getContents().equals("5"))
		{
			ARoom = true;
			areejJessRoom.AreejRoom.userEnter();
		}
		else if(CaveExplorer.currentRoom.getContents().equals("1"))
		{
			jiVickieRoom.VickieRoom.userEntered();
		}
		else if(CaveExplorer.currentRoom.getContents().equals("2"))
		{
			JiRoom = true;
			jiVickieRoom.JiRoom.userEntered();
		}
		
		else if(CaveExplorer.currentRoom.getContents().equals("3"))
		{
			SRoom = true;
			kevinStephRoom.StephanieRoom.userEntered();
		}
		else if(CaveExplorer.currentRoom.getContents().equals("4"))
		{
			KRoom = true;
			kevinStephRoom.KevinRoom.userEntered();
		}
		else if(CaveExplorer.currentRoom.getContents().equals("C"))
		{
			Connect4 = true;
			areejJessRoom.JessicaFrontEnd.play();
		}
		else if(CaveExplorer.currentRoom.getContents().equals("M"))
		{
			magicSquare = true;
			VickieFrontEnd.main(null);
		}
		else if(CaveExplorer.currentRoom.getContents().equals("L"))
		{
			LightsOut = true;
			StephFrontEnd.main(null);	
		}
		else if(CaveExplorer.currentRoom.getContents().equals("S"))
		{
			Store = true;
			areejJessRoom.StoreRoom.userEntered();
		}
		
		else
		{
			contents = "X";
		
		}
		
	}
	
	public void leave() {
		contents = defaultContents;
	}

	/**
	 * This is how we join rooms together.
	 * It gives this room access to anotherRoom and vice-versa
	 * It also puts the door between both rooms
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	public void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();//updates the directions
	}

	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			printValidMoves();
			
			input = CaveExplorer.in.nextLine();
		}
		int direction = validMoves().indexOf(input);
		if (direction < 4) {
			goToRoom(direction);
		}else {
			performAction(direction);
		}
	}
	
	/**
	 * override to create response to keys other than wdsa
	 * @param direction
	 */
	public void performAction(int direction) {
		CaveExplorer.print("That key does nothing.");
	}


	/**
	 * Override to change description of possible moves
	 */
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd'.");
	}

	/**
	 * override to add more moves
	 * @return
	 */
	public String validMoves() {
		return "wdsa";
	}

	/**
	 * returns true if w,a,s, or d is the input (NO IF STATEMENTS)
	 * @param input
	 * @return
	 */
	private boolean isValid(String input) {
		return validMoves().indexOf(input) > -1 && input.length() == 1;
	}

	/**
	 * THIS IS WHERE YOU EDIT YOUR CAVES
	 */

	public static void setUpCaves() {
		//Size of Caves
		CaveExplorer.caves = new NPCRoom[4][10];
		CaveRoom[][] c = CaveExplorer.caves; //shortcut for accessing CaveExplorer
		

		
		//Populate with default caves
		for(int row = 0; row < c.length; row++)
		{
			for(int col = 0; col < c[row].length; col++)
			{
				c[row][col] = new NPCRoom("You are at " + row + ", " + col); //change
			}
		}
		
		//replace default room with custom room (SAVE FOR LATER)
		//Set starting room
		
		CaveExplorer.currentRoom = c[0][1];
		CaveExplorer.currentRoom.enter();
		//Set up doors
		
		NPC NPCAJ = new NPC(); //EDIT TO OWN NPC
		NPCAJ.setPosition(1,4);
		CaveExplorer.npcs = new NPC[1];
		CaveExplorer.npcs[0] = NPCAJ; 
		
		
		
	/*	NPC testNPCAJ = new NPC();
		testNPC.setPosition(1,2);
		CaveExplorer.npcs = new NPC[1];
		CaveExplorer.npcs[0] = testNPC; */
		
		//room1 : 1,4
		//room2: 2,5
		//room3: 4.3
		
		//replace default room with custom room (SAVE FOR LATER)
		//Set starting room
	
		//Set up doors
		
		//rooms 
				c[3][1].setContents("C");
				c[3][9].setContents("M");
				c[0][4].setContents("L");
				
				//thematic rooms
				c[3][5].setContents("S");//Jess
				c[0][6].setContents("5"); //Areej
				
				c[0][8].setContents("1"); //Vickie Room
				c[2][0].setContents("2"); //Ji Room
				c[2][3].setContents("3");	//Steph Room
				c[2][7].setContents("4");	//Kevin Room
		
		
		//addRoom
		c[3][1].addRoom(NORTH, c[2][1], new Door("Connect Four", true));
		c[1][4].addRoom(WEST, c[1][3], new Door("Magic Square", true));
		c[3][2].addRoom(EAST, c[3][3],new Door("Lights Out", true));
		c[3][5].addRoom(EAST, c[3][4],new Door("Store", true));
		
		
		//connections
		c[0][1].setConnection(SOUTH, c[1][1], new Door("hallway", true));
		//c[1][1].setConnection(EAST, c[1][2], new Door("hallway", true));
		
		c[1][1].setConnection(SOUTH, c[2][1], new Door("hallway", true));
	//	c[1][1].setConnection(WEST, c[1][0], new Door("hallway", true));
		c[1][1].setConnection(EAST, c[1][2], new Door("hallway", true));
		
	//	c[1][3].setConnection(SOUTH, c[2][3], new Door("hallway", true));
		c[1][3].setConnection(WEST, c[1][2], new Door("hallway", true)); 
		c[1][3].setConnection(EAST, c[1][4], new Door("hallway", true));
	//	c[1][3].setConnection(NORTH, c[0][3], new Door("hallway", true));
		
		c[1][2].setConnection(WEST, c[1][1], new Door("hallway", true));
		
		c[2][1].setConnection(NORTH, c[1][1], new Door("hallway",true));
	
		c[1][4].setConnection(EAST, c[1][5], new Door("hallways",true));
		c[1][5].setConnection(EAST, c[1][6], new Door("hallways",true));
		c[1][6].setConnection(EAST, c[1][7], new Door("hallways",true));
		c[1][4].setConnection(NORTH, c[0][4], new Door("hallways",true));
		c[0][4].setConnection(SOUTH, c[1][4], new Door("hallways",true));
		
		c[1][5].setConnection(SOUTH, c[2][5], new Door("hallways",true));
		c[2][5].setConnection(SOUTH, c[3][5], new Door("hallways",true));
		c[2][5].setConnection(NORTH, c[1][5], new Door("hallways",true));
	//	c[3][1].setConnection(NORTH, c[2][1], new Door("hallway", true));
		
		c[2][1].setConnection(SOUTH, c[3][1], new Door("hallways",true));
		
		//Hallways for thematic
		c[2][0].setConnection(EAST, c[2][1], new Door("hallway", true));
		c[2][3].setConnection(NORTH, c[1][3], new Door("hallway", true));
		c[2][7].setConnection(NORTH, c[1][7], new Door("hallway", true));
		c[0][6].setConnection(SOUTH, c[1][6], new Door("hallway", true));
		//hall
		c[1][7].setConnection(EAST, c[1][8], new Door("hallway", true));
		c[1][8].setConnection(EAST, c[1][9], new Door("hallway", true));
		c[1][9].setConnection(SOUTH, c[2][9], new Door("hallway", true));
		c[2][9].setConnection(SOUTH, c[3][9], new Door("hallway", true));
		c[0][8].setConnection(SOUTH, c[1][8], new Door("hallway", true));
	}



	public void goToRoom(int direction) {
		//make sure there is a room to go to:
		if(borderingRooms[direction] != null && doors[direction] != null &&
				doors[direction].isOpen()) 
		{
			
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			
			CaveExplorer.inventory.updateMap();
			
			
			
			
		}else {
			//print red text
			System.err.println("You can't do that!");
		}
	}

	/**
	 * returns the OPPOSITE direction
	 *   oD(0) returns 2
	 *   oD(1) returns 3
	 * @param dir
	 * @return
	 */
	public static int oppositeDirection(int dir) {
		return (dir + 2) % 4;
	}
	
	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}


	public Door getDoor(int direction) {
		return doors[direction];
	}
}