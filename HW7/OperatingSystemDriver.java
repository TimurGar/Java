public class OperatingSystemDriver
{
	public static void main(String[] args) 
	{
		// OperatingSystem os = new PriorityScheduling( /*timeSlice*/ 1, /*int numberOfPrograms*/ 50, /*int maxExecutionTime*/ 5, /*int maxPriority*/ 64);
		// System.out.println(os);

		// uncomment and run after implementing RoundRobin
		OperatingSystem os1 = new RoundRobin( 2, /*int numberOfPrograms*/ 50, /*int maxExecutionTime*/ 5, /*int maxPriority*/ 64);
		System.out.println(os1);		
	}
}