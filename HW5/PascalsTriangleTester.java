import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PascalsTriangleTester{
	@Test
	public void test()
	{
		PascalsTriangle pt = new PascalsTriangle(1);
		String triangle = "\n1 \n";
		String result = "\n" + pt;
		assertEquals(triangle, result);

		pt = new PascalsTriangle(2);
		triangle = "\n1 \n1 1 \n";
		result = "\n" + pt;
		assertEquals(triangle, result);		


		pt = new PascalsTriangle(3);
		triangle = "\n1 \n1 1 \n1 2 1 \n";
		result = "\n" + pt;
		assertEquals(triangle, result);		

		pt = new PascalsTriangle(4);
		triangle = "\n1 \n1 1 \n1 2 1 \n1 3 3 1 \n";
		result = "\n" + pt;
		assertEquals(triangle, result);		

		pt = new PascalsTriangle(5);
		triangle = "\n1 \n1 1 \n1 2 1 \n1 3 3 1 \n1 4 6 4 1 \n";
		result = "\n" + pt;
		assertEquals(triangle, result);		

		pt = new PascalsTriangle(6);
		triangle = "\n1 \n1 1 \n1 2 1 \n1 3 3 1 \n1 4 6 4 1 \n1 5 10 10 5 1 \n";
		result = "\n" + pt;
		assertEquals(triangle, result);								
	}
}