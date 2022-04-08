package Java.Semester2.Chapter11.Translator;

import javafx.scene.layout.VBox;

public class WordList {

    WordList() {

        arrList[0] = new WordFunction("sinister", "left", "left direction");
        arrList[1] = new WordFunction("dexter", "right", "right direction");
        arrList[2] = new WordFunction("medium", "center", "center location");
        arrList[3] = new WordFunction("laponica", "japanese", "relating to Japan or its language, culture, or people");
        arrList[4] = new WordFunction("somnum", "sleep", "a condition of body and mind that" +
                                    " recurs for several hours every night, " +
                                    "in which the nervous system is relatively " +
                                    "inactive, the eyes closed, the postural muscles relaxed," +
                                    " and consciousness practically suspended.");
        arrList[5] = new WordFunction("dexter", "right", "right direction");
        arrList[6] = new WordFunction("medium", "center", "center location");
        arrList[7] = new WordFunction("laponica", "japanese", "relating to Japan or its language, culture, or people");
        arrList[8] = new WordFunction("dexter", "right", "right direction");
        arrList[9] = new WordFunction("medium", "center", "center location");

    }
    
    public WordFunction[] arrList = new WordFunction[10];

    public VBox[] generalList() {
        
        VBox[] vbox = new VBox[arrList.length];

        for(int i = 0; i < arrList.length; i++) {

            vbox[i] = arrList[i].setupNewWord();

        }

        return vbox;

    }

}