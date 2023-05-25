import static org.junit.jupiter.api.Assertions.assertEquals;
// static allows members that are declared as static to be used without the 
// specifying their class name

import org.junit.jupiter.api.Test;

public class AckermanTest
{
	@Test
	void testSignal()
	{
		int [][] ackermanFunctions = {
			{1, 2,  3,  4,  5},
			{2, 3,  4,  5,  6},
			{3, 5,  7,  9,  11},
			{5, 13, 29, 61, 125}			
		};

		int [][] retrievalCounts = {
			{0, 0,  0,  0,  0},
			{0, 0,  0,  0,  0},
			{0, 1,  2,  3,  4},
			{1, 6, 15, 32, 65}			
		};

		for(int i = 0; i < ackermanFunctions.length; i++)
		{
			for(int j = 0; j < ackermanFunctions[i].length; j++)
			{
				Ackerman ac = new Ackerman(i,j);						
		 		assertEquals(ac.getAckermanResult(), ackermanFunctions[i][j]);	
		 		assertEquals(ac.getNumberOfMapRetrievals(), retrievalCounts[i][j]);	
			}
		}
	}
}