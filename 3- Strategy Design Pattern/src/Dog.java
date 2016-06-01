public class Dog extends Animal{
	
	public void digHole(){
		
		System.out.println("Dug a hole");
		
	}
	
	public Dog(){
		
		super();
		
		setSound("Bark");
		
		// We set the Flys interface polymorphically
		// This sets the behavior as a non-flying Animal
		
		flyingType = new CantFly();
		// polymorphism
	}
	
	/* BAD
	* You could override the fly method, but we are breaking
	* the rule that we need to abstract what is different to 
	* the subclasses. we need to continue to abstract out what 
	* is different and put just those things that are different 
	* inside of the classes.
	
	public void fly(){
		
		System.out.println("I can't fly");
		
	}
	
	*It would be also wrong to implement abstract fly method 
	*for creating duplicates
	*/
	
}