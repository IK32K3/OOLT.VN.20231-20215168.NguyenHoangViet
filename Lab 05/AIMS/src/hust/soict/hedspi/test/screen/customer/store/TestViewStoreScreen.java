package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.screen.customer.controller.*;
import hust.soict.hedspi.aims.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;


public class TestViewStoreScreen extends Application{
	private static Store store;
	private Cart cart;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	
	public static void main(String[] agrs) {
		new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry Potter and the Philosopher's stone", 3f);
		Store.all.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Potter and the Chamber of Secrets", 3.5f);
		Store.all.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban", 5f);
		Store.all.addMedia(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter and the Goblet of Fire", 4.5f);
		Store.all.addMedia(dvd4);
		Track track1 = new Track("Hello", 180);
		Track track2 = new Track("Hi", 240);
		Track track3 = new Track("Fetch the Bolt Cutters", 210);
		CompactDisc cd1 = new CompactDisc("Fetch the Bolt Cutters", 10.39f);
		cd1.addTrack(track3);
		Store.all.addMedia(cd1);
		CompactDisc cd2 = new CompactDisc("Future Nostalgia", 9.6f);
		cd2.addTrack(track1);
		cd2.addTrack(track2);
		Store.all.addMedia(cd2);
		Book b1 = new Book("The Hunger Games", 5.5f);
		Store.all.addMedia(b1);
		Book b2 = new Book("Catching Fire", 4.9f);
		Store.all.addMedia(b2);
		Book b3 = new Book("Mocking Jay", 5.1f);
		Store.all.addMedia(b3);
		launch(agrs);
		
	}
}
