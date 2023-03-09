public class SetClient
{
	public static void main(String[] args) 
	{
		SetInterface<Integer> mySet = new LinkedSet<>();
		System.out.println(mySet.add(2));
		displaySetContent(mySet);

		System.out.println(mySet.add(2));

		System.out.println("day 2");
		displaySetContent(mySet);

		System.out.println(mySet.add(3));		
		displaySetContent(mySet);	
		
		System.out.println(mySet.add(5));		
		displaySetContent(mySet);	

		System.out.println(mySet.add(7));		
		displaySetContent(mySet);	

		System.out.println(mySet.add(4));		
		displaySetContent(mySet);	

		System.out.println(mySet.remove());		
		displaySetContent(mySet);		


		System.out.println(mySet.remove(2));		
		displaySetContent(mySet);						

	}


	public static <T> void displaySetContent(SetInterface<T> aSet)
	{
		T [] setContent = aSet.toArray();
		for(T item : setContent)
		{
			System.out.print(item + " ");
		}
		System.out.println();
	}
}