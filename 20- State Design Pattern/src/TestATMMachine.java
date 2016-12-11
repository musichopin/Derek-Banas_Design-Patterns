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

*/