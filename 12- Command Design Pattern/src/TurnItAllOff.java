import java.util.List;

// *turns off all the devices*
public class TurnItAllOff implements Command {
  List<ElectronicDevice> theDevices;
 
  public TurnItAllOff(List<ElectronicDevice> newDevices) {
	  theDevices = newDevices;
  }
 
  public void execute() {
 
    for (ElectronicDevice device : theDevices) {
      device.off();
    }
 
  }

  public void undo() {
	
	for (ElectronicDevice device : theDevices) {
	      device.on();
	    }
	
  }
}