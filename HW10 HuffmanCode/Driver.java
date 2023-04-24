public class Driver
{
	public static void main(String[] args) 
	{
		// Examples of how to use Node methods
		
		// Example 1: building a tree
		// create a leaf
		Node node = new Node('K', 3,  null, null);

		// create tree with the leaf created above as a leaf in the new tree
		// creates a new Node with node
		// assigns the reference of the new node to the variable node 
		int i = 0;
		while(i < 10)
		{
			char c =  (char) (i + 65);
			Node aNode = new Node(c, i,  node, null);
			node =  aNode;
			i++;
		}

		// uncomment to see the created tree
		System.out.println("*******Print First Tree*********");
		System.out.println(node);
		System.out.println();


		// Example 2: building a tree
		// create a tree progressively
		// tree7, tree6, tree5 and tree4 are leaves
		Node tree7 = new Node('7', 0,  null, null);
		Node tree6 = new Node('6', 0, null, null);
		Node tree5 = new Node('5', 0, null, null);
		Node tree4 = new Node('4', 0, null, null);
		Node tree3 = new Node('3', 0, tree6, tree7);
		Node tree2 = new Node('2', 0, tree4, tree5);
		Node tree1 = new Node('1', 0, tree2, tree3);

		// uncomment to see the created tree
		System.out.println("*******Print Second Tree*********");		
		System.out.println(tree1);
		System.out.println();


		// Example 3: huffman tests
		// builds a huffman tree with the a text
		HuffmanCode huffmanCode = new HuffmanCode("aaaaaaaaaaaabbbcdddddddddeeeeeeeeeeeeeee");

		// print the created huffman tree
		System.out.println("*******Print First Huffman Tree*********");		
		System.out.println(huffmanCode.getTree());
		System.out.println();

		// test encode
		System.out.println("*******First Huffman Tree: Encoding*********");				
		System.out.println("a: " + huffmanCode.encode('a'));
		System.out.println("b: " + huffmanCode.encode('b'));
		System.out.println("c: " + huffmanCode.encode('c'));
		System.out.println("d: " + huffmanCode.encode('d'));
		System.out.println("e: " + huffmanCode.encode('e'));
		System.out.println();

		// test decode
		System.out.println("*******First Huffman Tree: Decoding*********");				
		System.out.println("10: " + huffmanCode.decode("10"));
		System.out.println("1101: " + huffmanCode.decode("1101"));
		System.out.println("1100: " + huffmanCode.decode("1100"));
		System.out.println("111: " + huffmanCode.decode("111"));
		System.out.println("0: " + huffmanCode.decode("0"));
		System.out.println();


		// Example 4: huffman tests
		// builds a huffman tree with the a text		
		HuffmanCode huffmanCode1 = new HuffmanCode("qzpzpzq");

		// print the tree
		System.out.println("*******Print Second Huffman Tree*********");				
		System.out.println(huffmanCode1.getTree());
		System.out.println();

		// test encode
		System.out.println("*******Second Huffman Tree: Encoding*********");				
		System.out.println("z: " + huffmanCode1.encode('z'));
		System.out.println("p: " + huffmanCode1.encode('p'));
		System.out.println("q: " + huffmanCode1.encode('q'));
		System.out.println();

		// test decode
		System.out.println("*******Second Huffman Tree: Decode*********");				
		System.out.println("0: " + huffmanCode1.decode("0"));
		System.out.println("10: " + huffmanCode1.decode("10"));
		System.out.println("11: " + huffmanCode1.decode("11"));
	}
}