/** An interface that describes the operations of a set of objects. */ 
public class LinkedSet<T> implements SetInterface<T>
{
	//inner class Node 
	private class Node
	{
		private T data;
		private Node next;

		
		private Node(T entry)
		{
			this.data = entry;
		}

		/** 
		 * Private getter of data
		 * @return data of a node
		 */
		private T getData(){
			return this.data;
		}

		/** 
		 * Private getter of next
		 * @return next element a node points to
		 */
		private Node getNext(){
			return this.next;
		} 

		/** 
		 * Private setter of data
		 * @param data is the data to be stored in a node
		 */
		private void setData(T data){
			this.data = data;
		}

		/** 
		 * Private setter of next
		 * @param next is the next element a node will point to
		 */
		private void setNext(Node next){
			this.next = next;
		}
	}


	private Node firstNode;
	private int numberOfEntries;

	public LinkedSet()
	{
		firstNode = null;
		numberOfEntries = 0;
	}

	private Node getReferenceOf(T anEntry)
	{
		boolean found = false;
		Node node = null;
		Node currentNode = firstNode;
		while(!found && currentNode != null)
		{
			if (anEntry.equals(currentNode.getData()))
			{
				found = true;
				node = currentNode;
			}
			currentNode = currentNode.getNext();
		}

		return node;
	}


	/** Gets the current number of entries in this set.
	 * @return  The integer number of entries currently in the set.
	 **/
	public int getCurrentSize()
	{
		return numberOfEntries;
	}
	
	/** Sees whether this set is empty.
	 * @return  True if the set is empty, or false if not.
	 **/
	public boolean isEmpty()
	{
		return (firstNode == null && numberOfEntries == 0);
	} 

	/** Adds a new entry to this set, avoiding duplicates. 
	 * @param newEntry  The object to be added as a new entry. 
	 * @return  True if the addition is successful, or 
	 * false if the item already is in the set.
	 **/ 
	public boolean add(T newEntry)
	{
		boolean added = false;
		if(getReferenceOf(newEntry) == null)
		{
			Node newNode = new Node(newEntry);
			newNode.setNext(firstNode);
			firstNode = newNode;
			numberOfEntries++;
			added = true;
		}
		return added;
	}


	/** Removes an unspecified entry from this set, if possible.
	 * @return  Either the removed entry, if the removal.
	 * was successful, or null. 
	 **/
	public T remove()
	{
		T removeItem = null;
		if (!isEmpty())
		{
			removeItem = firstNode.getData();
			firstNode = firstNode.getNext();
			numberOfEntries--;
		}
		return removeItem;
	}

	/** Removes a specific entry from this set, if 	possible.
	 * @param anEntry  The entry to be removed.
	 * @return  True if the removal was successful, or false if not. 
	 **/
	public boolean remove(T anEntry)
	{
		boolean removed = false;
		Node nodeToRemove = getReferenceOf(anEntry);
		if (nodeToRemove != null)
		{
			nodeToRemove.setData(firstNode.getData());
			firstNode = firstNode.getNext();
			numberOfEntries--;
			removed = true;
		}
		return removed;
	}

	/** Removes all entries from this bag. 
	 **/
	public void clear()
	{
		while(!isEmpty())
		{
			remove();
		}
		// firstNode = null;
		// numberOfEntries = 0;
	}	

	/** Tests whether this set contains a given entry.=
	 * @param anEntry  The entry to find.
	 * @return  True if the set contains anEntry, or false if not. 
	 **/
	 public boolean contains(T anEntry)
	 {
		Node currentNode = firstNode;
		while(currentNode != null){
			if(currentNode.getData() == anEntry){
				return true;
			}
			currentNode = currentNode.next;
		}
	 	return false;
	 }
   
	/** Retrieves all entries that are in this set.
	 * @return  A newly allocated array of all the entries in the set.
	 * Note: If the set is empty, the returned array is empty. 
	 **/
	 @SuppressWarnings("unchecked")
	 public T[] toArray()
	 {
	 	T[] result = (T[]) new Object[numberOfEntries];
	 	int index = 0;
	 	Node currentNode = firstNode;
	 	while(index < numberOfEntries && currentNode != null)
	 	{
	 		result[index] = currentNode.getData();
	 		currentNode = currentNode.getNext();
	 		index++;
	 	}
	 	return result;
	 }
 }