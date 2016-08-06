public class TestCloning {
	
	public static void main(String[] args){
		
		// Handles routing makeCopy method calls to the 
		// right subclasses of Animal
		
		CloneFactory animalMaker = new CloneFactory();
		
		// Creates a new, original Sheep instance
		
		Sheep sally = new Sheep();
//		alt (?): mantýk olarak yanlýþ olabilir
//		Animal sally = new Sheep();
		
		// Creates a clone of Sally with same methods, fields and stores it in its own  memory location
//		String return eden metod çaðýrýlýp stringi return edince int e cast etmeye benziyor
		Sheep clonedSheep = (Sheep) animalMaker.getClone(sally);
		// These are exact copies of each other
//		alt (?): mantýk olarak yanlýþ olabilir
//		Animal clonedSheep = animalMaker.getClone(sally);
		
//		CloneFactory olmadan alt metod:
//		Sheep sally = new Sheep();
//		Sheep clonedSheep = (Sheep) sally.makeCopy();
		
		System.out.println(sally);
		
		System.out.println(clonedSheep);
		
		System.out.println("Sally HashCode: " + System.identityHashCode(System.identityHashCode(sally)));
		
		System.out.println("Clone HashCode: " + System.identityHashCode(System.identityHashCode(clonedSheep)));
	}
	
}
/*
Sheep is Made
Copy Sheep is Being Made
Dolly is my Hero, Baaaaa
Dolly is my Hero, Baaaaa
Sally HashCode: 366712642
Clone HashCode: 2018699554
*/