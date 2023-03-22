public class QueueClient
{
	public static void main(String[] args) 
	{
		QueueInterface<Integer>	myQueue = new ArrayQueue<>();

		try
		{
			QueueInterface<Integer>	anotherQueue = new ArrayQueue<>(15);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println("Testing Enqueue");
		myQueue.enqueue(5);
		displayContent(myQueue);

		myQueue.enqueue(2);
		displayContent(myQueue);

		myQueue.enqueue(3);
		displayContent(myQueue);

		myQueue.enqueue(4);
		displayContent(myQueue);

		myQueue.enqueue(1);
		displayContent(myQueue);

		myQueue.enqueue(12);
		displayContent(myQueue);

		System.out.println("Testing dequeue");
		myQueue.dequeue();
		displayContent(myQueue);

		myQueue.dequeue();
		displayContent(myQueue);

		myQueue.dequeue();
		displayContent(myQueue);		

		System.out.println("Continue testing enqueue");
		myQueue.enqueue(78);
		displayContent(myQueue);	

		myQueue.enqueue(8);
		displayContent(myQueue);

		myQueue.enqueue(256);
		displayContent(myQueue);

		myQueue.enqueue(43);
		displayContent(myQueue);

		myQueue.enqueue(54);
		displayContent(myQueue);

		myQueue.enqueue(91);
		displayContent(myQueue);

		myQueue.enqueue(12);
		displayContent(myQueue);
	
// 
		try
		{
			myQueue.enqueue(12);
			displayContent(myQueue);				
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println("Testing clear");
		myQueue.clear();
		displayContent(myQueue);		

		try
		{
			System.out.println("Testing isEmpty");
			myQueue.dequeue();			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println("Enqueue items to test getFront");
		myQueue.enqueue(91);
		displayContent(myQueue);

		myQueue.enqueue(12);
		displayContent(myQueue);	

		System.out.println(myQueue.getFront());
					
	}


	public static <T> void displayContent(QueueInterface<T> aQueue)
	{
		T[] queueContent = aQueue.toArray();

		for( T item : queueContent)
		{
			System.out.print(item + " ");
		}

		System.out.println();
		System.out.println();
	}
}