/**
 * A utility sort class 
 * @author Mmachi Obiorah
 * @author Timur Garifullin
 */
public class Sort
{
	public static final int MIN_SIZE = 4;

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void mergeSort(T [] a)
	{
		T[] temp = (T[]) new Comparable[a.length];
		mergeSort(a, temp, 0, a.length - 1);
	}	

	public static <T extends Comparable<? super T>> void mergeSort(T [] a, T [] temp, int first, int last)
	{
		if (first < last)
		{
			int mid =  first + (last - first) / 2; //(first + last) / 2;
			mergeSort(a, temp, first, mid);
			mergeSort(a, temp, mid + 1, last);
			merge(a, temp, first, mid, last);
		}
	}

	public static <T extends Comparable<? super T>> void merge(T [] a, T [] temp, int first, int mid, int last)
	{
		int i = first;
		int j = mid + 1;
		int n = mid;
		int m = last;
		int k = first;

		while (k <= last)
		{
			if (i <= n && ((j > m) || (a[i].compareTo(a[j]) > 0)))
			{
				temp[k] = a[i];
				i++;
			}
			else
			{
				temp[k] = a[j];
				j++;
			}
			k++;
		}

		for(int index = first; index <= last; index++)
		{
			a[index] = temp[index];
		}
	}


	/**
	 * uses quick sort to sort the array a beginning from index position first to index position last
	 * @param a is an array of generic type
	 * @param first is an integer representing the position in the array where sorting starts
	 * @param last is an integer representing the position in the array where sorting ends
	 */ 
	public static <T extends Comparable<? super T>> void quickSort(T [] a, int first, int last)
	{
		// Checking if the array's size is less than 4 
		// If so using Insertion sort instead
		if (last - first + 1 < MIN_SIZE){
			insertionSort(a, first, last);
		}
		else{
			// Rearranging array items around the pivot 
			// Smaller value to the left of pivot, bigger than pivot items to the right
			int indexOfPivot = partition(a, first, last);

			// Using recursion to call the quick sort method itself
			quickSort(a, first, indexOfPivot - 1);
			quickSort(a, indexOfPivot + 1, last); 
		}
		
	}

	/**
	 * partitions the array a into two partitions, a partition with smaller items and greater items
	 * @param a is an array of generic type
	 * @param first is an integer representing the position in the array where partioning starts
	 * @param last is an integer representing the position in the array where partitioning ends
	 */ 
    private static <T extends Comparable<? super T>> int partition(T[] a, int first, int last)
    {
    	int mid = first + (last - first) / 2; //(first + last) / 2;

		// Sorting first, middle and last values 
		sortFirstMiddleLast(a, first, mid, last);
		int indexOfPivot = last - 1;
		T pivotValue = a[indexOfPivot];
		int indexFromLeft = first + 1;
		int indexFromRight = last - 2;
		boolean done = false;

		while (!done){

			// Increasing index from left while it's bigger than a pivot  
			while (a[indexFromLeft].compareTo(pivotValue) == 1){
				indexFromLeft++;
			}

			// Increasing index from right while it's smaller than a pivot  
			while (a[indexFromRight].compareTo(pivotValue) == -1){
				indexFromRight--;
			}
			if (indexFromLeft < indexFromRight){
				// Swithing places of index from left and index from right 
				swap(a, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
			else
				done = true;
		}
		// Swithing places of pivot and index from left 
		swap(a, indexOfPivot, indexFromLeft);
		indexOfPivot = indexFromLeft;
		return indexOfPivot;
    }

    /**
     * swaps the item in index position i and j of array a
     * @param a is an array of generic type
     * @param i is an index position whose entry will be exchange with the item in index position j
     * @param j is an index position whose entry will be exchange with the item in index position i
     */ 
    private static <T extends Comparable<? super T>> void swap(T[] a, int i, int j)
    {
		T temp = a[j];
		a[j] = a[i];
		a[i] = temp;
    }

	/**
	 * uses insertion sort to sort the array a beginning from index position first to index position last
	 * @param a is an array of generic type
	 * @param first is an integer representing the position in the array where sorting starts
	 * @param last is an integer representing the position in the array where sorting ends
	 */ 
    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last)
    {
		T nextVal;
		int j = 0;
    	for(int i = 0; i < a.length-1; i++){
			nextVal = a[i + 1];
			j = i;
			while(j >= 0 && nextVal.compareTo(a[j]) == 1){
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = nextVal;
		}
    }

	// ! Unnecessary method !
	
	/**
	 * finds the maximum item in an array
	 * @param a is an array of generic type
	 * @param first is an integer representing the position in the array where searching starts
	 * @param last is an integer representing the position in the array where searching ends
	 */ 
    private static <T extends Comparable<? super T>> int getMaxIndex(T[] a, int first, int last)
    {
    	//students to complete
    	return 0;
    }


    @SuppressWarnings("unchecked")
    private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last)
    {
    	if(first < mid)
   			swap(a, first, mid);
		if (mid < last)
  			swap(a, mid, last);
		if (first < mid)
			swap(a, first, mid);
    }

}