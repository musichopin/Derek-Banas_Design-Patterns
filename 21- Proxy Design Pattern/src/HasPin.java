public class HasPin implements ATMState {
//	*if correct pin entered by user*
	ATMMachine atmMachine;
	
	public HasPin(ATMMachine newATMMachine){
		
		atmMachine = newATMMachine;
		
	}

	public void insertCard() {
		
		System.out.println("You already entered a card");
		
	}

	public void ejectCard() {
		
		System.out.println("Your card is ejected");
		atmMachine.setATMState(atmMachine.getNoCardState());
		
	}

	public void requestCash(int cashToWithdraw) {
		
		if(cashToWithdraw > atmMachine.cashInMachine){
			
			System.out.println("You don't have that much cash available");
			ejectCard();
			
		} else {
			
			System.out.println(cashToWithdraw + " is provided by the machine");
			atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw);
			
			ejectCard();
			
			if(atmMachine.cashInMachine <= 0){ 
				
				atmMachine.setATMState(atmMachine.getNoCashState());
				
			}
		} 
	}

	public void insertPin(int pinEntered) {
		
		System.out.println("You already entered a PIN");
		
	}	
}