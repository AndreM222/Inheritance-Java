package Java.Semester2.Chapter11.TipTaxTotal;

import java.util.ArrayList;
import javafx.scene.layout.VBox;

public class SalesList {
    
    private VBox listBox = new VBox();
    private ArrayList<SalesFunction> arrList = new ArrayList<SalesFunction>();
    private int taxAmount = 7;
    private float totalAddition;
    private int tip = 18;
    private float taxCalculation;
    private float finalPrice = totalAddition + taxCalculation + tip;

    // -------------------- Getters ----------------------

    public VBox getListBox() { return listBox; }
    public ArrayList<SalesFunction> getArrList() { return arrList; }
    public float getTaxCalculation() { return taxCalculation; }
    public float getFinalPrice() { return finalPrice; }
    public int getTip() { return tip; }
    public int getTaxAmount() { return taxAmount; }
    public float getTotalAddition() { return totalAddition; }

    // -------------------- Setters ----------------------

    public void setTaxCalculation(float f) { this.taxCalculation = f; }
    public void setTotalAddition(float totalAddition) { this.totalAddition = totalAddition; }
    public void setFinalPrice(float finalPrice) { this.finalPrice = finalPrice; }

    // -------------------- Create ----------------------

    public VBox[] addList() {
        
        VBox[] vbox = new VBox[1];

        vbox[0] = getArrList().get(getArrList().size()-1).setupNewWord();

        setTotalAddition(totalAddition + arrList.get(getArrList().size()-1).getTotal());
        setTaxCalculation(totalAddition * ((float)taxAmount / 100));
        setFinalPrice(totalAddition + taxCalculation + tip);

        return vbox;

    }

    public void removeList() {
        
        getListBox().getChildren().clear();;
        getArrList().clear();
        setTotalAddition(0);
        setTaxCalculation(0);
        setFinalPrice(totalAddition + taxCalculation + tip);

    }

}