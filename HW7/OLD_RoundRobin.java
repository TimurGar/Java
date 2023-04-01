// import java.util.Deque;
// import java.util.ArrayDeque;
// import java.util.Iterator;
// import java.util.List;
// import java.util.PriorityQueue;


// public class OLD_RoundRobin extends OperatingSystem {
//     private Deque<Program> queueA;
// 	private PriorityQueue<Program> queueB;
// 	private Deque<Program> queueC;
// 	private Deque<Program> queueD;

//     public OLD_RoundRobin(int timeSlice, int numberOfPrograms, int maxExecutionTime, int maxPriority)
// 	{
// 		super(timeSlice, numberOfPrograms, maxExecutionTime, maxPriority);

// 		logger("PRIORITY SCHEDULING");

// 		queueA = new ArrayDeque<>();
// 		queueB = new PriorityQueue<>();
// 		queueC = new ArrayDeque<>();
// 		queueD = new ArrayDeque<>();

// 		List<Program> programList = getProgramList();
// 		populateQueues(programList);
// 		execute(timeSlice);
// 	}

//     // populates the four queues with programs from the program list according to the priorities of the programs
// 	// very high priority programs are added to queueA
// 	// high priority programs are added to queueB
// 	// medium priority programs are added to queueC
// 	// low priority programs are added to queueD
// 	private void populateQueues(List<Program> programList)
// 	{
// 		Iterator<Program> programListIterator = programList.iterator();
// 		while (programListIterator.hasNext())
// 		{
// 			Program currentProgram = programListIterator.next();
// 			Integer currentPriority = currentProgram.getPriority();
// 			if ( currentPriority <= OperatingSystem.MIN_VERY_HIGH_PRIORITY)
// 			{
// 				queueA.addLast(currentProgram);
// 			}
// 			else if (currentPriority <= OperatingSystem.MIN_HIGH_PRIORITY)
// 			{
// 				queueB.add(currentProgram);
// 			}
// 			else if (currentPriority <= OperatingSystem.MIN_MEDIUM_PRIORITY)
// 			{
// 				queueC.addLast(currentProgram);				
// 			}
// 			else
// 			{
// 				queueD.addLast(currentProgram);
// 			}
// 		}
// 	}

//     /**
// 	 * executes all the programs in the program list starting with queueA
// 	 * then queueB, queueC and queueD
// 	 * logs the total wait time 
// 	 * logs the average wait time
// 	 */ 
// 	@Override
// 	public void execute()
// 	{
// 		logger("QUEUE A");
// 		executeA(queueA, getTimeSlice());
// 		logger("Total wait time: " + getTotalWaitTime());

// 		logger("QUEUE B");
// 		executeB(queueB, timeSlice);
// 		logger("Total wait time: " + getTotalWaitTime());

// 		logger("QUEUE C");		
// 		executeC(queueC, timeSlice);
// 		logger("Total wait time: " + getTotalWaitTime());

// 		logger("QUEUE D");		
// 		executeD(queueD);
// 		logger("Total wait time: " + getTotalWaitTime());

// 		computeAverageWaitTime();
// 		logger("Total wait time: " + getTotalWaitTime());
// 		logger("Average waiting time: " + getAverageWaitTime());		
// 	}	
//     private void executeA(Deque<Program> queue, int timeSlice){
// 		while (!queue.isEmpty()){
//             // retrieve program at the front of the of the queue
// 			Program currentProgram = queue.remove();

//             // get the programs execution time
// 			int currentExecution = timeSlice;

// 			// get the current time of on the clock
// 			int waitTime = currentTime();

// 			// log the current program - add the information about the current program to the OS's log
// 			logger("clock: " + currentTime() + currentProgram + "wait time: " + waitTime);

// 			// run the current program for a time slice
// 			int runTime = currentProgram.run(currentExecution);

// 			// update the clock
// 			tick(runTime);

// 			// update the total wait time
// 			updateTotalWaitTime(waitTime); 


// 			Program nextProgram = queue.remove();

// 			waitTime = currentTime();
// 			logger("clock: " + currentTime() + nextProgram + "wait time: " + waitTime);
// 			// run the next program for a time slice
// 			runTime = nextProgram.run(currentExecution);
// 			tick(runTime);
// 			updateTotalWaitTime(waitTime); 

			
// 			if(currentProgram.getTimeLeft() != 0){
// 				queue.addFirst(currentProgram);
// 			}
// 			if(nextProgram.getTimeLeft() != 0){
// 				queue.addFirst(nextProgram);
// 			}

// 		}	
// 	}


//     private void executeB(PriorityQueue<Program> queue, int timeSlice){
//         while (!queue.isEmpty()){
//             // retrieve program at the front of the of the queue
// 			Program currentProgram = queue.remove(); 

//             // get the programs execution time
// 			int currentExecution = timeSlice;

//             // get the current time of on the clock
// 			int waitTime = currentTime();

//             // log the current program - add the information about the current program to the OS's log
// 			logger("clock: " + currentTime() + currentProgram + "wait time: " + waitTime);
            
//             // run the current program for a time slice
//             int runTime = currentProgram.run(currentExecution);

// 			// Check if has some time left and therefore needs to be executed again
//             if(currentProgram.getTimeLeft() != 0){
                 
//                 currentProgram.reducePriority();

// 				// Moving the program to Queue C if it's priority reaches 32
//                 if(currentProgram.getPriority() == 32)
//                     queueC.addLast(currentProgram);
//                 else{
//                     queue.add(currentProgram);
//                 }
//             }
//             // update the clock
//             tick(runTime);

//             // update the total wait time
//             updateTotalWaitTime(waitTime); 
            
//         }
//     }


//     private void executeC(Deque<Program> queue, int timeSlice){
//         while (!queue.isEmpty()){
//             // retrieve program at the front of the of the queue
// 			Program currentProgram = queue.removeFirst(); 

//             // get the programs execution time
// 			int currentExecution = timeSlice;

//             // get the current time of on the clock
// 			int waitTime = currentTime();

//             // log the current program - add the information about the current program to the OS's log
// 			logger("clock: " + currentTime() + currentProgram + "wait time: " + waitTime);

//              // run the current program for a time slice
// 			int runTime = currentProgram.run(currentExecution);

//             // update the clock
//             tick(runTime);

//             // update the total wait time
//             updateTotalWaitTime(waitTime);

//             // if(timeleft > 1){
// 			if(currentProgram.getTimeLeft() != 0){
//                 queue.addLast(currentProgram);
//             }

//         }
//     }


//     private void executeD(Deque<Program> queue){
//         while (!queue.isEmpty()){
//             // retrieve program at the front of the of the queue
// 			Program currentProgram = queue.removeFirst(); 

//             // get the programs execution time
// 			int currentExecution = currentProgram.getExecutionTime();

//             // get the current time of on the clock
// 			int waitTime = currentTime();

//             // log the current program - add the information about the current program to the OS's log
// 			logger("clock: " + currentTime() + currentProgram + "wait time: " + waitTime);

//             // run the current program to completion
// 			int runTime = currentProgram.run(currentExecution);

//             // update the clock
//             tick(runTime);

//             // update the total wait time
//             updateTotalWaitTime(waitTime);
//         }
//     }
// }
