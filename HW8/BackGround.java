import java.awt.*;
/**
 * A Background class that represents and holds information for the blue Background
 * @author Mmachi Obiorah
 */ 
public class BackGround extends ImageItem
{
	private Color color;
	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * A constructor for the background class
	 * @param x is the x position of the background
	 * @param y is the y position of the background
	 * @param width is the width of the background
	 * @param height is the height of the background
	 * @param color is the color the background will be filled with
	 * @param depth is an integer representing when the background will be renedered(higher depths will be rendered before lower depths)
	 */ 
	public BackGround(int x, int y, int width, int height, Color color, int depth)
	{
		super(depth, ImageItem.BACKGROUND);
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.color = color;
	}	

	/**
	 * A getter for the color data field
	 * @return the color for the background
	 */ 
	public Color getColor()
	{
		return color;
	}

	/**
	 * A getter for the x_coordinate data field of the background
	 * @return the starting x coordinate of the background
	 */ 
	public int getX()
	{
		return x;
	}	

	/**
	 * A getter for the y_coordinate data field of the background
	 * @return the starting y coordinate of the background
	 */ 
	public int getY()
	{
		return y;
	}	

	/**
	 * A getter for the width data field of the background
	 * @return the width of the background
	 */ 
	public int getWidth()
	{
		return width;
	}	

	/**
	 * A getter for the height data field of the background
	 * @return the height of the background
	 */ 
	public int getHeight()
	{
		return height;
	}			
}