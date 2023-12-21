package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.*;

public class Track implements Playable{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}


	public int getLength() {
		return length;
	}

	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("track length: " + this.getLength());
		}
		else throw new PlayerException("ERROR: DVD length is non-positive");
	}
	
	public boolean equals(Track a) {
		if(this.title.compareTo(a.title) == 0 && this.length == a.length) return true;
		return false;
	}
}
