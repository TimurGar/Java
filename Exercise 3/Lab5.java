/**
 * A class for questions on arrays
 * @author Timur Garifullin
 */ 
public class Lab5
{
	public static int testCount = 0;

	/**
	 * modifies arr in-place so that the first k values of arr are unique
	 * @param arr is a sorted array of integers
	 */ 
	public static void uniqueArray(int [] arr)
	{
		int slowRunner = 0;
        int fastRunner = -1;
        for(int i = 0; i < arr.length; i++){
            if(fastRunner != arr[i]){
                fastRunner = arr[i];
                arr[slowRunner] = fastRunner;
                slowRunner++;
            }
        }
	}


	/**
	 * modifies arr in-place so that the first k entries of arr does not contain val
	 * @param arr is an array of integers
	 * @param val is the value, an integer to be removed from arr
	 * @return an integer that is the length of the array with out the entru val
	 */ 
	public static int removeVal(int [] arr, int val)	
	{
		int fastRunner = -1;
        int index = 0;
        int k = 0;
        for(int i = 0; i < arr.length; i++){
            fastRunner = arr[i];
            if(fastRunner != val){
                arr[index] = fastRunner;
                index++;
            }
        }
        k = index;
		return k;
	}


	/**
	 * determines the maximum profit from a list of stock prices 
	 * @param prices is an array of integers whose entries are prices of stocks with each index of the prices representing the days
	 * @return an integer that is the maximum profit possible given the entries in prices 
	 */
	public static int maximumProfit(int [] prices) 	
	{
		int buy = prices[0]; 
        int sell = 0; 
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] <= buy){
                buy = prices[i];
                sell = prices[i];
            }
            if(prices[i] >= sell){
                sell = prices[i];
            }
            
        }
        maxProfit = sell - buy;
        return maxProfit;  
	}


	/**
	 * Tests for uniqueArray, removeVal and maximumProfit
	 */ 
	public static void test() 
	{
		// test 1
		int [] arr1 = {1,1,2};
		int [] arr2 = {1,2,2};		
		uniqueArray(arr1);
		System.out.println("Test case " + (++testCount) + ": " + (compareArray(arr1, arr2, 2) ? "passed" : "failed"));

		// test 2
		int [] arr3 = {0,0,1,1,1,2,2,3,3,4};
		int [] arr4 = {0,1,2,3,4,2,2,3,3,4};		
		uniqueArray(arr3);
		System.out.println("Test case " + (++testCount) + ": " + (compareArray(arr3, arr4, 5) ? "passed" : "failed"));

		// test 3
		int [] arr9 = {1, 2, 2, 3, 4, 4, 4, 5, 5};
		int [] arr10 = {1, 2, 3, 4, 5, 4, 4, 5, 5};
		uniqueArray(arr9);		
		System.out.println("Test case " + (++testCount) + ": " + (compareArray(arr9, arr10, 5) ? "passed" : "failed"));

		// test 4
		int [] arr11 = {};
		int [] arr12 = {};
		uniqueArray(arr11);			
		System.out.println("Test case " + (++testCount) + ": " + (compareArray(arr11, arr12, 0) ? "passed" : "failed"));

		// test 5
		int[] arr5 = {3,2,2,3}; //val = 3, 
		int val = removeVal(arr5, 3);
		System.out.println("Test case " + (++testCount) + ": " + ((checkEntries(arr5, 2, 3) && val == 2)  ? "passed" : "failed"));

		// test 6
		int[] arr13 = {1};  	
		val = removeVal(arr13, 1);
		System.out.println("Test case " + (++testCount) + ": " + ((checkEntries(arr13, 0, 1) && val == 0)  ? "passed" : "failed"));

		int[] arr15 = {0,1,2,2,3,0,4,2}; // {0,1,3,0,4,0,4,2}
		val = removeVal(arr15, 2);
		System.out.println("Test case " + (++testCount) + ": " + ((checkEntries(arr15, 5, 2) && val == 5)  ? "passed" : "failed"));

		// test 7
		int [] prices = {7,1,5,3,6,4};		
		val = maximumProfit(prices);
		System.out.println("Test case " + (++testCount) + ": " + (val == 5 ? "passed" : "failed"));

		// test 8
		int [] prices1 = {7,6,4,3,1};		
		val = maximumProfit(prices1);
		System.out.println("Test case " + (++testCount) + ": " + (val == 0 ? "passed" : "failed"));	

		// test 9
		int [] prices2 = {7,6,4,3,8};		
		val = maximumProfit(prices2);
		System.out.println("Test case " + (++testCount) + ": " + (val == 5 ? "passed" : "failed"));	

	}

	/**
	 * compares entries in two arrays: array1 and array2 up to index endIndex
	 * @param array1 an array with unique and sorted entries from index 0 to endIndex - 1
	 * @param array2 an array with unique and sorted entries from index 0 to endIndex - 1
	 * @param endIndex the last index position for unique entries
	 */ 
	private static boolean compareArray(int [] array1, int [] array2, int endIndex)
	{
		for (int i = 0; i < endIndex; i++) 
		{
			if (array1[i] != array2[i])
				return false;
		}
		return true;
	}

	/**
	 * Ensures removedEntry is not in array by comparing the entries in positions 0 to endIndex - 1
	 * @param array the array whose entries will be checked
	 * @param endIndex the index position to stop the check at
	 * @param removedEntry the entry that is not to appear in array between indices 0 and endIndex - 1
	 */ 
	private static boolean checkEntries(int [] array, int endIndex, int removedEntry)
	{
		for (int i = 0; i < endIndex; i++)
		{
			if(array[i] == removedEntry)
				return false;
		}
		return true;
	}

	/**
	 * prints the entries in array to the standard output
	 * @param array an array of integers
	 */ 
	private void printArray(int [] array)
	{
		for(int val: array)
			System.out.print(val + " ");
		System.out.println();
	}
}