package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;



public class ItemController {
	 @FXML
	 private Button btnAddToCart;

	 @FXML
	 private Button btnPlay;

	 @FXML
	 private Label lblCost;

	 @FXML
	 private Label lblTitle;

	 @FXML
	 void btnAddToCartClicked(ActionEvent event) {

	 }

	 @FXML
	 void btnPlayClicked(ActionEvent event) {

	 }
	 private Store store;
	 private Cart cart;
	 public ItemController(Store store, Cart cart) {
		 super();
		 this.store = store;
		 this.cart = cart;
	 }
	 
	 
	 private Media media;
	 public void setData(Media media) {
		 this.media = media;
		 lblTitle.setText(media.getTitle());
		 lblCost.setText(media.getCost() + "$");
		 if(media instanceof Playable) btnPlay.setVisible(true);
		 else {
			 btnPlay.setVisible(false);
			 HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
		 }
	 }
}
