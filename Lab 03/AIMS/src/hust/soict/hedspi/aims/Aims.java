package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import java.util.*;

public class Aims {
	Cart all = new Cart();
	Cart cart = new Cart();

	public void SeeDetail() {
		Scanner input = new Scanner(System.in);
		int key; boolean cont = true;
		System.out.print("Enter title: ");
		String str = input.next();
		for(Media m : all.getList()) if (m.isMatch(str) == 0) {
			if(m.getType() == "Book") {
				do {
					 Store.mediaDetailsMenu2();
					 key = input.nextInt();
					 switch(key) {
					 case 1:
						 boolean check = cart.addMedia(m);
						 if(check) System.out.println("Added to the cart.");
						 else System.out.println("Already in the cart.");
						 cont = false;
						 break;
					 case 0: 
						 cont = false;
						 break;
					 default:
						 System.out.println("Unavailable choice. Choose again.\n");
						 break;
					 }
				} while(cont);
			}
			else do {
				 Store.mediaDetailsMenu1();
				 key = input.nextInt();
				 switch(key) {
				 case 1:
					 boolean check = cart.addMedia(m);
					 if(check) System.out.println("Added to the cart.");
					 else System.out.println("Already in the cart.");
					 break;
				 
				 case 2:
					 if (m.getType() == "DVD") {
						 DigitalVideoDisc d = (DigitalVideoDisc) m;
						 d.play();
					 }
					 else {
						 CompactDisc c = (CompactDisc ) m;
						 c.play();
					 }
				 case 0: continue;
				 default:
					 System.out.println("Unavailable choice. Choose again.\n");
					 continue;
				 }
			} while(cont);
		}
		input.close();
	}
	
	
	public void ViewStore() {
		Scanner input = new Scanner(System.in);
		int key; boolean cont = true; String str;
		all.show();
		do {
			Store.storeMenu();
			key = input.nextInt();
			switch(key) {
			case 1:
				SeeDetail();
				break;
			case 2:
				System.out.print("Enter title: ");
				str = input.next();
				for(Media m : all.getList()) if (m.isMatch(str) == 0) {
					boolean check = cart.addMedia(m);
					if(check) {
						System.out.println("Added to the cart.");
						break;
					} 
					else {
						System.out.println("Already in the cart.");
						break;
					}
				}
				System.out.println("Unavailable title.");
				break;
			case 3:
				System.out.print("Enter title: ");
				str = input.next();
				for(Media m : all.getList()) if (m.isMatch(str) == 0) {
					if(m.getType() == "Book") {
						System.out.println("Cannot play.");
						break;
					}
					else if (m.getType() == "CD") {
						 CompactDisc c = (CompactDisc) m;
						 c.play();
						 break;
					}
					else {
						DigitalVideoDisc d = (DigitalVideoDisc) m;
						d.play();
						break;
					}
				}
				System.out.println("Not available.");
				break;
			case 4:
				System.out.println("Current cart:");
				for(Media m: cart.getList()) System.out.println(m);
				break;
			case 0: 
				cont = false;
				break;
			default:
				System.out.println("Unavailable choice. Choose again.\n");
				break;
		} 
	} while(cont);
		input.close();
	
}
	
	public void updateStore() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("1:Add\t2:Remove\t: ");
			int i = input.nextInt();
			if(i == 1) {
				int id;
				String title, category;
				float cost;
				System.out.println("ID: ");
				id = input.nextInt();
				System.out.println("Title: ");
				title = input.next();
				System.out.println("Category: ");
				category = input.next();
				System.out.println("Cost: ");
				cost = input.nextFloat();
				System.out.println("Media type (Book, CD, DVD): ");
				String type = input.next();
				if(type == "Book") {
					List<String> authors = new ArrayList<String>();
					String author;
					System.out.println("Author list (Press 0 when you're done.):");
					do {
						author = input.next();
						if(author == "0") continue;
						authors.add(author);
					} while (author != "0");
					Book b = new Book(id, title, category, cost, authors);
					all.addMedia(b);
					System.out.println("Added to the store.");
				}
				else if (type == "CD") {
					String artist; 
					String s_title; int length; char check;
					List<Track> tracks = new ArrayList<Track>();
					System.out.println("Artist: ");
					artist = input.next();
					System.out.println("Song list: ");
					do {
						System.out.println("Song title: ");
						s_title = input.next();
						System.out.println("Length: ");
						length = input.nextInt();
						Track t = new Track(s_title, length);
						tracks.add(t);
						System.out.println("Done(Y/N): ");
						check = input.next().charAt(0);
					} while(check != 'Y');
					CompactDisc c = new CompactDisc(id, title, category, length, cost, artist, tracks);
					all.addMedia(c);
					System.out.println("Added to the store.");
				}
				else if (type == "DVD") {
					String director; int length;
					System.out.println("Diractor: ");
					director = input.next();
					System.out.println("Length: ");
					length = input.nextInt();
					DigitalVideoDisc d = new DigitalVideoDisc(id, title, category, length, cost, director);
					all.addMedia(d);
					System.out.println("Added to the store.");
				}
			}
			
			else if(i == 2) {
				System.out.println("Enter id: ");
				int id = input.nextInt();
				for(Media m: all.getList()) if(m.getId() == id) {
					all.removeMedia(m);
					System.out.println("Removed from the store.");
					return;
				}
				System.out.println("Not in the store.");
			}
			else System.out.println("Unavailable choice.");
			input.close();
		}
	}
	
	public void SeeCart() {
		Scanner input = new Scanner(System.in);
		int key; boolean cont = true;
		do {
			cart.show();
			Store.cartMenu();
			key = input.nextInt();
			switch(key) {
			case 1:
				break;
			case 2:
				System.out.print("Sort by 1:Title    2: Cost    : ");
				int i = input.nextInt();
				if(i == 1) cart.TitleCost();		
				else if(i == 2) cart.CostTitle();
				break;
			case 3:
				System.out.print("Title: ");
				String title = input.next();
				for(Media m: cart.getList()) if (m.isMatch(title) == 0) {
					cart.removeMedia(m);
					System.out.println("Removed from the cart.");
					break;
				}
				System.out.println("Not in the cart.");
				break;
			case 4:
				System.out.print("Enter title: ");
				String str = input.next();
				for(Media m : all.getList()) if (m.isMatch(str) == 0) {
					if(m.getType() == "Book") {
						System.out.println("Cannot play.");
						break;
					}
					else if (m.getType() == "CD") {
						 CompactDisc c = (CompactDisc) m;
						 c.play();
						 break;
					}
					else {
						DigitalVideoDisc d = (DigitalVideoDisc) m;
						d.play();
						break;
					}
				}
				System.out.println("Not available.");
				break;
			case 5:
				for(Media m:cart.getList()) cart.removeMedia(m);
				System.out.println("An order is created.");
				break;
			case 0:
				cont = false;
				break;
			default:
				 System.out.println("Unavailable choice. Choose again.\n");
				 break;
			}
		} while(cont);
		input.close();
	}
	
	
	public static void main(String[] args) {
		Aims aims = new Aims();
		int key; boolean cont = true;
		Scanner input = new Scanner(System.in);
		do {
			Store.showMenu();
			key = input.nextInt();
			switch(key) {
			case 1:
				aims.ViewStore();
				break;
			case 2:
				aims.updateStore();
				break;
			case 3:
				aims.SeeCart();
				break;
			case 0:
				System.out.println("You've exited AIMS.");
				cont = false;
				return;
			default:
				System.out.println("Unavailable choice. Please choose again.");
				break;
			}
		} while (cont);
		input.close();
	}

}
