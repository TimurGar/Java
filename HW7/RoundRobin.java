import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Mmachi Obiorah
 * @author Timur Garifullin
 * A class executes programs using the Round Robin algorithm
 * it extends the OperatingSystem abstract class
 */ 
public class RoundRobin extends OperatingSystem {
    private Deque<Program> queueA;
	private PriorityQueue<Program> queueB;
	private Deque<Program> queueC;
	private Deque<Program> queueD;

    public RoundRobin(int timeSlice, int numberOfPrograms, int maxExecutionTime, int maxPriority)
	{
		super(timeSlice, numberOfPrograms, maxExecutionTime, maxPriority);

		queueA = new ArrayDeque<>();
		queueB = new PriorityQueue<>();
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
				queueB.add(currentProgram);
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
	@Override
	public void execute()
	{
		logger("QUEUE A");
		executeA(queueA, getTimeSlice());
		logger("Total wait time: " + getTotalWaitTime());

		logger("QUEUE B");
		executeB(queueB, getTimeSlice());
		logger("Total wait time: " + getTotalWaitTime());

		logger("QUEUE C");		
		executeC(queueC, getTimeSlice());
		logger("Total wait time: " + getTotalWaitTime());

		logger("QUEUE D");		
		executeD(queueD);
		logger("Total wait time: " + getTotalWaitTime());

		computeAverageWaitTime();
		logger("Total wait time: " + getTotalWaitTime());
		logger("Average waiting time: " + getAverageWaitTime());		
	}	

    /**
     * Private method to execute deque with programs with priority 1-15
     * @param queue is Queue A or deque with programs
     * @param timeSlice the amount of time a CPU will run each program 
     * logs the data about every program
     */
    private void executeA(Deque<Program> queue, int timeSlice){
		// a deque to store all the previous programs that CPU still needs to  run
		Deque<Program> queuePreviousPrograms = new ArrayDeque<>();;
        Program previousProgram = null;

		while (!queue.isEmpty()){
            // retrieve program at the front of the of the queue
			Program currentProgram = queue.remove();

            // get the programs execution time
			int currentExecution = timeSlice;

			// get the current time of on the clock
			int waitTime = currentTime();

			// log the current program - add the information about the current program to the OS's log
			logger("clock: " + currentTime() + currentProgram + "wait time: " + waitTime);

			// run the current program for a time slice
			int runTime = currentProgram.run(currentExecution);

            // update the clock
            tick(runTime);

            // Checking if the programs still needs to be executed later
            if(currentProgram.getTimeLeft() != 0){
                // Storing the program in a deque to run later
				queuePreviousPrograms.addLast(currentProgram);
			}
            else{
                // update the total wait time
                updateTotalWaitTime(waitTime);
            }

            // Checking if there are any previous programs that still have to be executed
			if(!queuePreviousPrograms.isEmpty()){	
                // Making sure that the first program is not the same as the current program
                // Prevents the execution of the same program twice 
                if(queuePreviousPrograms.peek() != currentProgram){

                    // Running all the previous programs
                    while(!queuePreviousPrograms.isEmpty()){
                        previousProgram = queuePreviousPrograms.removeFirst();
                        
                        waitTime = currentTime();
                        // log the previous program
                        logger("clock: " + currentTime() + previousProgram + "wait time: " + waitTime);
                        runTime = previousProgram.run(currentExecution);
                        
                        tick(runTime);
			            updateTotalWaitTime(waitTime);
                    }
                }
			}

		}	
	}

    /**
     * Private method to execute priority queue with programs with priority 16-31
     * @param PriorityQueue is Queue B or PriorityQueue with programs
     * @param timeSlice the amount of time a CPU will run each program 
     * logs the data about every program
     */
    private void executeB(PriorityQueue<Program> queue, int timeSlice){
        while (!queue.isEmpty()){
            // retrieve program at the front of the of the queue
			Program currentProgram = queue.remove(); 

            // get the programs execution time
			int currentExecution = timeSlice;

            // get the current time of on the clock
			int waitTime = currentTime();

            // log the current program - add the information about the current program to the OS's log
			logger("clock: " + currentTime() + currentProgram + "wait time: " + waitTime);
            
            // run the current program for a time slice
            int runTime = currentProgram.run(currentExecution);

            tick(runTime);

			// Check if has some time left and therefore needs to be executed again
            if(currentProgram.getTimeLeft() != 0){
                currentProgram.reducePriority();

				// Moving the program to Queue C if it's priority reaches 32
                if(currentProgram.getPriority() == 32)
                    queueC.addLast(currentProgram);
                else{
                    queue.add(currentProgram);
                }
            }
            else{
                updateTotalWaitTime(waitTime);
            }

        }
    }

    /**
     * Private method to execute deque with programs with priority 32-47
     * @param queue is Queue C or deque with programs
     * @param timeSlice the amount of time a CPU will run each program 
     * logs the data about every program
     */
    private void executeC(Deque<Program> queue, int timeSlice){
        while (!queue.isEmpty()){
            // retrieve program at the front of the of the queue
			Program currentProgram = queue.removeFirst(); 

            // get the programs execution time
			int currentExecution = timeSlice;

            // get the current time of on the clock
			int waitTime = currentTime();

            // log the current program - add the information about the current program to the OS's log
			logger("clock: " + currentTime() + currentProgram + "wait time: " + waitTime);

             // run the current program for a time slice
			int runTime = currentProgram.run(currentExecution);

            // update the clock
            tick(runTime);

            // Checking if the programs still needs to be executed later
			if(currentProgram.getTimeLeft() != 0){
                queue.addLast(currentProgram);
            }
            else{
                updateTotalWaitTime(waitTime);
            }

        }
    }

    /**
     * Private method to execute deque with programs with priority 48-64
     * @param queue is Queue D or deque with programs
     * @param timeSlice the amount of time a CPU will run each program 
     * logs the data about every program
     */
    private void executeD(Deque<Program> queue){
        while (!queue.isEmpty()){
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