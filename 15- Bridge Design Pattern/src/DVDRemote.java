// Refined Abstraction

// If I decide I want to further extend the remote I can

public class DVDRemote extends AbstractRemoteControl{
	
	private boolean play = true;
	
	public DVDRemote(EntertainmentDevice newDevice) {
		super(newDevice);
	}
	
	public void buttonNinePressed() {
		
		play();
		
	}

	private void play() {
		
		play = !play;
		
		System.out.println("DVD is Playing: " + play);
		
	}
	
}