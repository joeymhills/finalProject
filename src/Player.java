
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
	
	public String move (Direction dir) {
		return "";
	}
	
	public String collectTools () {
		return "";
	}
	
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
