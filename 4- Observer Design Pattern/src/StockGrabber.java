import java.util.ArrayList;

// Uses the Subject interface to update all Observers

public class StockGrabber implements Subject{
	
	private ArrayList<Observer> observers;
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	public StockGrabber(){
		
		// Creates an ArrayList to hold all observers
		observers = new ArrayList<Observer>();
	}
	
	public void register(Observer newObserver) {
		// poly: Observer newObserver = this;
		
		// Adds a new observer to the ArrayList
		// added observers are notified of stock prices
		observers.add(newObserver); 
		// !add metodu Observer int'e ait deðil, Observer'dan oluþan arrayliste ait
		// bu arrayliste Observer'ýn subclassý olan StockObserver eklendi
// (newObserver ref var points to StockObserver subclass (polymorphism))

	}

	public void unregister(Observer deleteObserver) {
		
		// Get the index of the observer to delete
		
		int observerIndex = observers.indexOf(deleteObserver);
		
		// Print out message (Have to increment index to match)
		System.out.println("Observer " + (observerIndex+1) + " deleted");
		
		// Removes observer from the ArrayList
		// removed observer are not notified 
		observers.remove(observerIndex); // remove metodu Observer classa ait deðil
//		remove method belongs to arraylist class
		
	}

	public void notifyObserver() {
		
		// Cycle through all observers and notifies them of
		// price changes
		// Observer: type, observer: temporary holder, observers: ref to arraylist
		for(Observer observer : observers){
			// arrayliste Observer'ýn subclassý olan StockObserver eklenmiþti
			observer.update(ibmPrice, aaplPrice, googPrice);
			// calls the update method of the subclass, StockObserver
		}
	}
	
	// Change prices for all stocks and notify observers of changes
	// with notifyObserver and update methods
	public void setIBMPrice(double newIBMPrice){
		
		this.ibmPrice = newIBMPrice; // setter
		
		notifyObserver();
		
	}
	
	public void setAAPLPrice(double newAAPLPrice){
		
		this.aaplPrice = newAAPLPrice;
		
		notifyObserver();
		
	}

	public void setGOOGPrice(double newGOOGPrice){
	
		this.googPrice = newGOOGPrice;
	
		notifyObserver();
	
	}
	
}