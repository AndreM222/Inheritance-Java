package Java.Semester2.Chapter11;

import Java.Semester2.Chapter11.TipTaxTotal.TipTaxTotalScene;
import Java.Semester2.Chapter11.Translator.TranslatorScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainDrive extends Application {

    public static void main(String[] args){ launch(args); }

    public void start(Stage currentStage) {

        TipTaxTotalScene menuRef = new TipTaxTotalScene();

        currentStage.setScene(menuRef.getTipTaxTotalScene());
        currentStage.setTitle("Chapter-11");
        currentStage.show();

    }
    
}