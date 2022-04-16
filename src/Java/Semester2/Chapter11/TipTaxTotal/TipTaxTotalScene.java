package Java.Semester2.Chapter11.TipTaxTotal;

import javafx.collections.FXCollections;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.text.DecimalFormat;
import Java.Semester2.Chapter11.SelectionBT;

public class TipTaxTotalScene {

    // -------------------- Init ----------------------

    public TipTaxTotalScene() {

        root.setTop(selectionRef.getMenuBox());
        root.setCenter(window);
        root.setStyle("-fx-background-color: #282a36;");

        welcomeMSG.setFont(new Font("Comic Sans MS", 40));
        welcomeMSG.setTextFill(Color.WHITE);
        totalPrice.setFont(new Font("Comic Sans MS", 15));
        totalPrice.setTextFill(Color.WHITE);
        finalPriceTxt.setFont(new Font("Comic Sans MS", 15));
        finalPriceTxt.setTextFill(Color.WHITE);
        tip.setFont(new Font("Comic Sans MS", 15));
        tip.setTextFill(Color.WHITE);
        taxTotal.setFont(new Font("Comic Sans MS", 15));
        taxTotal.setTextFill(Color.WHITE);

        rectangleBKGD.setEffect(new DropShadow(20, Color.BLACK));
        rectangleBKGD.setFill(Color.web("#1d1f26"));
        rectangleBKGD.setArcHeight(20);
        rectangleBKGD.setArcWidth(20);
        priceRectangle.setFill(Color.web("#3c3d51"));
        priceRectangle.setArcHeight(10);
        priceRectangle.setArcWidth(10);
        
        VBox.setVgrow(salesListRef.getListBox(), Priority.ALWAYS);
        VBox.setVgrow(listScroll, Priority.ALWAYS);
        title.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinSize(350, 450);
        vbox.setMaxHeight(450);
        vbox.setTranslateX(25);
        vbox.setTranslateY(25);

        foodType.setStyle("-fx-background-color: #6668b0;");
        foodType.setMinWidth(154);
        foodType.getSelectionModel().selectFirst();
        amountCount.setStyle("-fx-background-color: #6668b0;");
        amountCount.setMinWidth(154);
        amountCount.getSelectionModel().selectFirst();
        addBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #7f80a0;");
        clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #7f80a0;");

        salesListRef.getListBox().setStyle("-fx-background-color: #2e3347;");
        listScroll.setStyle("-fx-background: #191c26; -fx-background-color: black;");
        listScroll.setFitToHeight(true);
        listScroll.setMaxSize(355, 235);
        listScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        
        tipTaxTotalIcon.setFitWidth(50);
        tipTaxTotalIcon.setFitHeight(50);

        hoveringBTFX();

    }
    
    // -------------------- Variables ----------------------

    private SelectionBT selectionRef = new SelectionBT();
    private SalesList salesListRef = new SalesList();
    private FoodList foodListRef = new FoodList();
    private Integer[] amountInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private DecimalFormat taxFormated = new DecimalFormat("0.00");
    private ComboBox<String> foodType = new ComboBox<String>(FXCollections.observableArrayList(foodListRef.getFood()));
    private ComboBox<Integer> amountCount = new ComboBox<Integer>(FXCollections.observableArrayList(amountInt));
    private Label welcomeMSG = new Label("Tip, Tax, Total");
    private Label totalPrice = new Label("Total: " + salesListRef.getTotalAddition()+ "$ +");
    private Label tip = new Label("Tip: " + salesListRef.getTip() + "$ +");
    private Label taxTotal = new Label("("+ salesListRef.getTaxAmount() + "%)Tax: " + taxFormated.format(salesListRef.getTaxCalculation()) + "$ +");
    private Label finalPriceTxt = new Label("Final Price: " + taxFormated.format(salesListRef.getFinalPrice()) + "$");
    private Button addBT = new Button("Add");
    private Button clearBT = new Button("Clear All");
    private Rectangle rectangleBKGD = new Rectangle(400, 500);
    private Rectangle priceRectangle = new Rectangle(200, 10);
    private ImageView tipTaxTotalIcon = new ImageView("Java/Semester2/Chapter11/CH11Icons/TipTaxTotalTitle.png");
    
    private BorderPane root = new BorderPane();
    private HBox title = new HBox(10, tipTaxTotalIcon, welcomeMSG);
    private ScrollPane listScroll = new ScrollPane(salesListRef.getListBox());
    private Scene tipTaxTotalScene = new Scene(root, 1000, 600);
    private HBox newFoodBox = new HBox(5, addBT, foodType , amountCount);
    private VBox infoBox = new VBox(clearBT, totalPrice, tip, taxTotal, priceRectangle, finalPriceTxt);
    private VBox vbox = new VBox(10, title, newFoodBox, listScroll, infoBox);
    private Group window = new Group(rectangleBKGD,vbox);
    
    // -------------------- Getters ----------------------

    public Scene getTipTaxTotalScene() { return tipTaxTotalScene; }

    // -------------------- ButtonFX ----------------------

    public void hoveringBTFX() {
        
        // -------------------- OnHover ----------------------

        addBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                addBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");

            }

        });

        clearBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");

            }

        });

        // -------------------- UnHover ----------------------

        addBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                addBT.setStyle("-fx-background-radius: 5em;-fx-background-color: #7f80a0;");

            }

        });

        clearBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em;-fx-background-color: #7f80a0;");

            }

        });

        // -------------------- OnPressed ----------------------

        addBT.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                addBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #565778;");
                
            }

        });

        clearBT.setOnMousePressed(new EventHandler<MouseEvent>(){

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #565778;");

            }

        });

        // -------------------- OnReleased ----------------------

        addBT.setOnMouseReleased(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                String object = foodType.getValue();
                int amount = amountCount.getValue();
                float price = foodListRef.getPrice(foodType.getItems().indexOf(foodType.getValue())); 
                addBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");
                SalesFunction salesFunctionRef = new SalesFunction(object, amount, price);
                salesListRef.getArrList().add(salesFunctionRef);
                salesListRef.getListBox().getChildren().addAll(salesListRef.addList());
                totalPrice.setText("Total: " + salesListRef.getTotalAddition()+ "$ +");
                taxTotal.setText("("+ salesListRef.getTaxAmount() + "%)Tax: " + taxFormated.format(salesListRef.getTaxCalculation()) + "$ +");
                finalPriceTxt.setText("Final Price: " + taxFormated.format(salesListRef.getFinalPrice()) + "$");

            }

        });

        clearBT.setOnMouseReleased(new EventHandler<MouseEvent>(){

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");
                salesListRef.removeList();
                totalPrice.setText("Total: " + salesListRef.getTotalAddition()+ "$ +");
                taxTotal.setText("("+ salesListRef.getTaxAmount() + "%)Tax: " + taxFormated.format(salesListRef.getTaxCalculation()) + "$ +");
                finalPriceTxt.setText("Final Price: " + taxFormated.format(salesListRef.getFinalPrice()) + "$");

            }

        });

    }
    
}