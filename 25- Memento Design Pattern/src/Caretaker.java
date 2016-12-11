// Memento Design Pattern Tutorial

//	***mementonun liste eklenmesi (save) esnasýnda originator -> memento -> caretaker sýrasý varken 
//	mementonun listten çýkarýlmasý (undo ve redo) esnasýnda caretaker -> memento -> originator sýrasý oluþur***

import java.util.ArrayList;

class Caretaker {
   
	// Where all mementos are saved
	
	ArrayList<Memento> savedArticles = new ArrayList<Memento>();

	// Adds memento to the ArrayList

	public void addMemento(Memento m) { savedArticles.add(m); }
   
	// Gets the memento requested from the ArrayList
	
	public Memento getMemento(int index) { return savedArticles.get(index); }
} 