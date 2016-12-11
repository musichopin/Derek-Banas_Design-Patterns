import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class DiscJockey {
	
//	***not used***
	SongsOfThe70s songs70s;
	SongsOfThe80s songs80s;
	SongsOfThe90s songs90s;
	
	// NEW Passing in song iterators
	
	SongIterator iter70sSongs;
	SongIterator iter80sSongs;
	SongIterator iter90sSongs;
	
	/* OLD WAY
	public DiscJockey(SongsOfThe70s newSongs70s, SongsOfThe80s newSongs80s, SongsOfThe90s newSongs90s) {
		
		songs70s = newSongs70s;
		songs80s = newSongs80s;
		songs90s = newSongs90s;
		
	}
	*/
	
	// NEW WAY Initialize the iterators	
	
	public DiscJockey(SongIterator newSongs70s, SongIterator newSongs80s, SongIterator newSongs90s) {
		
		iter70sSongs = newSongs70s;
		iter80sSongs = newSongs80s;
		iter90sSongs = newSongs90s;
		
	}
//	prints
	public void showTheSongs() {
//		***not used
		// Because the SongInfo Objects are stored in different
		// collections everything must be handled on an individual
		// basis. This is BAD!***
		
//		alt: without downcasting (but we needed to initialize iter70sSongs):
//		ArrayList<SongInfo> aL70sSongs = songs70s.getBestSongs();
		ArrayList<SongInfo> aL70sSongs = ((SongsOfThe70s) iter70sSongs).getBestSongs();
		
		System.out.println("Songs of the 70s\n");
		
		for(int i=0; i < aL70sSongs.size(); i++){
			
			SongInfo bestSongs = (SongInfo) aL70sSongs.get(i); // casting was needless
			
			System.out.println(bestSongs.getSongName());
			System.out.println(bestSongs.getBandName());
			System.out.println(bestSongs.getYearReleased() + "\n");
			
		}
		
//		alt: without downcasting (but we needed to initialize iter80sSongs):
//		SongInfo[] array80sSongs = songs80s.getBestSongs();
		SongInfo[] array80sSongs = ((SongsOfThe80s) iter80sSongs).getBestSongs();
		
		System.out.println("Songs of the 80s\n");
		
		for(int j=0; j < array80sSongs.length; j++){
			
			SongInfo bestSongs = array80sSongs[j];
			
			System.out.println(bestSongs.getSongName());
			System.out.println(bestSongs.getBandName());
			System.out.println(bestSongs.getYearReleased() + "\n");
			
		}
		
//		alt: without downcasting (but we needed to initialize iter90sSongs):
//		Hashtable<Integer, SongInfo> ht90sSongs = songs90s.getBestSongs();
		Hashtable<Integer, SongInfo> ht90sSongs = ((SongsOfThe90s) iter90sSongs).getBestSongs();
		
		System.out.println("Songs of the 90s\n");
		
//		*while we got more elements in the hastable we want to continue looping*
		for (Enumeration<Integer> e = ht90sSongs.keys(); e.hasMoreElements();)
	    {
			SongInfo bestSongs = ht90sSongs.get(e.nextElement());
			
			System.out.println(bestSongs.getSongName());
			System.out.println(bestSongs.getBandName());
			System.out.println(bestSongs.getYearReleased() + "\n");
			
	    }
		
	}
	
	// ***Now that I can treat everything as an Iterator it cleans up
	// the code while allowing me to treat all collections as 1.
//	calls printTheSongs method to print***
	public void showTheSongs2(){
		
		System.out.println("NEW WAY WITH ITERATOR\n");
//		*stores*
//		***different from the field variables of Songs70s, Songs80s, Songs90s***
		Iterator<SongInfo> Songs70s = iter70sSongs.createIterator(); // ... = bestSongs.iterator();
		Iterator<SongInfo>  Songs80s = iter80sSongs.createIterator(); // ... = Arrays.asList(bestSongs).iterator()
		Iterator<SongInfo> Songs90s = iter90sSongs.createIterator(); // ... = bestSongs.values().iterator();
//		**alt:
//		Iterator<SongInfo> Songs70s = ((SongsOfThe70s) iter70sSongs).createIterator();
//		Iterator<SongInfo> Songs80s = ((SongsOfThe80s) iter80sSongs).createIterator();
//		Iterator<SongInfo> Songs90s = ((SongsOfThe90s) iter90sSongs).createIterator();**
		
		System.out.println("Songs of the 70s\n");
		printTheSongs(Songs70s);
		
		System.out.println("Songs of the 80s\n");
		printTheSongs(Songs80s);
		
		System.out.println("Songs of the 90s\n");
		printTheSongs(Songs90s);
		
	}
	
//	**printTheSongs metodu kullanýlmasaydý hardcoding yapýlacaktý**
	public void printTheSongs(Iterator iterator){
		
		while(iterator.hasNext()){
			
//			"double to int castingi" misali cast edilmiþ
			SongInfo songInfo = (SongInfo) iterator.next();
//			**parametrede "Iterator<SongInfo> iterator denseydi castinge gerek olmayacaktý"**
			
			System.out.println(songInfo.getSongName());
			System.out.println(songInfo.getBandName());
			System.out.println(songInfo.getYearReleased() + "\n");
			
		}
		
	}
	
}