public abstract class Colleague{
//	**this class refers to people who put through stock offers referred in stockoffer class.
//	"colleague" is not specific name to mediator design pattern.
//	with this pattern we are attempting to get different colleagues not know anything about each other**
	
	private Mediator mediator;
	private int colleagueCode;
	
//	***all colleagues refer to same mediator(aracý)***
	public Colleague(Mediator newMediator){
		mediator = newMediator; 
		
		mediator.addColleague(this);
//	***this kw ile main metoddaki broker ve broker2 objeleri pass ediliyor***
	}
	
	public void saleOffer(String stock, int shares){
		
		mediator.saleOffer(stock, shares, this.colleagueCode);
		
	}
	
	public void buyOffer(String stock, int shares){
		
		mediator.buyOffer(stock, shares, this.colleagueCode);
		
	}
	
	public void setCollCode(int collCode){ colleagueCode = collCode; }
	
	
}