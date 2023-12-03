package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private int length;
	
	public int getLength() {
		return length;
	}

	public Disc() {
		// TODO Auto-generated constructor stub
	}


	public Disc(int id, String title, String category, int length, float cost) {
		super(id, title, category, cost);
		this.length = length;
		
	}

}
