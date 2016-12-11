public interface Mediator { // aracý
	
	public void saleOffer(String stock, int shares, int collCode);
	
	public void buyOffer(String stock, int shares, int collCode);

	public void addColleague(Colleague colleague);
	
}