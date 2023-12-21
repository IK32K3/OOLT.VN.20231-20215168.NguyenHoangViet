package hust.soict.hedspi.aims.screen.customer.controller;
import java.io.IOException;

import hust.soict.hedspi.aims.Store;
import hust.soict.hedspi.aims.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.*;

public class ViewStoreController {
	@FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader();
    		fxmlLoader.setLocation(getClass().getResource(CART_FXML_FILE_PATH));
    		fxmlLoader.setController(new CartController(cart));
    		Parent root = fxmlLoader.load();
    		Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Cart");
    		stage.show();
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    private Store store;
    public ViewStoreController(Store store, Cart cart) {
    	this.store = store;
    	this.cart = cart;
    }
    
    private Cart cart;
    
    @FXML
    public void initialize() {
    	final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";
    	int column = 0;
    	int row = 1;
    	for(int i=0;i<store.getStoreList().size();i++) {
    		try {
    			FXMLLoader fxmlLoader = new FXMLLoader();
    			fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
    			ItemController itemController = new ItemController(store, cart);
    			fxmlLoader.setController(itemController);
    			AnchorPane anchorPane = new AnchorPane();
    			anchorPane = fxmlLoader.load();
    			itemController.setData(store.getStoreList().get(i));
    			
    			if(column == 3) {
    				column = 0;
    				row++;
    			}
    			
    			gridPane.add(anchorPane, column++, row);
    			GridPane.setMargin(anchorPane, new Insets(20,10,10,10));
    		}
    		catch(IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
}

