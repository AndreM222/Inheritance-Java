package Java.Semester2.Chapter11.PropertyTax;

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
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;

import Java.Semester2.Chapter11.SelectionBT;

public class PropertyTaxScene {

    // -------------------- Init ----------------------

    public PropertyTaxScene() {

        root.setTop(selectionRef.getMenuBox());
        root.setCenter(window);
        root.setStyle("-fx-background-color: #282a36;");

        welcomeMSG.setFont(new Font("Comic Sans MS", 40));
        welcomeMSG.setTextFill(Color.WHITE);
        assessPercentTXT.setFont(new Font("Comic Sans MS", 15));
        assessPercentTXT.setTextFill(Color.WHITE);
        assessmentTXT.setFont(new Font("Comic Sans MS", 15));
        assessmentTXT.setTextFill(Color.WHITE);
        taxTotalTXT.setFont(new Font("Comic Sans MS", 15));
        taxTotalTXT.setTextFill(Color.WHITE);

        rectangleBKGD.setEffect(new DropShadow(20, Color.BLACK));
        rectangleBKGD.setFill(Color.web("#1d1f26"));
        rectangleBKGD.setArcHeight(20);
        rectangleBKGD.setArcWidth(20);
        priceRectangle.setFill(Color.web("#3c3d51"));
        priceRectangle.setArcHeight(10);
        priceRectangle.setArcWidth(10);
        
        VBox.setVgrow(propertyInfoRef.getListBox(), Priority.ALWAYS);
        propertyInfoRef.getListBox().setAlignment(Pos.CENTER);
        title.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinSize(350, 300);
        vbox.setMaxHeight(300);
        vbox.setTranslateX(25);
        vbox.setTranslateY(25);

        nameBox.setStyle("-fx-background-color: #6668b0;");
        nameBox.setMaxWidth(140);
        nameBox.setPromptText("Type Name");
        priceBox.setStyle("-fx-background-color: #6668b0;");
        priceBox.setMaxWidth(140);
        priceBox.setPromptText("Type Price");
        calculateBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #7f80a0;");
        clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #7f80a0;");

        propertyInfoRef.getListBox().setStyle("-fx-background-color: #2e3347; -fx-border-color: black;");
        propertyInfoRef.getListBox().setMaxSize(355, 50);
        
        tipTaxTotalIcon.setFitWidth(50);
        tipTaxTotalIcon.setFitHeight(50);

        hoveringBTFX();

    }
    
    // -------------------- Variables ----------------------

    private SelectionBT selectionRef = new SelectionBT();
    private PropertyInfo propertyInfoRef = new PropertyInfo();

    private DecimalFormat taxFormated = new DecimalFormat("0.00");
    private TextField nameBox = new TextField();
    private TextField priceBox = new TextField();
    private Label welcomeMSG = new Label("Property Tax");
    private Label assessPercentTXT = new Label("Percent: " + propertyInfoRef.getAssessPercent() + "%");
    private Label assessmentTXT = new Label("Assessment: " + taxFormated.format(propertyInfoRef.getAssessment()) + "$");
    private Label taxTotalTXT = new Label("("+ propertyInfoRef.getPropertyInfo() + ")Tax: " + taxFormated.format(propertyInfoRef.getPropertyTax()) + "$ +");
    private Button calculateBT = new Button("Calculate");
    private Button clearBT = new Button("Clear");
    private Rectangle rectangleBKGD = new Rectangle(400, 350);
    private Rectangle priceRectangle = new Rectangle(200, 10);
    private ImageView tipTaxTotalIcon = new ImageView("Java/Semester2/Chapter11/CH11Icons/PropertyTaxTitle.png");
    
    private BorderPane root = new BorderPane();
    private HBox title = new HBox(10, tipTaxTotalIcon, welcomeMSG);
    private Scene propertyTaxScene = new Scene(root, 1000, 600);
    private HBox newFoodBox = new HBox(5, calculateBT, nameBox, priceBox);
    private VBox infoBox = new VBox(clearBT, assessPercentTXT, assessmentTXT, priceRectangle, taxTotalTXT);
    private VBox vbox = new VBox(10, title, newFoodBox, propertyInfoRef.getListBox(), infoBox);
    private Group window = new Group(rectangleBKGD,vbox);
    
    // -------------------- Getters ----------------------

    public Scene getPropertyTaxScene() { return propertyTaxScene; }

    // -------------------- ButtonFX ----------------------

    public void hoveringBTFX() {
        
        // -------------------- OnHover ----------------------

        calculateBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                calculateBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");

            }

        });

        clearBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");

            }

        });

        // -------------------- UnHover ----------------------

        calculateBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                calculateBT.setStyle("-fx-background-radius: 5em;-fx-background-color: #7f80a0;");

            }

        });

        clearBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em;-fx-background-color: #7f80a0;");

            }

        });

        // -------------------- OnPressed ----------------------

        calculateBT.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                calculateBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #565778;");
                
            }

        });

        clearBT.setOnMousePressed(new EventHandler<MouseEvent>(){

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #565778;");

            }

        });

        // -------------------- OnReleased ----------------------

        calculateBT.setOnMouseReleased(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                propertyInfoRef.getListBox().getChildren().clear();;
                propertyInfoRef.getArrList().clear();
                String name = nameBox.getText();
                float price = Integer.parseInt(priceBox.getText());
                calculateBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");
                PropertyFunction propertyFunctionRef = new PropertyFunction(name, price);
                propertyInfoRef.getArrList().add(propertyFunctionRef);
                propertyInfoRef.getListBox().getChildren().addAll(propertyInfoRef.addList());
                assessPercentTXT.setText("Percent: " + propertyInfoRef.getAssessPercent() + "%");
                assessmentTXT .setText("Assessment: " + taxFormated.format(propertyInfoRef.getAssessment()) + "$");
                taxTotalTXT.setText("("+ propertyInfoRef.getPropertyInfo() + ")Tax: " + taxFormated.format(propertyInfoRef.getPropertyTax()) + "$ +");

            }

        });

        clearBT.setOnMouseReleased(new EventHandler<MouseEvent>(){

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");
                propertyInfoRef.removeList();
                assessPercentTXT.setText("Percent: " + propertyInfoRef.getAssessPercent() + "%");
                assessmentTXT .setText("Assessment: " + taxFormated.format(propertyInfoRef.getAssessment()) + "$");
                taxTotalTXT.setText("("+ propertyInfoRef.getPropertyInfo() + ")Tax: " + taxFormated.format(propertyInfoRef.getPropertyTax()) + "$ +");

            }

        });

    }
    
}