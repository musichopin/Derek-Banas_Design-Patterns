public class GrabStocks{
	// basic summary: observer arraylisti oluþur (by StockGrabber)
	// observer yaratýlýr ki sonradan update gönderilsin (by StockObserver and StockGrabber)
	// stockPrice set edilir ve Observera yollanýr (by StockGrabber and StockObserver)
	public static void main(String[] args){
		
		// Create the Subject (aka publisher) object
		// It will handle updating all observers 
		// as well as deleting and adding them
		StockGrabber stockGrabber = new StockGrabber();
//		*** !subclass var diye 'super class = sub class' yazýlmak zorunda deðil
//		Subject stockGrabber = new StockGrabber(); yazýlabilmesi için
//		setIBMPrice, setAAPLPrice etc metodlarýnýn Subject interface içinde
//		olmasý gerekecekti***
		
		// Create an Observer (aka subscriber; add to the arraylist) that will 
		// be sent updates from Subject 
		// !we'll be able to access methods of StockGrabber class with stockGrabber arg
		// register metodu stockGrabber arg sayesinde eriþilebilir
		StockObserver observer1 = new StockObserver(stockGrabber); 
		// ***argument yollanýnca polymorphism olur: Subject stockGrabber=stockGrabber;***
//		***Observer observer1 = new StockObserver(stockGrabber); olabilirdi***
		
		// hem set eder hem de notify metodunu çaðýrarak dolaylý yoldan print
		stockGrabber.setIBMPrice(197.00); 
		stockGrabber.setAAPLPrice(677.60);
		stockGrabber.setGOOGPrice(676.40);
		
		StockObserver observer2 = new StockObserver(stockGrabber); 
		// object created for the constructor
		
		// hem observer 1'e hem de 2'ye notification yollanýr
		stockGrabber.setIBMPrice(197.00); 
		stockGrabber.setAAPLPrice(500.60);
		stockGrabber.setGOOGPrice(300.40);
		
		// Delete one of the observers
//		observer 1 no longer receives updates
		stockGrabber.unregister(observer2); //***poly***
		// register metodu StockObserver constructor üzerinden çaðýrýlmýþtý
		
		stockGrabber.setIBMPrice(180.00);
		stockGrabber.setAAPLPrice(327.60);
		stockGrabber.setGOOGPrice(346.40);
		
		
		//***2. part***
		
		// Create 3 threads using the Runnable interface
		// GetTheStock implements Runnable, so it doesn't waste 
		// its one extendable class option
		
//		calls the constructor as well as creating ref var
//		alt: GetTheStock getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
		Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
		Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 677.60);
		Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 676.40);
		
		// Call for the code in run to execute 
		
		new Thread(getIBM).start();
		new Thread(getAAPL).start();
		new Thread(getGOOG).start();
//		run metodu yukarýda kendine ait olan her bir objectten sonra bile yaratýlmýþ olsa toptan print ederdi
//		run metodu çaðýrýlmadan constructor yaratmanýn ve value set etmenin anlamý yok
		
	}
	
}