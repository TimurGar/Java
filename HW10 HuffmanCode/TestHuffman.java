import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; 
// static allows members that are declared as static to be used without the 
// specifying their class name

public class TestHuffman
{
	@Test
	public void testHuffmanEncode()
	{
		HuffmanCode huffmanCode = new HuffmanCode("aaaaaaaaaaaabbbcdddddddddeeeeeeeeeeeeeee");
		assertEquals("10", huffmanCode.encode('a'));
		assertEquals("1101", huffmanCode.encode('b'));
		assertEquals("1100", huffmanCode.encode('c'));
		assertEquals("111", huffmanCode.encode('d'));
		assertEquals("0", huffmanCode.encode('e'));
	}

	@Test
	public void testHuffmanDecode()
	{
		HuffmanCode huffmanCode = new HuffmanCode("aaaaaaaaaaaabbbcdddddddddeeeeeeeeeeeeeee");
		assertEquals('a', huffmanCode.decode("10"));
		assertEquals('b', huffmanCode.decode("1101"));
		assertEquals('c', huffmanCode.decode("1100"));
		assertEquals('d', huffmanCode.decode("111"));
		assertEquals('e', huffmanCode.decode("0"));
		
	}

	@Test
	public void testHuffmanTree()
	{
		HuffmanCode huffmanCode = new HuffmanCode("aaaaaaaaaaaabbbcdddddddddeeeeeeeeeeeeeee");
		
		Node node1 = new Node('c', 1,  null, null);
		Node node2 = new Node('b', 3,  null, null);
		Node node3 = new Node(null, 4,  node1, node2);
		Node node4 = new Node('d', 9,  null, null);
		Node node5 = new Node('a', 12,  null, null);
		Node node6 = new Node(null, 13,  node3, node4);
		Node node7 = new Node('e', 15,  null, null);
		Node node8 = new Node(null, 25,  node5, node6);
		Node node9 = new Node(null, 40,  node7, node8);

		assertEquals(node9, huffmanCode.getTree());
	}
}