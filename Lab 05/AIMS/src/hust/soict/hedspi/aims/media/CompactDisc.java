package hust.soict.hedspi.aims.media;
import java.util.*;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}
	public CompactDisc(int id, String title, String category, float cost, String artist,
			ArrayList<Track> tracks) {
		super(id, title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
		super.setType("CD");
	}
	
	public CompactDisc(String title, float cost) {
		this.setTitle(title);
		this.setCost(cost);
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
	
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			for(Track a: tracks) a.play();
			Iterator<Track> iter = tracks.iterator();
			Track nextTrack;
			while(iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				} catch(PlayerException e) {
					throw e;
				}
			}
		}
		else throw new PlayerException("ERROR: DVD length is non-positive");
	}
}
