import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertTrue; 
import static org.junit.jupiter.api.Assertions.assertFalse; 

/**
 * Class that conducts a series of tests with Junit
 * @author Timur Garifullin
 */
public class TestTwoDimensionalTree {

    // Testing method insert of the 2D tree
    @Test
	public void TestTreeInsert(){
        // Testing insertion in the root
        TwoDimensionalTree tree = new TwoDimensionalTree();
        Node node1 = new Node(50, 40,  null, null);

        tree.insert(50, 40);
        assertEquals(node1, tree.getTree());

        // Testing insertion in the level 2 (as a child of the root)
        Node node2 = new Node(40, 70,  null, null);
		Node node3 = new Node(80, 20,  null, null);
        Node node4 = new Node(50, 40,  node2, node3);

		tree.insert(40, 70);
		tree.insert(80, 20);
        assertEquals(node4, tree.getTree());


         // Testing insertion in the level 3 (as a child of the root's child)
        Node node5 = new Node(90, 10,  null, null);
		Node node6 = new Node(60, 30,  null, null);
		Node node7 = new Node(40, 70,  null, null);
		Node node8 = new Node(80, 20,  node5, node6);
		Node node9 = new Node(50, 40,  node7, node8);
 
        tree.insert(80, 20);
        tree.insert(60, 30);
        assertEquals(node9, tree.getTree());
       
    }

    // Testing method contains of the 2D tree
    @Test
    public void TestTreeContains(){
        TwoDimensionalTree tree = new TwoDimensionalTree();

        tree.insert(50, 40);
		tree.insert(40, 70);
		tree.insert(80, 20);
		tree.insert(90, 10);
		tree.insert(60, 30);

        assertTrue(tree.contains(50, 40));
        assertTrue(tree.contains(40, 70));
        assertTrue(tree.contains(80, 20));
        assertTrue(tree.contains(90, 10));
        assertTrue(tree.contains(60, 30));

        assertFalse(tree.contains(50, 50));
        assertFalse(tree.contains(10, 40));
        assertFalse(tree.contains(100, 20));
    }

    // Testing the shape of the 2D tree
    @Test
	public void test2DTree(){
        TwoDimensionalTree tree = new TwoDimensionalTree();

        tree.insert(50, 40);
		tree.insert(40, 70);
		tree.insert(80, 20);
		tree.insert(90, 10);
		tree.insert(60, 30);        

		Node node1 = new Node(90, 10,  null, null);
		Node node2 = new Node(60, 30,  null, null);
		Node node3 = new Node(40, 70,  null, null);
		Node node4 = new Node(80, 20,  node1, node2);
		Node node5 = new Node(50, 40,  node3, node4);

        assertEquals(node5, tree.getTree());
    }
}
