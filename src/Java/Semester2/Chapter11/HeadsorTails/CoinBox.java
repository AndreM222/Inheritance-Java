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
    
    CoinBox() {

        coinMesh.getTransforms().add(new Rotate(90, new Point3D(1, 0, 0)));
        coinMesh.setMaterial(material);
        material.setDiffuseMap(new Image("Java/Semester2/Chapter11/CH11Icons/Bitcoin.png"));
        coinIdleAnimation();
        coinMesh.setRotationAxis(Rotate.Y_AXIS);

    }

    private Cylinder coinMesh = new Cylinder(80, 30, 80);
    private PhongMaterial material = new PhongMaterial();
    private VBox diceBox = new VBox(coinMesh);
    private String[] dicePosibilities = {"heads", "Tails", "Middle"};
    private Boolean hovering = false;
    private Boolean playingAnim = false;
    private Label actionMSG = new Label("----- Choose Side -----");
    private Button continueBT = new Button();

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
        
        } else {continueBT.setText("You Loose (Press To Continue)");}

        actionMSG.setText("----- " + winner + " Win! -----");
    
    }

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

        int randomWinner = (int)(Math.random() * 10);
        actionMSG.setText("----- ?-?-? -----");
        playingAnim = true;

        AnimationTimer coinAnim = new AnimationTimer() {

            int init = 0;
            String winner;

            public void handle(long now) {

                init++;

                coinMesh.rotateProperty().set(coinMesh.getRotate() + 7);

                if(init == 200) {

                    this.stop();

                    if(randomWinner < 5) {

                        coinMesh.setRotate(180);
                        winner = "Heads";

                    } else if(randomWinner > 5) {

                        coinMesh.setRotate(0);
                        winner = "Tails";

                    } else { coinMesh.setRotate(90); winner = "Middle";}

                    setResult(winner, chosen);
                    continueBT.setVisible(true);

                }

            }

            

        };

        coinAnim.start();

    }

    public void continueEvent() { playingAnim = false; }

}
