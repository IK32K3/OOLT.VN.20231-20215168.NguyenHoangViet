package hust.soict.hedspi.aims.media;
import java.util.*;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public CompactDisc() {
		// TODO Auto-generated constructor stub
		super.setType("CD");
	}
	public String getArtist() {
		return artist;
	}
	public CompactDisc(int id, String title, String category, int length, float cost, String artist,
			List<Track> tracks) {
		super(id, title, category, length, cost);
		this.artist = artist;
		this.tracks = tracks;
		super.setType("CD");
	}
	
	public boolean addTrack(Track a) {
		if(!tracks.contains(a)) {
			tracks.add(a);
			return true;
		} 
		return false;
		
	}
	
	public boolean removeTrack(Track a) {
		if(tracks.contains(a)) {
			tracks.remove(a);
			return true;
		}
		return false;
	}
	
	public int getLength() {
		int sum = 0;
		for(Track a: tracks) sum += a.getLength();
		return sum;
	}
	
	public String toString() {
		String str = "CD: " + this.getTitle() + " - Category: " + this.getCategory() + " - Artist: " + this.getArtist()
						+ "\nTrack(s):\n";
		for(Track a: tracks) str = str + a.getTitle() + " - " + a.getLength() + "\n";
		str = str + "Cost: " + this.getCost();
		return str;
		
	}
	
	public void play() {
		for(Track a: tracks) a.play();
	}
}
