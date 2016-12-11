public class FundsCheck {
	
	private double cashInAccount = 1000.00;
	
//	getter
	public double getCashInAccount() { return cashInAccount; }
	
//	setter
	public void decreaseCashInAccount(double cashWithdrawn) { cashInAccount -= cashWithdrawn; }
//	*cannot be "getCashInAccount -= cashWithdrawn"*
	
//	setter
	public void increaseCashInAccount(double cashDeposited) { cashInAccount += cashDeposited; }
	
	public boolean haveEnoughMoney(double cashToWithdrawal) {
		
		if(cashToWithdrawal > getCashInAccount()) {

			return false;
			
		} else {
			
			return true;
			
		}
		
	}
	
//	***Normally this class should have only checked the fund and another class should have withdrawn or madedeposit***
	public void makeWithdrawal(double cashToGet) {
		
		decreaseCashInAccount(cashToGet);
		
		System.out.println(cashToGet + "$ withdrawn");

		System.out.println("Withdrawal Complete: Current Balance is " + getCashInAccount());
		
	}
	
	public void dontMakeWithdrawal() {
		
		System.out.println("Error: You don't have enough money");
		
		System.out.println("Current Balance: " + getCashInAccount());
		
	}
	
	public void makeDeposit(double cashToDeposit) {
		
		increaseCashInAccount(cashToDeposit);
		
		System.out.println(cashToDeposit + "$ deposited");
		
		System.out.println("Deposit Complete: Current Balance is " + getCashInAccount());
		
	}
	
}