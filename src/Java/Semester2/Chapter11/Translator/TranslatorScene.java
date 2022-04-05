package Java.Semester2.Chapter11.Translator;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class TranslatorScene {

    private WordFunction wordRef = new WordFunction();
    private ArrayList<WordFunction> wordList = new ArrayList<WordFunction>();
    
    TranslatorScene () { initTerminal(); }

    public void initTerminal() {

        wordList.add(wordRef); wordList.get(1).setupNewWord("latinWord", "englishWord", "description");

    }

}
