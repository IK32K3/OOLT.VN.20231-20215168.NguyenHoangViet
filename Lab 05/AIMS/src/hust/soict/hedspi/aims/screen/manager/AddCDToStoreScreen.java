package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.Store;
import hust.soict.hedspi.aims.media.*;

public class AddCDToStoreScreen extends AddItemToStoreScreen  {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void add() {
		String title = super.getTfTitle().getText();
		float cost = Float.parseFloat(super.getTfCost().getText());
		CompactDisc cd = new CompactDisc(title, cost);
		Store.all.addMedia(cd);
	}
	
	public AddCDToStoreScreen() {
		super();
		setTitle("Add CD");
		// TODO Auto-generated constructor stub
	}
	
}
