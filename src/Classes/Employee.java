package Classes;

public class Employee {
    
    private String idNumber = "2a1b4c";
    private String name = "Jerry";
    private String group = "Cyber Security";
    private String area = "Software";
    
    // ------------------------------- Setters ---------------------------
    
    public void setIDNumber(String idNumber) { this.idNumber = idNumber; }
    
    public void setName(String name) { this.name = name; }
    
    public void setGroup(String group) { this.group = group; }

    public void setArea(String area) { this.area = area; }
    
    // ------------------------------- Getters ---------------------------
    
    public String getIDNumber() { return idNumber; }
    
    public String getName() { return name; }
    
    public String getGroup() { return group; }

    public String getArea() { return area; }
    
    // ------------------------------- Printing ---------------------------
    
    public String toString() {

        return 
        "---------- IdName: " + getIDNumber() +
        "\n---------- Name: " + getName() +
        "\n---------- Job: " + getGroup() +
        "\n---------- Area: " + getArea();

    }

}
