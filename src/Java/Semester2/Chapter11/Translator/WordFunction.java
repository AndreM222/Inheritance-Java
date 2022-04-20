package Java.Semester2.Chapter11.Translator;

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

public class WordFunction {

    // -------------------- Init ----------------------

    WordFunction(String latinWord, String englishWord, String description) {

        this.latinWord = latinWord;
        this.englishWord = englishWord;
        this.description = description;

    }
    
    // -------------------- Properties --------------------

    private String latinWord;
    private String englishWord;
    private String description;

    // -------------------- Getters --------------------

    public String getLatinWord() { return latinWord; }

    // -------------------- Functions --------------------

    public VBox setupNewWord() { 

        // -------------------- Properties ----------------------

        Label latTXT = new Label(" Latin: " + latinWord);
        Rectangle latRectangle = new Rectangle(160, 25);
        Group latWindow = new Group(latRectangle, latTXT);
        
        Label engTXT = new Label(" English: " + englishWord);
        Rectangle engRectangle = new Rectangle(160, 25);
        Group engWindow = new Group(engRectangle, engTXT);

        Label descriptionTXT = new Label("Description: \n" + description);
        
        HBox hbox = new HBox(latWindow, engWindow);
        VBox descriptionBox = new VBox(hbox, descriptionTXT);
        VBox vbox = new VBox(descriptionBox);
        
        // -------------------- Setup ----------------------
        
        latTXT.setFont(new Font("Comic Sans MS", 15));
        latTXT.setTextFill(Color.WHITE);
        latRectangle.setEffect(new DropShadow(5, Color.BLACK));
        latRectangle.setFill(Color.web("#953ac8"));
        latRectangle.setArcHeight(20);
        latRectangle.setArcWidth(20);
        
        engTXT.setFont(new Font("Comic Sans MS", 15));
        engTXT.setTextFill(Color.WHITE);
        engRectangle.setEffect(new DropShadow(5, Color.BLACK));
        engRectangle.setFill(Color.web("#953ac8"));
        engRectangle.setArcHeight(20);
        engRectangle.setArcWidth(20);
        
        descriptionTXT.setFont(new Font("Comic Sans MS", 15));
        descriptionTXT.setTextFill(Color.WHITE);
        descriptionTXT.setWrapText(true);
        descriptionTXT.setPadding(new Insets(0, 5, 0, 5));
        
        descriptionBox.setEffect(new DropShadow(5, Color.BLACK));
        descriptionBox.setMaxWidth(334);
        descriptionBox.setStyle("-fx-background-color: #7f80a0;");
        
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(355.2);
        vbox.setMaxWidth(355.2);
        vbox.setPadding(new Insets(5, 0, 0, 0));

        return vbox;

    }
    
}
