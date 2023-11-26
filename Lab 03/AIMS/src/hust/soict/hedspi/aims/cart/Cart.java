package hust.soict.hedspi.aims.cart;
import java.util.*;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.MediaComparatorByCostTitle;
import hust.soict.hedspi.aims.media.MediaComparatorByTitleCost;

public class Cart {
	private List<Media> list = new ArrayList<Media>();
	
	public Cart() {
		super();
	}
	
	public List<Media> getList() {
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
	
	public void show() {
		List<Media> temp = list;
		System.out.println("Book:");
		for(Media m: temp) if(m.getType() == "Book") {
			 System.out.println(m.getTitle());
			 temp.remove(m);
		}
		System.out.println("CD");
		for(Media m: temp) if(m.getType() == "CD") {
			System.out.println(m.getTitle());
			temp.remove(m);
		}
		System.out.println("DVD");
		for(Media m: temp) System.out.println(m.getTitle());
	}
	
	public float totalCost() {
		float sum = 0;
		for(Media m: list) sum += m.getCost();
		return sum;
	}
	
	public void TitleCost() {
		Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
		Collections.sort(list, COMPARE_BY_TITLE_COST);
	}
	
	public void CostTitle() {
		Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
		Collections.sort(list, COMPARE_BY_COST_TITLE);
	}
}





