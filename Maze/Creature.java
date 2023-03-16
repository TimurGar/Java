/**
 * A Creature class
 * The creature has a current location and can move to a new location
 * @author Mmachi G. Obiorah
 * @author Your Name
 */ 
public class Creature
{
	public static final char NORTH = 'N';
	public static final char SOUTH = 'S';
	public static final char EAST = 'E';
	public static final char WEST = 'W';

	private Location location;

	/**
	 * The default constructor
	 */ 
	public Creature(){}

	/**
	 * A constructor that accepts a starting position for the Creature object
	 * @param location is a Location object representing the position of a Creature object in a Maze
	 */ 
	public Creature(Location location)
	{
		this.location = new Location(location);
	}

	/**
	 * Returns a copy of the current location of the creature
	 * @return a Location object that is the current location of the creature
	 */ 
	public Location getLocation()
	{
		return new Location(location);
	}

	/**
	 * Moves the creature to a new location
	 * @param newLocation a Location object that is the new location to move the creature to
	 * @param maze is the maze object the creature is currently moving through
	 * @return true if the move was successful and false otherwise
	 */ 

	// For the stack (prev loc in the stack) 
	public boolean moveTo(Maze maze, Location newLocation)
	{
		//if (maze.isMazeClearOrPathPosition(newLocation))
		if (maze.isPath(newLocation) || maze.isClear(newLocation))
		{
			location = new Location(newLocation);
			return true;
		}
		return false;
	}

	/**
	 * moves the creature object through maze in the direction held in the variable direction
	 * @param maze is the maze object the creature is currently moving through
	 * @param direction is a value of character type that represents the direction the Creature is to move in 
	 * @return a boolean value, true if the object is able to move in the specified direction and false otherwise
	 */ 
	public boolean move(Maze maze, char direction)
	{
		int newColumn = location.getColumn();
		int newRow = location.getRow();
		switch (direction)
		{
			case NORTH:
				newRow -= 1;
				break;
			case EAST:
				newColumn += 1;
				break;				
			case SOUTH:
				newRow += 1;
				break;
			case WEST:
				newColumn -= 1;
				break;				

		}

		if(maze.isClear(new Location(newRow, newColumn)))
		{
			location.setColumn(newColumn);
			location.setRow(newRow);
			return true;
		}
		return false;
	}	
}