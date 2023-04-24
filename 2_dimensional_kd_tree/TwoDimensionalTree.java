public class TwoDimensionalTree {
    
	private Node tree;
    private int numberOfCoordinates;

    // false - Even levels 
    // true - odd levels
    private boolean level = false;

    /**
	 * The default constructor
	 */ 
	public TwoDimensionalTree()
	{
		tree = null;
        numberOfCoordinates = 0;
	}

    private int getSize(){
        return numberOfCoordinates;
    }


    public void insert(int x, int y){
        int size = getSize();
        Node newNode = null;

        // Setting a root
        if(size == 0){
            newNode = new Node(x, y, null, null);
            // Setting the next level to be odd 
            level = !level;
        }
        else{
            if(level == false){
                
            }
        }

    }


}
