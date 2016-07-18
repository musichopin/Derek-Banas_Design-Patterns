// With an Abstract Factory Pattern you won't
// just build ships, but also all of the components
// for the ships

// Here is where you define the parts that are required
// if an object wants to be an enemy ship

// we can produce as many products/objects/UFOs with factory as possible 
// if we got enough engine and gun

// factory
public interface EnemyShipFactory{
//	yt alt: 
//	void addParts(EnemyShip ship);
	
	public ESWeapon addESGun();
	public ESEngine addESEngine();
	
}