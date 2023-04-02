import java.awt.*;
/**
 * A Ridge class is a class that defines the dimensions and behavior of the light
 * green contour in the image
 * @author Mmachi Obiorah
 */ 
public class Ridge extends Elevation
{
	/**
	 * A constructor for a Ridge
	 * @param polygon is the polygon representing the ridge
	 * @param color is the color the ridge will be filled with
	 * @param depth is an int that determines when the ridge will be rendered
	 */ 	
	public  Ridge(Polygon polygon, Color color, int depth)
	{
		super(polygon, color, depth, ImageItem.ELEVATION);
	}	
}