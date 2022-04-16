package Java.Semester2.Chapter11.PropertyTax;

import java.util.ArrayList;
import javafx.scene.layout.VBox;

public class PropertyInfo {
    
    private VBox listBox = new VBox();
    private ArrayList<PropertyFunction> arrList = new ArrayList<PropertyFunction>();
    private int assessPercent = 60;
    private float assessment;
    private float propertyInfo = (float) 0.64;
    private float propertyTax = (propertyInfo * assessment)/100;

    // -------------------- Getters ----------------------

    public float getPropertyInfo() { return propertyInfo; }
    public VBox getListBox() { return listBox; }
    public ArrayList<PropertyFunction> getArrList() { return arrList; }
    public int getAssessPercent() { return assessPercent; }
    public float getAssessment() { return assessment; }
    public float getPropertyTax() { return propertyTax; }

    // -------------------- Create ----------------------
    
    public VBox[] addList() {
        
        VBox[] vbox = new VBox[1];
        vbox[0] = getArrList().get(getArrList().size()-1).setupNewObject();
        assessment = ((float)assessPercent/100) * arrList.get(getArrList().size()-1).getPrice();
        propertyTax = (propertyInfo * assessment)/100;

        return vbox;

    }

    public void removeList() {
        
        getListBox().getChildren().clear();;
        getArrList().clear();
        propertyTax = 0;
        assessment = 0;

    }
}
