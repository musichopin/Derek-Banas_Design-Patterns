import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class GetTheStock implements Runnable{
	
	// Could be used to set how many seconds to wait
	// in Thread.sleep() below
	
//	startTime intended to make the thread be updated based on a time we define
	// private int startTime; 
	private String stock;
	private double price;
	
	// Will hold reference to the StockGrabber object
	private Subject stockGrabber;
	
//	newStartTime: how long to wait before the thread is executed
//	stockGrabber: makes a reference to the Subject (and StockGrabber via poly)
	public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice){
		
		// Store the reference to the stockGrabber object so
		// I can make calls to its methods (just like we did it before without using thread)
		this.stockGrabber = stockGrabber;
		
		// startTime = newStartTime;  (Not used) to have variable sleep time
		stock = newStock;
		price = newPrice;
		
	}
	
	public void run(){
		
//		***change the price for 20 times***
		for(int i = 1; i <= 20; i++){
		
			try{
				
				// ***Sleep for 2 seconds before executing the code below
//				(tüm observerlar için her loopda toplam 2 saniye bekliyor ve sýra karýþýk print ediliyor)***
				Thread.sleep(2000);
//				Thread.sleep(1000*newStartTime);
				
				// Use Thread.sleep(startTime * 1000); to 
				// make sleep time variable
			}
			catch(InterruptedException e)
			{}
			
			// Generates a random number between -.03 and .03
			
			double randNum = (Math.random() * (.06)) - .03;
			
			// Formats decimals to 2 places
			
			Locale locale = new Locale("en", "US"); 
			DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(locale); 
			df.applyPattern("#.##");
			// hata verdi abd dýþýnda olduðumuzdan:
//			DecimalFormat df = new DecimalFormat("#.##");
			
			// Change the price and then convert it back into a double (double wrapper class)
//			(decimalformat kicks out a string)
	        price = Double.valueOf(df.format((price + randNum)));
			
//	        ***polymorphism (upcasting) sonrasý downcasting yapýlmýþ ki sadece StockGrabber
//	        içerisindeki metodlara ulaþýlabilsin***
			if(stock == "IBM") ((StockGrabber) stockGrabber).setIBMPrice(price);
			if(stock == "AAPL") ((StockGrabber) stockGrabber).setAAPLPrice(price);
			if(stock == "GOOG") ((StockGrabber) stockGrabber).setGOOGPrice(price);
			
			String mark = (randNum>=0) ? "+" : "";
			
			System.out.println(stock + ": " + df.format((price + randNum)) + 
					" " + mark + df.format(randNum));
			
			System.out.println();
		
		}
	}
	
}