public class GrabStocks{
	// basic summary: observer arraylisti oluþur (by StockGrabber)
	// observer yaratýlýr ki sonradan update gönderilsin (by StockObserver and StockGrabber)
	// stockPrice set edilir ve Observera yollanýr (by StockGrabber and StockObserver)
	public static void main(String[] args){
		
		// Create the Subject (aka publisher) object
		// It will handle updating all observers 
		// as well as deleting and adding them
		StockGrabber stockGrabber = new StockGrabber();
		
		// Create an Observer (aka subscriber; add to the arraylist) that will 
		// be sent updates from Subject 
		// !we'll be able to access methods of StockGrabber class with stockGrabber arg
		// register metodu stockGrabber arg sayesinde eriþilebilir
		StockObserver observer1 = new StockObserver(stockGrabber); 
		// object created for the constructor
		// argument yollanýnca polymorphism olur: Subject stockGrabber=stockGrabber;
		
		// hem set eder hem de baþka metodlarý çaðýrarak dolaylý yoldan print
		stockGrabber.setIBMPrice(197.00); 
		stockGrabber.setAAPLPrice(677.60);
		stockGrabber.setGOOGPrice(676.40);
		
		StockObserver observer2 = new StockObserver(stockGrabber); 
		// object created for the constructor
		
		// hem observer 1'e hem de 2'ye notification yollanýr
		stockGrabber.setIBMPrice(197.00); 
		stockGrabber.setAAPLPrice(677.60);
		stockGrabber.setGOOGPrice(676.40);
		
		// Delete one of the observers
//		observer 1 no longer receives updates
		stockGrabber.unregister(observer2); 
		// register metodu StockObserver constructor üzerinden çaðýrýlmýþtý
		
		stockGrabber.setIBMPrice(197.00);
		stockGrabber.setAAPLPrice(677.60);
		stockGrabber.setGOOGPrice(676.40);
		
		// Create 3 threads using the Runnable interface
		// GetTheStock implements Runnable, so it doesn't waste 
		// its one extendable class option
		
		Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
		Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 677.60);
		Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 676.40);
		
		// Call for the code in run to execute 
		
		new Thread(getIBM).start();
		new Thread(getAAPL).start();
		new Thread(getGOOG).start();
		
		
	}
	
}