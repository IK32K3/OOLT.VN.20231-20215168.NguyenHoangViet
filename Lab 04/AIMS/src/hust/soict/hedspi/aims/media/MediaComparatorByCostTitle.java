package hust.soict.hedspi.aims.media;
import java.util.*;

public class MediaComparatorByCostTitle implements Comparator<Media>{

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}
	public int compare(Media a, Media b) {
		int costCompare = Float.compare(a.getCost(), b.getCost());
		int titleCompare = a.getTitle().compareTo(b.getTitle());
		return (costCompare == 0) ? titleCompare : costCompare;
	}
}
