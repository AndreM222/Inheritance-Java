package Java.Semester2.Chapter11;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class MenuScene {

    // -------------------- Init ----------------------

    public MenuScene(SelectionBT selectionRef) {

        iconCenter.setFitWidth(500);
        iconCenter.setFitHeight(500);
        root.setTop(selectionRef.getMenuBox());
        root.setCenter(vbox);
        vbox.setAlignment(Pos.CENTER);
        welcomeMSG.setFont(new Font("Arial", 80));
        welcomeMSG.setTextFill(Color.WHITE);
        root.setStyle("-fx-background-color: #282a36;");

    }

    // -------------------- Variables ----------------------

    private Label welcomeMSG = new Label("Welcome to Chapter 11");
    private BorderPane root = new BorderPane();
    private Scene mainScene = new Scene(root, 1000, 600);
    private ImageView iconCenter = new ImageView("Java/Semester2/Chapter11/CH11Icons/Panda.png");
    private VBox vbox = new VBox( 10, welcomeMSG, iconCenter );
    
    // -------------------- Getters ----------------------

    public Scene getMainScene() { return mainScene; }

}