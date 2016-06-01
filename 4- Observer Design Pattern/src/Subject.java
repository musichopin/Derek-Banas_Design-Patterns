// This interface handles adding, deleting and updating
// all observers 

public interface Subject {
	
	public void register(Observer o); // adds observer (subscriber)
	public void unregister(Observer o); // removes observer (subscriber)
	public void notifyObserver();
//	notifies about stock changes
	
}