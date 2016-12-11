// Refined Abstraction

// If I decide I want to further extend the remote I can

public class TVRemotePause extends AbstractRemoteControl{
	
	public TVRemotePause(EntertainmentDevice newDevice) {
		super(newDevice);
	}
	
	public void buttonNinePressed() {
		
		pause();
		
	}

	private void pause() {
		
		System.out.println("TV was Paused");
		
	}
	
}