
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
	}
	
	public Part getLastMachinePartCollected() {
		return lastMachinePartCollected;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
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
		if (currentRoom.getDoor(direction) == null){
			return "There is no door in this direction";
		} else  {
			Room newRoom = currentRoom.getDoor(direction);
			currentRoom = newRoom;
			return currentRoom.printMessage();
		}
			
	}
	
	//needs finishing
	public String collectTools () {
		return "";
	}
	
	//needs finishing
	public String build () {
		return "";
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
}
