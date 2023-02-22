/**
 * @author Timur Garifullin
 */
public class SetClient
{
	public static void main(String[] args) 
	{
        testMethods();
	}

	public static <T> void displaySetContent(SetInterface<T> aSet)
	{
		T[] setContent = (T[]) aSet.toArray();
        System.out.print("Set contains: ");
		for (T item : setContent)
			System.out.print(item + " ");
		System.out.println();
	}

    public static void testMethods(){
        SetInterface<Integer> set2 = new ArraySet<>(10);
        System.out.println("Item 4 added: " + set2.add(4));
        System.out.println("Item 4 added: " + set2.add(4));
        System.out.println("Item 8 added: " + set2.add(8));
        System.out.println("Item 6 added: " + set2.add(6));

        // testing toArray method
        displaySetContent(set2);

        // testing contains method
        System.out.println("set contains element 4: " + set2.contains(4));
        System.out.println("set contains element 13: " + set2.contains(13));

        // testing getCurrentSize method
        System.out.println("Current size of a set: " + set2.getCurrentSize());
        set2.remove(8);
        System.out.println("8 removed");
        System.out.println("Current size of a set: " + set2.getCurrentSize());

        // testing isEmpty & clear method
        System.out.println("Array is empty: " + set2.isEmpty());
        set2.clear();
        
        System.out.println("Item 5 added: " + set2.add(5));
        System.out.println("Item 7 added: " + set2.add(7));

        displaySetContent(set2);

        set2.clear();
        System.out.println("Array is empty: " + set2.isEmpty());
    }


}