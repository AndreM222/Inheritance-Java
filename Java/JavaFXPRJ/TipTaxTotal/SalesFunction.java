package Java.Semester2.Chapter11.TipTaxTotal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class SalesFunction {

    // -------------------- Init --------------------
    
    SalesFunction(String object, int amount, float price) {

        this.object = object;
        this.amount = amount;
        this.price = price;

    }

    // -------------------- Properties --------------------
        
    private String object;
    private float price;
    private int amount;
    private float total;

    // -------------------- Getters ----------------------

    public float getTotal() { return total; }

    // -------------------- Functions --------------------
    
    public VBox setupNewObject() { 
        
        total = price * amount;

        // -------------------- Properties ----------------------

        Label objAmountXT = new Label(" " + object + " (" + amount + "x)");
        Rectangle objRectangle = new Rectangle(160, 25);
        Group objWindow = new Group(objRectangle, objAmountXT);
        Label totalTXT = new Label(" Originial: " + price + "$ |" + " Total: " + total + "$");
        HBox hbox = new HBox(objWindow, totalTXT);
        VBox vbox = new VBox(hbox);

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
        hbox.setMinWidth(345);
        hbox.setMaxWidth(345);
        
        vbox.setPadding(new Insets(5,0,0,0));
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(355.2);
        vbox.setMaxWidth(355.2);

        return vbox;

    }

}