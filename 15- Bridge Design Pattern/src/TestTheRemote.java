public class TestTheRemote{
	
	public static void main(String[] args){
		
		AbstractRemoteControl tvRemote = new TVRemoteMute(new TVDevice(1, 200));
		
		AbstractRemoteControl tvRemote2 = new TVRemotePause(new TVDevice(1, 200));
		
		// HOMEWORK --------------
		
		AbstractRemoteControl DVDRemote = new DVDRemote(new DVDDevice(1,14));
		
		// -----------------------
		
		System.out.println("Test TV with Mute");
		
		tvRemote.buttonFivePressed();
		tvRemote.buttonSixPressed();
		tvRemote.buttonNinePressed();
		tvRemote.buttonSevenPressed();
		tvRemote.buttonEightPressed();
		
		System.out.println("\nTest TV with Pause");
		
		tvRemote2.buttonFivePressed();
		tvRemote2.buttonSixPressed();
		tvRemote2.buttonNinePressed();
		tvRemote2.deviceFeedback();
		
		// HOMEWORK
		
		System.out.println("\nTest DVD");
		
		DVDRemote.buttonFivePressed();
		DVDRemote.buttonSixPressed();
		DVDRemote.buttonNinePressed();
		DVDRemote.buttonNinePressed();
		tvRemote.buttonSevenPressed();
		tvRemote.buttonSevenPressed();
		tvRemote.buttonEightPressed();
		
	}
	
}
/*
Test TV with Mute
Channel Down
Channel Up
TV was Muted
Volume at: 1
Volume at: 0

Test TV with Pause
Channel Down
Channel Up
TV was Paused
On Channel 1

Test DVD
DVD Skips to Chapter
DVD Skips to Next Chapter
DVD is Playing: false
DVD is Playing: true
Volume at: 1
Volume at: 2
Volume at: 1
*/