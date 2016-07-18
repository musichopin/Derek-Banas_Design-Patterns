public class ScrabbleTestThreads{
	
	public static void main(String[] args){
		
		// Create a new Thread using the Runnable interface
		// in order to implement different players as threads.
		// Execute the code in run after 1 seconds
				
		Runnable getTiles = new GetTheTiles();
				
		Runnable getTilesAgain = new GetTheTiles();
//		parametresi olan constructorý çaðýrýp player 2'ya ait spesifik value larý pass edebilirdi
				
		// Call for the code in the method run to execute
				
		new Thread(getTiles).start();
		new Thread(getTilesAgain).start();
		
	}
	
}