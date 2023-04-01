/**
 * A utility sort class 
 * @author Mmachi Obiorah
 * @author Your Name
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
	// @SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void quickSort(T [] a, int first, int last)
	{
		// Checking if the array's size is less than 4 
		if (last - first + 1 < MIN_SIZE){
			insertionSort(a, first, last);
		}
		else{
			int pivotIndex = partition(a, first, last);
			quickSort(a, first, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, last); 
		}
		
	}

	/**
	 * partitions the array a into two partitions, a partition with smaller itens and greater items
	 * @param a is an array of generic type
	 * @param first is an integer representing the position in the array where partioning starts
	 * @param last is an integer representing the position in the array where partitioning ends
	 */ 
    private static <T extends Comparable<? super T>> int partition(T[] a, int first, int last)
    {
    	int mid = first + (last - first) / 2; //(first + last) / 2;
		sortFirstMiddleLast(a, first, mid, last);
		int pivotIndex = last - 1;
		T pivotValue = a[pivotIndex];
		int indexFromLeft = first + 1;
		int indexFromRight = last - 2;
		boolean done = false;

		while (!done){

			while (a[indexFromLeft].compareTo(pivotValue) == 1){
				indexFromLeft++;
			}

			while (a[indexFromRight].compareTo(pivotValue) == -1){
				indexFromRight--;
			}
			if (indexFromLeft < indexFromRight){

				// Exchange a[indexFromLeft] and a[indexFromRight]
				swap(a, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
			else
				done = true;
		}
		// Exchange a[pivotIndex] and a[indexFromLeft]
		swap(a, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;
		return pivotIndex;
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
    	if(first > mid)
   			swap(a, first, mid);
		if (mid > last)
  			swap(a, mid, last);
		if (first > mid)
		swap(a, first, mid);
    }

}