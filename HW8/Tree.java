import java.awt.*;
/**
 * A Tree class that represents and holds information for a Tree objects in the image
 * @author Mmachi Obiorah
 */ 
public class Tree extends ImageItem
{
	private Color color;
	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * A constructor for the Tree class
	 * @param x is the x position of the Tree
	 * @param y is the y position of the Tree
	 * @param width is the width of the Tree
	 * @param height is the height of the Tree
	 * @param color is the color the Tree will be filled with
	 * @param depth is an integer representing when the Tree will be renedered(higher depths will be rendered before lower depths)
	 */ 
	public Tree(int x, int y, int width, int height, Color color, int depth)
	{
		super(depth, ImageItem.TREE);
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.color = color;
	}	

	/**
	 * A getter for the color data field
	 * @return the color for the Tree
	 */ 
	public Color getColor()
	{
		return color;
	}

	/**
	 * A getter for the x_coordinate data field of the Tree
	 * @return the starting x coordinate of the Tree
	 */ 
	public int getX()
	{
		return x;
	}	

	/**
	 * A getter for the y_coordinate data field of the Tree
	 * @return the starting y coordinate of the Tree
	 */ 
	public int getY()
	{
		return y;
	}	

	/**
	 * A getter for the width data field of the Tree
	 * @return the width of the Tree
	 */ 
	public int getWidth()
	{
		return width;
	}	

	/**
	 * A getter for the height data field of the Tree
	 * @return the height of the Tree
	 */ 
	public int getHeight()
	{
		return height;
	}			
}