import java.util.HashMap;

/**
 * The class that provides functions for creating nodes
 * Serves as a base to build trees
 * @author Timur Garifullin
 * @author Mmachi Obiorah
 */ 
class Node implements Comparable<Node>{

	private Integer xCoordinate;
	private Integer yCoordinate;
	private Node leftChild;
    private Node rightChild;

    /**
	 * The default constructor for creating a new point
	 */ 
	public Node(){
		this.xCoordinate = null;
		this.yCoordinate = null;		
		this.leftChild = null;
        this.rightChild = null;
	}

	/**
	 * Another costructor for creating a new point
	 * @param xCoordinate is X coordinate of a new point
	 * @param yCoordinate is Y coordinate of a new point
	 * @param leftChild is the left child of a new point
	 * @param rightChild is the left child of a new point
	 */
    public Node(Integer xCoordinate, Integer yCoordinate, Node leftChild, Node rightChild){
		// data = new Entry(xCoordinate, yCoordinate);
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;		
		this.leftChild = leftChild == null? null : leftChild.copy();
        this.rightChild = rightChild == null? null : rightChild.copy();		
	}

    /**
	 * An accessor for x coordinate 
	 * @return returns the x coordinate associated with the point
	 */ 
	public Integer getXCoordinate(){
		return xCoordinate;
	}

	/**
	 * An accessor for y coordinate 
	 * @return returns the y coordinate associated with the point
	 */ 
	public Integer getYCoordinate(){
		return yCoordinate;
	}

    /**
	 * An accessor for the left child of a point
	 * @return the left child for the current point
	 */ 
	public Node getLeftChild(){
		return leftChild;
	}

	/**
	 * An accessor for the right child of a point
	 * @return the right child for the current point
	 */ 
	public Node getRightChild(){
		return rightChild;
	}

    /**
	 * A modifier for the left child of a point
	 * @param node is copied to the left node of the current point (object)
	 */ 
	public void setLeftChild(Node node){
		leftChild = node.copy();
	}

    /**
	 * A modifier for the right child of a point
	 * @param node node is copied to the right node of the current point (object)
	 */ 
	public void setRightChild(Node node){
		rightChild = node.copy();
	}

    /**
	 * Creates a new node from the current object
	 * @return a node that has the same entries as the current object
	 */ 
	public Node copy(){
		return copy(this);
	}

    /**
	 * A helper function for copy
	 * Creates a new node from the current object
	 * @param node is the node to be copied
	 * @return a new node that has the same entries as node
	 */ 
	private Node copy(Node node){
		Node newNode = null;
		if (node != null)
		{	
			newNode = new Node(node.getXCoordinate(), node.getYCoordinate(), node.leftChild, node.rightChild);
		}
		return newNode;
	}

    /**
	 * Overrides the compareTo method of the object class
	 * @param other the object to compare the current object to 
	 */ 
	public int compareTo(Node other){
		return 0;
	} 

	/**
	 * Method that compares the x or y coordinates of one point with another point
	 * @param other point with which the original point needs to be compared to
	 * @param level current level of a tree
	 * @return the difference between coordinates
	 */
	public int compare(Node other, int level){
		// Comparing x or y coordinate based on whether the level is odd or even 
		if(level % 2 == 0){
			// System.out.println("Comparing")
			return this.xCoordinate - other.getXCoordinate();
		}
		else{
			return this.yCoordinate - other.getYCoordinate();
		}
	}

	/** Method that checks whether the current point is equal to another object
	 * @param other another point which is used to determine if the orginal point is equal to
	 * @return whether the two objects are equal to one another
	 */
    public boolean equals(Object other){
		Node tempOther = (Node) other;
		return equals(this, tempOther);
	}

	/**
	 * Helper method for the method equals
	 * @param node1 first point
	 * @param node2 second point
	 * @return whether the two objects are equal to one another
	 */
	private boolean equals(Node node1, Node node2){
		if (node1 == null && node2 == null)
			return true;
		else if (node1 != null && node2 != null)
		{
			return  (node1.getXCoordinate() == node2.getXCoordinate() && node1.getYCoordinate() == node2.getYCoordinate());
		}
		else
			return false;
	}

    /**
	 * Overrides the toString function of the object class
	 * @return a string with the character and frequency of entries of each node in the tree
	 */ 
	public String toString(){
		String result = "";
		HashMap<Integer, String> map = new HashMap<>();
		toStringHelper(this, map, 1);
		int i = 1;

		while (map.containsKey(i))
		{
			result += "\nLevel: " + i + "\n";
			result += map.get(i);
			i++;
		}

		return result;
	}

    /**
	 * A recursive helper function for the toString function
	 * node entries in level n are placed into map(n, entries)
	 * @param node the node to be displayed
	 * @param map node entries are accumulated by levels in map
	 * @param level an integer that keeps track of the level of each noce
	 */ 
	private void toStringHelper(Node node, HashMap<Integer, String> map, int level){
		String levelString = map.get(level) ;

		if (node == null)
		{
			map.put(level, levelString  == null? (" " + '@') : levelString + " " + '@');
		}
		else
		{
			// Entry entry = node.getData();
			String newString = " (" + node.getXCoordinate() + ": " + node.getYCoordinate() + ")";				
			if (levelString == null)
				map.put(level, newString);
			else
				map.put(level, levelString  + newString);	
			toStringHelper(node.leftChild, map, level + 1);
			toStringHelper(node.rightChild, map, level + 1);
		}
	}	
}
