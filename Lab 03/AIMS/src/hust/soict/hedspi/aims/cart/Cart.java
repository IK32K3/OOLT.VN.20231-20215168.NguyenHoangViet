package hust.soict.hedspi.aims.cart;
import java.util.*;

import hust.soict.hedspi.aims.media.Media;
public class Cart {
	private ArrayList<Media> list = new ArrayList<Media>();
	
	public Cart() {
		super();
	}
	
	public ArrayList<Media> getList() {
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
		list = new ArrayList<Media>();
	}
	
}





