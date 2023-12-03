package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	public MediaComparatorByTitleCost() {
		// TODO Auto-generated constructor stub
	}
	public int compare(Media a, Media b) {
		int costCompare = Float.compare(a.getCost(), b.getCost());
		int titleCompare = a.getTitle().compareTo(b.getTitle());
		return (titleCompare == 0) ? costCompare : titleCompare;
	}
}
