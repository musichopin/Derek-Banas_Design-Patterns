public class TestRobotBuilder {
	
	public static void main(String[] args){
		
		// Get an OldRobotBuilder of type RobotBuilder
		
		RobotBuilder oldStyleRobot = new OldRobotBuilder();
		
		// Pass the OldRobotBuilder specification to the engineer
		
		RobotEngineer robotEngineer = new RobotEngineer(oldStyleRobot);
		
		// Tell the engineer to make the Robot using the specifications
		// of the OldRobotBuilder class
		
		robotEngineer.makeRobot();
		
		// The engineer returns the right robot based off of the spec
		// sent to it on line 11
		
		Robot firstRobot = robotEngineer.getRobot();
		
		System.out.println("Robot Built");
		
		System.out.println("Robot Head Type: " + firstRobot.getRobotHead());
		
		System.out.println("Robot Torso Type: " + firstRobot.getRobotTorso());
		
		System.out.println("Robot Arm Type: " + firstRobot.getRobotArms());
		
		System.out.println("Robot Leg Type: " + firstRobot.getRobotLegs());
		
	}
	
}
/*
Robot Built
Robot Head Type: Tin Head
Robot Torso Type: Tin Torso
Robot Arm Type: Blowtorch Arms
Robot Leg Type: Rollar Skates
*/