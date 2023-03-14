import java.util.Stack;
/**
 * A client class that uses the Creature class and Maze Class
 * @author Mmachi G. Obiorah
 * @author Your Name
 */ 
public class Client{

	public static void main(String [] args)
	{
		Client client = new Client();
		client.test();				
	}

	/**
	 * finds the path a creature can take through a maze from the entrance to the exit and marks it.
	 * visited locations are marked as 'V' and locations that are on the path to the exit are marked as 'P' on the maze
	 * @param creature is of type Creature and has a location on the maze
	 * @param maze is of type Maze. creature moves through maze
	 */ 
	public void findPath(Creature creature, Maze maze)
	{
		// find the path of creature from entrance  to exit	
		Stack<Location> pathStack = new Stack<>();
		char [] allDirections = {'N', 'E', 'S', 'W'};
		int flag = 0;
		boolean deadend = true;
		// Location mazeExit = maze.getExit();

		creature.moveTo(maze, maze.getEntrance());
		// Location currentCreatureLoc = creature.getLocation();

		maze.setStateAt(creature.getLocation(), 'P');
		while(!creature.getLocation().equals(maze.getExit())){	
			// System.out.println("Not an exit");
			for(char direction : allDirections){
				System.out.println(direction);
				if(creature.move(maze, direction)){
					System.out.println("Moved to " + direction);
					System.out.println("Creatures location " + creature.getLocation());

					maze.setStateAt(creature.getLocation(), 'P');
					pathStack.push(creature.getLocation());
					System.out.println("Stack peeking: " + pathStack.peek());
					deadend = false;
					break;
				}
				else{
					System.out.println("Dir " + direction + " not available");
					deadend = true;
				}
			}
			if(deadend == true){
				if(!pathStack.empty()){
					System.out.println("Moving back");
					maze.setStateAt(creature.getLocation(), 'V');
					creature.moveTo(maze, pathStack.pop());
				}
				else{
					System.out.println("NO EXIT");
					break;
				}
			}
			System.out.println("New step");

		}
	}

