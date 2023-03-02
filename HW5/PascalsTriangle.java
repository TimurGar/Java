import java.util.ArrayList;
/** 
 * @author Mmachi Obiorah
 * @author Timur Garifullin
 * A class that builds Pascal's Triangle up to a number of rows specified by the user
 * Clients can retrieve values at different positions in the triangle
 */ 
public class PascalsTriangle
{
	private ArrayList<ArrayList<Integer>> triangle;
	private int size;
	private boolean integrityOk;

	/**
	 * A default constructor for the pascal triangle
	 * It creates the first row of the triangle
	 */ 
	public PascalsTriangle()
	{	
		this(1);
	}

	/**
	 * A constructor that builds a triangle with size number of rows
	 * @param size the number of rows to build
	 */ 
	public PascalsTriangle(int size)
	{
		integrityOk = false;
		if (size < 1)
			throw new ArithmeticException("invalid size");
		triangle = new ArrayList<>();
		this.size = size;
		boolean triangleBuilt = buildTriangle();
		integrityOk = triangleBuilt;
	}

	// private method that ensures that all data fields are initialized 
	// before they are access
	private void checkIntegrity()
	{
		if (!integrityOk)
			throw new SecurityException("unauthorized access: triangle not built");
	}

	/**
	 * Private method that calculates the factorial of given number
	 * @param number is the number whose factorial needs to be found
	 * @return factorial of a given number
	 */
	private int factorial(int number){
		int factorial = 1;
		for(int i = 2; i <= number; i++){
			factorial *= i;
		}
		return factorial;
	}

	/**
	 * Private method that finds the combination 
	 * @param n is a number of given items
	 * @param k is a number of items to be selected
	 * @return number of ways to select k items, given n items
	 */
	private int combination(int n, int k){
		int numOfCombinations = factorial(n) / (factorial(n-k) * factorial(k));
		return numOfCombinations;
	}

	/**
	 * Private method that builds the pascals triangle
	 * @return if the triangle is built or not
	 */
	private boolean buildTriangle()
	{		
		for(int i = 0; i < size; i++){
			ArrayList<Integer> row = new ArrayList<>();
			for(int j = 0; j <= i; j++){
				row.add(combination(i, j));
			}
			triangle.add(row);
		}
		return true;
	}

	/**
	 * computes n combination k
	 * @param n number of items to select from
	 * @param k number of items to select
	 * @return n combination k from the table created
	 */ 
	public Integer getChoices(int n, int  k)
	{
		checkIntegrity();
		if (k < 0 || k > n || k > size)
		{
			throw new ArithmeticException("illegal choice of k");
		}
		else if(n < 0)
		{
			throw new ArithmeticException("illegal choice of n");
		}

		ArrayList<Integer> listn = triangle.get(n);
		return listn.get(k);
	}

	/**
	 * creates a string with Pasacal's triangle entries
	 * @return returns a string with Pascal's triangle entries
	 */ 
	public String toString()
	{
		checkIntegrity();
		String result = "";
		for(int i = 0; i <  triangle.size(); i++)
		{
			ArrayList<Integer> aList = triangle.get(i);
			for(Integer value: aList){
				result += value + " ";
			}
			result += "\n";			
		}
		return result;
	}	
}