public class SandwichSculptor {
	
	public static void main(String[] args){
		
		Hoagie cust12Hoagie = new ItalianHoagie();
		
		cust12Hoagie.makeSandwich();
		
		System.out.println();
		
		Hoagie cust13Hoagie = new VeggieHoagie();
		
		cust13Hoagie.makeSandwich();
		
	}
	
}
/*
The Hoagie is Cut
Adding the Meat: Salami Pepperoni Capicola Ham 
Adding the Cheese: Provolone 
Adding the Vegetables: Lettuce Tomatoes Onions Sweet Peppers 
Adding the Condiments: Oil Vinegar 
Wrap the Hoagie

The Hoagie is Cut
Adding the Vegetables: Lettuce Tomatoes Onions Sweet Peppers 
Adding the Condiments: Oil Vinegar 
Wrap the Hoagie
*/