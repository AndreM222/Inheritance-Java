package Java.Semester2.Chapter11.PropertyTax;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class PropertyFunction {
    
        
    PropertyFunction(String houseName, float price) {

        this.houseName = houseName;
        this.price = price;

    }
        
    private String houseName;
    private float price;
    private ImageView houseIcon = new ImageView("Java/Semester2/Chapter11/CH11Icons/CH11SelectButtonsIcon/home.png");

    // -------------------- Getters ----------------------

    public float getPrice() { return price; }
    
    // -------------------- Calculate ----------------------

    public VBox setupNewObject() { 
        
        Label houseNameTXT = new Label("( " + houseName + " )");
        HBox houseBox = new HBox(5, houseIcon, houseNameTXT);
        Rectangle rectangleBKGD = new Rectangle(170, 25);
        Group houseWindow = new Group(rectangleBKGD, houseBox);
        Label priceTXT = new Label(" Price: " + price + "$");
        HBox hbox = new HBox(houseWindow, priceTXT);
        VBox vbox = new VBox(hbox);

        // -------------------- Setup ----------------------
        
        houseNameTXT.setFont(new Font("Comic Sans MS", 15));
        houseNameTXT.setTextFill(Color.WHITE);
        rectangleBKGD.setEffect(new DropShadow(5, Color.BLACK));
        rectangleBKGD.setFill(Color.web("#953ac8"));
        rectangleBKGD.setArcHeight(20);
        rectangleBKGD.setArcWidth(20);
        
        houseBox.setPadding(new Insets(0, 0, 0, 2));
        priceTXT.setFont(new Font("Comic Sans MS", 15));
        priceTXT.setTextFill(Color.WHITE);
        
        hbox.setStyle("-fx-background-color: #7f80a0;");
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setEffect(new DropShadow(5, Color.BLACK));
        hbox.setMinWidth(345);
        hbox.setMaxWidth(345);
        
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(355.2);
        vbox.setMaxWidth(355.2);

        return vbox;

    }

}