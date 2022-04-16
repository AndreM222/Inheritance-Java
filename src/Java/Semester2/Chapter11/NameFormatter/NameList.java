package Java.Semester2.Chapter11.NameFormatter;

import java.util.ArrayList;
import javafx.scene.layout.VBox;

public class NameList {
    
    private VBox listBox = new VBox();
    private ArrayList<NameFunction> arrList = new ArrayList<NameFunction>();
    private String[] nameTitles = {"Mr. ", "Mrs. ", "Ms. ", "Dr. ", "Jr. ", "Prof. "};

    // -------------------- Getters ----------------------

    public VBox getListBox() { return listBox; }
    public ArrayList<NameFunction> getArrList() { return arrList; }
    public String[] getNameTitles() { return nameTitles; }

    // -------------------- Create ----------------------

    public VBox[] addName(int i) {

        VBox[] vbox = new VBox[1];

        vbox[0] = getArrList().get(getArrList().size()-1).setupNewName(i);

        return vbox;

    }

    public void removeList() {

        getListBox().getChildren().clear();
        getArrList().clear();

    }

}
