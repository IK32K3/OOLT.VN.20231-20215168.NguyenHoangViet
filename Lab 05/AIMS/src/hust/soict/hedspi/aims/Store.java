package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import javafx.collections.ObservableList;

public class Store {
	Scanner input = new Scanner(System.in);
	public static Cart all = new Cart();
	public static Cart cart = new Cart();
	public static final int MAX = 20;
	
	public ObservableList<Media> getStoreList() {
		return all.getList();
	}
	
	public Store() {
		// TODO Auto-generated constructor stub
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}
	
	public static void mediaDetailsMenu1() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	
	public static void mediaDetailsMenu2() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1");
		}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		}
	
	public void addtoCart(String str) throws LimitExceededException {
		if(cart.getList().size() == MAX) {
			throw new LimitExceededException("ERROR: The number of " + "media has reached its limit");
		}
		else {
			for(Media m : all.getList()) if (m.isMatch(str) == 0) {
				boolean check = cart.addMedia(m);
				if(check) {
					System.out.println("Added to the cart.");
					System.out.println("\n\n");
					return;
				} 
				else {
					System.out.println("Already in the cart.");
					System.out.println("\n\n");
					return;
				}
			}
			System.out.println("Unavailable title.");
		}
	}
	
	public void addtoCart(Media m) throws LimitExceededException {
		if(cart.getList().size() == MAX) {
			throw new LimitExceededException("ERROR: The number of " + "media has reached its limit");
		}
		else {
			 boolean check = cart.addMedia(m);
			 if(check) System.out.println("Added to the cart.");
			 else System.out.println("Already in the cart.");
		}
	}
	
	public void ViewStore() throws LimitExceededException, PlayerException {
		int key; boolean cont = true; String str;
		all.show();
		do {
			Store.storeMenu();
			key = input.nextInt();
			switch(key) {
			case 1:
				SeeDetail();
				System.out.println("\n\n");
				break;
			case 2:
				System.out.print("Enter title: ");
				str = input.next();
				this.addtoCart(str);
				break;
			case 3:
				System.out.print("Enter title: ");
				str = input.next();
				for(Media m : all.getList()) if (m.isMatch(str) == 0) {
					if(m.getType() == "Book") {
						System.out.println("Cannot play.");
						System.out.println("\n\n");
						break;
					}
					else if (m.getType() == "CD") {
						 CompactDisc c = (CompactDisc) m;
						 c.play();
						 System.out.println("\n\n");
						 break;
					}
					else {
						DigitalVideoDisc d = (DigitalVideoDisc) m;
						d.play();
						System.out.println("\n\n");
						break;
					}
				}
				System.out.println("Not available.");
				break;
			case 4:
				System.out.println("Current cart:");
				for(Media m: cart.getList()) System.out.println(m);
				System.out.println("\n\n");
				break;
			case 0: 
				System.out.println("\n\n");
				return;
			default:
				System.out.println("Unavailable choice. Choose again.\n");
				System.out.println("\n\n");
				break;
		} 
	} while(cont);
	}
	
	public void SeeDetail() throws LimitExceededException, PlayerException {
		int key; boolean cont = true;
		System.out.print("Enter title: ");
		String str = input.next();
		for(Media m : all.getList()) if (m.isMatch(str) == 0) {
			System.out.println(m);
			if(m.getType().equals("Book")) {
				do {
					 Store.mediaDetailsMenu2();
					 key = input.nextInt();
					 switch(key) {
					 case 1:
						 this.addtoCart(m);
						 cont = false;
						 break;
					 case 0: 
						 return;
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
					 this.addtoCart(m);
					 cont = false;
					 break;
				 case 2:
					 if (m.getType().equals("DVD")) {
						 DigitalVideoDisc d = (DigitalVideoDisc) m;
						 d.play();
						 break;
					 }
					 else {
						 CompactDisc c = (CompactDisc) m;
						 c.play();
						 break;
					 }
				 case 0: 
					 return;
				 default:
					 System.out.println("Unavailable choice. Choose again.\n");
					 break;
				 }
			} while(cont);
		}
	}
	
	public void updateStore() {
			System.out.println("1:Add\t2:Remove\t: ");
			int i = input.nextInt();
			if(i == 1) {
				int id;
				
				float cost;
				System.out.println("ID: ");
				id = input.nextInt();
				System.out.println("Title: ");
				String title = input.next();
				System.out.println("Category: ");
				String category = input.next();
				System.out.println("Cost: ");
				cost = input.nextFloat();
				try {
					if (cost < 0) throw new IllegalArgumentException();
				} catch (NumberFormatException e) {
					System.out.println("invalid cost");
					return;
				} catch (IllegalArgumentException e) {
					System.out.println("cost must be greater than 0");
					return;
				}
				System.out.println("Media type (1:Book, 2:CD, 3:DVD): ");
				int type = input.nextInt();
		
				if(type == 1) {
					ArrayList<String> authors = new ArrayList<String>();
					String author;
					System.out.println("Author list (Press 0 when you're done.):");
					do {
						author = input.next();
						if(author.equals("0")) continue;
						authors.add(author);
					} while (!author.equals("0"));
					Book b = new Book(id, title, category, cost, authors);
					all.addMedia(b);
					System.out.println("Added to the store.");
				}
				else if (type == 2) {
					String artist; 
					String s_title; int length; char check;
					ArrayList<Track> tracks = new ArrayList<Track>();
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
					CompactDisc c = new CompactDisc(id, title, category, cost, artist, tracks);
					all.addMedia(c);
					System.out.println("Added to the store.");
				}
				else {
					String director; int length;
					System.out.println("Director: ");
					director = input.next();
					System.out.println("Length: ");
					length = input.nextInt();
					try {
						if (length <= 0) throw new IllegalArgumentException();
					} catch(NumberFormatException e) {
						System.out.println("Invalid length");
						return;
					} catch (IllegalArgumentException e) {
						System.out.println("Length must be greater than 0");
						return;
					}
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
			System.out.println("\n\n");
	}
	
	public void SeeCart() throws PlayerException {
		int key; boolean cont1 = true;
		do {
			cart.show();
			Store.cartMenu();
			key = input.nextInt();
			switch(key) {
			case 1:
				System.out.print("Filter by 1:Title    2: Cost    : ");
				int i = input.nextInt();
				if(i == 1) {
					System.out.print("ID: ");
					int id = input.nextInt();
					Media m = cart.search(id);
					if(m == null) {
						System.out.println("Unavailable");
					}
					else System.out.println(m);
				}
				else {
					System.out.print("Title: ");
					String title = input.next();
					Media m = cart.search(title);
					if(m == null) {
						System.out.println("Unavailable");
					}
					else System.out.println(m);
				}
				System.out.println("\n\n");
				break;
			case 2:
				System.out.print("Sort by 1:Title    2: Cost    : ");
				i = input.nextInt();
				if(i == 1) {
					Collections.sort(cart.getList(), Media.COMPARE_BY_TITLE_COST);
					cart.print();
				}		
				else if(i == 2) {
					Collections.sort(cart.getList(), Media.COMPARE_BY_COST_TITLE);
					cart.print();
				} 
				System.out.println("\n\n");
				break;
			case 3:
				System.out.print("Title: ");
				String title = input.next();
				Media m = cart.search(title);
				if (m == null) System.out.println("Not in the cart.");
				else cart.removeMedia(m);
				System.out.println("Removed from the cart.");
				System.out.println("\n\n");
				break;
			case 4:
				System.out.print("Enter title: ");
				title = input.next();
				m = cart.search(title);
				if(m == null) System.out.println("Not available.");
							
					if(m.getType() == "Book") {
						System.out.println("Cannot play.");
					}
					else if (m.getType() == "CD") {
						 CompactDisc c = (CompactDisc) m;
						 c.play();
					}
					else {
						DigitalVideoDisc d = (DigitalVideoDisc) m;
						d.play();
					}
	
				System.out.println("\n\n");
				break;
			case 5:
				cart.clear();
				System.out.println("An order is created.");
				System.out.println("\n\n");
				return;
				
			case 0:
				return;
			default:
				 System.out.println("Unavailable choice. Choose again.\n");
				 System.out.println("\n\n");
				 break;
			}
		} while(cont1);
		
	}
}
