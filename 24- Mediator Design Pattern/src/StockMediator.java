import java.util.ArrayList;

public class StockMediator implements Mediator{ // aracý

	private ArrayList<Colleague> colleagues;
	private ArrayList<StockOffer> stockBuyOffers;
	private ArrayList<StockOffer> stockSaleOffers;
	
	private int colleagueCodes = 0;
	
	public StockMediator(){
		
		colleagues = new ArrayList<Colleague>();
		stockBuyOffers = new ArrayList<StockOffer>();
		stockSaleOffers = new ArrayList<StockOffer>();
	}
	
	public void addColleague(Colleague newColleague){
		
		colleagues.add(newColleague); // *not binding for the program*
//		*new colleague is added to the list of colleagues*
		
		colleagueCodes++; // *static olmasýna gerek yok*
//		**colleague code refers to unique code specific to each colleague** 
		newColleague.setCollCode(colleagueCodes);
		
	}
	
	public void saleOffer(String stock, int shares, int collCode) {

		boolean stockSold = false;
		
		for(StockOffer offer: stockBuyOffers){
			
			if((offer.getStockSymbol() == stock) && (offer.getstockShares() == shares)){
				
				System.out.println(shares + " shares of " + stock + 
						" sold to colleague code " + offer.getCollCode());
//				***we found an offer (specific stock and shares) that one colleague wanna sell and another wanna buy***
				
				stockBuyOffers.remove(offer);
//				**we erase the buy offer from db/list since the need was met**
//				**bu konsepti anlamak önemli: listin bir elemaný eksiliyor**
				
				stockSold = true;
				
			}
			
//			**since stock has been sold we dont wanna cycle through stockbuyoffer list anymore**
			if(stockSold){ break; } // gets out of loop
			
		}
		
		if(!stockSold) {
			
			System.out.println(shares + " shares of " + stock + 
					" added to inventory"); // kataloga/listeye eklendi
//			**sonraki sefere hisse alanlardan aranacak**
			
			StockOffer newOffering = new StockOffer(shares, stock, collCode);
			
			stockSaleOffers.add(newOffering);
			
		}
	
	}

	public void buyOffer(String stock, int shares, int collCode) {
		
		boolean stockBought = false;
		
		for(StockOffer offer: stockSaleOffers){
			
			if((offer.getStockSymbol() == stock) && (offer.getstockShares() == shares)){
				
				System.out.println(shares + " shares of " + stock + 
						" bought by colleague code " + collCode);
				
				stockSaleOffers.remove(offer);
				
				stockBought = true;
				
			} 
			
			if(stockBought){ break; }
			
		}
		
		if(!stockBought) {
			
			System.out.println(shares + " shares of " + stock + 
					" added to inventory"); // kataloga/listeye eklendi
//			**sonraki sefere hissesini satanlardan aranacak**
			
			StockOffer newOffering = new StockOffer(shares, stock, collCode);
			
			stockBuyOffers.add(newOffering);
			
		}
		
	}
	
//	**prints out stock offers mediator knows about**
	public void getstockOfferings(){
		
		System.out.println("\nStocks Sale Offers");
		
		for(StockOffer offer: stockSaleOffers){
			
			System.out.println(offer.getstockShares() + " shares of " + offer.getStockSymbol() 
				+ " from colleague code " + offer.getCollCode());
			
		}
		
		System.out.println("\nStock Buy Offers");
		
		for(StockOffer offer: stockBuyOffers){
			
			System.out.println(offer.getstockShares() + " shares of " + offer.getStockSymbol()  
				+ " from colleague code " + offer.getCollCode());
			
		}
		
	}
	
}