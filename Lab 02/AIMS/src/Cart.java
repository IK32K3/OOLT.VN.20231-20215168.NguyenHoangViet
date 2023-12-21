
public class Cart {
	public static final int Max_Number_Ordered = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[Max_Number_Ordered]; 
	private int cur = 0;
	
	public Cart() {
		super();
	}
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (cur < Max_Number_Ordered){ 
			itemsOrdered[cur] = disc;
			cur++;
			System.out.println("The disc has been added.");
		}
		else System.out.println("The cart is full.");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
		if(cur < Max_Number_Ordered - dvdList.length) {
			for(int i=0;i<dvdList.length;i++) {
				itemsOrdered[cur] = dvdList[i];
				cur++;
			} 
			System.out.println("The disc(s) has been added.");
		}
		else System.out.println("The cart is full.");
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i=0;i<cur;i++) {
			if(itemsOrdered[i].equals(disc)) {
				for(int j=i;j<cur-1;j++) itemsOrdered[j] = itemsOrdered[j+1];
				cur--;
				System.out.println("The disc has been removed.");
				return;
			}
		}
		System.out.println("The disc is not in the cart");
	}
	
	public float totalCost() {
		float sum = 0;
		for(int i=0;i<cur;i++) sum += itemsOrdered[i].getCost();
		return sum;
	}
	
	public void c_show() {
		for(int i=0;i<cur;i++) {
			System.out.print(i+1 + "\t");
			itemsOrdered[i].show();
		}
		System.out.println("\tTotal Cost: \t\t" + totalCost());
	}
}
