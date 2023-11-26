package hust.soict.hedspi.aims.media;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private String type;
	private float cost;
	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media(int id, String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = id;
	}
	
	public boolean equals(Media m) {
		if(this.title.compareTo(m.title) == 0) return true;
		return false;
	}
	
	public int isMatch(String title) {
		return this.getTitle().compareTo(title);
	}
	
	
}
