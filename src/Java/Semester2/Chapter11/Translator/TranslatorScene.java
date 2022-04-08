package Java.Semester2.Chapter11.Translator;

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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Java.Semester2.Chapter11.SelectionBT;


public class TranslatorScene {

        // -------------------- Init ----------------------

        public TranslatorScene() {

            root.setTop(selectionRef.getMenuBox());
            root.setCenter(window);
            root.setStyle("-fx-background-color: #282a36;");

            welcomeMSG.setFont(new Font("Comic Sans MS", 40));
            welcomeMSG.setTextFill(Color.WHITE);
            searchBox.setPromptText("Type Word");
            searchBox.setMinWidth(300);

            rectangle.setEffect(new DropShadow(20, Color.BLACK));
            rectangle.setFill(Color.web("#1d1f26"));
            rectangle.setArcHeight(20);
            rectangle.setArcWidth(20);

            title.setAlignment(Pos.CENTER);
            vbox.setAlignment(Pos.CENTER);
            VBox.setVgrow(listScroll, Priority.ALWAYS);
            VBox.setVgrow(listBox, Priority.ALWAYS);
            vbox.setMinSize(350, 450);
            vbox.setTranslateX(25);
            vbox.setTranslateY(25);
            searchBox.setStyle("-fx-background-color: #3c3d51; -fx-text-fill: #ffffff;");
            searchBT.setStyle("-fx-background-radius: 5em; -fx-background-color: #7f80a0;");
            listBox.setStyle("-fx-background-color: #2e3347;");
            listScroll.setStyle("-fx-background-color: #191c26;");
            listBox.setMinSize(355, 343);
            listScroll.setMaxSize(357, 360);
            translatorIcon.setFitWidth(50);
            translatorIcon.setFitHeight(50);

            hoveringBTFX();

        }
    
    // -------------------- Variables ----------------------

    private SelectionBT selectionRef = new SelectionBT();
    private WordList wordListRef = new WordList();

    private TextField searchBox = new TextField();
    private Label welcomeMSG = new Label("Translator");
    private BorderPane root = new BorderPane();
    private Button searchBT = new Button("Search");
    private Rectangle rectangle = new Rectangle(400, 500);
    private ImageView translatorIcon = new ImageView("Java/Semester2/Chapter11/CH11Icons/TranslatorTitle.png");
    
    private HBox title = new HBox(10, translatorIcon, welcomeMSG);
    private VBox listBox = new VBox(5, wordListRef.generalList());
    private ScrollPane listScroll = new ScrollPane(listBox);
    private Scene translatorScene = new Scene(root, 1000, 600);
    private HBox search = new HBox(5, searchBT, searchBox);
    private VBox vbox = new VBox(10, title, search, listScroll);
    private Group window = new Group(rectangle,vbox);
    
    // -------------------- Getters ----------------------

    public Scene getTranslatorScene() { return translatorScene; }

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
                boolean foundWord = false;

                if( searchBox.getCharacters().length() > 0) {

                    for(int i = 0; i < wordListRef.arrList.length && !foundWord; i++) {

                        if(wordListRef.arrList[i].getLatinWord().equals(searchBox.getText())) {

                            listBox.getChildren().addAll(wordListRef.arrList[i].setupNewWord());
                            foundWord = true;

                        }

                    }

                } else {

                    listBox.getChildren().addAll(wordListRef.generalList());

                }
                
            }

        });

    }
    
}