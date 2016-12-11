public class NoCash implements ATMState {
//	*if account has no more cash; simplest of all states*
	ATMMachine atmMachine;
	
	public NoCash(ATMMachine newATMMachine){
		
		atmMachine = newATMMachine;
		
	}

	public void insertCard() {
		
		System.out.println("You don't have any money");
		System.out.println("Your card is ejected");
		
	}

	public void ejectCard() {
		
		System.out.println("You didn't enter a card");
		
	}

	public void requestCash(int cashToWithdraw) {
		
		System.out.println("You didn't enter a card");
		
	}

	public void insertPin(int pinEntered) {
		
		System.out.println("You didn't enter a card");
		
	}	
	
}