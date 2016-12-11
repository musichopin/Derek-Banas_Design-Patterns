import java.util.ArrayList;
import java.util.List;

public class PlayWithRemote{
	
	public static void main(String[] args){
//		**program akýþý (objelerin oluþma sýrasý) basic olan ElectronicDevice'dan 
//		kompleks olan DeviceButton'a doðru**
		
		// Gets the ElectronicDevice to use
		ElectronicDevice newDevice = TVRemote.getDevice(); // = new Television()
//		**cannot be, Television newDevice = TVRemote.getDevice();**
		
		// TurnTVOn contains the command to turn on the tv
		// When execute() is called on this command object
		// it will execute the method on() in Television
		
		Command onCommand = new TurnTVOn(newDevice);
//		**same as, TurnTVOn onCommand = new TurnTVOn(newDevice); **
		
		// Calling the execute() causes on() to execute in Television
		
		DeviceButton onPressed = new DeviceButton(onCommand);
		
		// When press() is called theCommand.execute(); executes
		
		onPressed.press();
		
		//----------------------------------------------------------
		
		// Now when execute() is called off() of Television executes
		
		Command offCommand = new TurnTVOff(newDevice);
		
		// Calling the execute() causes off() to execute in Television
//		*overrides the onPressed object*
		onPressed = new DeviceButton(offCommand);
		
		// When press() is called theCommand.execute(); executes
		
		onPressed.press();
		
		//----------------------------------------------------------
		
		// Now when execute() is called volumeUp() of Television executes
		
		Command volUpCommand = new TurnTVUp(newDevice);
				
		// Calling the execute() causes volumeUp() to execute in Television
				
		onPressed = new DeviceButton(volUpCommand);
				
		// When press() is called theCommand.execute(); executes
				
		onPressed.press();
		onPressed.press();
		onPressed.press();
		
		//----------------------------------------------------------
		
		// Creating a TV and Radio to turn off with 1 press
		
		Television theTV = new Television();
//		*alt: ElectronicDevice theTV = new Television();*
		
		Radio theRadio = new Radio();
		
		// Add the Electronic Devices to a List
		
		List<ElectronicDevice> allDevices = new ArrayList<ElectronicDevice>();
		
//		*subclasses are added*
		allDevices.add(theTV);
		allDevices.add(theRadio);
		
		// Send the List of Electronic Devices to TurnItAllOff
		// where a call to run execute() on this function will
		// call off() for each device in the list 
		
		TurnItAllOff turnOffDevices = new TurnItAllOff(allDevices);
//		alt: Command turnOffDevices = new TurnItAllOff(allDevices);
		
		// This calls for execute() to run which calls for off() to
		// run for every ElectronicDevice
		
		DeviceButton turnThemOff = new DeviceButton(turnOffDevices);
		turnThemOff.press();
//		**alt: turnOffDevices.execute();**
		
		//----------------------------------------------------------
		
		/*
		 * It is common to be able to undo a command in a command pattern
		 * To do so, DeviceButton will have a method called undo
		 * Undo() will perform the opposite action that the normal
		 * Command performs. undo() needs to be added to every class
		 * with an execute()
		 */
		
		turnThemOff.pressUndo();
		
		// To undo more than one command add them to a LinkedList
		// using addFirst(). Then execute undo on each item until 
		// there are none left. (This is your Homework)
		
	}
	
}
/*
TV is on
TV is off
TV Volume is at: 1
TV Volume is at: 2
TV Volume is at: 3
TV is off
Radio is off
TV is on
Radio is on
*/