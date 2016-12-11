// The Facade Design Pattern decouples or separates the client 
// from all of the sub components

// The Facades aim is to simplify interfaces so you don't have 
// to worry about what is going on under the hood

public class BankAccountFacade {
	
	private int accountNumber;
	private int securityCode;
	
	AccountNumberCheck acctChecker;
	SecurityCodeCheck codeChecker;
	FundsCheck fundChecker;
	
	WelcomeToBank bankWelcome;
	
	public BankAccountFacade(int newAcctNum, int newSecCode){
		
		accountNumber = newAcctNum;
		securityCode = newSecCode;
		
		bankWelcome = new WelcomeToBank();
		
		acctChecker = new AccountNumberCheck();
		codeChecker = new SecurityCodeCheck();
		fundChecker = new FundsCheck();
		
//		**we avoid duplicate by checking checking account no and security code in constructor** 
		if(!acctChecker.accountActive(getAccountNumber()) ||
				!codeChecker.isCodeCorrect(getSecurityCode())){
				System.out.println("Transaction failed because of wrong security code "
						+ "or wrong account number.\n");	
				System.exit(0);
		}
		
	}
	
	public int getAccountNumber() { return accountNumber; }
	
	public int getSecurityCode() { return securityCode; }
	
	
	public void doesWithdrawCash(double cashToGet){
		
		if(fundChecker.haveEnoughMoney(cashToGet)) {
					
					fundChecker.makeWithdrawal(cashToGet);
			
					System.out.println("Transaction Complete\n");
					
				} else {
					
					fundChecker.dontMakeWithdrawal();
					
					System.out.println("Transaction Failed\n");
					
				}
		
	}
	
	
	public void doesDepositCash(double cashToDeposit){
		
					fundChecker.makeDeposit(cashToDeposit);
					
					System.out.println("Transaction Complete\n");
					
	}
					
}