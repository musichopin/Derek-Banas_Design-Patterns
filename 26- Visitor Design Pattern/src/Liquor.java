class Liquor implements Visitable {
	
	private double price;

	Liquor(double item) {
		price = item;
	}

	public double accept(Visitor visitor) {
		return visitor.visit(this);
		// ***with this kw it passes its own instance made in main method.
		//	this kw'ün kulanýlabilmesi için constructor içinde olmasý gerekmiyor***
	}

	public double getPrice() {
		return price;
	}
	
}