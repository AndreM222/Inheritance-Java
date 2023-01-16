package Java.Semester2.Chapter11.TipTaxTotal;

public class FoodList {

    // -------------------- Init --------------------
    
    FoodList() {

        setFoodList(0, "1# Pizza", (float) 3.5);
        setFoodList(1, "2# Hamburger", (float) 5.5);
        setFoodList(2, "3# Dumplings", (float) 15.5);
        setFoodList(3, "4# Sushi", (float) 15);
        setFoodList(4, "5# Fish", (float) 20);
        setFoodList(5, "6# Oden", (float) 7.9);
        setFoodList(6, "7# Sandwich", (float) 3.5);
        setFoodList(7, "8# Rice", (float) 1.4);
        setFoodList(8, "9# Chicken", (float) 12);
        setFoodList(9, "10# Gratin", (float) 7);

    }
    
    // -------------------- Properties --------------------

    private String[] foodList = new String[10];
    private Float[] priceList = new Float[10];

    // -------------------- Getters --------------------

    public String[] getFood() { return foodList; }
    public Float getPrice(int i) { return priceList[i]; }

    // -------------------- Setters --------------------
    
    public void setFoodList(int i, String food, Float price) {

        foodList[i] = food;
        priceList[i] = price;

    }

}