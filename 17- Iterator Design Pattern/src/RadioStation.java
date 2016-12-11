public class RadioStation {
	
	public static void main(String[] args){
		
		SongIterator songs70s = new SongsOfThe70s();
		SongIterator songs80s = new SongsOfThe80s();
		SongIterator songs90s = new SongsOfThe90s();
		
		DiscJockey madMike = new DiscJockey(songs70s, songs80s, songs90s);
		
		// madMike.showTheSongs();
		
		madMike.showTheSongs2();
		
	}
	
}
/*
NEW WAY WITH ITERATOR

Songs of the 70s

Imagine
John Lennon
1971

American Pie
Don McLean
1971

I Will Survive
Gloria Gaynor
1979

Songs of the 80s

Roam
B 52s
1989

Cruel Summer
Bananarama
1984

Head Over Heels
Tears For Fears
1985

Songs of the 90s

Walk on the Ocean
Toad The Wet Sprocket
1991

Creep
Radiohead
1993

Losing My Religion
REM
1991
*/