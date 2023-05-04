import java.util.HashMap;
/**
 * A class that computes the ackerman function
 * @author Mmachi G. Obiorah
 * @author Timur Garifullin
 */
public class Ackerman
{
	private int numberOfMapRetrievals;
	private int m;
	private int n;
	private int ackermanResult;
	private HashMap<Index, Integer> map;

	/**
	 * the default constructor initializes m and n to zero 
	 */ 
	public Ackerman()
	{
		this(0, 0);
	}

	/**
	 * A constructor that initializes m and n to values provided by the client
	 * initializes the map,
	 * and computes the ackerman function 
	 * @param m is the first argument to the ackerman function
	 * @param n is the second argument to the ackerman function
	 */ 
	public Ackerman(int m, int n)
	{
		numberOfMapRetrievals = 0;
		this.m = m;
		this.n = n;
		map = new HashMap<>();
		ackermanResult = ackerman(this.m, this.n);
	}	

	/**
	 * a getter for the computed ackerman function
	 * @return the computed ackerman function
	 */ 
	public int getAckermanResult()
	{
		return ackermanResult;
	}

	/**
	 * A getter for the number of retrievals from the map during the computation of the ackerman function
	 * @return the number of retrievals from the map
	 */ 
	public int getNumberOfMapRetrievals()
	{
		return numberOfMapRetrievals;
	}

	/**
	 * computes ackerman function at m, n
	 * @param m is a row number
	 * @param n is a column number
	 * @return the ackerman function, A(m, n) at m and n
	 */ 
	private int ackerman(int m, int n)
	{
		Index index = new Index(m, n);
		int value = 0;

		// Checking whether function with provided parameters (m, n) 
		// have been already evaluated
		if(map.containsKey(index)){
			// Counting the number of retrievals
			numberOfMapRetrievals++;
			return map.get(index);
		}

		// Function with provided parameters (m, n) 
		// have NOT been already evaluated
		else{
			
			// Calculating the output (value) of ackerman function
			// based on the m and n
			if(m == 0){
				value = n+1;
			}
			else if(m > 0 && n == 0){
				value = ackerman(m - 1, 1);
			}
			else if(m > 0 && n > 0){
				value = ackerman(m - 1, ackerman(m, n - 1));
			}

			// Adding the result of a function to hashmap
			map.put(index, value);
			return map.get(index);
		}
	}

	/**
	 * returns a string with information about the ackerman function including
	 * the indices and the number of retrievals from the map
	 */ 
	public String toString()
	{
		return "ackerman(" + m + ", " + n + "): " + ackermanResult + " " + "hashmap retrievals: " + numberOfMapRetrievals; 
	}
}