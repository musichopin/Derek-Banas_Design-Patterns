import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Singleton {
	
//	holds the one and only instance for the class Singleton
	private static Singleton firstInstance = null;
//	static cause objects like this needs to be available on a global basis
	
	String[] scrabbleLetters = {"a", "a", "a", "a", "a", "a", "a", "a", "a",
			"b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e", 
			"e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h", 
			"h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l", 
			"l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o", 
			"o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r", 
			"r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u", 
			"u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z",};  
	
//	gets array of things inside a linked list
	private LinkedList<String> letterList = new LinkedList<String> (Arrays.asList(scrabbleLetters));
   
    // Used to slow down 1st thread
//	so that there is potential for the 2nd thread to come in 
//	(prevents potential exception)
	static volatile boolean firstThread = true;
//	for making it more thread safe ,it would be better to declare firstThread as volatile 
	
	// Created to keep users from instantiation
	// Only Singleton will be able to instantiate this class
   
	private Singleton() { }
//	private cause we wanna make sure there is only one instance for the class singleton
	
	// We could make getInstance a synchronized method to force 
	// every thread to wait its turn. That way only one thread
	// can access a method at a time. This can really slow everything
	// down though:
	// public static synchronized Singleton getInstance()
	
	public static Singleton getInstance() {
		if(firstInstance == null) {
//			bir tane daha olduðu için ya bu ya da aþaðýdaki kopyasý gereksiz gibi geldi 
			
			// This is here to test what happens if threads try
			// to create instances of this class
			
			if(firstThread){
			
				firstThread = false;
				
				try {
					Thread.currentThread(); 
//					currentThread method returns the thread we are currently running inside
//					(muhtemelen etkisi yok(?))
					
					Thread.sleep(1000); // First thread sleeps for 1 seconds
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			}
			
			// Here we just use synchronized when the first object is created. 
//			this is going to force it to be a synchronized method until the first object is created,
//			and then it is no longer going to be considered as synchronized 
			synchronized(Singleton.class){
//			synchronized(new Singleton()){ yazýnca sonuç deðiþmedi
				
//				buradan aþaðýdaki return'e kadar olan kýsým basic Singleton Pattern'dir.
				if(firstInstance == null) {
					// If the instance isn't needed it isn't created
					// This is known as lazy instantiation
			
					firstInstance = new Singleton();
			
					// Shuffle the letters in the list
					Collections.shuffle(firstInstance.letterList);
					
				}
			
			}
			
		}
		
		// Under either circumstance this returns the instance
		
		return firstInstance;
	}
	
	public LinkedList<String> getLetterList(){
//		returns a list of all the available methods
//		(type is LinkedList<String>)
		
		return firstInstance.letterList;
		
	}
	
	public LinkedList<String> getTiles(int howManyTiles){
		
		// Tiles to be returned to the user
		
		LinkedList<String> tilesToSend = new LinkedList<String>();
		
		// Cycle through the LinkedList while adding the starting
		// Strings to the to be returned LinkedList while deleting
		// them from letterList
		
		for(int i = 0; i <= howManyTiles; i++){
		
			tilesToSend.add(firstInstance.letterList.remove(0));
			// firstInstance.getLetterList().remove(0)
		}
		
		// Return the number of letter tiles requested
		
		return tilesToSend;
		
	}
	
}