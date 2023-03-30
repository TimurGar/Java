/**
 * @author Mmachi Obiorah
 * @author Your Name 
 * A that creates a program with an id to uniquely identify the program, 
 * an execution time and a priority
 * It update the timeLeft after the program is run in a timeSlice
 */
public class Program implements Comparable<Program>
{
	private int programID;
	private int executionTime;
	private Integer priority;
	private int timeLeft;

	/**
	 * Program constructor that initializes a program with an id 
	 * executionTime and priority
	 * @param programID is a number uniquely identifying the program
	 * @param executionTime is the time required to complete the program
	 * @param priority is the priority given to the program
	 * timeLeft is executionTime before the program is run
	 * timeLeft should be 0 by the time execution of the program is completed
	 */ 
	public Program(int programID, int executionTime, int priority)
	{
		this.programID = programID;
		this.executionTime = executionTime;
		this.priority = priority;
		this.timeLeft = executionTime;
	}

	/**
	 * A getter for the programID
	 * @return the program ID
	 */ 
	public int getProgramID()
	{
		return programID;
	}

	/**
	 * A getter for the executionTime
	 * @return the execution time of the program
	 */ 
	public int getExecutionTime()
	{
		return executionTime;
	}

	/**
	 * A getter for the priority of the program
	 * @return the priority of the program
	 */ 
	public int getPriority()
	{
		return priority;
	}

	/**
	 * Returns the timeLeft to complete execution of the program
	 * @return the timeLeft to complete execution of the program
	 */ 
	public int getTimeLeft()
	{
		return timeLeft;
	}	

	/**
	 * A method that reduces the priority of the program by 1
	 */ 
	public void reducePriority()
	{
		priority += 1;
	}

	/**
	 * simulates a run of the program for timeSlice and returns the left over time
	 * updates the timeLeft datafield
	 * @param timeSlice the amount of time given to the program to run for
	 * @return the run time of the program; 
	 */
	public int run(int timeSlice)
	{
		int runTime = 0;
		while (timeSlice != 0 && timeLeft != 0)
		{
			runTime++;
			timeLeft--;
			timeSlice--;
		}
		return runTime;
	}


	/**
	 * compares the current program's priority to the program other's priority
	 * it uses the compareTo method of the wrapper class Integer
	 * required for programs that will be placed in the priority queue
	 * @param other is a program to compare this program to
	 * @return -1, if this.priority < other.priority
	 * 0 if this.priority == other.priority
	 * 1 if this.priority > other.priority
	 */ 
	public int compareTo(Program other)
	{
		return priority.compareTo(other.getPriority());
	}

	/**
	 * overrides the toString method of the object class
	 * @return a string that holds the programID, execution time, 
	 * priority and time left to complete the program
	 */ 
	public String toString()
	{
		return 	String.format("\tprogram id: %3d \texecution time: %3d \ttime left: %3d \tpriority: %3d \t", programID, executionTime, timeLeft, priority);
	}
}