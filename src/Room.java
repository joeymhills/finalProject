/**
 * A class representing a room in the Maze adventure 
 * @author Sahar Al Seesi
 */
public class Room {
	
	private int number;
	private Room [] doors;
	
	public Room(int number) {
		this.number = number;
		doors = new Room[4];				
	}
	
	   /**
	    * Sets the door[direction] to r, after checking for inconsistencies
	    *
	    * @param direction, one of the values in class Direction
	    * @param r a Room object
	    * @return void
	    * @throws Exception if inconsistencies found
	    */
	public void setDoor(int direction, Room r) throws Exception {

		if (r.getDoor(Direction.getOpposite(direction)) ==  null || 
				r.getDoor(Direction.getOpposite(direction)) == this) { 
			doors[direction] = r;
		}
		else throw (new Exception ("Inconsistent Door from Room "+number+" to Room "+ r.getNumber()));
	}
	
	   /**
	    * returns the Room object to which a door in 
	    * a specific direction points; null if none
	    * @param direction, one of the values in class Direction
	    * @return Room
	    */
	public Room getDoor(int direction) {
		System.out.println(direction);
		System.out.println("Room "+number);		
		return doors[direction];
	}

	   /**
	    * getter method. Returns number
	    * @return integer
	    */

	public int getNumber() {
		return number;
	}

	   /**
	    * returns false for generic room type. To be overridden 
	    * in subclass RoomWithMachinePart
	    * @return boolean
	    */

	public boolean hasPart () {
		return false;
	}

	   /**
	    * returns false for generic room type. To be overridden 
	    * in subclass RoomWithTools
	    * @return boolean
	    */

	public boolean hasTools() {
		return false;
	}
	   /**
	    * returns false for generic room type. To be overridden 
	    * in subclass Workshop
	    * @return boolean
	    */
	
	public boolean isWorkshop () {
		return false;
	}
	   /**
	    * returns the welcome message for a player entering this room
	    * @return String
	    */
	
	public String printMessage() {
		return "Welcome to Room "+ getNumber();
	}

	   /**
	    * returns a help message for specifying this room number
	    * @return String
	    */

	public String helpMessage() {
		return "You are in Room "+ getNumber();
	}

	/*
	 * will be Overrided for RoomWithMachinePart
	 */
	public Part collectPart(Player player) {
		System.out.println("Wrong method called. collect part is callled in room instead of roomwithpart");
		return null;
		
	}
	
	
	
	
	
}


/**
 * Extends Room class, represents a room with a collectible part.
 * holds an extra Part object to be collected by the player.
 * Has extra methods to collect Part and get/set Part
 * @author Mustafa
 */
class RoomWithMachinePart extends Room {

	private Part machinePart;
	
	
	public RoomWithMachinePart(int number, Part part) {
		super(number);
		this.machinePart = part;
	}
	
	/**
	 * returns the Room's part
	 */
	public Part getMachinePart() {
		return machinePart;
	}
	
	/**
	 * Returns the Part object if the Player Object has the part before it
	 */
	@Override
	public Part collectPart(Player player) {
		if (player.getLastMachinePartCollected() == null) {
			return null;
		}
		else if (getMachinePart().isNext(player.getLastMachinePartCollected() )) {
			return machinePart;
			
		} else {
			return null;
		}
		
	}
	
	/**
	 * returns true for having a part
	 */
	@Override
	public boolean hasPart () {
		return true;
	}
	
	/**
	 * Help message for the player, returns the room number using method.
	 */
 @Override
	public String helpMessage() {
		return "you are in room " + this.getNumber();
	}
	
}


/**
 * extends Room class, represents a room with tools.
 * @author Mustafa
 */
class RoomWithTools extends Room {
	
	/*
	 * no extra data members, uses method return instead.
	 */
	public RoomWithTools(int number) {
		super(number);
	}
	
	/*
	 * always returns true if called on RoomWithTools Class
	 */
	@Override
	public boolean hasTools () {
		return true;
	}
	
}

/**
 * Extends Room class and represents a workshop.
 * no extra data, just uses method returns.
 * @author Mustafa
 */
class Workshop extends Room {

	public Workshop(int number) {
		super(number);
	}
	
	@Override
	public boolean isWorkshop () {
		return true;
	}
	
}

