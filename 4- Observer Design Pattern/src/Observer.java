// The Observers (subscribers) update method is called when the Subject (publisher) changes

public interface Observer {
	
	public void update(double ibmPrice, double aaplPrice, double googPrice);
	
}