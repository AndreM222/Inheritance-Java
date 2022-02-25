package Classes;

public class Employee {
    
    private int idNumber = 231241;
    private String name = "Jerry";
    private String group = "Business";
    
    // ------------------------------- Setters ---------------------------
    
    public void setIDNumber(int idNumber) { this.idNumber = idNumber; }
    
    public void setName(String name) { this.name = name; }
    
    public void setGroup(String group) { this.group = group; }
    
    // ------------------------------- Getters ---------------------------
    
    public int getIDNumber() { return idNumber; }
    
    public String getName() { return name; }
    
    public String getGroup() { return group; }
    
    // ------------------------------- Printing ---------------------------
    
    public String toString() {

        return 
        "IdName: " + getIDNumber() +
        "\nName: " + getName() +
        "\nJob: " + getGroup();

    }

}
