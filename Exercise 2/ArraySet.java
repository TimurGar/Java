import java.util.Arrays;
/** An interface that describes the operations of a set of objects. */ 
public class ArraySet<T> implements SetInterface<T>
{
	private T[] set;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 5;
	private static final int MAXIMUM_CAPACITY = 10;
	private boolean integrityOk;

	/**
	 * default constructor
	 */ 
	public ArraySet()
	{
		this(DEFAULT_CAPACITY);
	}

	/**
	 * A constructor that accepts the capacity of the set
	 */ 
	@SuppressWarnings("unchecked")
	public ArraySet(int capacity)
	{
		integrityOk = false;
		checkCapacity(capacity);
		set = (T[]) new Object[capacity];
		numberOfEntries = 0;
		integrityOk = true;
	}

	private void checkIntegrity()
	{
		if (!integrityOk)
			throw new SecurityException("unathorized access");
	}

	private void checkCapacity(int capacity)
	{
		if (capacity > MAXIMUM_CAPACITY)
			throw new IllegalStateException("Exceeds maximum capacity");
	}

	private void ensureCapacity()
	{
		if (numberOfEntries >= set.length)
		{
			int newLength = set.length * 2;
			checkCapacity(newLength);
			set = Arrays.copyOf(set, newLength);
		}
	}

	private int getIndexOf(T anEntry)
	{
		int index = -1;
		int i = 0;
		boolean found = false;
		while(!found && i < numberOfEntries)
		{
			if (anEntry.equals(set[i]))
			{
				index = i;
				found = true;
			}
			i++;
		}
		return index;
	}


	private T removeEntry(int index)
	{
		T removedItem = null;
		if (!isEmpty() && index >= 0)
		{
			removedItem = set[index];
			set[index] = set[numberOfEntries - 1];
			set[numberOfEntries - 1] = null;
			numberOfEntries--;
		}

		return removedItem;
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
		return numberOfEntries == 0;
	}  

	/** Adds a new entry to this set, avoiding duplicates. 
	 * @param newEntry  The object to be added as a new entry. 
	 * @return  True if the addition is successful, or 
	 * false if the item already is in the set.
	 **/ 
	public boolean add(T newEntry)
	{
		checkIntegrity();
		ensureCapacity();
		int index = getIndexOf(newEntry);
		boolean added = false;
		if (index == -1)
		{
			set[numberOfEntries] = newEntry;
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
		checkIntegrity();
		T removedItem = removeEntry(numberOfEntries - 1);
		return removedItem;
	}

	/** Removes a specific entry from this set, if 	possible.
	 * @param anEntry  The entry to be removed.
	 * @return  True if the removal was successful, or false if not. 
	 **/
	public boolean remove(T anEntry)
	{
		checkIntegrity();
		int index = getIndexOf(anEntry);
		T removedItem = removeEntry(index);
		return anEntry.equals(removedItem);
	}

	/** Removes all entries from this bag. 
	 **/
	public void clear()
	{
		while(!isEmpty())
			remove();
	}	

	/** Tests whether this set contains a given entry.
	 * @param anEntry  The entry to find.
	 * @return  True if the set contains anEntry, or false if not. 
	 **/
	 public boolean contains(T anEntry)
	 {
	 	checkIntegrity();
	 	int index = getIndexOf(anEntry);
	 	return index >= 0;
	 }
   
	/** Retrieves all entries that are in this set.
	 * @return  A newly allocated array of all the entries in the set.
	 * Note: If the set is empty, the returned array is empty. 
	 **/
	 public T[] toArray()
	 {
	 	checkIntegrity();
         @SuppressWarnings("unchecked")
        // creating a new object(array) of genering type the size of numberOfEntries
	 	T[] result = (T[]) new Object[numberOfEntries];
        for(int i = 0; i < numberOfEntries; i++){
            result[i] = set[i];
        }
	 	return result;
	 }
 }