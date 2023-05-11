/**
 * This class holds the whole game and its components (the two players and 10 rooms). 
 * This class should be instantiated in the main application class 
 * @author ADD YOUR NAME
 */

/*
 * Game Object must be instantiated in the main application class*/

 public class Game {
	private Player[] players;  //should hold two player objects
	private Room[] rooms; 	// should hold 10 room objects 
	private Player currentPlayer;

	
	public Game() { //Exception for setUpDoors();
		
		players = new Player[1];
		rooms = new Room[ ]{
				
				new Room(1), 
				new RoomWithMachinePart(2, new Part(3)),
				new RoomWithMachinePart(3, new Part(1)),
				new Room(4),
				new RoomWithMachinePart(5, new Part(2)),
				new RoomWithMachinePart(6, new Part(4)),
				new Room(7),
				new RoomWithTools(8),
				new Room(9),
				new Workshop(10)
				
				};
		
		try {
			setUpDoors();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in Game>Game()>setupdoors()");
		}
		InitGame();
		
		}
	
	
	public void InitGame() {
		
		Player player1 = new Player(1, rooms[0]);
		Player player2 = new Player(2, rooms[0]);
		
		Player[] players = {
				player1, player2
				};
		
		currentPlayer = players[0];
		
		}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void switchPlayer() {
		if (currentPlayer == players[0]) {
			currentPlayer = players[1];
		} else {
			currentPlayer = players[0];
		}
	}
	
	public void reset() throws Exception {
		
		players = new Player[1];
		rooms = new Room[ ]{
				
				new Room(1), 
				new RoomWithMachinePart(2, new Part(3)),
				new RoomWithMachinePart(3, new Part(1)),
				new Room(4),
				new RoomWithMachinePart(5, new Part(2)),
				new RoomWithMachinePart(6, new Part(4)),
				new Room(7),
				new RoomWithTools(8),
				new Room(9),
				new Workshop(10)
				
				};
		
		setUpDoors();
		
	}
	
	   /**
	    * Assuming that Rooms has been initialized in the constructor 
	    * to hold 10 objects of type Room or a subclass of Room, this method 
	    * sets up the doors between the rooms, as described in the map
	    * @return void
	    * @throws Exception if inconsistencies found by setDoor
	    */
	
	private void setUpDoors() throws Exception {
		rooms[0].setDoor(Direction.up, rooms[3]);
		rooms[0].setDoor(Direction.left, rooms[8]);
		
		rooms[1].setDoor(Direction.up, rooms[4]);
		rooms[1].setDoor(Direction.down, rooms[7]);
		rooms[1].setDoor(Direction.right, rooms[9]);

		rooms[2].setDoor(Direction.down, rooms[8]);

		rooms[3].setDoor(Direction.down, rooms[0]);
		rooms[3].setDoor(Direction.right, rooms[4]);

		rooms[4].setDoor(Direction.down, rooms[1]);
		rooms[4].setDoor(Direction.right, rooms[5]);
		rooms[4].setDoor(Direction.left, rooms[3]);

		rooms[5].setDoor(Direction.down, rooms[9]);
		rooms[5].setDoor(Direction.left, rooms[4]);

		rooms[6].setDoor(Direction.up, rooms[8]);
		rooms[6].setDoor(Direction.right, rooms[7]);

		rooms[7].setDoor(Direction.up, rooms[1]);
		rooms[7].setDoor(Direction.left, rooms[6]);

		rooms[8].setDoor(Direction.up, rooms[2]);
		rooms[8].setDoor(Direction.down, rooms[6]);
		rooms[8].setDoor(Direction.right, rooms[0]);

		rooms[9].setDoor(Direction.up, rooms[5]);
		rooms[9].setDoor(Direction.left, rooms[1]);

	}

	
	
}

