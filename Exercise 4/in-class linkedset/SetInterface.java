/** An interface that describes the operations of a set of objects. */ 
public interface SetInterface<T>
{
	/** Gets the current number of entries in this set.
	 * @return  The integer number of entries currently in the set.
	 **/
	public int getCurrentSize();
	
	/** Sees whether this set is empty.
	 * @return  True if the set is empty, or false if not.
	 **/
	public boolean isEmpty();  

	/** Adds a new entry to this set, avoiding duplicates. 
	 * @param newEntry  The object to be added as a new entry. 
	 * @return  True if the addition is successful, or 
	 * false if the item already is in the set.
	 **/ 
	public boolean add(T newEntry); 
	/** Removes an unspecified entry from this set, if possible.
	 * @return  Either the removed entry, if the removal.
	 * was successful, or null. 
	 **/
	public T remove();

	/** Removes a specific entry from this set, if 	possible.
	 * @param anEntry  The entry to be removed.
	 * @return  True if the removal was successful, or false if not. 
	 **/
	public boolean remove(T anEntry);

	/** Removes all entries from this bag. 
	 **/
	public void clear();	

	/** Tests whether this set contains a given entry.=
	 * @param anEntry  The entry to find.
	 * @return  True if the set contains anEntry, or false if not. 
	 **/
	 public boolean contains(T anEntry);
   
	/** Retrieves all entries that are in this set.
	 * @return  A newly allocated array of all the entries in the set.
	 * Note: If the set is empty, the returned array is empty. 
	 **/
	 public T[] toArray();

 }