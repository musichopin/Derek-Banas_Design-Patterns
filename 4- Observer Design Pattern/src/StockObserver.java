// Represents each Observer that is monitoring changes in the subject

public class StockObserver implements Observer {
	
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	// Static used as a counter
	
	private static int observerIDTracker = 0;
	
	// Used to track the observers
	
	private int observerID;
	
	// Will hold reference to the StockGrabber object (polymorphism)
	private Subject stockGrabber;
	
	// reference is passed to the current StockGrabber object (polymorphism)
	public StockObserver(Subject stockGrabber){ 
		// poly: Subject stockGrabber=new StockGrabber();
		
		// Store the reference to the stockGrabber object so
		// I can make calls to its methods
		
		this.stockGrabber = stockGrabber;
		
		// Assign an observer ID and increment the static counter
		
		this.observerID = ++observerIDTracker;
		
		// Message notifies user of new observer
		
		System.out.println("New Observer " + this.observerID);
		
		// Add the observer that we just created to the Subjects ArrayList
		this.stockGrabber.register(this); // calls the register method of StockGrabber subclass (poly)
//		this: reference variable of this StockObserver object 
// argument yollanýnca polymorphism olur: Observer newObserver=this;
		
	}
	
	// Called to update all observers
	
	public void update(double ibmPrice, double aaplPrice, double googPrice) {
		
		this.ibmPrice = ibmPrice;
		this.aaplPrice = aaplPrice;
		this.googPrice = googPrice;
		
		printThePrices();
		
	}
	
	public void printThePrices(){
		
		System.out.println("observerID: " + observerID + "\nIBM: " + ibmPrice + "\nAAPL: " + 
				aaplPrice + "\nGOOG: " + googPrice + "\n");
		
	}
	
}