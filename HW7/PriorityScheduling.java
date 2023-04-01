import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mmachi Obiorah
 * @author Timur Garifullin
 * A class executes programs using the priority scheduling algorithm
 * it extends the OperatingSystem abstract class
 */ 
public class PriorityScheduling extends OperatingSystem
{
	private Deque<Program> queueA;
	private Deque<Program> queueB;
	private Deque<Program> queueC;
	private Deque<Program> queueD;

	/**
	 * A priorityScheduling constructor
	 * @param timeSlice programs can run for at most timeSlice (not relevant for PriorityScheduling)
	 * @param numberOfPrograms the number of programs to create and execute
	 * @param maxExecutionTime each program is given a random execution time not more than maxExecutionTime
	 * @param maxPriority each program is given a priority not more than maxPriority
	 */ 
	public PriorityScheduling(int timeSlice, int numberOfPrograms, int maxExecutionTime, int maxPriority)
	{
		super(timeSlice, numberOfPrograms, maxExecutionTime, maxPriority);

		logger("PRIORITY SCHEDULING");

		queueA = new ArrayDeque<>();
		queueB = new ArrayDeque<>();
		queueC = new ArrayDeque<>();
		queueD = new ArrayDeque<>();

		List<Program> programList = getProgramList();
		populateQueues(programList);
		execute();
	}

	// populates the four queues with programs from the program list according to the priorities of the programs
	// very high priority programs are added to queueA
	// high priority programs are added to queueB
	// medium priority programs are added to queueC
	// low priority programs are added to queueD
	private void populateQueues(List<Program> programList)
	{
		Iterator<Program> programListIterator = programList.iterator();
		while (programListIterator.hasNext())
		{
			Program currentProgram = programListIterator.next();
			Integer currentPriority = currentProgram.getPriority();
			if ( currentPriority <= OperatingSystem.MIN_VERY_HIGH_PRIORITY)
			{
				queueA.addLast(currentProgram);
			}
			else if (currentPriority <= OperatingSystem.MIN_HIGH_PRIORITY)
			{
				queueB.addLast(currentProgram);
			}
			else if (currentPriority <= OperatingSystem.MIN_MEDIUM_PRIORITY)
			{
				queueC.addLast(currentProgram);				
			}
			else
			{
				queueD.addLast(currentProgram);
			}
		}
	}

	/**
	 * executes all the programs in the program list starting with queueA
	 * then queueB, queueC and queueD
	 * logs the total wait time 
	 * logs the average wait time
	 */ 
	public void execute()
	{
		logger("QUEUE A");
		executeHelper(queueA);

		logger("QUEUE B");
		executeHelper(queueB);

		logger("QUEUE C");		
		executeHelper(queueC);

		logger("QUEUE D");		
		executeHelper(queueD);

		computeAverageWaitTime();
		logger("Total wait time: " + getTotalWaitTime());
		logger("Average waiting time: " + getAverageWaitTime());		
	}	

	// a private method that simulate the execution of each program in the different queues
	// logs the execution of each program 
	// queue is a queue with programs in the same priority range
	private void executeHelper(Deque<Program> queue)
	{
		while (!queue.isEmpty())
		{
			// retrieve program at the front of the of the queue
			Program currentProgram = queue.removeFirst(); 

			// get the programs execution time
			int currentExecution = currentProgram.getExecutionTime();			

			// get the current time of on the clock
			int waitTime = currentTime();

			// log the current program - add the information about the current program to the OS's log
			logger("clock: " + currentTime() + currentProgram + "wait time: " + waitTime);

			// run the current program to completion
			int runTime = currentProgram.run(currentExecution);

			// update the clock
			tick(runTime);

			// update the total wait time
			updateTotalWaitTime(waitTime);		
		}
	}

}