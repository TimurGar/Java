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

    /**
	 * Returns the 2D tree
	 * @return a 2D tree
	 */ 
    public Node getTree()
	{
		return tree;
	}

    private int getSize(){
        return numberOfCoordinates;
    }


    public void insert(int x, int y){
        int size = getSize();
        Node newNode = new Node(x, y, null, null);
        System.out.println("Level is currently " + level);

        // Setting a root
        if(size == 0){
            tree = newNode;
        }
        else{
            System.out.println(tree.compare(newNode, level));
            if(tree.compare(newNode, level) > 0){
                tree.setLeftChild(newNode);
            }
            else{
                tree.setRightChild(newNode);
            }

            // Setting the next level to be odd 
            level = !level;
            
        }
        numberOfCoordinates++;
        System.out.println("Level is currently " + level);

    }


}
