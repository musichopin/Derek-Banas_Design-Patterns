import java.util.LinkedList;

public class ScrabbleTest {
	
	public static void main(String[] args){
		
		// creates a new instance of Singleton
		
		Singleton newInstance = Singleton.getInstance();
		
		// Get unique id for instance object
//		makes us understand whether we are dealing with same object		
		System.out.println("1st Instance ID: " + System.identityHashCode(newInstance));
		
		// Get all of the letters stored in the List and print them
		
		System.out.println(newInstance.getLetterList());
		
		LinkedList<String> playerOneTiles = newInstance.getTiles(7);
		
		System.out.println("Player 1: " + playerOneTiles);
		
//		created just to see the shortened list after player 1 gets his tiles:
		System.out.println(newInstance.getLetterList());
		
		// Try to make another instance of Singleton
		// This doesn't work because the constructor is private:
		// Singleton instanceTwo = new Singleton();
		
		// Try getting a new instance using getInstance:
		Singleton instanceTwo = Singleton.getInstance();
		
		// Get unique id for the new instance object
		
		System.out.println("2nd Instance ID: " + System.identityHashCode(instanceTwo));
		
		// This returns the value of the first instance created
		
		System.out.println(instanceTwo.getLetterList());
		
		// Player 2 draws 7 tiles
		
		LinkedList<String> playerTwoTiles = newInstance.getTiles(7);
		
		System.out.println("Player 2: " + playerTwoTiles);
		
	}
	
}
/*
1st Instance ID: 1829164700
[b, e, e, i, y, n, o, v, f, o, a, r, p, i, h, q, o, n, e, a, e, w, i, b, e, n, o, e, u, p, y, s, m, r, s, r, o, e, a, d, t, a, g, k, i, i, t, u, t, i, o, r, n, a, s, e, d, c, s, e, l, u, v, o, h, e, a, a, x, u, a, d, o, r, m, a, l, t, c, g, w, g, l, i, j, t, r, e, f, n, t, i, n, i, e, d, z, l]
Player 1: [b, e, e, i, y, n, o, v]
[f, o, a, r, p, i, h, q, o, n, e, a, e, w, i, b, e, n, o, e, u, p, y, s, m, r, s, r, o, e, a, d, t, a, g, k, i, i, t, u, t, i, o, r, n, a, s, e, d, c, s, e, l, u, v, o, h, e, a, a, x, u, a, d, o, r, m, a, l, t, c, g, w, g, l, i, j, t, r, e, f, n, t, i, n, i, e, d, z, l]
2nd Instance ID: 1829164700
[f, o, a, r, p, i, h, q, o, n, e, a, e, w, i, b, e, n, o, e, u, p, y, s, m, r, s, r, o, e, a, d, t, a, g, k, i, i, t, u, t, i, o, r, n, a, s, e, d, c, s, e, l, u, v, o, h, e, a, a, x, u, a, d, o, r, m, a, l, t, c, g, w, g, l, i, j, t, r, e, f, n, t, i, n, i, e, d, z, l]
Player 2: [f, o, a, r, p, i, h, q]
*/