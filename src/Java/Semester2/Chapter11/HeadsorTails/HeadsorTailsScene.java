package Java.Semester2.Chapter11.HeadsorTails;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import Java.Semester2.Chapter11.SelectionBT;


public class HeadsorTailsScene {

    // -------------------- Init ----------------------

    public HeadsorTailsScene() {

        root.setTop(selectionRef.getMenuBox());
        root.setCenter(window);
        root.setStyle("-fx-background-color: #282a36;");

        welcomeMSG.setFont(new Font("Comic Sans MS", 20));
        welcomeMSG.setTextFill(Color.WHITE);
        coinBoxRef.getActionMSG().setFont(new Font("Comic Sans MS", 15));
        coinBoxRef.getActionMSG().setTextFill(Color.WHITE);

        rectangleBKGD.setEffect(new DropShadow(20, Color.BLACK));
        rectangleBKGD.setFill(Color.web("#1d1f26"));
        rectangleBKGD.setArcHeight(20);
        rectangleBKGD.setArcWidth(20);
        priceRectangle.setFill(Color.web("#3c3d51"));
        priceRectangle.setArcHeight(10);
        priceRectangle.setArcWidth(10);
        
        VBox.setVgrow(coinBoxRef.getListBox(), Priority.ALWAYS);
        coinBoxRef.getListBox().setAlignment(Pos.CENTER);
        title.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinSize(350, 300);
        vbox.setMaxHeight(300);
        vbox.setTranslateX(25);
        vbox.setTranslateY(25);

        headsBT.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20;");
        tailsBT.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20;");
        middleBT.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20;");
        coinBoxRef.getContinueBT().setStyle("-fx-font-size: 20;");
        coinBoxRef.getContinueBT().setWrapText(true);
        coinBoxRef.getContinueBT().setOpacity(0.5);
        coinBoxRef.getContinueBT().setMinSize(355, 200);
        coinBoxRef.getContinueBT().setMaxSize(355, 200);
        coinBoxRef.getListBox().setStyle("-fx-background-color: #2e3347; -fx-border-color: black;");
        coinBoxRef.getListBox().setMinSize(355, 200);
        coinBoxRef.getContinueBT().setVisible(false);
        headsBT.setMinSize(126, 200);
        tailsBT.setMinSize(126, 200);
        middleBT.setMinSize(100, 200);
        
        headsOrTailsIcon.setFitWidth(50);
        headsOrTailsIcon.setFitHeight(50);

        hoveringBTFX();

    }
    
    // -------------------- Variables ----------------------

    private SelectionBT selectionRef = new SelectionBT();
    private CoinBox coinBoxRef = new CoinBox();

    private Label welcomeMSG = new Label("Heads or Tails");
    private Button headsBT = new Button("Heads");
    private Button tailsBT = new Button("Tails");
    private Button middleBT = new Button("Middle");
    private Rectangle rectangleBKGD = new Rectangle(400, 350);
    private Rectangle priceRectangle = new Rectangle(200, 10);
    private ImageView headsOrTailsIcon = new ImageView("Java/Semester2/Chapter11/CH11Icons/HeadOrTailsTitle.png");
    
    private BorderPane root = new BorderPane();
    private HBox title = new HBox(10, headsOrTailsIcon, welcomeMSG);
    private Scene headOrTailsScene = new Scene(root, 1000, 600);
    private HBox choiceBox = new HBox(headsBT, middleBT, tailsBT);
    private Group coinGroup = new Group(coinBoxRef.getListBox(), choiceBox, coinBoxRef.getContinueBT());
    private VBox vbox = new VBox(10, title, coinBoxRef.getActionMSG(), coinGroup);
    private Group window = new Group(rectangleBKGD,vbox);
    
    // -------------------- Getters ----------------------

    public Scene getHeadsOrTailsScene() { return headOrTailsScene; }

    // -------------------- ButtonFX ----------------------

    public void hoveringBTFX() {
        
        // -------------------- OnHover ----------------------

        headsBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                headsBT.setStyle("-fx-background-color: #dbc6e1; -fx-text-fill: white; -fx-font-size: 20;");
                coinBoxRef.HoverFX("heads");
                headsBT.setOpacity(0.4);
                coinBoxRef.getActionMSG().setText("----- 45% Chance -----");

            }

        });

        tailsBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                tailsBT.setStyle("-fx-background-color: #dbc6e1; -fx-text-fill: white; -fx-font-size: 20;");
                coinBoxRef.HoverFX("tails");
                tailsBT.setOpacity(0.4);
                coinBoxRef.getActionMSG().setText("----- 45% Chance -----");

            }

        });

        middleBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                middleBT.setStyle("-fx-background-color: #dbc6e1; -fx-text-fill: white; -fx-font-size: 20;");
                coinBoxRef.HoverFX("middle");
                middleBT.setOpacity(0.4);
                coinBoxRef.getActionMSG().setText("----- 10% Chance (God Level) -----");

            }

        });

        // -------------------- UnHover ----------------------

        headsBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                headsBT.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20;");
                coinBoxRef.unHoverFX("heads");
                headsBT.setOpacity(1);
                coinBoxRef.getActionMSG().setText("----- Choose Side -----");

            }

        });

        tailsBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                tailsBT.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20;");
                coinBoxRef.unHoverFX("tails");
                tailsBT.setOpacity(1);
                coinBoxRef.getActionMSG().setText("----- Choose Side -----");

            }

        });

        middleBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                middleBT.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20;");
                coinBoxRef.unHoverFX("middle");
                middleBT.setOpacity(1);
                coinBoxRef.getActionMSG().setText("----- Choose Side -----");

            }

        });

        // -------------------- OnPressed ----------------------

        headsBT.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                headsBT.setStyle("-fx-background-color: #6f5678; -fx-text-fill: white; -fx-font-size: 20;");
                coinBoxRef.runGamble("Heads");
                choiceBox.setVisible(false);
                
            }

        });

        tailsBT.setOnMousePressed(new EventHandler<MouseEvent>(){

            public void handle(MouseEvent t) {

                tailsBT.setStyle("-fx-background-color: #6f5678; -fx-text-fill: white; -fx-font-size: 20;");
                coinBoxRef.runGamble("Tails");
                choiceBox.setVisible(false);

            }

        });

        middleBT.setOnMousePressed(new EventHandler<MouseEvent>(){

            public void handle(MouseEvent t) {

                middleBT.setStyle("-fx-background-color: #6f5678; -fx-text-fill: white; -fx-font-size: 20;");
                coinBoxRef.runGamble("Middle");
                choiceBox.setVisible(false);

            }

        });

        coinBoxRef.getContinueBT().setOnMousePressed(new EventHandler<MouseEvent>(){

            public void handle(MouseEvent t) {

                choiceBox.setVisible(true);
                coinBoxRef.getContinueBT().setVisible(false);
                coinBoxRef.continueEvent();

            }

        });

    }
    
}