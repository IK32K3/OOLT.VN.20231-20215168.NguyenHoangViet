package hust.soict.hedspi.aims.cart;
import javafx.collections.*;
import hust.soict.hedspi.aims.media.Media;
public class Cart {
	
	private ObservableList<Media> list = FXCollections.observableArrayList(); 
	
	public Cart() {
		super();
	}
	
	public ObservableList<Media> getList() {
		return list;
	}

	public boolean addMedia(Media m) {
		if(!list.contains(m)) {
			list.add(m);
			return true;
		}
		return false;
	}
	
	public boolean removeMedia(Media m) {
		if(list.contains(m)) {
			list.remove(m);
			return true;
		}
		return false;
	}
	
	public Media search(int id) {
		return list.get(id);
	}
	
	public Media search(String title) {
		for(Media m: list) if(m.getTitle().equals(title)) return m;
		return null;
	}
	
	public void show() {
		for(Media m: list) System.out.println(m.getTitle() + " - " + m.getType());
	}
	
	public void print() {

		System.out.println("=============CART=============");
		if (list.size() == 0) {
			System.out.println("Cart is empty!");
		}
			
		for (Media m : list) System.out.println(m);
	
		System.out.printf("Total cost: %f\n", totalCost());
		System.out.println("==============================");
	}
	
	public float totalCost() {
		float sum = 0;
		for(Media m: list) sum += m.getCost();
		return sum;
	}
	
	public void clear() {
		list = FXCollections.observableArrayList();
	}
	
}





