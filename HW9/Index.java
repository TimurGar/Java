/**
 * An index class to hold ackerman indices
 */ 
public class Index
{
	private int row;
	private int column;

	/**
	 * a constructor for index
	 * @param i is the row index
	 * @param j is the column index
	 */ 
	public Index(int i, int j)
	{
		row = i;
		column = j;
	}

	/**
	 * a getter for the row data field
	 * @return an int that holds the row index
	 */ 
	public int getRow()
	{
		return row;
	}

	/**
	 * a getter for the column data field
	 * @return an int that holds the column index
	 */ 
	public int getColumn()
	{
		return column;
	}

	/**
	 * overrides the equal method in the Object class
	 * two indices are equal if their rows and columns are equal
	 * @param other is an Index to be compared with the current Index Object
	 * @return true if (row == other.row) && (column == other.column)
	 */ 
	public boolean equals(Object other)
	{
		Index tempOther = (Index) other;
		return ((row == tempOther.row) && (column == tempOther.column));
	}

	/**
	 * overrides the hashcode method of the Object class
	 * for unique hashcodes, it multiplies the row index by a constant integer 31
	 * @return an index for the hashtable
	 */ 
	public int hashCode()
	{
		return ((row * 31) + column);
	}

	/**
	 * overrides the toString method of the object class
	 * @return a string containing the row and column number in the Index object
	 */ 
	public String toString()
	{
		return "(" + row + "," + column + ")";
	}
}