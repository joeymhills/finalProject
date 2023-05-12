
/*
 * Represents a player in the game
 * */

 public class Player {
	
	private int playerNumber;
	private Room currentRoom;
	private boolean toolsCollected;
	private Part lastMachinePartCollected;
	
	public Player(int playerNumber, Room startingRoom) {
		this.setPlayerNumber(playerNumber);
		this.currentRoom = startingRoom;
		this.toolsCollected = false;
		this.lastMachinePartCollected = new Part(0);
	}
	
	/*
	 * returns the last part 
	 */
	public Part getLastMachinePartCollected() {
		return lastMachinePartCollected;
	}
	
	/*
	 * returns the current room
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	/*
	 * returns true if tools have been collected
	 */
	public boolean hasTools() {
		return toolsCollected;
	}
	
	/**
	 * Moves the character in a direction. takes in a integer  
	 * 
	 * @param int direction
	 * @return if there is a door, returns error message, if there is a door
	 * 			it will change 'currentRoom' and print the room message.
	 * @author mustafabolat
	 */
	public String move (int direction) {
		if (currentRoom.getDoor(direction) == null) {
			return "There is no door in this direction";
		} else {
			Room newRoom = currentRoom.getDoor(direction);
			currentRoom = newRoom;
			return currentRoom.printMessage();
		}
			
	}
	
	/**
	 * Collects tools if the room has it.
	 * 
	 * @return String a string to be put in the HelpMessage text field
	 */
	public String collectTools() {
		if (currentRoom.hasTools() == false) 
			return "This room does not have tools to collect";
		else if (toolsCollected == true ) {
			return "You have already collected the tools";
		}else {
		toolsCollected = true;
		return "Tools are now collected";
		}
	}
	
	/*
	 * if the the part is consecutive and the room has 
	 * a part it assigns the new part to the player
	 */
	public String collectPart() {
		if (currentRoom.hasPart() == true) {
			
			lastMachinePartCollected = getCurrentRoom().collectPart(this);
			return "Part number " + lastMachinePartCollected.getPartNumber() + " has been collected";
			
		} else {
			return "the room does not have a part";
		}
		
		
	}
	
	/*
	 * if everything is collected, and in the workshop, then the game finishes.
	 */
	public String build() {
		if (lastMachinePartCollected.isLastPart() == true && toolsCollected == true && currentRoom.isWorkshop() == true) {
			return "Congrats on finishing the game!";
		} else {
			return "You need to collect all the parts and tools";
		}
	}

	/*
	 *returns the player number 
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	/*
	 * sets the player number
	 */
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
}
