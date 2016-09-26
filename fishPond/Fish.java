package fishPond;

import cmsc131Utilities.Random131;

/**
 * The state of a fish consists of its position in the pond (row and         
 * column), it's size, and the direction in which it is moving (UP, DOWN,    
 * LEFT, or RIGHT).                                                          
 * <p>                                                                 
 * A fish moves, eats other fish, eats plants, and shrinks over time.        
 * <p>                                                                          
 * STUDENTS MAY NOT ADD ANY FIELDS OR PUBLIC METHODS!  (You may add private  
 * methods of your own, if you wish.)                                        
 *                                                                           
 * @author Put Your Name Here          
 */

public class Fish {

	/** Initial size of each fish when simulation begins */
	public static final int FISH_STARTING_SIZE = 100;
	
	/** Maximum size for a fish */
	public static final int MAX_FISH_SIZE = 1000;
	
	/** Code for "Left" fish direction */
	public static final int LEFT = 56;
	
	/** Code for "Right" fish direction */
	public static final int RIGHT = 57;
	
	/** Code for "Up" fish direction */
	public static final int UP = 58;
	
	/** Code for "Down" fish direction */
	public static final int DOWN = 59;
	
	/*State of this fish */
	private int row, col, size, direction;
	
	/** Simply initializes the state of the fish with these parameters */
	public Fish(int row, int col, int size, int direction) {
		this.row = row;
		this.col = col;
		this.size = size;
		this.direction = direction;
	}
	
	/** Standard copy constructor -- just copies the fields */
	public Fish(Fish x) {
		row = x.row;
		col = x.col;
		size = x.size;
		direction = x.direction;
	}
	
	/** Fish size increased by nutritionalValue. */
	public void eat(int nutritionalValue) {
		size += nutritionalValue;
	}
	
	/** Returns true if size is greater than zero, false otherwise */
	public boolean isAlive() {
		if(size <= 0)
			return false;
		else
			return true;
	}
	
	/** Size is decreased by TWO.  */
	public void shrink() { 
		size -= 2;
	}
	
	/* This fish eats the other fish.  I.e. This fish's size is increased by
	 * the size of the fish "other".  The size of "other" is set to 0. */
	private void eat(Fish other) {
		eat(other.size);
		other.size = 0;
	}
	
	/** Implement this however you want -- it's for your own purposes while debugging */
	public String toString() {
		return "R: " + row + "  C: " + col + "Size: " + size + "    ";
	}
	
	/** The current object battles the parameter (other).  Whichever one is larger
	 * eats the other by calling the private "eat" method.  In cases where the
	 * sizes of the two fish are exactly the same, have the current object win! */
	public void fight(Fish other) {
		if(this.size >= other.size)
			this.eat(other);
		else
			other.eat(this);
	}
	
	/**The fish's location (row or col) is adjusted by ONE unit, depending on the 
	 * fish's current direction.  For example, if the current direction is "UP", then
	 * the fish's row should be decremented.
	 * <p>
	 * If the fish's current direction is not equal to one of the static constants UP, 
	 * DOWN, LEFT, or RIGHT, then this method will throw an 
	 * IllegalFishDirectionException, passing the fish's direction to the constructor
	 * of that exception when you create it. 
	 */
	public void move() {
		switch(this.direction) {
			case 56: this.col--;
					 break;
			case 57: this.col++;
					 break;
			case 58: this.row--;
					 break;
			case 59: this.row++;
					 break;
			default: throw new IllegalFishDirectionException(this.direction);
		}
	}
	
	/**The fish's direction is randomly determined (UP, DOWN, LEFT or RIGHT).  
	 * Sometimes the resulting direction will be the same as the original one.
	 * <p>
	 * YOU MUST FOLLOW THE INSTRUCTIONS BELOW OR YOU WILL NOT PASS OUR TESTS!
	 * <p>
	 * Call Random131.getRandomInteger(4).
	 * <p>
	 * If the value is 0, set the direction to UP.  If 1, set to DOWN.  If 2, set to 
	 * LEFT.  If 3, set to RIGHT.  IMPORTANT:  DO NOT SET THE DIRECTION TO THE VALUES 
	 * 0, 1, 2, OR 3 -- directions must be set using the static constants (UP, DOWN, 
	 * LEFT, RIGHT). */
	public void setRandomDirection() {
		int test = Random131.getRandomInteger(4);
		if(test == 0)
			this.direction = UP;
		else if(test == 1)
			this.direction = DOWN;
		else if(test == 2)
			this.direction = LEFT;
		else
			this.direction = RIGHT;
	}
	
	/** Returns size */
	public int getSize() {
		return this.size;
	}
	
	/** Returns row */
	public int getRow() {
		return this.row;
	}
	
	/** Returns column */
	public int getCol() {
		return this.col;
	}
	
	/** Returns direction (UP, DOWN, LEFT, or RIGHT) */
	public int getDirection() {
		return this.direction;
	}
}
