/**
 * A class of Nodes
 * @author Mmachi Obiorah
 */ 
public class Node
{
	private Node next;
	private int data;

	/**
	 * A constructor that initializes data
	 * @param entry is an integer that will be used to initialize data
	 */ 
	public Node(int entry)
	{
		data = entry;
		next = null;
	}	

	/**
	 * A constructor that initializes the receiving object with another Node
	 * @param node a node to initialize the receiving object. 
	 * precondition: Node must not be null
	 */ 
	public Node(Node node)
	{
		if (node != null)
		{
			data = node.getData();
			next = node.getNext();			
		}
	}

	/**
	 * A getter for the link portion of the receiving object
	 * @return the reference to the link portion of the object
	 */ 
	public Node getNext()
	{
		return next;
	}

	/**
	 * A getter for the data portion of a node
	 * @return An integer stored in the node
	 */ 
	public int getData()
	{
		return data;
	}

	/**
	 * A setter for the link portion of the node
	 * @param node the link portion of the node reference node
	 */ 
	public void setNext(Node node)
	{
		next = node;
	}
}