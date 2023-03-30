import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Mmachi Obiorah
 * @author Your Name 
 * An operating System class
 * it creates numberOfPrograms programs and places them in programList
 */ 
public abstract class OperatingSystem
{
	public final static int MIN_VERY_HIGH_PRIORITY = 15;
	public final static int MIN_HIGH_PRIORITY = 31;
	public final static int MIN_MEDIUM_PRIORITY = 47;
	public final static int MIN_LOW_PRIORITY = 64;

	private int maxPriority;
	private int maxExecutionTime;	
	private int timeSlice;
	private int numberOfPrograms;

	private int clock;
	private double totalWaitTime;
	private double averageWaitTime;	
	private String log;	

	private List<Program> programList;

	/**
	 * An OperatingSystem constructor
	 * @param timeSlice programs can run for at most timeSlice in a Round Robin OS
	 * @param numberOfPrograms the number of programs to create and execute
	 * @param maxExecutionTime each program is given a random execution time not more than maxExecutionTime
	 * @param maxPriority each program is given a priority not more than maxPriority
	 */ 
	public OperatingSystem(int timeSlice, int numberOfPrograms, int maxExecutionTime, int maxPriority)
	{
		programList = new ArrayList<>();
		this.timeSlice = timeSlice;
		this.numberOfPrograms = numberOfPrograms;
		this.maxExecutionTime = maxExecutionTime;
		this.maxPriority = maxPriority;

		initializeTimeAndLogParameters();
		createProgramList();
	}

	// initialize the clock, totalWaitTime and log datafields 
	private void initializeTimeAndLogParameters()
	{
		this.clock = 0;
		this.totalWaitTime = 0;
		this.log = "";
	}

	// create programs and add them to programList
	private void createProgramList()
	{
		Random rand = new Random(5);
		for(int index = 1; index <= numberOfPrograms; index++)
		{
			int executionTime = (int) (1 + rand.nextInt(maxExecutionTime));
			int priority = (int) (1 + rand.nextInt(maxPriority));
			Program program = new Program(index, executionTime, priority);
			programList.add(program);
		}
	}	

	/* an abstract method that simulates the execution of each program in programList */
	public abstract void execute();

	/**
	 * a getter for timeSlice
	 * @return an int that is the timeSlice used by the OS
	 */ 
	public int getTimeSlice()
	{
		return timeSlice;
	}

	/**
	 * A getter for the number of programs in programList
	 * @return the numberOfPrograms to be executed by the OS
	 */ 
	public int getNumberOfPrograms()
	{
		return numberOfPrograms;
	}

	/**
	 * Simulates passage of time by the amount time
	 * @param time is the time by which to advance the clock
	 */ 
	public void tick(int time)
	{
		clock += time;
	}

	/**
	 * Returns the current value of the clock
	 * @param returns the current value of the clock
	 */ 
	public int currentTime()
	{
		return clock;
	}

	/**
	 * updates the totalWaitTime by waitTime
	 * @param waitTime the wait time to add to the totalWaitTime
	 */ 
	public void updateTotalWaitTime(int waitTime)
	{
		totalWaitTime += waitTime;
	}

	/**
	 * computes the average waitTime of each program in the OS
	 * precondition: execute must have been called
	 */ 
	public void computeAverageWaitTime()
	{
		averageWaitTime = (double) totalWaitTime / (double) numberOfPrograms;		
	}

	/**
	 * a getter for the total wait time
	 * @return the total wait time of all programs in the OS
	 */ 
	public double getTotalWaitTime()
	{
		return totalWaitTime;
	}

	/**
	 * A getter for the average wait time
	 * @return the average wait time of all programs in the OS
	 */ 
	public double getAverageWaitTime()
	{
		return averageWaitTime;
	}	

	/**
	 * A getter for programList
	 * @return a list of all the programs in the OS
	 */ 
	public List<Program> getProgramList()
	{
		List<Program> newProgramList = new ArrayList<>();
		for(Program program : programList)
			newProgramList.add(program);
		return newProgramList;
	}

	/**
	 * creates a string that includes 
	 * the algorithm used to run a program
	 * the program being run everytime tick() is executed 
	 * the program priority, id, and execution time
	 * the total wait time 
	 * the average wait time of all programs in the OS
	 * the string is placed in log
	 * @param operatingSystemInfo is the information to be added to the OS log
	 */ 
	public void logger(String operatingSystemInfo)
	{
		log += operatingSystemInfo + "\n";
	}		

	/**
	 * returns the string in the datafield log
	 * @return the content of log
	 */ 
	public String toString()
	{
		return log;
	}	
}