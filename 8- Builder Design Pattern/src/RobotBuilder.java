// Defines the methods needed for creating parts 
// for the robot (kinda like a factory)

public interface RobotBuilder {
	
	public void buildRobotHead();
	
	public void buildRobotTorso();
	
	public void buildRobotArms();
	
	public void buildRobotLegs();
	
	public Robot getRobot();
	
}