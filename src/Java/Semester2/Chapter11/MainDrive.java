package Java.Semester2.Chapter11;

import Java.Semester2.Chapter11.TipTaxTotal.TipTaxTotalScene;
import Java.Semester2.Chapter11.Translator.TranslatorScene;
import Java.Semester2.Chapter11.NameFormatter.NameFormatterScene;
import Java.Semester2.Chapter11.PropertyTax.PropertyTaxScene;
import Java.Semester2.Chapter11.HeadsorTails.HeadsorTailsScene;

import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainDrive extends Application {

    // -------------------- Properties --------------------

    private SelectionBT selectionRef = new SelectionBT();
    private TranslatorScene translatorRef = new TranslatorScene(selectionRef);
    private TipTaxTotalScene tipTaxTotalRef = new TipTaxTotalScene(selectionRef);
    private PropertyTaxScene propertyTaxRef = new PropertyTaxScene(selectionRef);
    private NameFormatterScene nameFormatterRef = new NameFormatterScene(selectionRef);
    private HeadsorTailsScene headsOrTailsRef = new HeadsorTailsScene(selectionRef);
    private MenuScene menuRef = new MenuScene(selectionRef);

    public static void main(String[] args){ launch(args); }

    public void start(Stage currentStage) {

        menuRef.setSelectionBT(selectionRef);
        currentStage.setScene(menuRef.getMainScene());
        currentStage.setTitle("Chapter-11");
        currentStage.show();

        // -------------------- OnPressed ----------------------
        
        selectionRef.getHomeBT().setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                menuRef = new MenuScene(selectionRef);
                selectionRef.onClickBT(selectionRef.getHomeBT());
                currentStage.setScene(menuRef.getMainScene());
                
            }

        });

        // -------------------- SceneButtons --------------------

        selectionRef.getTranslatorBT().setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                translatorRef = new TranslatorScene(selectionRef);
                selectionRef.onClickBT(selectionRef.getTranslatorBT());
                currentStage.setScene(translatorRef.getTranslatorScene());
                
            }

        });

        selectionRef.getTipTaxtTotalBT().setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                tipTaxTotalRef = new TipTaxTotalScene(selectionRef);
                selectionRef.onClickBT(selectionRef.getTipTaxtTotalBT());
                currentStage.setScene(tipTaxTotalRef.getTipTaxTotalScene());
                
            }

        });

        selectionRef.getPropertyTaxBT().setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                propertyTaxRef = new PropertyTaxScene(selectionRef);
                selectionRef.onClickBT(selectionRef.getPropertyTaxBT());
                currentStage.setScene(propertyTaxRef.getPropertyTaxScene());
                
            }

        });

        selectionRef.getNameFormatterBT().setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                nameFormatterRef = new NameFormatterScene(selectionRef);
                selectionRef.onClickBT(selectionRef.getNameFormatterBT());
                currentStage.setScene(nameFormatterRef.getNameFormatterScene());
                
            }

        });
   
        selectionRef.getHeadsOrTailsBT().setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent t) {

                headsOrTailsRef = new HeadsorTailsScene(selectionRef);
                selectionRef.onClickBT(selectionRef.getHeadsOrTailsBT());
                currentStage.setScene(headsOrTailsRef.getHeadsOrTailsScene());
                
            }

        });

    }
    
}