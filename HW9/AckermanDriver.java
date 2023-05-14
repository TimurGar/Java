import java.util.HashMap;
public class AckermanDriver
{
	public static void main(String[] args) 
	{
		// Ackerman function results for positions i, j
		// int [][] ackermanFunctions = {
		// 	{1, 2,  3,  4,  5},
		// 	{2, 3,  4,  5,  6},
		// 	{3, 5,  7,  9,  11},
		// 	{5, 13, 29, 61, 125}			
		// };

		int rowLength = 4;
		int columnLength = 5;
		for(int i = 0; i < rowLength; i++)
		{
			for(int j = 0; j < columnLength; j++)
			{
				Ackerman ac = new Ackerman(i, j);
		 		System.out.println(ac);						
			}
		}
	}
}