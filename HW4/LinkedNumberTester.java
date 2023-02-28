import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class LinkedNumberTester{
	// @Test
	public static void test()
	{
		Node a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11;
		Node b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;	
		Node s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12;	
		// adding nodes from the least significant node


		/************************************************
		 * Test 1: 123 + 923                            *
		 ************************************************/ 
		a1 = new Node(3); a2 = new Node(2); a3 = new Node(1);
		b1 = new Node(3); b2 = new Node(2); b3 = new Node(9);

		a1.setNext(a2); a2.setNext(a3);
		b1.setNext(b2); b2.setNext(b3);

		s1 = new Node(6); s2 = new Node(4); s3 = new Node(0); s4 = new Node(1);
		s1.setNext(s2); s2.setNext(s3); s3.setNext(s4);

		sumAndTest(a1, b1, s1);


		/************************************************
		 * Test 2: 5 + 5                                *
		 ************************************************/ 
		a1 = new Node(5); 
		b1 = new Node(5); 

		s1 = new Node(0); s2 = new Node(1);
		s1.setNext(s2);		

		sumAndTest(a1, b1, s1);

		/************************************************
		 * Test 3: 238 + 129                            *
		 ************************************************/ 
		a1 = new Node(8); a2 = new Node(3); a3 = new Node(2);
		b1 = new Node(9); b2 = new Node(2); b3 = new Node(1);

		a1.setNext(a2); a2.setNext(a3);
		b1.setNext(b2); b2.setNext(b3);

		s1 = new Node(7); s2 = new Node(6); s3 = new Node(3);
		s1.setNext(s2); s2.setNext(s3);		

		sumAndTest(a1, b1, s1);

		/************************************************
		 * Test 4: 342 + 465                            *
		 ************************************************/ 
		a1 = new Node(2); a2 = new Node(4); a3 = new Node(3);
		b1 = new Node(5); b2 = new Node(6); b3 = new Node(4);

		a1.setNext(a2); a2.setNext(a3);
		b1.setNext(b2); b2.setNext(b3);

		s1 = new Node(7); s2 = new Node(0); s3 = new Node(8);
		s1.setNext(s2); s2.setNext(s3);		

		sumAndTest(a1, b1, s1);

		/************************************************
		 * Test 5: 99999999999 + 999999                 *
		 ************************************************/ 
		a1 = new Node(9); a2 = new Node(9); a3 = new Node(9); a4 = new Node(9); a5 = new Node(9);
		a6 = new Node(9); a7 = new Node(9); a8 = new Node(9); a9 = new Node(9); a10 = new Node(9);
		a11 = new Node(9);

		a1.setNext(a2); a2.setNext(a3); a3.setNext(a4); a4.setNext(a5); a5.setNext(a6);
		a6.setNext(a7); a7.setNext(a8); a8.setNext(a9); a9.setNext(a10); a10.setNext(a11);

		s1 = new Node(8); s2 = new Node(9); s3 = new Node(9); s4 = new Node(9); s5 = new Node(9);
		s6 = new Node(9); s7 = new Node(0); s8 = new Node(0); s9 = new Node(0); s10 = new Node(0);
		s11 = new Node(0); s12 = new Node(1);

		s1.setNext(s2); s2.setNext(s3); s3.setNext(s4); s4.setNext(s5); s5.setNext(s6);
		s6.setNext(s7); s7.setNext(s8); s8.setNext(s9); s9.setNext(s10); s10.setNext(s11);
		s11.setNext(s12);

		sumAndTest(a1, a6, s1);
	}

	private static void sumAndTest(Node a1, Node b1, Node s1)
	{
		LinkedNumber a = new LinkedNumber(a1);
		LinkedNumber b = new LinkedNumber(b1);
		LinkedNumber c = a.add(b);

		LinkedNumber s = new LinkedNumber(s1);		

		// assertEquals(s, c);
	}	
    public static void main(String[] args) {
        test();
    }
}