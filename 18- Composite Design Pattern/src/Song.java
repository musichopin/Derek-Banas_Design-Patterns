public class Song extends SongComponent {
//	***Song classý SongComponent'ý extend ettiði için, (SongGroup classý içerisinde) 
//	poly yoluyla liste ekleme, listten çýkarma vs yapýlabiliyor. 
//	ayný zamanda bu classdaki displaysonginfo metodu poly ile çaðýrýlýyor.*** 
	
	String songName;
	String bandName;
	int releaseYear;
	
	public Song(String newSongName, String newBandName, int newReleaseYear){
		
		songName = newSongName;
		bandName = newBandName;
		releaseYear = newReleaseYear;
		
	}
	
	public String getSongName() { return songName; }
	public String getBandName() { return bandName; }
	public int getReleaseYear() { return releaseYear; }
	
	public void displaySongInfo(){
		
		System.out.println(getSongName() + " was recorded by " +
				getBandName() + " in " + getReleaseYear());
		
	}
	
}