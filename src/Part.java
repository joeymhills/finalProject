/*
 * This class represents the collectible machine part during the game
 * 
 * 
 * @author Mustafa
 * */

 public class Part {
	
	private int partnumber; //self explanatory
	public static final int LAST_PART = 4; //^ again 
	
	
	public Part(int number ) {
		this.partnumber = number;
	}
	
	/**
	 * Returns the part number 
	 * 
	 * @return int, part number
	 */
	public int getPartNumber() {
		return this.partnumber;
	}
	
	/**
	 * Checks a part to see if is the last part 
	 * the last part should be part 6.
	 * 
	 * @return boolean True if last part, false if not last part
	 */
	public boolean isLastPart() {
		if (partnumber == LAST_PART) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 *Compares the current part with another part found in game, 
	 *checks if that part is consecutive to the last 
	 * 
	 * @param part Part object collected in-game
	 * @return true if the part is consecutive, false if not. 
	 * 
	 */
	public boolean isNext(Part part) {
		if (getPartNumber() == (part.getPartNumber() + 1) ) {
			return true;
		} else {
			return false;
		}
		
	
		
	
	}
	
	
}