import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class that extends the frame class provided by java.awt
 * This class is resposible for drawing the images 
 * It gives us access to the Graphics class, the paint method, etc.
 * @author Mmachi G. Obiorah
 * @author Timur Garifullin
 */ 
public class MyFrame extends Frame 
{
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 500;
	public static final	int MAX_Y = SCREEN_HEIGHT - 55;
    public static final	int MAX_START_X = 0;
    public static final	int MAX_X = SCREEN_WIDTH;
    public static final	int MOUNTAIN_BASE = (int) (0.5 * SCREEN_HEIGHT);
    public static final	int TALL = 150;	

    public static final int numberOfMountains = 100;
    public static final int numberOfTrees = 30;
    public int numberOfEntries;

    private ImageItem [] imageItems;

    /**
     * Constructor for MyFrame
     * it initializes the imageItems array
     * adds ImageItems to the imageItem array
     */ 
    public MyFrame()
    {
		imageItems = new ImageItem[numberOfMountains + numberOfTrees + 3];
    	Random rand = new Random(5);	
		numberOfEntries = 0;    	 

		addBackGround();
    	generateMountains(rand);
    	addForeGround();
    	addRidge();
    	generateTrees(rand);	    	
    	Sort.quickSort(imageItems, 0, numberOfEntries - 1);
        //Sort.mergeSort(imageItems);


    	System.out.println("number of entries " + numberOfEntries);
    	for(int i = 0; i < numberOfEntries; i++)
    	{
    		System.out.print(imageItems[i].getDepth() + " ");
    	}

        setVisible(true);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }


	/**
	 * Renders the ImageItem in imagItems on the screen starting from image 0 to image numberOfEntries - 1
	 * @param g a graphics object that provides gives us access to rendering methods
	 */ 
    public void paint(Graphics g)
    {
    	for (int i = 0; i < numberOfEntries; i++)
    	{
    		ImageItem item = imageItems[i];
    		char type = item.getType();
    		switch (type)
    		{
    			case ImageItem.ELEVATION:
    				Elevation elevation = (Elevation) item;
			        g.setColor(elevation.getColor());
			    	Polygon myPolygon = elevation.getPolygon();
			        g.fillPolygon(myPolygon);
			    	g.drawPolygon(myPolygon);    				
    				break;

    			case ImageItem.TREE:
    				Tree tree = (Tree) item;
					Color brown = new Color(105,70,5);    	    				
		    		g.setColor(brown);
		    		int width = tree.getWidth();
		    		int quarterWidth = (int) (width / 4.0);
		    		int x = tree.getX() + (int) (width * 0.375);
		    		g.fillRect(x, tree.getY(), quarterWidth, tree.getHeight() + 10);
		    		g.setColor(tree.getColor());
		    		g.fillOval(tree.getX(), tree.getY(), tree.getWidth(), tree.getHeight());
    				break;

    			case ImageItem.BACKGROUND:
    				BackGround backGround = (BackGround) item;
			    	g.setColor(backGround.getColor());
			    	g.fillRect(backGround.getX(), backGround.getY(), backGround.getWidth(), backGround.getHeight());        				
    				break;
    		}
    	}
    }


    /**
     * Sets up the coordinates for the sky
     */ 
    private void addBackGround()
    {
    	Color skyblue = new Color(135, 206, 235);
    	BackGround backGround = new BackGround(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, skyblue, 7);
		imageItems[numberOfEntries] = backGround;
		numberOfEntries++;    		
    }


    /**
     * Sets up the coordinates for the foreground
     */ 
    private void addForeGround()
    {
    	Color green = new Color(0, 70, 0);
    	BackGround backGround = new BackGround(0, SCREEN_HEIGHT / 2, SCREEN_WIDTH, SCREEN_HEIGHT / 2, green, 6);    	
		imageItems[numberOfEntries] = backGround;
		numberOfEntries++;       	
    }


    /**
     * sets up the coordinates for the ridge over the foreground
     */ 
    private void addRidge()
    {
    	Color lightGreen = new Color(0, 150, 0);
    	int x1 = (int) (SCREEN_WIDTH * 0.7);    	
    	int x3 = x1 - (x1 / 2);
    	int x2 = x3 - (x1 / 2);
    	int y1 = SCREEN_HEIGHT / 2;
    	int y2 = SCREEN_HEIGHT;
    	int y3 = SCREEN_HEIGHT;

    	Polygon currPolygon = new Polygon(new int[]{x1, x2, x3} , new int[] {y1, y2, y3}, 3);    	
    	Ridge ridge = new Ridge(currPolygon, lightGreen, 4);
    	imageItems[numberOfEntries] = ridge;
    	numberOfEntries++;    	
    }


    /**
     * creates numberOfMountains triangles representing mountains
     * sets up one of 4 colors for the mountains
     * assigns a random depth to each mountain
     * adds the mountains to the imageItem array
     */ 
    private void generateMountains(Random rand)
    {
		Color [] colors = {new Color(105,70,5), new Color(150,70,5), new Color(188, 143, 143)};
		Color white = new Color(255, 255, 255);


    	for (int i = 0; i < numberOfMountains; i++)
    	{
    		int y1 = MOUNTAIN_BASE  - rand.nextInt(MOUNTAIN_BASE - 10);
    		int x2 = rand.nextInt(MAX_X);
    		int x3 = x2 + rand.nextInt(MAX_X - x2);
    		int x1 = x2 + (x3 - x2)/2;
    		int y2 = MOUNTAIN_BASE;
    		int y3 = MOUNTAIN_BASE;
    		Polygon currPolygon = new Polygon(new int[]{x1, x2, x3} , new int[] {y1, y2, y3}, 3);
    		int depth = rand.nextInt(5);
    		Color color = y1 <= TALL && depth >= 3 ? white: colors[i % colors.length];    		
    		Mountain myMountain = new Mountain(currPolygon, color, depth);
    		imageItems[numberOfEntries] = myMountain;
    		numberOfEntries++;
    	}
    }


    /**
     * Creates numberOftrees trees representing trees
     * sets up each tree with one of two colors
     * assigns a random depth to each tree
     * adds the tree to the imageItem array
     */ 
    private void generateTrees(Random rand)
    {
		Color brown = new Color(105,70,5);
		int maxDepth = 5;

		for(int i = 0; i < numberOfTrees; i++)
		{
			int x = rand.nextInt(MAX_X);
			int y = rand.nextInt(SCREEN_HEIGHT);
			int depth =  y < MOUNTAIN_BASE ? 8 : rand.nextInt(3) ;
			Color color = depth < 3 ? new Color(175, 225, 175) : new Color(0, 255, 0);
			int width = 20 + maxDepth / (depth + 1) * 10 ;
			int height = 20 + maxDepth / (depth + 1) * 10 ;
			Tree tree = new Tree(x, y, width, height, color, depth);
			imageItems[numberOfEntries] = tree;
			numberOfEntries++;
		}
    }


    public static void main(String[] args)
    {
        new MyFrame();
    }
}