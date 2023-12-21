package hust.soict.hedspi.test;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.cart.*;

public class CartTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cart cart = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addMedia(dvd3);

		cart.print();

		Media disc = cart.search(1);
		disc.toString();

		disc = cart.search("Aladin");
		disc.toString();

		disc = cart.search("Video");

	}

}
