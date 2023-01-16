package Java.Semester2.Chapter11;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.shape.Rectangle;

public class SelectionBT {
    
    // ---------------------- Init ----------------------
    
    public SelectionBT() {
        
        menuSelection.setStyle("-fx-background-color: #1d1f26;");
        menuSelection.setMinHeight(50);
        menuSelection.setAlignment(Pos.CENTER);
        menuSelection.setEffect(new DropShadow(20, Color.BLACK));
        
        homeBT.setPrefSize(60, 50);
        translatorBT.setPrefSize(60, 50);
        tipTaxtTotalBT.setPrefSize(60, 50);
        propertyTaxBT.setPrefSize(60, 50);
        nameFormatterBT.setPrefSize(60, 50);
        headsOrTailsBT.setPrefSize(60, 50);
        
        homeBT.setGraphic(new ImageView("Java/Semester2/Chapter11/CH11Icons/CH11SelectButtonsIcon/home.png"));
        translatorBT.setGraphic(new ImageView("Java/Semester2/Chapter11/CH11Icons/CH11SelectButtonsIcon/translate.png"));
        tipTaxtTotalBT.setGraphic(new ImageView("Java/Semester2/Chapter11/CH11Icons/CH11SelectButtonsIcon/money.png"));
        propertyTaxBT.setGraphic(new ImageView("Java/Semester2/Chapter11/CH11Icons/CH11SelectButtonsIcon/property.png"));
        nameFormatterBT.setGraphic(new ImageView("Java/Semester2/Chapter11/CH11Icons/CH11SelectButtonsIcon/format.png"));
        headsOrTailsBT.setGraphic(new ImageView("Java/Semester2/Chapter11/CH11Icons/CH11SelectButtonsIcon/coin.png"));
        
        homeBT.setStyle("-fx-background-color: transparent;");
        translatorBT.setStyle("-fx-background-color: transparent;");
        tipTaxtTotalBT.setStyle("-fx-background-color: transparent;");
        propertyTaxBT.setStyle("-fx-background-color: transparent;");
        nameFormatterBT.setStyle("-fx-background-color: transparent;");
        headsOrTailsBT.setStyle("-fx-background-color: transparent;");
        
        hoverRectangle.setArcHeight(10.0d);
        hoverRectangle.setArcWidth(10.0d);
        hoverRectangle.setTranslateX(locationBT);
        hoverRectangle.setEffect(shadowDrop);
        hoveringBTFX();
        homeBT.setDisable(true);
        
    }
    
    // ---------------------- Properties ----------------------

    private DropShadow shadowDrop = new DropShadow(20, Color.WHITE);
    private Rectangle hoverRectangle = new Rectangle(30, 10, Color.WHITE);
    private Button homeBT = new Button();
    private Button translatorBT = new Button();
    private Button tipTaxtTotalBT = new Button();
    private Button propertyTaxBT = new Button();
    private Button nameFormatterBT = new Button();
    private Button headsOrTailsBT = new Button();
    private Button oldBT = homeBT;
    private double locationBT = 335;
    private double hoverLocation;
    private HBox menuSelection = new HBox(
        
        homeBT,
        translatorBT,
        tipTaxtTotalBT,
        propertyTaxBT,
        nameFormatterBT,
        headsOrTailsBT
        
    );
    private VBox menuBox = new VBox(menuSelection, hoverRectangle);

    // -------------------- Button Actions ----------------------

    public void hoveringBTFX() {
        
        // -------------------- OnHover ----------------------

        homeBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                onHoverBTFX(homeBT, Color.PINK);

            }

        });

        translatorBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                onHoverBTFX(translatorBT, Color.BLUEVIOLET);

            }

        });

        tipTaxtTotalBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                onHoverBTFX(tipTaxtTotalBT, Color.CORAL);

            }

        });

        propertyTaxBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                onHoverBTFX(propertyTaxBT, Color.GREEN);
                
            }

        });

        nameFormatterBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                onHoverBTFX(nameFormatterBT, Color.AQUA);

            }

        });

        headsOrTailsBT.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                onHoverBTFX(headsOrTailsBT, Color.YELLOW);

            }

        });

        // -------------------- UnHover ----------------------

        homeBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                unHoverBTFX(homeBT);

            }

        });

        translatorBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                unHoverBTFX(translatorBT);

            }

        });

        tipTaxtTotalBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                unHoverBTFX(tipTaxtTotalBT);

            }

        });

        propertyTaxBT.setOnMouseExited(new EventHandler<MouseEvent>() {
        
            public void handle(MouseEvent t) {

                unHoverBTFX(propertyTaxBT);

            }

        });

        nameFormatterBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                unHoverBTFX(nameFormatterBT);

            }

        });

        headsOrTailsBT.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                unHoverBTFX(headsOrTailsBT);

            }

        });

    }

    // -------------------- Buttons --------------------

    public void onHoverBTFX (Button refBT, Color color) {

        hoverLocation = refBT.getLayoutX() + (refBT.getWidth()/4);
        refBT.setStyle("-fx-background-color: #282942;");
        shadowDrop.setColor(color);
        hoverRectangle.setFill(color);
        hoverAnim.start();
        unHoverAnim.stop();
        


    }

    public void unHoverBTFX (Button refBT) {

        shadowDrop.setColor(Color.WHITE);
        hoverRectangle.setFill(Color.WHITE);
        refBT.setStyle("-fx-background-color: transparent;");
        unHoverAnim.start();
        hoverAnim.stop();

    }

    public void onClickBT (Button refBT) {

        oldBT.setDisable(false);
        shadowDrop.setColor(Color.WHITE);
        hoverRectangle.setFill(Color.WHITE);
        locationBT = refBT.getLayoutX() + (refBT.getWidth()/4);
        hoverRectangle.setTranslateX(locationBT);
        refBT.setDisable(true);
        oldBT = refBT;

    }

    // -------------------- Getters ----------------------

    public VBox getMenuBox() { return menuBox; }

    public Button getHomeBT() { return homeBT; }
    public Button getTranslatorBT() { return translatorBT; }
    public Button getTipTaxtTotalBT() { return tipTaxtTotalBT; }
    public Button getPropertyTaxBT() { return propertyTaxBT; }
    public Button getNameFormatterBT() { return nameFormatterBT; }
    public Button getHeadsOrTailsBT() { return headsOrTailsBT; }

    // -------------------- Animations --------------------

    AnimationTimer unHoverAnim = new AnimationTimer() {

        int changeRate = 20;
            
        public void handle(long now) {

            if((int)locationBT > (int)hoverRectangle.getTranslateX()) { 
                
                hoverRectangle.setTranslateX((int)hoverRectangle.getTranslateX() + changeRate);
            
            } else if((int)locationBT < (int)hoverRectangle.getTranslateX()) {

                hoverRectangle.setTranslateX((int)hoverRectangle.getTranslateX() - changeRate);

            } else { unHoverAnim.stop(); }

        }

    };

    AnimationTimer hoverAnim = new AnimationTimer() {

        int changeRate = 20;
            
        public void handle(long now) {

            if((int)hoverLocation > (int)hoverRectangle.getTranslateX()) { 
                
                hoverRectangle.setTranslateX((int)hoverRectangle.getTranslateX() + changeRate);
            
            } else if((int)hoverLocation < (int)hoverRectangle.getTranslateX()) {

                hoverRectangle.setTranslateX((int)hoverRectangle.getTranslateX() - changeRate);

            } else { hoverAnim.stop(); }

        }

    };

}