public class TestBankAccount {
	
	public static void main(String[] args){
		
		BankAccountFacade accessingBank = new BankAccountFacade(12345678, 1234);
		
		accessingBank.doesWithdrawCash(50.00);

		accessingBank.doesDepositCash(10.00);
		
		accessingBank.doesWithdrawCash(990.00);
		
	}
	
}
/*
Welcome to ABC Bank
We are happy to give you your money if we can find it

50.0$ withdrawn
Withdrawal Complete: Current Balance is 950.0
Transaction Complete

10.0$ deposited
Deposit Complete: Current Balance is 960.0
Transaction Complete

Error: You don't have enough money
Current Balance: 960.0
Transaction Failed
*/