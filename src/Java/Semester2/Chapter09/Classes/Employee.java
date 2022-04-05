package Java.Semester2.Chapter09.Classes;

public class Employee {
    
    private String idNumber;
    private String name;
    private String group;
    private String area;
    private String type;
    
    // ------------------------------- Setters ---------------------------
    
    public void setIDNumber(String idNumber) { this.idNumber = idNumber; }
    
    public void setName(String name) { this.name = name; }
    
    public void setGroup(String group) { this.group = group; }

    public void setArea(String area) { this.area = area; }

    public void setType(String type) { this.type = type; }
    
    // ------------------------------- Getters ---------------------------
    
    public String getIDNumber() { return idNumber; }
    
    public String getName() { return name; }
    
    public String getGroup() { return group; }

    public String getArea() { return area; }

    public String getType() { return type; }
    
    // ------------------------------- Printing ---------------------------
    
    public String toString() {

        return 
        "\n--------------- " + getType() + " (" + getName() + ")\n" +

        "\n---------- IdName: " + getIDNumber() +
        "\n---------- Name: " + getName() +
        "\n---------- Job: " + getGroup() +
        "\n---------- Area: " + getArea();

    }

}
