package Java.Semester2.Chapter11.NameFormatter;

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
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Java.Semester2.Chapter11.SelectionBT;

public class NameFormatterScene {
    
    // -------------------- Init ----------------------

    public NameFormatterScene(SelectionBT selectionRef) {

        root.setTop(selectionRef.getMenuBox());
        root.setCenter(window);
        root.setStyle("-fx-background-color: #282a36;");

        welcomeMSG.setFont(new Font("Comic Sans MS", 40));
        welcomeMSG.setTextFill(Color.WHITE);
        
        rectangleBKGD.setEffect(new DropShadow(20, Color.BLACK));
        rectangleBKGD.setFill(Color.web("#1d1f26"));
        rectangleBKGD.setArcHeight(20);
        rectangleBKGD.setArcWidth(20);

        VBox.setVgrow(nameListRef.getListBox(), Priority.ALWAYS);
        title.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinSize(350, 450);
        vbox.setMaxHeight(450);
        vbox.setTranslateX(25);
        vbox.setTranslateY(25);

        titleType.setStyle("-fx-background-color: #6668b0;");
        titleType.setMinWidth(25);
        titleType.getSelectionModel().selectFirst();
        firstNameBox.setStyle("-fx-background-color: #6668b0;");
        firstNameBox.setMinWidth(100);
        firstNameBox.setPromptText("First Name");
        middleNameBox.setStyle("-fx-background-color: #6668b0;");
        middleNameBox.setMinWidth(100);
        middleNameBox.setPromptText("Middle Name");
        lastNameBox.setStyle("-fx-background-color: #6668b0;");
        lastNameBox.setMinWidth(100);
        lastNameBox.setPromptText("Last Name");
        formatBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #7f80a0;");
        clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #7f80a0;");

        nameListRef.getListBox().setStyle("-fx-background-color: #2e3347;");
        nameListRef.getListBox().setStyle("-fx-background-color: #191c26; -fx-border-color: black;");
        nameListRef.getListBox().setMaxSize(605,335);

        nameFormatterIcon.setFitHeight(50);
        nameFormatterIcon.setFitWidth(50);

        hoveringBTFX();

    }

    // -------------------- Properties ----------------------

    private NameList nameListRef = new NameList();

    private ComboBox<String> titleType = new ComboBox<String>(FXCollections.observableArrayList(nameListRef.getNameTitles()));
    private TextField firstNameBox = new TextField();
    private TextField middleNameBox = new TextField();
    private TextField lastNameBox = new TextField();
    private Label welcomeMSG = new Label("Name Formatter");
    private Button formatBT = new Button("Format");
    private Button clearBT = new Button("Clear All");
    private Rectangle rectangleBKGD = new Rectangle(650, 500);
    private ImageView nameFormatterIcon = new ImageView("Java/Semester2/Chapter11/CH11Icons/NameFormatterTitle.png");
    
    private BorderPane root = new BorderPane();
    private HBox title = new HBox(10, nameFormatterIcon, welcomeMSG);
    private Scene nameFormatterScene = new Scene(root, 1000, 600);
    private HBox formatNameBox = new HBox(5, formatBT, titleType, firstNameBox, middleNameBox, lastNameBox);
    private VBox vbox = new VBox(10, title, formatNameBox, nameListRef.getListBox(), clearBT);
    private Group window = new Group(rectangleBKGD,vbox);

    // -------------------- Getters ----------------------

    public Scene getNameFormatterScene() { return nameFormatterScene; }
    
    // -------------------- ButtonFX ----------------------

    public void hoveringBTFX() {
        
        // -------------------- OnHover ----------------------

        formatBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                formatBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");

            }

        });

        clearBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");

            }

        });

        // -------------------- UnHover ----------------------

        formatBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                formatBT.setStyle("-fx-background-radius: 5em;-fx-background-color: #7f80a0;");

            }

        });

        clearBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em;-fx-background-color: #7f80a0;");

            }

        });

        // -------------------- OnPressed ----------------------

        formatBT.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                formatBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #565778;");
                
            }

        });

        clearBT.setOnMousePressed(new EventHandler<MouseEvent>(){

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #565778;");

            }

        });

        // -------------------- OnReleased ----------------------

        formatBT.setOnMouseReleased(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                nameListRef.removeList();
                String title = titleType.getValue();
                String firstName = firstNameBox.getText();
                String middleName = middleNameBox.getText();
                String lastName = lastNameBox.getText();
                formatBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");
                NameFunction nameFunctionRef = new NameFunction(firstName, middleName, lastName, title);
                for(int i = 0; i < 6; i++) {

                    nameListRef.getArrList().add(nameFunctionRef);
                    nameListRef.getListBox().getChildren().addAll(nameListRef.addName(i));

                }
                

            }

        });

        clearBT.setOnMouseReleased(new EventHandler<MouseEvent>(){

            public void handle(MouseEvent t) {

                clearBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #c6c8e1;");
                nameListRef.removeList();

            }

        });

    }

}