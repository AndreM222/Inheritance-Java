package Java.Semester2.Chapter11.TipTaxTotal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.scene.layout.VBox;

public class SalesList {
    
    private ArrayList<SalesFunction> arrList = new ArrayList<SalesFunction>();
    private int taxAmount = 7;
    private float totalAddition;
    private int tip = 18;
    private float taxCalculation;
    private DecimalFormat taxFormated = new DecimalFormat("0.00");
    private float finalPrice = totalAddition + taxCalculation + tip;
    private String finalPriceString = new String("Final Price: " + taxFormated.format(finalPrice) + "$");

    // -------------------- Getters ----------------------

    public ArrayList<SalesFunction> getArrList() { return arrList; }
    public float getTaxCalculation() { return taxCalculation; }
    public String getFinalPrice() { return finalPriceString; }
    public int getTip() { return tip; }
    public int getTaxAmount() { return taxAmount; }
    public float getTotalAddition() { return totalAddition; }

    // -------------------- Setters ----------------------

    public void setTaxCalculation(int taxCalculation) { this.taxCalculation = taxCalculation; }
    public void setTotalAddition(float totalAddition) { this.totalAddition = totalAddition; }

    // -------------------- Create ----------------------

    public VBox[] addList() {
        
        VBox[] vbox = new VBox[1];

        vbox[0] = getArrList().get(getArrList().size()-1).setupNewWord();
        
        setTotalAddition(totalAddition + arrList.get(getArrList().size()-1).getTotal());
        taxCalculation = totalAddition * ((float)taxAmount / 100);

        return vbox;

    }

}