import java.util.*;


public class Cart {
	public static final int Max_Number_Ordered = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[Max_Number_Ordered];
	public Cart() {
		super();
	}
	List<DigitalVideoDisc> list = new ArrayList<>(Arrays.asList(itemsOrdered));
	
	public int size() {
		return itemsOrdered.length; 
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (itemsOrdered.length < Max_Number_Ordered){ 
			list.add(disc);
			itemsOrdered = list.toArray(itemsOrdered);
			System.out.println("The disc has been added.");
		}
		else System.out.println("The cart is full.");
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		 list.remove(disc);
		 itemsOrdered = list.toArray(itemsOrdered);
		 System.out.println("The disc has been removed.");
	}
	
	public float totalCost() {
		float sum = 0;
		for(int i=0;i< itemsOrdered.length;i++) sum += itemsOrdered[i].getCost();
		return sum;
	}
}
