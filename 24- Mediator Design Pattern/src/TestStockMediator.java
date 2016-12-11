public class TestStockMediator{
	
	public static void main(String[] args){
		
		StockMediator nyse = new StockMediator(); // ny stock exchange
//		Colleague and StockOffer lists created
		
		Colleague broker = new GormanSlacks(nyse); // borsacý
//		StockMediator object created
		
		Colleague broker2 = new JTPoorman(nyse); // borsacý
		
		broker.saleOffer("MSFT", 100);
		broker.buyOffer("GOOG", 50);
		broker2.buyOffer("MSFT", 100); // ***saleoffer, "MSFT", 100 olduðu için o hisseyi alýr***
		broker2.saleOffer("NRG", 10);
		broker.buyOffer("NRG", 10); // saleOffer, "NRG", 10 olduðu için o hisseyi alýr
		broker2.saleOffer("GOOG", 50); // buyoffer, "GOOG", 50 olduðu için o hisseyi alýr
		broker2.saleOffer("GOOG", 10); // buyoffer, "GOOG", 50 olduðu için o hisseyi alýr
		broker.buyOffer("APPLE", 5); // buyoffer, "GOOG", 50 olduðu için o hisseyi alýr
		
//		**prints out stock offers after transactions completed above**
		nyse.getstockOfferings();
		
	}
	
}
/*
Gorman Slacks signed up with the stockexchange

JT Poorman signed up with the stockexchange

100 shares of MSFT added to inventory
50 shares of GOOG added to inventory
100 shares of MSFT bought by colleague code 2
10 shares of NRG added to inventory
10 shares of NRG bought by colleague code 1
50 shares of GOOG sold to colleague code 1
10 shares of GOOG added to inventory
5 shares of APPLE added to inventory

Stocks Sale Offers
10 shares of GOOG from colleague code 2

Stock Buy Offers
5 shares of APPLE from colleague code 1
*/