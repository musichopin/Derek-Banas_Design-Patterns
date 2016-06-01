import java.util.Scanner;

public class EnemyShipTesting {

	public static void main(String[] args){
		
		// Create the factory object
		EnemyShipFactory shipFactory = new EnemyShipFactory();
		
		// Enemy ship object
		
		EnemyShip theEnemy = null;
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("What type of ship? (U / R / B)");
		
		if (userInput.hasNextLine()){ // tests the existence of input 
			
			String typeOfShip = userInput.nextLine(); // stores input
		
			theEnemy = shipFactory.makeEnemyShip(typeOfShip); // returns and stores object
//			polymorphism
			
			if(theEnemy != null){
				
				doStuffEnemy(theEnemy);
				
			} else System.out.print("Please enter U, R, or B next time");
		
		}
		
		
		
		// *****Old way of creating objects*****
		// EnemyShipFactory class olmadan
		// When we use new we are not being dynamic
		
		//*****Not Dynamic******//
//		EnemyShip ufoShip = new UFOEnemyShip();
//		
//		doStuffEnemy(ufoShip);
//		
//		System.out.print("\n");
		
		// *******Dynamic*********//
		
		// This allows me to make the program more dynamic
		// It doesn't close the code from being modified
		// and that is bad!
		
		// Defines an input stream to watch: keyboard
//		EnemyShip theEnemy = null;
//		
//		Scanner userInput = new Scanner(System.in);
//		
//		String enemyShipOption = "";
//		
//		System.out.print("What type of ship? (U or R)");
//		
//		if (userInput.hasNextLine()){
//			
//			enemyShipOption = userInput.nextLine();
//			
//		}
//		
//		if (enemyShipOption.equals("U")){
//			
//			theEnemy = new UFOEnemyShip();
//
//			
//		} else 
//		
//		if (enemyShipOption.equals("R")){
//			
//			theEnemy = new RocketEnemyShip();
//			
//		} else {
//			
//			theEnemy = new BigUFOEnemyShip();
//			
//		}
//		
//		doStuffEnemy(theEnemy);
		
		// --------------------------------------------
		
	}
	
	// Executes methods of the super class
	
	public static void doStuffEnemy(EnemyShip anEnemyShip){
		// parameterda polymorphism
		
		anEnemyShip.displayEnemyShip();
		
		anEnemyShip.followHeroShip();
		
		anEnemyShip.enemyShipShoots();
		
	}
	
}
