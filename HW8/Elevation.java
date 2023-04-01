import java.awt.*;

/**
 * A class for Elevations (Moutains and Ridges)
 * @author Mmachi Obiorah
 */ 
public class Elevation extends ImageItem
{
	private Polygon polygon;
	private Color color;

	/**
	 * A constructor for an Elevation
	 * @param polygon is the polygon representing the Elevation
	 * @param color is the color the polygon will be filled with
	 * @param depth is an int representing when the Elevation will be rendered
	 * @param type is the type of the elevation 
	 */ 
	public Elevation(Polygon polygon, Color color, int depth, char type)
	{
		super(depth, type);
		this.polygon = polygon;
		this.color = color;
	}

	/**
	 * A getter for the color of the Elevation
	 * @return the color of the elevation
	 */ 
	public Color getColor()
	{
		return color;
	}

	/**
	 * A getter for the polygon
	 * @return the polygon representing the elevation
	 */ 
	public Polygon getPolygon()
	{
		return polygon;
	}		
}