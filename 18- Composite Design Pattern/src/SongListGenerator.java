public class SongListGenerator {
	
	public static void main(String[] args){
//		**songgroup class is like a folder whereas song class is like a file**
		
		SongComponent industrialMusic = 
				new SongGroup("Industrial", 
						"is a style of experimental music that draws on transgressive and provocative themes");
		
		SongComponent heavyMetalMusic = 
				new SongGroup("\nHeavy Metal", 
						"is a genre of rock that developed in the late 1960s, largely in the UK and in the US");
		
		SongComponent dubstepMusic = 
				new SongGroup("\nDubstep", 
						"is a genre of electronic dance music that originated in South London, England");
		
		// **Top level component that holds everything**
		
		SongComponent everySong = new SongGroup("Song List", "Every Song Available");
		
		everySong.add(new Song("Without Me", "Eminem", 2002));
		
		// *Composite that holds individual groups of songs
		// This holds Songs plus a SongGroup with Songs*
		
		everySong.add(industrialMusic);
		
		industrialMusic.add(new Song("Head Like a Hole", "NIN", 1990));
		industrialMusic.add(new Song("Headhunter", "Front 242", 1988));
		
		industrialMusic.add(dubstepMusic);
		
		dubstepMusic.add(new Song("Centipede", "Knife Party", 2012));
		dubstepMusic.add(new Song("Tetris", "Doctor P", 2011));
		
		// This is a SongGroup that just holds Songs
		
		everySong.add(heavyMetalMusic);
		
		heavyMetalMusic.add(new Song("War Pigs", "Black Sabath", 1970));
		heavyMetalMusic.add(new Song("Ace of Spades", "Motorhead", 1980));
		
		DiscJockey crazyLarry = new DiscJockey(everySong);
		
		crazyLarry.getSongList();
			
	}
	
}
/*
Song List Every Song Available

Without Me was recorded by Eminem in 2002
Industrial is a style of experimental music that draws on transgressive and provocative themes

Head Like a Hole was recorded by NIN in 1990
Headhunter was recorded by Front 242 in 1988

Dubstep is a genre of electronic dance music that originated in South London, England

Centipede was recorded by Knife Party in 2012
Tetris was recorded by Doctor P in 2011

Heavy Metal is a genre of rock that developed in the late 1960s, largely in the UK and in the US

War Pigs was recorded by Black Sabath in 1970
Ace of Spades was recorded by Motorhead in 1980
*/