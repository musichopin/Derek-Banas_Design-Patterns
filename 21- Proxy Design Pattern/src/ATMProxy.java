// **In this situation the proxy is passed an ATMMachine Object**

public class ATMProxy implements GetATMData {

	// Allows the user to access getATMState in the 
	// Object ATMMachine
	
	public ATMState getATMState(ATMMachine atm) {
		
		return atm.getATMState(null);
//		**null pass edilmesinin sebebi atmmachine ve atmproxy'nin 
//		2 sinin de getatmdata'yý implement etmesi**
	}

	// Allows the user to access getCashInMachine 
	// in the Object ATMMachine
	
	public int getCashInMachine(ATMMachine atm) {
		
		return atm.getCashInMachine(null);
		
	}
	
}