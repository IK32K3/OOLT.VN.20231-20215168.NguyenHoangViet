package hust.soict.hedspi.aims.screen.customer.controller;

import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.*;
import javafx.beans.value.*;
import javafx.fxml.Initializable;

public class CartController  implements Initializable{
	private Cart cart;
	public CartController(Cart cart) {
		this.cart = cart;
	}
	
	 @FXML
	    private Button placeOrder;
	
    @FXML
    private Button btnPlay;
    
    @FXML
    private Button btnRemove;
    
    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {
    	 Media media = tblMedia.getSelectionModel().getSelectedItem();
    	 Alert alert;
		 Disc disc = (Disc) media;
		 if(disc.getLength() == 0) {
			alert = new Alert(AlertType.ERROR);
			alert.setContentText("Cannot play this disc");
			alert.show();
		 } else {
			String info = "Title: " + disc.getTitle()
				+ "\nCategory: " + disc.getCategory()
				+ "\nLength: " + disc.getLength()
				+ "\nCost: " + disc.getCost() ;
			alert = new Alert(AlertType.INFORMATION);
			alert.setContentText(info);
			alert.show();
		 }
    }

    @FXML
    void btnRemovedPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	
    }
    
    @FXML
    void emptyCart() {
    	cart.clear();
    	tblMedia.setItems(cart.getList());
    	costLabel.setText("0 $");
    }
    
    void placeOrderPressed(ActionEvent event) {
    	emptyCart();
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Place order");
		alert.setContentText("Order created");
	    alert.show();
    }
    
    void updateButtonBar(Media media) {
    	if(media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	}
    	else {
    		btnRemove.setVisible(true);
    		if(media instanceof Playable) {
    			btnPlay.setVisible(true);
    		}
    		else btnPlay.setVisible(false);
    	}
    }
    
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	if(cart.getList() != null) tblMedia.setItems(cart.getList());
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
    	});
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
