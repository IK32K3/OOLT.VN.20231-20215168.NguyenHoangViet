package hust.soict.hedspi.aims;

import java.util.*;

public class Aims {
	
	public static void main(String[] args) {
		Store store = new Store();
		int key; boolean cont = true;
		Scanner input = new Scanner(System.in);
		do {
			Store.showMenu();
			key = input.nextInt();
			switch(key) {
			case 1:
				store.ViewStore();
				break;
			case 2:
				store.updateStore();
				break;
			case 3:
				store.SeeCart();
				break;
			case 0:
				System.out.println("You've exited AIMS.");
				cont = false;
				break;
			default:
				System.out.println("Unavailable choice. Please choose again.");
				System.out.println("\n\n");
				break;
			}
		} while (cont);
		input.close();
	}

}
