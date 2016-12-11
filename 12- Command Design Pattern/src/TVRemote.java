public class TVRemote {
//	*we didn’t fully develop the TVRemote. 
//	The idea was to have numerous versions of getDevice, 
//	so that I could control things other then just the television.
//	The goal here was to be able to use an unlimited number of possible 
//	remotes with an unlimited number of different electronic devices.*
	
	public static ElectronicDevice getDevice(){
//		***alt: public static Television getDevice(){
//		main metoddaki, ElectronicDevice newDevice = TVRemote.getDevice();
//		ifadesi Television newDevice = TVRemote.getDevice(); olsaydý (ki poly ye ters)
//		public static Television getDevice(){ olmak zorunda olacaktý***
		
		return new Television();
		
	}
	
}