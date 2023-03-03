/**
 * A Driver class that tests PascalsTriangle
 * @author Mmachi Obiorah
 * @author Your Name
 */ 
public class PascalsTriangleDriver
{	
	public static void main(String[] args) 
	{
		try
		{
			PascalsTriangle pt1 = new PascalsTriangle(1);
			System.out.println(pt1.getChoices(0,0) == 1);
			
			PascalsTriangle pt = new PascalsTriangle(6);
			System.out.println(pt);	// should print the triangle			
			assert pt.getChoices(1,1) == 1;
			assert pt.getChoices(2,1) == 2;
			assert pt.getChoices(3,2) == 3;
			assert pt.getChoices(5,3) == 10;
			assert pt.getChoices(4,2) == 6;
			assert pt.getChoices(0,0) == 1;

			System.out.println(pt.getChoices(1,1) == 1 ? "passed" : "failed");
			System.out.println(pt.getChoices(2,1) == 2 ? "passed" : "failed");
			System.out.println(pt.getChoices(3,2) == 3 ? "passed" : "failed");
			System.out.println(pt.getChoices(5,3) == 10 ? "passed" : "failed");
			System.out.println(pt.getChoices(4,2) == 6 ? "passed" : "failed");		
			System.out.println(pt.getChoices(4,0) == 1 ? "passed" : "failed");		
			System.out.println(pt.getChoices(0,0) == 1 ? "passed" : "failed");


		}
		catch(SecurityException e)
		{
			System.out.println(e.getMessage());
			System.out.println("remove try-catch block in PascalsTriangleDriver for more detailed error message");
		 }


	}
}