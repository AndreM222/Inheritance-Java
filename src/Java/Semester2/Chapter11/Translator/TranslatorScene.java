package Java.Semester2.Chapter11.Translator;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import Java.Semester2.Chapter11.SelectionBT;


public class TranslatorScene {

        // -------------------- Init ----------------------

        public TranslatorScene() {

            root.setTop(selectionRef.getMenuBox());
            root.setCenter(vbox);
            welcomeMSG.setFont(new Font("Arial", 40));
            welcomeMSG.setTextFill(Color.WHITE);
            root.setStyle("-fx-background-color: #282a36;");
            vbox.setMaxWidth(300);
            vbox.setMaxHeight(400);
            searchBox.setPromptText("Search:");
            vbox.setStyle("-fx-background-color: Grey;");
            listBox.setMaxWidth(500);
    
        }
    
    // -------------------- Variables ----------------------

    
    private TextField searchBox = new TextField();
    private SelectionBT selectionRef = new SelectionBT();
    private Label welcomeMSG = new Label("Translator");
    private BorderPane root = new BorderPane();
    private Scene translatorScene = new Scene(root, 1000, 600);
    private HBox hbox = new HBox(10, welcomeMSG);
    private ScrollPane listBox = new ScrollPane(hbox);
    private VBox vbox = new VBox( 10, welcomeMSG, searchBox, listBox);
    
    // -------------------- Getters ----------------------

    public Scene getTranslatorScene() { return translatorScene; }
    

}
