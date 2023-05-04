/*
 * This class represents the collectible machine part during the game
 * 
 * 
 * @author Mustafa
 * */

public class Part {
	
	private int partnumber;
	public static final int LAST_PART = 6;
	
	
	public Part(int number ) {
		this.partnumber = number;
	}
	
	public int getPartNumber() {
		return this.partnumber;
	}
	
	public boolean isLastPart(Part part) {
		if (LAST_PART == partnumber) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isNext(Part part ) {
		if (this.partnumber + 1 == part.partnumber ) {
			return true;
		} else {
			return false;
		}
		
	
		
	
	}
	
	
}