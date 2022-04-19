package Java.Semester2.Chapter11;

import Java.Semester2.Chapter11.TipTaxTotal.TipTaxTotalScene;
import Java.Semester2.Chapter11.Translator.TranslatorScene;
import Java.Semester2.Chapter11.NameFormatter.NameFormatterScene;
import Java.Semester2.Chapter11.PropertyTax.PropertyTaxScene;
import Java.Semester2.Chapter11.HeadsorTails.HeadsorTailsScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainDrive extends Application {

    public static void main(String[] args){ launch(args); }

    public void start(Stage currentStage) {

        HeadsorTailsScene menuRef = new HeadsorTailsScene();

        currentStage.setScene(menuRef.getHeadsOrTailsScene());
        currentStage.setTitle("Chapter-11");
        currentStage.show();

    }
    
}