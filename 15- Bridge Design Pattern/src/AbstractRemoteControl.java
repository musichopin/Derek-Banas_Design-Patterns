// Abstraction

// This is an abstract class that will represent numerous
// ways to work with each device

public abstract class AbstractRemoteControl{
	
	// A reference to a generic device using aggregation
	
	private EntertainmentDevice theDevice;
	
	public AbstractRemoteControl(EntertainmentDevice newDevice){
		
		theDevice = newDevice;
		
	}
	
	public void buttonFivePressed() {
		
		theDevice.buttonFivePressed();
		
	}
	
	public void buttonSixPressed() {
		
		theDevice.buttonSixPressed();
		
	}
	
	public void deviceFeedback(){
		
		theDevice.deviceFeedback();
		
	}
	
	public void buttonSevenPressed() {
		
		theDevice.buttonSevenPressed();
		
	}
	
	public void buttonEightPressed() {
		
		theDevice.buttonEightPressed();
		
	}
	
//	**buttonNinePressed() subclass ile implement edilirken diðer metodlar (deviceFeedback() vs)
//	EntertainmentDevice abstract classý ve onun subclasslarý ile anlam kazanýr**
	public abstract void buttonNinePressed();
	
}