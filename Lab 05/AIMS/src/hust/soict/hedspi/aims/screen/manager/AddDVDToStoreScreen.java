package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.Store;
import hust.soict.hedspi.aims.media.*;

public class AddDVDToStoreScreen extends AddItemToStoreScreen  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void add() {
		String title = super.getTfTitle().getText();
		float cost = Float.parseFloat(super.getTfCost().getText());
		DigitalVideoDisc dvd = new DigitalVideoDisc(title, cost);
		Store.all.addMedia(dvd);
	}
	
	public AddDVDToStoreScreen() {
		super();
		setTitle("Add DVD");
		// TODO Auto-generated constructor stub
	}
	
}
