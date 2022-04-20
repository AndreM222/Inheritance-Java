package Java.Semester2.Chapter11.HeadsorTails;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point3D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;

public class CoinBox {
    
    // -------------------- Init ----------------------

    CoinBox() {

        coinMesh.getTransforms().add(new Rotate(90, new Point3D(1, 0, 0)));
        coinMesh.setMaterial(material);
        material.setDiffuseMap(new Image("Java/Semester2/Chapter11/CH11Icons/Bitcoin.png"));
        coinIdleAnimation();
        coinMesh.setRotationAxis(Rotate.Y_AXIS);

    }

    // -------------------- Properties ----------------------

    private Cylinder coinMesh = new Cylinder(80, 30, 80);
    private PhongMaterial material = new PhongMaterial();
    private VBox diceBox = new VBox(coinMesh);
    private String[] dicePosibilities = {"heads", "Tails", "Middle"};
    private Boolean hovering = false;
    private Boolean playingAnim = false;
    private Label actionMSG = new Label("----- Choose Side -----");
    private Button continueBT = new Button();
    private String loadingString = "";

    // -------------------- Getters ----------------------

    public Button getContinueBT() { return continueBT; }
    public Label getActionMSG() { return actionMSG; }
    public VBox getListBox() { return diceBox; }
    public String[] getDicePosibilities() { return dicePosibilities; }

    // -------------------- Setters ----------------------

    public void setResult (String winner, String current) {
        
        if(winner == current) {
            
            if(winner != "Middle") { continueBT.setText("You Win (Press To Continue)"); }
            else { continueBT.setText("It Fell On A Crack What A Luck! You Win  (Press To Continue)"); }

            continueBT.setStyle("-fx-background-color: green; -fx-font-size: 20;");
        
        } else { 
            
            continueBT.setText("You Loose (Press To Continue)"); 
        
            continueBT.setStyle("-fx-background-color: red; -fx-font-size: 20;");
        
        }

        actionMSG.setText("----- " + winner + " Win! -----");
    
    }

    // -------------------- Actions ----------------------

    public void HoverFX(String type) {

        hovering = true;

        coinMesh.setRotate(0);

        if(type == "heads") {

            coinMesh.getTransforms().add(new Rotate(180, new Point3D(0, 1, 0)));
            coinMesh.getTransforms().add(new Rotate(60, new Point3D(0, 0, 1)));

        } else if(type == "tails") {

            coinMesh.getTransforms().add(new Rotate(60, new Point3D(0, 0, 1)));

        } else { coinMesh.setRotate(90); }

    }

    public void unHoverFX(String type) {

        hovering = false;

        if(type == "heads") {

            coinMesh.getTransforms().add(new Rotate(180, new Point3D(0, 1, 0)));
            coinMesh.getTransforms().add(new Rotate(60, new Point3D(0, 0, 1)));

        } else if(type == "tails") {

            coinMesh.getTransforms().add(new Rotate(-60, new Point3D(0, 0, 1)));

        } else { coinMesh.setRotate(0); }

        if(playingAnim == false) { actionMSG.setText("----- Choose Side -----"); }

    }

    public void coinIdleAnimation() {

        AnimationTimer timer = new AnimationTimer() {
            
            public void handle(long now) {

                if(!hovering && !playingAnim) { coinMesh.rotateProperty().set(coinMesh.getRotate() + 0.2); }

            }

        };

        timer.start();

    }

    public void runGamble(String chosen) {

        actionMSG.setText("-----  -----");
        playingAnim = true;

        AnimationTimer coinAnim = new AnimationTimer() {

            int init = 0;
            String winner;
            int randomWinner = (int)(Math.random() * 10);
            
            public void handle(long now) {

                init++;

                coinMesh.rotateProperty().set(coinMesh.getRotate() + 20);

                if(init == 200) {

                    this.stop();

                    if(randomWinner < 5) {

                        coinMesh.setRotate(180);
                        winner = "Heads";

                    } else if(randomWinner > 5) {

                        coinMesh.setRotate(0);
                        winner = "Tails";

                    } else { coinMesh.setRotate(90); winner = "Middle";}

                    loadingString = "";
                    setResult(winner, chosen);
                    continueBT.setVisible(true);

                } else { setLoadingText(init); }

            }

            

        };

        coinAnim.start();

    }

    public void setLoadingText(int init) {

        char loadingCharOne = '?';
        char loadingCharTwo = '-';

        if (init % 15 == 0) {

            if(loadingString.length() < 5) {

                if(loadingString.length() < 1 || loadingString.charAt(loadingString.length() - 1) == loadingCharTwo){
                    
                    loadingString = loadingString + loadingCharOne;
                
                } else { loadingString = loadingString + loadingCharTwo; }

                actionMSG.setText("----- " + loadingString + " -----");

            } else { loadingString = ""; }

            
        }

    }

    public void continueEvent() { playingAnim = false; }

}
