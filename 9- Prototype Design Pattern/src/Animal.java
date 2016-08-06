// By making this class cloneable you are telling Java
// that it is ok to copy instances of this class
// These instance copies have different results when
// System.identityHashCode(System.identityHashCode(bike))
// is called (they are just copy, not same object)

public interface Animal extends Cloneable {
	
	public Animal makeCopy();
	
}