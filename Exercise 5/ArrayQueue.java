import javax.swing.DefaultBoundedRangeModel;

public class ArrayQueue<T> implements QueueInterface<T>
{
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 5;
    private static final int MAXIMUM_CAPACITY = 10;
    private boolean integrityOK;

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int intitialCapacity){
        integrityOK = false;
        if(intitialCapacity < DEFAULT_CAPACITY)
            intitialCapacity = DEFAULT_CAPACITY;
        checkCapacity(intitialCapacity);
        queue = (T[]) new Object[intitialCapacity + 1];
        frontIndex = 0;
        backIndex = queue.length - 1;
        integrityOK = true;
    }

    private void checkCapacity(int capacity){
        if(capacity > MAXIMUM_CAPACITY)
            throw new IllegalStateException("maximum capacity exceeded");
    }

    private void checkIntergrity(){
        if(!integrityOK)
            throw new SecurityException("unauthorized access");
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(){
        if(frontIndex == ((backIndex + 2) % queue.length)){
            int oldSize = queue.length;
            int newSize = (oldSize - 1) * 2;
            checkCapacity(newSize);
            T [] oldQueue = queue;
            queue = (T[]) new Object[newSize + 1];
            for(int index = 0; index < oldSize - 1; index++){
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }

            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }

	/**
	 * Adds a new entry to the back of the queue
	 * @param newEntry is the new entry
	 */ 
	public void enqueue(T newEntry){
        checkIntergrity();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

	/**
	 * Removes and returns the entry at the front of the queue
	 * @return returns the queue's front entry.
	 * @throws EmptyQueueException if the queue is empty before the operation
	 */ 
	public T dequeue(){
        checkIntergrity();
        if(isEmpty())
            throw new EmptyQueueException("empty queue in dequeue");
           
        T front = this.getFront();
        queue[frontIndex] = null;
        frontIndex = (frontIndex + 1) % queue.length;
        return front;
    }

	/**
	 * Retrieves the queue's front entry without changing the queue in any way
	 * @return the queue's front entry
	 * @throws EmptyQueueException if the queue is empty before the operation
	 */ 
	public T getFront(){
        checkIntergrity();
        if(isEmpty())
            throw new EmptyQueueException("empty queue in getFront");
        else
            return queue[frontIndex];
    }

	/**
	 * Detects whether the queue is empty
	 * @return true if the queue is empty
	 */ 
	public boolean isEmpty(){
        return frontIndex == ((backIndex + 1) % queue.length);
    }

	/**
	 * Removes all entries from the queue
	 */ 
	public void clear(){
        checkIntergrity();
        if(isEmpty())
            throw new EmptyQueueException("empty queue in clear");

        for(int index = 0; index < queue.length; index++){
            queue[index] = null;
        }
        frontIndex = 0;
        backIndex = queue.length - 1;
        System.out.println(isEmpty());
        
    }

	/**
	 * Returns the entries of the queue in the chronological order
	 * @return an array with queue entries in chronological order
	 */ 
    @SuppressWarnings("unchecked")
	public T[] toArray(){
        checkIntergrity();

        if(isEmpty()){
            T[] array = (T[]) new Object[0];
            return array;
        }

        // Setting index to front index less than 1 to make sure that the first element will be printed
        int index = frontIndex-1;
        int length = queue.length;
        int arrayIndex = 0;
        int numOfItems = 0;
       
        // Counting the number of non-null items
        for(int i = 0; i < length; i++){
            if(queue[i] != null){
                numOfItems++;
            } 
        }    
        
        // appending the array with queue items in chronological order
        T[] array = (T[]) new Object[numOfItems];
        while(index != backIndex){
            index = (index + 1) % length;
            array[arrayIndex] = queue[index];
            arrayIndex++;
        }

        return array;
    }
}