package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void add() {
		String title = super.getTfTitle().getText();
		float cost = Float.parseFloat(super.getTfCost().getText());
		Book b = new Book(title, cost);
		Store.all.addMedia(b);
	}
	
	public AddBookToStoreScreen() {
		super();
		setTitle("Add Book");
		// TODO Auto-generated constructor stub
		
		
	}
	
}
