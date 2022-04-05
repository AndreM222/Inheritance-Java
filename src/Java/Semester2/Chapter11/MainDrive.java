package Java.Semester2.Chapter11;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class MainDrive extends Application {

    public static void main(String[] args){ launch(args); }

    public void start(Stage currentStage) {

        SelectionBT selectionRef = new SelectionBT();
        Label welcomeMSG = new Label("Welcome to Chapter 11");
        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root, 1000, 600);
        ImageView iconCenter = new ImageView("Java/Semester2/Chapter11/CH11Icons/Panda.png");
        VBox vbox = new VBox( 10, welcomeMSG, iconCenter );
        iconCenter.setFitHeight(500);
        iconCenter.setFitWidth(500);
        
        root.setTop(selectionRef.getMenuBox());
        root.setCenter(vbox);
        vbox.setAlignment(Pos.CENTER);
        
        welcomeMSG.setFont(new Font("Arial", 80));
        welcomeMSG.setTextFill(Color.WHITE);
        root.setStyle("-fx-background-color: #282a36;");

        currentStage.setScene(mainScene);
        currentStage.setTitle("Chapter-11");
        currentStage.show();

    }
    
}