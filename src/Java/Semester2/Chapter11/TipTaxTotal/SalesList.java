package Java.Semester2.Chapter11.TipTaxTotal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SalesList {

    SalesList() {

        arrList.add(salesFunctionRef);
        arrList.add(salesFunctionRef);

    }
    
    private SalesFunction salesFunctionRef = new SalesFunction("Chicken", 2, 2);

    private ArrayList<SalesFunction> arrList = new ArrayList<SalesFunction>();
    private int taxAmount = 7;
    private float totalAddition = 0;
    private int tip = 18;
    private float taxCalculation = totalAddition * ((float)taxAmount / 100);
    private DecimalFormat taxFormated = new DecimalFormat("0.00");
    private float finalPrice = totalAddition + taxCalculation + tip;
    private String taxTotalString = "("+ getTaxAmount() + "%)Tax: " + taxFormated.format(taxCalculation) + "$ +";
    private String finalPriceString = new String("Final Price: " + taxFormated.format(finalPrice) + "$");

    // -------------------- Getters ----------------------

    public ArrayList<SalesFunction> getArrList() { return arrList; }
    public String getTaxLabel() { return taxTotalString; }
    public String getFinalPrice() { return finalPriceString; }
    public int getTip() { return tip; }
    public int getTaxAmount() { return taxAmount; }
    public float getTotalAddition() { return totalAddition; }

    // -------------------- Getters ----------------------

    public void setTaxCalculation(int taxCalculation) { this.taxCalculation = taxCalculation; }
    public void setTaxLabel(String taxTotalString) { this.taxTotalString = taxTotalString; }
    public void setTotalAddition(float totalAddition) { this.totalAddition = totalAddition; }

    // -------------------- Create ----------------------

    public VBox[] addList(Label taxTotal) {
        
        VBox[] vbox = new VBox[arrList.size()];

        for(int i = 0; i < arrList.size(); i++) {

            vbox[i] = arrList.get(i).setupNewWord();
            setTotalAddition(totalAddition + arrList.get(i).getTotal());

        }

        taxTotal.setText(getTaxLabel());

        return vbox;

    }

}
