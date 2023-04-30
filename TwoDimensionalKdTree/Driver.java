
/**
 * class that creates a two dimensional tree, 
 * inserts and checks if the tree contains items
 * @author Timur Garifullin
 */
public class Driver {
    public static void main(String[] args) 
	{

		System.out.println("*******Creating 2D Tree*********");		
		TwoDimensionalTree tree = new TwoDimensionalTree();

		// Inserting points into a 2D tree
		tree.insert(50, 40);
		tree.insert(40, 70);
		tree.insert(80, 20);
		tree.insert(90, 10);
		tree.insert(60, 30);

		System.out.println(tree.getTree());
		System.out.println();

		// Testing existing points
		System.out.println(tree.contains(50, 40));
		System.out.println(tree.contains(40, 70));
		System.out.println(tree.contains(80, 20));
		System.out.println(tree.contains(90, 10)); 
		System.out.println(tree.contains(60, 30));

		// Testing non existing points
		System.out.println(tree.contains(50, 50));
		System.out.println(tree.contains(10, 10));
		System.out.println(tree.contains(100, 100));
    }    
}
