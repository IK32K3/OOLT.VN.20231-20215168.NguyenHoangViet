package hust.soict.hedspi.aims.media;

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

	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("track length: " + this.getLength());
	}
	
	public boolean equals(Track a) {
		if(this.title.compareTo(a.title) == 0 && this.length == a.length) return true;
		return false;
	}
}
