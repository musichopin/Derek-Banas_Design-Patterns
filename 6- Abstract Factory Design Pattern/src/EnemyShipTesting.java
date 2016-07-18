public class EnemyShipTesting {
	
public static void main(String[] args) {
//	store (order) - factory (kilit özellikleri ekler) - product (itemýn tüm özellikleri) sýrasý önemli
		
		// EnemyShipBuilding handles "orders" for new EnemyShips
		// You send it a code using the orderTheShip method &
		// it sends the order to the right factory for creation
	
		EnemyShipBuilding MakeUFOs = new UFOEnemyShipBuilding();
 
		EnemyShip theGrunt = MakeUFOs.orderTheShip("UFO");
		System.out.println(theGrunt + "\n");
//		EnemyShip'deki toString metodunu çaðýrýr
		
		EnemyShip theBoss = MakeUFOs.orderTheShip("UFO BOSS");
		System.out.println(theBoss + "\n");
 
	}
	
}
/*
Making enemy ship UFO Grunt Ship
UFO Grunt Ship is on the screen
UFO Grunt Ship is following the hero at 1000 mph
UFO Grunt Ship attacks and does 20 damage
The UFO Grunt Ship has a top speed of 1000 mph and an attack power of 20 damage

Making enemy ship UFO Boss Ship
UFO Boss Ship is on the screen
UFO Boss Ship is following the hero at 2000 mph
UFO Boss Ship attacks and does 40 damage
The UFO Boss Ship has a top speed of 2000 mph and an attack power of 40 damage
*/