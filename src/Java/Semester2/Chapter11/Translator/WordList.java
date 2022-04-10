package Java.Semester2.Chapter11.Translator;

import javafx.scene.layout.VBox;

public class WordList {

    WordList() {

        arrList[0] = new WordFunction("sinister", "left", "Left direction");
        arrList[1] = new WordFunction("dexter", "right", "Right direction");
        arrList[2] = new WordFunction("medium", "center", "Center location");
        arrList[3] = new WordFunction("laponica", "japanese", "Relating to Japan or its language, culture, or people");
        arrList[4] = new WordFunction("somnum", "sleep", "a condition of body and mind that" +
                                    " recurs for several hours every night, " +
                                    "in which the nervous system is relatively " +
                                    "inactive, the eyes closed, the postural muscles relaxed," +
                                    " and consciousness practically suspended.");
        arrList[5] = new WordFunction("navis", "boat", "A small vessel propelled on water by oars, sails, or an engine.");
        arrList[6] = new WordFunction("gemma", "gem", "A precious or semiprecious stone, especially when cut and polished or engraved");
        arrList[7] = new WordFunction("laponica", "heart", "Relating to Japan or its language, culture, or people");
        arrList[8] = new WordFunction("cor", "heart", "A hollow muscular organ that pumps the blood through the circulatory" +
                                    " system by rhythmic contraction and dilation. In vertebrates " +
                                    "there may be up to four chambers (as in humans), with two atria and two ventricles.");
        arrList[9] = new WordFunction("telum", "weapon", "A thing designed or used for inflicting bodily harm or physical damage");

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