package Java.Semester2.Chapter11.NameFormatter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class NameFunction {

    NameFunction(String firstName, String middleName, String lastName, String title) {

        Format1 = title + firstName + " " + middleName + " " + lastName;
        Format2 = firstName + " " + middleName + " " + lastName;
        Format3 = firstName + " " + lastName;
        Format4 = lastName + ", " + firstName + " " + middleName + ", " + title; 
        Format5 = lastName + ", " + firstName + " " + middleName;
        Format6 = lastName + ", " + firstName;

        txtFormats[0] = Format1;
        txtFormats[1] = Format2;
        txtFormats[2] = Format3;
        txtFormats[3] = Format4;
        txtFormats[4] = Format5;
        txtFormats[5] = Format6;

    }

    private String Format1;
    private String Format2;
    private String Format3;
    private String Format4; 
    private String Format5;
    private String Format6;
   
    private String[] txtFormats = new String[6];

    public VBox setupNewName(int i) {

        Label nameTxt = new Label(txtFormats[i]);
        HBox hbox = new HBox(nameTxt);
        VBox vbox = new VBox(hbox);

        // -------------------- Setup --------------------

        nameTxt.setFont(new Font("Comic Sans MS", 22));
        nameTxt.setTextFill(Color.WHITE);
        
        hbox.setStyle("-fx-background-color: #7f80a0;");
        hbox.setAlignment(Pos.CENTER);
        hbox.setEffect(new DropShadow(5, Color.BLACK));
        hbox.setMinWidth(545);
        hbox.setMaxWidth(545);

        vbox.setPadding(new Insets(5,0,0,0));
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(595.2);
        vbox.setMaxWidth(595.2);

        return vbox;

    }

}