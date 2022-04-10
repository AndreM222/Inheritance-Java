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
            finalPrice.setFont(new Font("Comic Sans MS", 15));
            finalPrice.setTextFill(Color.WHITE);
            tip.setFont(new Font("Comic Sans MS", 15));
            tip.setTextFill(Color.WHITE);
            taxTotal.setFont(new Font("Comic Sans MS", 15));
            taxTotal.setTextFill(Color.WHITE);

            rectangle.setEffect(new DropShadow(20, Color.BLACK));
            rectangle.setFill(Color.web("#1d1f26"));
            rectangle.setArcHeight(20);
            rectangle.setArcWidth(20);
            priceRectangle.setFill(Color.web("#3c3d51"));
            priceRectangle.setArcHeight(10);
            priceRectangle.setArcWidth(10);

            title.setAlignment(Pos.CENTER);
            vbox.setAlignment(Pos.CENTER);
            VBox.setVgrow(listScroll, Priority.ALWAYS);
            VBox.setVgrow(listBox, Priority.ALWAYS);
            vbox.setMinSize(350, 450);
            vbox.setTranslateX(25);
            vbox.setTranslateY(25);

            food.setStyle("-fx-background-color: #6668b0;");
            food.setMinWidth(154);;
            food.setPromptText("Food Type");
            amount.setStyle("-fx-background-color: #6668b0;");
            amount.setMinWidth(154);
            amount.setPromptText("Quantity");
            searchBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #7f80a0;");

            listBox.setStyle("-fx-background-color: #2e3347;");
            listScroll.setStyle("-fx-background-color: #191c26;");
            listScroll.setFitToHeight(true);
            listScroll.setMaxSize(355, 235);
            listScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
            
            tipTaxTotalIcon.setFitWidth(50);
            tipTaxTotalIcon.setFitHeight(50);

            hoveringBTFX();

        }
    
    // -------------------- Variables ----------------------

    private String[] foodType = {"Chicken", "Beef", "Stake", "Dumpling", };
    private String[] amountInt = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private SelectionBT selectionRef = new SelectionBT();
    private SalesList salesListRef = new SalesList();

    private ComboBox<String> food = new ComboBox<String>(FXCollections.observableArrayList(foodType));
    private ComboBox<String> amount = new ComboBox<String>(FXCollections.observableArrayList(amountInt));
    private Label welcomeMSG = new Label("Tip, Tax, Total");
    private Label totalPrice = new Label("Total: " + salesListRef.getTotalAddition()+ "$ +");
    private Label tip = new Label("Tip: " + salesListRef.getTip() + "$ +");
    private Label taxTotal = new Label(salesListRef.getTaxLabel());
    private Label finalPrice = new Label(salesListRef.getFinalPrice());
    private BorderPane root = new BorderPane();
    private Button searchBT = new Button("Add");
    private Rectangle rectangle = new Rectangle(400, 500);
    private Rectangle priceRectangle = new Rectangle(200, 10);
    private ImageView tipTaxTotalIcon = new ImageView("Java/Semester2/Chapter11/CH11Icons/TipTaxTotalTitle.png");
    
    private HBox title = new HBox(10, tipTaxTotalIcon, welcomeMSG);
    private VBox listBox = new VBox(salesListRef.addList(taxTotal));
    private ScrollPane listScroll = new ScrollPane(listBox);
    private Scene tipTaxTotalScene = new Scene(root, 1000, 600);
    private HBox search = new HBox(5, searchBT,food , amount);
    private VBox infoBox = new VBox(totalPrice, tip, taxTotal, priceRectangle, finalPrice);
    private VBox vbox = new VBox(10, title, search, listScroll, infoBox);
    private Group window = new Group(rectangle,vbox);
    
    // -------------------- Getters ----------------------

    public Scene getTipTaxTotalScene() { return tipTaxTotalScene; }

    // -------------------- ButtonFX ----------------------

    public void hoveringBTFX() {
        
        // -------------------- OnHover ----------------------

        searchBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                searchBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");

            }

        });

        // -------------------- UnHover ----------------------

        searchBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                searchBT.setStyle("-fx-background-radius: 5em;-fx-background-color: #7f80a0;");

            }

        });

        // -------------------- OnPressed ----------------------

        searchBT.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                searchBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #565778;");
                
            }

        });

        // -------------------- OnReleased ----------------------

        searchBT.setOnMouseReleased(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                searchBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");
                listBox.getChildren().clear();

                listBox.getChildren().addAll(salesListRef.addList(taxTotal));
                
            }

        });

    }
    
}
