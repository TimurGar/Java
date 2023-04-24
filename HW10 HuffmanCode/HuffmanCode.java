import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Iterator;

/**
 * A HuffmanCode class that creates a tree, encodes characters and decodes strings
 * @author Mmachi Obiorah
 * @author Timur Garifullin
 */ 
public class HuffmanCode
{
	private Node tree;
	private String text;

	public static final Character ON_BIT = '1';
	public static final Character OFF_BIT = '0';


	/**
	 * The default constructor
	 */ 
	public HuffmanCode(String text)
	{
		this.text = text;
		tree = null;
		buildHuffmanTree();
	}


	/**
	 * Returns the Huffman tree that encodes and decodes string and characters
	 * @return a Huffman tree
	 */ 
	public Node getTree()
	{
		return tree;
	}	


	/**
	 * An accessor for the text with which the tree is built
	 * @return the text with which the tree is built
	 */ 
	 public String getText()
	 {
	 	return text;
	 }


	/**
	 * Creates a Huffman tree from a string s
	 */ 
	private void buildHuffmanTree()
	{
		// Generating a hash map with characters and their frequencies 
		HashMap<Character, Integer> frequencyList = generateMap(text);

		// Arranging hash map in ascending order with priority queue
		PriorityQueue<Node> priorityQueue = generateSortedPriorityQueue(frequencyList);
		
		// Generating a Huffman Tree
		Node sumNode = null;
		while(priorityQueue.size() >= 2){
			Node node1 = (Node) priorityQueue.remove();
			Node node2 = (Node) priorityQueue.remove();

			int sumFrequency = node1.getFrequency() + node2.getFrequency();

			sumNode = new Node(null, sumFrequency, node1, node2); 
			priorityQueue.add(sumNode);
		
		}
		this.tree = sumNode;

	}

	/**
	 * Private method that generates the hash map with characters and their frequencies 
	 * @param text is a string of characters the hash map of which needs to be created
	 * @return hash map with characters and their frequencies 
	 */
	private HashMap<Character, Integer> generateMap(String text){

		HashMap<Character, Integer> map = new HashMap<>();

		// Going through the string of characters
		for(int i = 0; i < text.length(); i++){
			char key = text.charAt(i);

			// Adding a character if doesn't already exists in a hash map
			if(!map.containsKey(key)){
				map.put(key, 1);
			}
			else{
				// Updating the frequency of an existing character in a hash map
				int newFrequency = map.get(key) + 1;
				map.put(key, newFrequency);
			}
		}
		return map;
	}

	/**
	 * Private method that sorts the hash map by adding all 
	 * the characters and their frequencies to a priority queue
	 * @param map hash map with characters and their frequencies 
	 * @return priority queue with charcters from hash map sorted by their respected frequencies
	 */
	private PriorityQueue<Node> generateSortedPriorityQueue(HashMap map){
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		
		// Creating an iterator to iterate through hash map
		Iterator keyIterator = map.entrySet().iterator();

		// Iterating through every pair (character, frequency) in the hashmap
		while(keyIterator.hasNext()){
			Map.Entry<Character, Integer> pair = (Map.Entry)keyIterator.next();

			// generating a new node that has a character and character's frequency
			Node newNode = new Node((Character)pair.getKey(),(Integer)pair.getValue(), null, null);
			priorityQueue.add(newNode);
		}

		return priorityQueue;
	}

	/**
	 * encodes a character c using the Huffman tree in tree
	 * @param c The character to encode
	 */ 
	public String encode (Character c)
	{
		String code = encodeHelper(tree, c, "");
		return code;
	}

	/** 
	 * A recursive helper function for the encode function
	 * Traverses the tree starting from the top to find a character
	 * added 0 or 1 to a code (string) as when it visits left or right child of each node
	 * @param node the node of a Huffman tree (may have children)
	 * @param character is the character that we want to get the code of
	 * @param code is a code for a character accumulated while the traversal of Huffman tree 
	 * @return code is a complete code for a character accumulated while the traversal of Huffman tree 
	 */ 
	private String encodeHelper(Node node, Character character ,String code){
		// Base case
		// runs if a character was found
		if(node != null && node.getCharacter() == character){
			return code;
		}
	
		String leftCode = null;
		String rightCode = null;
		// Recursive case
		// traversing left side of a tree while adding "0" to code,
		if(node.getLeftChild() != null){
			leftCode = encodeHelper(node.getLeftChild(), character, code + OFF_BIT);
		}

		// then traversing right and adding "1" to code
		if(node.getRightChild() != null){
			rightCode = encodeHelper(node.getRightChild(), character, code + ON_BIT);
		}

		if(leftCode != null) 
			return leftCode;
		else 
			return rightCode;
	}
	
	/**
	 * decodes a string using the code represented in the Huffman tree
	 * @param code The string to decode
	 */ 
	public Character decode(String code)
	{
		Node currentNode = tree;

		// Going through each number in the code
    	for(int i = 0; i < code.length(); i++){
			char codeNumber = code.charAt(i);

			// taking a right branch for each 1 encountered
			if(codeNumber == ON_BIT){ 
				currentNode = currentNode.getRightChild();
			}

			// taking a left branch for each 0 encountered
			else if(codeNumber == OFF_BIT){
				currentNode = currentNode.getLeftChild();
			}		

		}	
		return currentNode.getCharacter();
	}	
}