import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; 

public class TestTwoDimensionalTree {

    // Testing method insert of the 2D tree
    @Test
	public void TestTreeInsert(){
        TwoDimensionalTree tree = new TwoDimensionalTree();
        
    }


    // Testing method contains of the 2D tree
    @Test
    public void TestTreeContains(){
        TwoDimensionalTree tree = new TwoDimensionalTree();

        Node node = tree.contains(50, 40);

        Assert.assertTrue(node instanceof BSTNode);
    }

    // Testing the shape of the 2D tree
    @Test
	public void test2DTree(){
        TwoDimensionalTree tree = new TwoDimensionalTree();

		Node node1 = new Node(90, 10,  null, null);
		Node node2 = new Node(60, 30,  null, null);
		Node node3 = new Node(40, 70,  null, null);
		Node node4 = new Node(80, 20,  node1, node2);
		Node node5 = new Node(50, 40,  node3, node4);

        assertEquals(node5, tree.getTree());
    }
}
