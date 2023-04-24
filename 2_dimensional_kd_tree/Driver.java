public class Driver {
    public static void main(String[] args) 
	{
		Node tree7 = new Node(50, 40,  null, null);
		Node tree6 = new Node(50, 40,  null, null);
		Node tree5 = new Node(50, 40,  null, null);
		Node tree4 = new Node(50, 40,  null, null);
		Node tree3 = new Node(50, 40,  tree6, tree7);
		Node tree2 = new Node(50, 40,  tree4, tree5);
		Node tree1 = new Node(50, 40,  tree2, tree3);

		// uncomment to see the created tree
		System.out.println("*******Print Second Tree*********");		
		System.out.println(tree1);
		System.out.println();


    }    
}
