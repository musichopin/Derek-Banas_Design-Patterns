// The interface is implemented by many other
// subclasses that allow for many types of flying
// without effecting Animal, or Flys.

// Classes that implement new Flys interface
// subclasses can allow other classes to use
// that code eliminating code duplication

// I'm decoupling : encapsulating the concept that varies

// AVOID interfaces that just force action 
// (abstract metod yaratýp Dog'un ve Bird'ün implement etmesini saðlamak)
// Using an interface just to force the creation of a method is a bad idea
public interface Flys {
//	we use the interface as an instance variable in Animal class
//	and then dynamically change the instance variable to be either 
//	of type class ItFlys or CantFly
//	and why that is a great idea, because interface is implemented by many other
//	different subclasses and therefore we would create many different types of Flys
//	without effecting Animal or any of its subclasses. 
//	From that point on classes that implement this new Flys interface are going 
//	to allow those classes to use that code while also eliminating code duplication.	
//	this is known as decoupling
	
   String fly();
   
}

// Class used if the Animal can fly

class ItFlys implements Flys{

	public String fly() {
		
		return "Flying High";
		
	}
	
}

//Class used if the Animal can't fly

class CantFly implements Flys{

	public String fly() {
		
		return "I can't fly";
		
	}
	
}