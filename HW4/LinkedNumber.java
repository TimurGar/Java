
/**
 * @author Mmachi Obiorah
 * @author Timur Garifullin
 * A class of numbers whose digits are placed in nodes
 */ 
public class LinkedNumber
{
	private Node firstNode;

	/**
	 * A getter for the first node
	 */ 
	public Node getFirstNode()
	{
		return firstNode;
	}

	/**
	 * The default constructor for LinkedNumber
	 * It initializes the first node to null
	 */ 
	public LinkedNumber()
	{
		firstNode = null;
	}

	/**
	 * A constructor that initializes linked number with a node
	 * The node might be a linked chain
	 * @param node is a node to initialize the firstNode of the object
	 */ 
	public LinkedNumber(Node node)
	{
		firstNode = new Node(node);

	}

	/**
	 * A method that adds the current LinkedNumber object to another LinkedNumber object
	 * @param number is a number to be added to the receiving object 
	 * @return a LinkedNumber object with the digits in the sum of the recieving object and number
	 */ 
	public LinkedNumber add(LinkedNumber number)
	{		
        int number1 = 0;
        int number2 = 0;
        int sum = 0;
		int carryVal = 0;
		int numberOfNodes = 0;
	
        Node currentNodeA = this.getFirstNode();
        Node currentNodeB = number.getFirstNode();
        
		Node node = new Node(null);
		Node head = node;
		Node tail = node;

        while(currentNodeA != null || currentNodeB != null){

			/* Excluding a number from Linked Number #1
			when calculating the sum, if the Linked 
			Number #1 is over */
			if(currentNodeA == null){
				number2 = currentNodeB.getData();
				currentNodeB = currentNodeB.getNext();
				sum = number2;
			
			}

			/* Excluding a number from Linked Number #2
			when calculating the sum, if the Linked 
			Number #2 is over */
			else if(currentNodeB == null){
				number1 = currentNodeA.getData();
				currentNodeA = currentNodeA.getNext();
				sum = number1;
			}

			// Both Linked Number #1 and Linked Number #2 are not over 
			else {
				number1 = currentNodeA.getData();
				number2 = currentNodeB.getData();
				currentNodeA = currentNodeA.getNext();
				currentNodeB = currentNodeB.getNext();
				sum = number1 + number2;
			}

			// Changing the value of the first node to the sum
			if(numberOfNodes == 0){
				// Checking if there is a carry value
				if(sum >= 10){
					carryVal = 1;
					sum = sum - 10;
				}
				node = new Node(sum);
				head = node;
				tail = node;
				numberOfNodes++;
				
			}

			// Node is not the first node
			else{
				/*Checking if there is a carry value 
				from a previous number */
				if(carryVal != 0){
					sum = sum + carryVal;
					carryVal = 0;
				}
				/*Checking if current number will have a carry value */	
				if(sum >= 10){
					Node newNode = new Node(sum - 10);
					tail.setNext(newNode);
					tail = tail.getNext();
					numberOfNodes+=1;
					carryVal = 1;   
				}

				else{
					Node newNode = new Node(sum);
					tail.setNext(newNode);
					tail = tail.getNext();
					numberOfNodes++;
					carryVal = 0;
				}
			}
        }

		// Adding last node
		if(carryVal != 0){
			Node newNode = new Node(carryVal);
			tail.setNext(newNode);
			tail = tail.getNext();
			numberOfNodes++;
			carryVal = 0;
		}

		LinkedNumber result = new LinkedNumber(head); 
		return result;	
	}

	/**
	 * Overrides the toString method of the Object class
	 * prints out the digits in the nodes of the receiving object
	 * @return a string whose characters are the digits in the receiving object 
	 */ 
	public String toString()
	{
		String result = "";
		Node currentNode = firstNode;
		while(currentNode != null)
		{
			result = currentNode.getData() + result;
			currentNode = currentNode.getNext();
		}

		return result;
	}

	/**
	 * Compares the receiving object with another LinkedNumber object
	 * by comparing the data in each node
	 * @param other is another LinkedNumber object
	 * @return true if all the digits in the receiving object are same as the digits in other
	 */ 
	public boolean equals(Object other)
	{
		boolean isEqual = false;
		if (other instanceof LinkedNumber)
		{
			Node currentNodeA = firstNode;
			Node currentNodeB = ((LinkedNumber) other).getFirstNode();
			isEqual = true;
			while(isEqual && (currentNodeA != null || currentNodeB != null))
			{
				if ((currentNodeA != null) && (currentNodeB != null))
				{
					isEqual = isEqual && (currentNodeA.getData() == currentNodeB.getData());									
					currentNodeA = currentNodeA.getNext();
					currentNodeB = currentNodeB.getNext();	
				}else
					return false;				
			}
		}
		return isEqual;
	}		
}