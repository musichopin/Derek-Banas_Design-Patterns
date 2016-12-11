public class TurnTVOn implements Command {
//	**TurnDeviceOn dense daha doðru olurdu (tv'nin yaný sýra radyoyu da niteliyor)**

	ElectronicDevice theDevice;
	
//	***TurnTVOn metoduna pass edilen arg, ElectronicDevice newDevice = new Television() þeklinde de
//	Television newDevice = new Television() þeklinde de oluþabilir ve poly'nin anlamý kaybolmaz***
	public TurnTVOn(ElectronicDevice newDevice){
//		*** TurnTVOn metodunun parametresi "(Television newDevice)" olamaz
//		zira hem poly'nin anlamý kalmaz hem de TurnTVOn'a pass edilen arg ElectronicDevice türünde.
//		yukarýdaki TurnTVOn metoduna pass edilen argument Television türünde olabilir. 
//		bu durumda parametre"(Television newDevice)" da olabilir (ama yine poly'nin anlamý kalmaz) ***
		
		theDevice = newDevice;
		
	}
	
	public void execute() {
		
		theDevice.on();
		
	}

	public void undo() {
		
		theDevice.off();
		
	}
	
}