	/**
	 * Test mazes for a creature object 
	 */ 
	public void test()
	{
	char [][] charArr1 = {	
		{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',' ','X'},
		{'X',' ','X',' ','X','X','X','X',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
		{'X',' ','X','X','X','X','X',' ','X','X','X','X','X',' ','X','X',' ','X',' ',' '},
		{'X',' ','X','X','X','X','X',' ','X','X','X','X','X','X','X',' ','X','X',' ','X'},
		{'X',' ','X',' ','X','X',' ','X','X',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' '},
		{'X',' ','X','X','X','X','X','X','X','X','X','X',' ','X','X',' ',' ','X',' ',' '},
		{'X','X','X','X','X','X','X','X','X','X','X','X','o','X','X','X','X','X','X','X'}};

	char [][] charArr2 = {	
		{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',' ','X'},
		{'X',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X','X','X','X',' ','X'},
		{'X',' ','X','X','X','X','X',' ',' ','X','X','X','X','X',' ',' ','X','X',' ','X'},
		{'X',' ','X','X','X','X','X',' ','X','X','X','X','X','X','X',' ','X','X',' ','X'},
		{'X',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X','X',' ','X','X',' ','X'},
		{'X',' ','X','X','X','X','X','X','X','X','X','X',' ','X','X',' ',' ',' ',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X','X','X','o','X','X','X','X','X','X','X'}};

	char [][] charArr3 = {	
		{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',' ','X'},
		{'X',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X','X','X','X',' ','X'},
		{'X',' ','X','X','X','X','X',' ',' ','X','X','X','X','X',' ',' ','X','X',' ','X'},
		{'X',' ','X','X','X','X','X',' ','X','X','X','X','X','X','X',' ','X','X',' ','X'},
		{'X',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X','X',' ','X','X',' ','X'},
		{'X',' ','X','X','X','X','X','X','X','X','X','X',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X','X','X','o','X','X','X','X','X','X','X'}};

	char [][] charArr4 = {	
		{'X','X','X','X','X','X','X','X','X','X',' ','X','X','X','X','X','X','X','X','X'},
		{'X',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X','X','X','X',' ','X'},
		{'X',' ','X','X','X',' ','X',' ',' ','X','X','X','X','X',' ',' ','X','X',' ','X'},
		{'X',' ','X','X','X',' ',' ',' ','X','X','X','X','X','X','X',' ','X','X',' ','X'},
		{'X',' ','X','X','X',' ',' ','X','X','X','X','X','X','X','X',' ','X','X',' ','X'},
		{'X',' ','X','X','X',' ','X','X','X','X','X','X',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','o','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};

	char [][] solved1 = {	
		{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','P','X'},
		{'X',' ','X',' ','X','X','X','X',' ','X',' ',' ',' ',' ',' ',' ',' ',' ','P',' '},
		{'X',' ','X','X','X','X','X',' ','X','X','X','X','X',' ','X','X',' ','X','P',' '},
		{'X',' ','X','X','X','X','X',' ','X','X','X','X','X','X','X','V','X','X','P','X'},
		{'X',' ','X',' ','X','X',' ','X','X',' ','X',' ','P','P','P','P','P','P','P',' '},
		{'X',' ','X','X','X','X','X','X','X','X','X','X','P','X','X',' ',' ','X',' ',' '},
		{'X','X','X','X','X','X','X','X','X','X','X','X','P','X','X','X','X','X','X','X'}};		

	char [][] solved2 = {	
		{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',' ','X'},
		{'X',' ',' ',' ',' ',' ','X','V','V','V','V','V','V','V','X','X','X','X',' ','X'},
		{'X',' ','X','X','X','X','X','V','V','X','X','X','X','X',' ',' ','X','X',' ','X'},
		{'X',' ','X','X','X','X','X','V','X','X','X','X','X','X','X',' ','X','X',' ','X'},
		{'X',' ','X','V','V','V','V','V','V','V','V','V','V','X','X',' ','X','X',' ','X'},
		{'X',' ','X','X','X','X','X','X','X','X','X','X','V','X','X',' ',' ',' ',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X','X','X','V','X','X','X','X','X','X','X'}};

	char [][] solved3 = {	
		{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','P','X'},
		{'X',' ',' ',' ',' ',' ','X','V','V','V','V','V','V','V','X','X','X','X','P','X'},
		{'X',' ','X','X','X','X','X','V','V','X','X','X','X','X','V','V','X','X','P','X'},
		{'X',' ','X','X','X','X','X','V','X','X','X','X','X','X','X','V','X','X','P','X'},
		{'X',' ','X','V','V','V','V','V','V','V','V','V','V','X','X','V','X','X','P','X'},
		{'X',' ','X','X','X','X','X','X','X','X','X','X','P','P','P','P','P','P','P','X'},
		{'X','X','X','X','X','X','X','X','X','X','X','X','P','X','X','X','X','X','X','X'}};

	char [][] solved4 = {	
		{'X','X','X','X','X','X','X','X','X','X','P','X','X','X','X','X','X','X','X','X'},
		{'X','P','P','P','P','P','X','P','P','P','P',' ',' ',' ','X','X','X','X',' ','X'},
		{'X','P','X','X','X','P','X','P',' ','X','X','X','X','X',' ',' ','X','X',' ','X'},
		{'X','P','X','X','X','P','P','P','X','X','X','X','X','X','X',' ','X','X',' ','X'},
		{'X','P','X','X','X',' ',' ','X','X','X','X','X','X','X','X',' ','X','X',' ','X'},
		{'X','P','X','X','X',' ','X','X','X','X','X','X',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','P','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};		

		Maze mazeP1 = new Maze(charArr1, new Location(6, 12), new Location(0, 18));
		Maze mazeP2 = new Maze(charArr2, new Location(6, 12), new Location(0, 18));
		Maze mazeP3 = new Maze(charArr3, new Location(6, 12), new Location(0, 18));
		Maze mazeP4 = new Maze(charArr4, new Location(6, 1), new Location(0, 10));

		Maze mazeS1 = new Maze(solved1, new Location(6, 12), new Location(0, 18));
		Maze mazeS2 = new Maze(solved2, new Location(6, 12), new Location(0, 18));
		Maze mazeS3 = new Maze(solved3, new Location(6, 12), new Location(0, 18));
		Maze mazeS4 = new Maze(solved4, new Location(6, 1), new Location(0, 10));

		// test 1
		System.out.println("Maze 1");
		findPath(new Creature(mazeP1.getEntrance()), mazeP1);
		System.out.print(mazeP1);
		System.out.println(mazeS1.equals(mazeP1)? "passed": "failed");
		System.out.println();

		//test 2
		System.out.println("Maze 2");
		findPath(new Creature(mazeP2.getEntrance()), mazeP2);
		System.out.print(mazeP2);
		System.out.println(mazeS2.equals(mazeP2)? "passed": "failed");
		System.out.println();	

		// test 3
		System.out.println("Maze 3");
		findPath(new Creature(mazeP3.getEntrance()), mazeP3);
		System.out.print(mazeP3);
		System.out.println(mazeS3.equals(mazeP3)? "passed": "failed");
		System.out.println();	

		// test 4
		System.out.println("Maze 4");
		findPath(new Creature(mazeP4.getEntrance()), mazeP4);
		System.out.print(mazeP4);
		System.out.println(mazeS4.equals(mazeP4)? "passed": "failed");
		System.out.println();	

		// use assert to test
		assert mazeS1.equals(mazeP1);
		assert mazeS2.equals(mazeP2);
		assert mazeS3.equals(mazeP3);
		assert mazeS4.equals(mazeP4);

	}

}