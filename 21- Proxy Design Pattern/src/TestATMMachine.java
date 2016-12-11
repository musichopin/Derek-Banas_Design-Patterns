public class TestATMMachine {
	
	public static void main(String[] args){
		
		ATMMachine atmMachine = new ATMMachine();
		
//		***sýrasýyla nocard, (insertcard metodu ile) hascard, (insertpin metodu ile) haspin 
//		ve (requestcash metodu ile ve hesapta para yok ise) nocash classlarý kullanýlýr 
//		(ejectCard metodu ise birçok class'da kullanýlabilir).
//		her class kendisinden bir sonraki ve bir önceki aksiyonlarý gerçekleþtirir.***
		atmMachine.insertCard();
		
		atmMachine.ejectCard();
		
		atmMachine.insertCard();
		
		atmMachine.insertPin(1); // wrong pin and card ejected
		
		atmMachine.insertCard(); // card inserted and pin number asked
		
		atmMachine.insertPin(1234); // correct pin and money to withdraw is asked
		
		atmMachine.requestCash(2000); // money withdrawn and card ejected 
		
//		from here object of nocash class is used
		atmMachine.insertCard();
		
		atmMachine.insertPin(1234);
		
		
		
		// *****!!!NEW STUFF : Proxy Design Pattern Code!!!*****
		// The interface limits access to just the methods you want
		// made accessible

		GetATMData realATMMachine = new ATMMachine();
		
		GetATMData atmProxy = new ATMProxy();
		
		System.out.println("\nCurrent ATM State " + atmProxy.getATMState(atmMachine));
		
		System.out.println("\nCash in ATM Machine $" + atmProxy.getCashInMachine(atmMachine));
		
		// The user can't perform this action because ATMProxy doesn't
		// have access to that potentially harmful method
		// atmProxy.setCashInMachine(10000);
		
	}
	
}
/*
Please enter your pin
Your card is ejected
Please enter your pin
You entered the wrong PIN
Your card is ejected
Please enter your pin
You entered the correct PIN
Please specify the amount to withdraw
2000 is provided by the machine
Your card is ejected
You don't have any money
Your card is ejected
You didn't enter a card

Current ATM State NoCash@2a139a55

Cash in ATM Machine $0
*/