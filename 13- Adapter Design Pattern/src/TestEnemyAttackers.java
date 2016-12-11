public class TestEnemyAttackers{
	
	public static void main(String[] args){
		
		EnemyAttacker rx7Tank = new EnemyTank();
		
		EnemyRobot fredTheRobot = new EnemyRobot();
		
		EnemyAttacker robotAdapter = new EnemyRobotAdapter(fredTheRobot);
		
		System.out.println("The Robot");
		
		fredTheRobot.reactToHuman("Paul");
		fredTheRobot.walkForward();
		fredTheRobot.smashWithHands();
		System.out.println();
		
		System.out.println("The Enemy Tank");
		
		rx7Tank.assignDriver("Frank");
		rx7Tank.driveForward();
		rx7Tank.fireWeapon();
		System.out.println();
		
		System.out.println("The Robot with Adapter");
		
		robotAdapter.assignDriver("Mark");
		robotAdapter.driveForward();
		robotAdapter.fireWeapon();

	}
	
}
/*
The Robot
Enemy Robot Tramps on Paul
Enemy Robot Walks Forward 5 spaces
Enemy Robot Causes 9 Damage With Its Hands

The Enemy Tank
Frank is driving the tank
Enemy Tank moves 1 spaces
Enemy Tank Does 1 Damage

The Robot with Adapter
Enemy Robot Tramps on Mark
Enemy Robot Walks Forward 1 spaces
Enemy Robot Causes 3 Damage With Its Hands
*/