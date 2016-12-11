// Has a "Has a" relationship with Pizza. This is an
// Aggregation Relationship

// *moz and sauce classes implements all these variables and methods*
abstract class ToppingDecorator implements Pizza {

	protected Pizza tempPizza;
//	*** sub-classlarý tarafýndan görülür ve farklý algýlanýr:
//	mozzarella için Pizza tempPizza = new PlainPizza();
//	olurken (PlainPizza, ToppingDecorator'ýn subclass ý veya superclass ý olmadýðý halde iletiþim kurulmuþ)
//	tomatosauce için Pizza tempPizza = new Mozzarella(new PlainPizza());
//	olur (new Mozzarella içinde new PlainPizza olmasý önemli deðil) ***
	
	// Assigns the type instance to this attribute
	// of a Pizza
	
	// All decorators can dynamically customize the Pizza
	// instance PlainPizza because of this
	
	public ToppingDecorator(Pizza newPizza){
		
		tempPizza = newPizza;
		
	}
	
	public String getDescription() {
		
		return tempPizza.getDescription();
		
	}

	public double getCost() {
		
		return tempPizza.getCost();
		
	}
	
}