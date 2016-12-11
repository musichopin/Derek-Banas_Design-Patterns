public class PizzaMaker {
	
	public static void main(String[] args){
		
		// The PlainPizza object is sent to the Mozzarella constructor
		// and then to the TomatoSauce constructor
		
//		***Pizza p = new PlainPizza dense de fark etmezdi***
		PlainPizza p = new PlainPizza(); // creates plain pizza
		Mozzarella m = new Mozzarella(p); // creates mozzarella w plain pizza 
		Pizza basicPizza = new TomatoSauce(m); // creates tomato sauce with mozzarella and plain pizza
//		***TomatoSauce basicPizza = new TomatoSauce(m)
//		veya
//		ToppingDecorator basicPizza = new TomatoSauce(m)
//		dense de fark etmezdi***

//		alt:
		//	Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
		
		System.out.println("Ingredients: " + basicPizza.getDescription());
		
		System.out.println("Price: " + basicPizza.getCost());
		
	}
	
}
/*
 Adding Dough
Adding Moz
Adding Sauce
Ingredients: Thin dough, mozzarella, tomato sauce
Cost of Sauce: 0.35
Cost of Moz: 0.5
Cost of Dough: 4.0
Price: 4.85
 */