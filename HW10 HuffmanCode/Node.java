import java.util.Deque;
import java.util.HashMap;

/**
 * The Node class provides functions for creating a tree
 * @author Mmachi Obiorah
 * @author Timur Garifullin
 */ 
class Node implements Comparable<Node>
{
	// data
	private Integer frequency;
	private Character character;

	private Node rightChild;
	private Node leftChild;

	/**
	 * The default constructor
	 */ 
	public Node()
	{

	}

	/**
	 * Creates a Node object from a character and two nodes
	 * @param character an entry is created from the character
	 * @param frequency a entry is created with this frequency
	 * @param leftChild the left node of the new node
	 * @param rightChild the right node of the new node
	 */ 
	public Node(Character character, Integer frequency, Node leftChild, Node rightChild)
	{
		// data = new Entry(frequency, character);
		this.frequency = frequency;
		this.character = character;		
		this.rightChild = rightChild == null? null : rightChild.copy();
		this.leftChild = leftChild == null? null : leftChild.copy();		
	}	

	/**
	 * Creates a node from a node 
	 * @param node is a node to create a new node from
	 */ 
	public Node(Node node)
	{
		this(node.getCharacter(), node.getFrequency(), node.leftChild, node.rightChild);
	}

	/**
	 * An accessor for frequency 
	 * @return returns the frequency associated with the object
	 */ 
	public Integer getFrequency()
	{
		return frequency;
	}

	/**
	 * An accessor for character 
	 * @return returns the frequency associated with the object
	 */ 
	public Character getCharacter()
	{
		return character;
	}	

	/**
	 * A modifier for character
	 * @param character the character datafield of the object is set to character
	 */ 
	public void setCharacter(Character character)
	{
		this.character = character;
	}		

	/**
	 * An accessor for the rightChild
	 * @return the right node for the current object
	 */ 
	public Node getRightChild()
	{
		return rightChild;
	}

	/**
	 * An accessor for the leftChild
	 * @return the left node for the current object
	 */ 
	public Node getLeftChild()
	{
		return leftChild;
	}

	/**
	 * A modifier for the right node
	 * @param node node is copied to the right node of the current object
	 */ 
	public void setRightChild(Node node)
	{
		rightChild = node.copy();
	}

	/**
	 * A modifier for the left node
	 * @param node node is copied to the left node of the current object
	 */ 
	public void setLeftChild(Node node)
	{
		leftChild = node.copy();
	}

	/**
	 * Creates a new node from the current object
	 * @return a node that has the same entries as the current object
	 */ 
	public Node copy()
	{
		return copy(this);
	}

	/**
	 * A helper function for copy
	 * Creates a new node from the current object
	 * @param node is the node to be copied
	 * @return a new node that has the same entries as node
	 */ 
	private Node copy(Node node)
	{
		Node newNode = null;
		if (node != null)
		{	
			newNode = new Node(node.getCharacter(), node.getFrequency(), node.leftChild, node.rightChild);
		}
		return newNode;
	}

	/**
	 * Overrides the compareTo method of the object class
	 * @param other the object to compare the current object to 
	 */ 
	public int compareTo(Node other)
	{
		return this.frequency - other.getFrequency();
	} 		

	public boolean equals(Object other)
	{
		Node tempOther = (Node) other;
		return equals(this, tempOther);
	}

	private boolean equals(Node node1, Node node2)
	{
		if (node1 == null && node2 == null)
			return true;
		else if (node1 != null && node2 != null)
		{
			return  (node1.getFrequency() == node2.getFrequency() && 
				node1.getCharacter() == node2.getCharacter() && 
				equals(node1.leftChild, node2.leftChild) && 
				equals(node1.rightChild, node2.rightChild));
		}
		else
			return false;
	}

	/**
	 * Overrides the toString function of the object class
	 * @return a string with the character and frequency of entries of each node in the tree
	 */ 
	public String toString()
	{
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
	private void toStringHelper(Node node, HashMap<Integer, String> map, int level)
	{
		String levelString = map.get(level) ;

		if (node == null)
		{
			map.put(level, levelString  == null? (" " + '@') : levelString + " " + '@');
		}
		else
		{
			// Entry entry = node.getData();
			String newString = " (" + node.getCharacter() + ": " + node.getFrequency() + ")";				
			if (levelString == null)
				map.put(level, newString);
			else
				map.put(level, levelString  + newString);	
			toStringHelper(node.leftChild, map, level + 1);
			toStringHelper(node.rightChild, map, level + 1);
		}
	}
}