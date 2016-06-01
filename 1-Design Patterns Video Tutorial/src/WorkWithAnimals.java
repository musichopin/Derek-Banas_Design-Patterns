public class WorkWithAnimals{
	
	int justANum = 10; // cannot be reached from within a static method
//	without creating an object 
	
	public static void main(String[] args){
		
		Dog fido = new Dog();
		
		fido.setName("Fido");
		System.out.println(fido.getName());
		
		fido.digHole();
		
		fido.setWeight(-1);
		
		// Everything is passed by value
		// The original is not effected by changes in methods
		System.out.println("\n***In Java variables are passed by copy:***");
		int randNum = 10;
		
		fido.changeVar(randNum); // fido.changeVar(10)'dan farký yok
		
		System.out.println("randNum after method call: " + randNum);
		
		// Objects are passed by copy of the reference to the original object 
		// Changes in methods do effect the object
		System.out.println("\n***In Java objects are passed by copy (of the references):***");
		changeObjectName(fido); // fido already created
		
		System.out.println("Dog name after method call: " + fido.getName());
		
		System.out.println();
		System.out.println("Animal Sound: " + fido.getSound());
		
		// Create a Dog and Cat object with the super class
		// but the Dog and Cat reference type
		
		Animal doggy = new Dog(); // named dog or animal object
		Animal kitty = new Cat(); // named cat or animal object
		System.out.println("\n***Polymorphism:***");
		System.out.println("Doggy says: " + doggy.getSound());
		System.out.println("Kitty says: " + kitty.getSound() + "\n");
		
		// Now you can make arrays of Animals and everything just works
		
		Animal[] animals = new Animal[4];
		animals[0] = doggy;
		animals[1] = kitty;
		
		System.out.println("Doggy says: " +animals[0].getSound());
		System.out.println("Kitty says: " +animals[1].getSound() + "\n");
		
		// Sends Animal objects for processing in a method
		
		speakAnimal(doggy);
		
		// Polymorphism allows you to write methods that don't need to 
		// change if new subclasses are created.
		
		// You can't reference methods, or fields that aren't in Animal
		// if you do, you'll have to cast (downcast) to the required object
		((Dog) doggy).digHole();
//		alt:
//		Dog dog = (Dog) doggy;
//		dog.digHole();
		
		// You can't use non-static variables or methods in a static function
		// System.out.println(justANum);
		// sayHello();
		
		// You can't call a private method even if you define it in
		// the subclass
		// fido.bePrivate();
		
		// You can execute a private method by using another public
		// method in the class
		fido.accessPrivate();
//		probably not a good idea
		
		// Creating a Giraffe from an abstract class
		System.out.println("\n***Creating a Giraffe from Creature abstract class:***");
		Creature giraffe = new Giraffe();
		
		giraffe.setName("Frank");
		
		System.out.println(giraffe.getName());
		
	}
	
	// Any methods that are in a class and not tied to an object must
	// be labeled static. Every object created by this class will
	// share just one static method
	
	public static void changeObjectName(Dog fido){
		System.out.println("Dog name in method called: " + fido.getName());
		
		fido.setName("Marcus");
		
	}
	
	// Receives Animal objects and makes them speak
	
	public static void speakAnimal(Animal randAnimal){
		
		System.out.println("Animal says: " + randAnimal.getSound());
		
	}
	
	// This is a non-static method used to demonstrate that you can't
	// call a non-static method inside a static method
	
	public void sayHello(){
		
		System.out.println("Hello");
		
	}
	
}