// Refined Abstraction

// If I decide I want to further extend the remote I can

public class TVRemoteMute extends AbstractRemoteControl{
	
	public TVRemoteMute(EntertainmentDevice newDevice) {
		super(newDevice);
	}
	
	public void buttonNinePressed() {
		
		mute();
		
	}

	private void mute() {
		
		System.out.println("TV was Muted");
		
	}
	
}