package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	private String director;
	
	public String getDirector() {
		return director;
	}
	
	public DigitalVideoDisc(String title) {
		this.setTitle(title);
		this.setType("DVD");
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.setType("DVD");
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.setType("DVD");
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.director = director;
		this.setType("DVD");
	}
	
	public DigitalVideoDisc(int id, String title, String category, int length, float cost, String director) {
		super(id, title, category, length, cost);
		this.director = director;
		super.setType("DVD");
	}

	public String toString() {
		return "DVD: " + this.getTitle() + " - Category: " + this.getCategory() + " - Director: "
				+ this.getDirector() + " - Length: " + this.getLength() + " - Cost: " + this.getCost();
	}	
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
