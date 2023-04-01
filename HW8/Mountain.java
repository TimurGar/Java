import java.awt.*;
/**
 * A Mountain class which extends Elevation
 * This class holds data fields and describe behavior that represents the mountain objects in the image 
 * @author Mmachi Obiorah
 */ 
public class Mountain extends Elevation
{
	/**
	 * A constructor for Mountain 
	 * @param polygon is the polygon representing the mountain
	 * @param color is the color the mountain will be filled with
	 * @param depth is an int that determines when the mountain will be rendered
	 */ 
	public Mountain(Polygon polygon, Color color, int depth)
	{
		super(polygon, color, depth, ImageItem.ELEVATION);
	}	
}