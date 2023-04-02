/**
 * An imageItem class
 * This class holds data and describes behaviour that's associated with any item in the image
 * @author Mmachi Obiorah
 */ 
public class ImageItem implements Comparable<ImageItem>
{
	public static final char MOUNTAIN = 'M';
	public static final char TREE = 'T';
	public static final char BACKGROUND = 'B';
	public static final char GRASS = 'G';
	public static final char ELEVATION = 'E';

	private Integer depth;
	private char type;

	/**
	 * Constructor for ImageItem
	 * @param depth the depth of the image on the canvas
	 * @param type the type of the image item (e.g. MOUNTAIN, TREE)
	 */ 
	public ImageItem(int depth, char type)
	{
		this.depth = depth;
		this.type = type;
	}

	/**
	 * A getter for the depth of an imageItem
	 * @return the depth of the image item
	 */ 
	public Integer getDepth()
	{
		return depth;
	}	

	/**
	 * A getter for the type of the imageItem
	 * @return the type of the image item (e.g. GROUND, MOUNTAIN, etc.)
	 */ 
	public char getType()
	{
		return type;
	}

	/**
	 * Overrides the compareTo method of the comparable class
	 * compares the current/receiving object with other
	 * @param other is the object to be compared with the receiving object
	 */ 
	public int compareTo(ImageItem other)
	{
		return depth.compareTo(other.depth);
	}
}