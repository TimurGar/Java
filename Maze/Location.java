/**
 * A class to represent 2 dimensional positions
 * @author Mmachi G. Obiorah
 * @author Timur Garifullin
 */ 
public class Location
{
	private int row;
	private int column;

	/**
	 * A Location constructor
	 * @param row an integer containing the row position
	 * @param column an integer containing the column position
	 */ 
	public Location(int row, int column)
	{
		this.row = row;
		this.column = column;
	}

	/**
	 * A Location constructor that creates a Location object from another Location object
	 * @param location is an object of type Location
	 */ 
	public Location(Location location)
	{
		this.row = location.getRow();
		this.column = location.getColumn();
	}

	/**
	 * A getter for the row position
	 * @return an integer that is a row position
	 */ 
	public int getRow()
	{
		return row;
	}

	/**
	 * A getter for the column position
	 * @return an integer that is a column position
	 */ 
	public int getColumn()
	{
		return column;
	}

	/**
	 * A setter for the row position
	 * @param row is an integer that this.row will be updated to
	 */
	 public void setRow(int row) 
	 {
	 	this.row = row;
	 }

	/**
	 * A setter for the column position
	 * @param column is an integer that this.column will be updated to
	 */
	 public void setColumn(int column) 
	 {
	 	this.column = column;
	 }	 

	/**
	 * overrides the equals method of the Object class
	 * @param other a Location object to be compared with the current/receiving object
	 * @return true if the current object and other have the same row and column values 
	 */ 
	public boolean equals(Object other) 
	{ 	
		if (other instanceof Location)
		{
			Location otherPos = (Location) other;
			return (this.row == otherPos.getRow() && this.column == otherPos.getColumn()); 			
		}
		return false;
	} 

	/**
	 * overrides the toString object of the Object class
	 * @return a String with information about the current Location object
	 */ 
	public String toString()
	{
		return("(" + row + "," + column + ")");
	}
}