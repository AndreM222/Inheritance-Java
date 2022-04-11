package Java.Semester2.Chapter11.TipTaxTotal;

import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.input.MouseEvent;

public class SalesFunction {
    
    // -------------------- New Words ----------------------

    SalesFunction(String object, int amount, float price) {

        this.object = object;
        this.amount = amount;
        this.price = price;

    }
    
    private String object;
    private float price;
    private int amount = 2;
    private float total;

    // -------------------- Getters ----------------------

    public float getTotal() { return total; }
    
    public VBox setupNewWord() { 
        
        total = price * amount;

        // -------------------- Create ----------------------

        Label objAmountXT = new Label(" " + object + " (" + amount + "x)");
        Rectangle objRectangle = new Rectangle(160, 25);
        Group objWindow = new Group(objRectangle, objAmountXT);
        Label totalTXT = new Label(" Originial: " + price + "$ |" + " Total: " + total + "$");
        Button removeBT = new Button("- REMOVE -");
        HBox hbox = new HBox(objWindow, totalTXT);
        Group group = new Group(hbox, removeBT);
        VBox vbox = new VBox(group);

        // -------------------- Setup ----------------------
        
        objAmountXT.setFont(new Font("Comic Sans MS", 15));
        objAmountXT.setTextFill(Color.WHITE);
        objRectangle.setEffect(new DropShadow(5, Color.BLACK));
        objRectangle.setFill(Color.web("#953ac8"));
        objRectangle.setArcHeight(20);
        objRectangle.setArcWidth(20);
        
        totalTXT.setFont(new Font("Comic Sans MS", 10));
        totalTXT.setTextFill(Color.WHITE);
        
        hbox.setStyle("-fx-background-color: #7f80a0;");
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setEffect(new DropShadow(5, Color.BLACK));
        removeBT.setStyle("-fx-background-color: #ff87b6;");
        removeBT.setOpacity(0);

        removeBT.setMaxSize(345, 35);
        removeBT.setMinSize(345, 35);
        
        hbox.setMinWidth(345);
        hbox.setMaxWidth(345);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(355.2);
        vbox.setMaxWidth(355.2);

        hoveringBTFX(removeBT);

        return vbox;

    }

    public void hoveringBTFX(Button removeBT) {
        
        // -------------------- OnHover ----------------------

        removeBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                removeBT.setOpacity(0.8);

            }

        });

        // -------------------- UnHover ----------------------

        removeBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                removeBT.setOpacity(0);

            }

        });

        // -------------------- OnPressed ----------------------

        removeBT.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                removeBT.setOpacity(0.5);
                
            }

        });

        // -------------------- OnReleased ----------------------

        removeBT.setOnMouseReleased(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                removeBT.setOpacity(0.8);
                
            }

        });

    }
    
}