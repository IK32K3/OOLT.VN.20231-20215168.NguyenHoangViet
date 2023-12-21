package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    

    @FXML
    private ToggleGroup identical;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    private Color c = Color.WHITE;
    
    @FXML
    void eraserbtnPressed(ActionEvent event) {
    	c = Color.WHITE;
    }

    @FXML
    void penbtnPressed(ActionEvent event) {
    	c = Color.BLACK;
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4);
    	newCircle.setFill(c);
    	if(event.getX() - 4 < 0 || event.getX() + 4 > 550 || event.getY() - 4 < 0 || event.getY() + 4 > 550) return;
    	drawingAreaPane.getChildren().add(newCircle);
    }  
        
}