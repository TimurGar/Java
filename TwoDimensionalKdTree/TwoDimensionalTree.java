
/**
 * The class that provides functionallity to build a 2D tree
 * @author Timur Garifullin
 */
public class TwoDimensionalTree {
    
	private Node tree;
    private int numberOfCoordinates;

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

    /**
     * Method that checks if the tree is empty
     * @return whether the tree is empty
     */
    private boolean isEmpty(){
        if(numberOfCoordinates == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Method to insert a new point into a 2d tree
     * @param x is X coordinate of a new point
     * @param y is Y coordinate of a new point
     */
    public void insert(int x, int y){
        Node newNode = new Node(x, y, null, null);

        // Setting a root of a tree
        if(isEmpty()){
            tree = newNode;
            numberOfCoordinates++;
        }
        // Inserting the new cordinates in a not empty tree
        else{
            insertHelper(newNode, tree, 2);
        }
    }

    /**
     * Private recursive method that helps method insert with adding new coordinates 
     * to a right location in a 2d tree
     * @param newNode new coordinates that needs to be added to a 2d tree
     * @param parent initially a root of a tree, later a node that is being evaluated 
     * for possibility of becoming a parent for a new node 
     * @param level current level of a tree
     */
    private void insertHelper(Node newNode, Node parent, int level){
        // Even level
        if(level % 2 == 0){
            // X cordinate of a new node is bigger than the X cordinate of a parent node
            if(newNode.getXCoordinate() > parent.getXCoordinate()){
                if(parent.getRightChild() != null){
                    parent = parent.getRightChild();
                    insertHelper(newNode, parent, level + 1);
                }

                else{
                    parent.setRightChild(newNode);
                }
            }

            // X cordinate of a new node is smaller than the X cordinate of a parent node
            else{
                if(parent.getLeftChild() != null){
                    parent = parent.getLeftChild();
                    insertHelper(newNode, parent, level + 1);
                }

                else{
                    parent.setLeftChild(newNode);
                }
            }
        }

        // Odd level
        else{
            // Y cordinate of a new node is bigger than the X cordinate of a parent node
            if(newNode.getYCoordinate() > parent.getYCoordinate()){
                if(parent.getRightChild() != null){
                    parent = parent.getRightChild();
                    insertHelper(newNode, parent, level + 1);
                }

                else{
                    parent.setRightChild(newNode);
                }
            }

            // Y cordinate of a new node is smaller than the X cordinate of a parent node
            else{
                if(parent.getLeftChild() != null){
                    parent = parent.getLeftChild();
                    insertHelper(newNode, parent, level + 1);
                }

                else{
                    parent.setLeftChild(newNode);
                }
            }
        }
    }

    /**
     * Method that tests whether a given point is in the tree 
     * @param x is X coordinate of a given point
     * @param y is Y coordinate of a given point
     * @return whether a given point is in the tree
     */
    public boolean contains(int x, int y){

        Node newNode = new Node(x, y, null, null);
        // containsHelper(tree, newNode, 1);

        return  findEntry(tree, newNode, 1) != null;
    }

    /**
     * Private method that helps contains method to determine whether the given point 
     * is in a tree, by traversing it and checking every node
     * @param rootNode the current node
     * @param entry an node that is being searched for
     * @param level the current level 
     * @return result is the found node, or null
     */
    private Node findEntry(Node rootNode, Node entry, int level){
        Node result = null;
        if (rootNode != null){
            if (entry.equals(rootNode)){
                // System.out.println("Entry is equal to root");
                result = rootNode;
            }
            else if (entry.compare(rootNode, level) > 0)
                result = findEntry(rootNode.getLeftChild(), entry, level + 1);
            else
                result = findEntry(rootNode.getRightChild(), entry, level + 1);
        }

        return result;
    }
}
