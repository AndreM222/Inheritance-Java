package Lists;

import java.util.Scanner;
import Classes.ShiftSupervisor;
import java.util.ArrayList;

public class EmployeesList {

  Scanner inputSC = new Scanner(System.in);
  private int supervisorsCount;
  public ArrayList<Classes.ShiftSupervisor> supervisorArr = new ArrayList<Classes.ShiftSupervisor>();

  public boolean createEmployeesList() {

    System.out.print("Input Supervisors Amount: ");

    try {
      supervisorsCount = Integer.parseInt(inputSC.nextLine());
    } catch (NumberFormatException e) {
      System.err.println("Incorrect Input Type");
      System.exit(1);
    }
    
    for (int i = 0; i < supervisorsCount; i++) {
      
      Classes.ShiftSupervisor supervisorRef = new Classes.ShiftSupervisor();
      String name, group, area, idNumber, firstNumbers;
      char setupNumbers;

      // ---------------------------------------Input-------------------------------------------------

      System.out.printf("-------- Input Supervisor[%d] Information: %n", i);

      System.out.print("----------  Input Name: ");
      name = inputSC.nextLine();
      System.out.print("----------  Input Group: ");
      group = inputSC.nextLine();
      System.out.print("----------  Input Area: ");
      area = inputSC.nextLine();
      System.out.print("----------  Input 6 Digit ID Number: ");
      idNumber = inputSC.nextLine();
      setupNumbers = idNumber.charAt(0);
      firstNumbers = "";

      // -------------------------------- Setup Next ID Initials
      // ----------------------------------------

      for (int i2 = 0; i2 < 2; i2++) {

        setupNumbers = idNumber.charAt(i2);
        firstNumbers = firstNumbers + setupNumbers;

      }
      // -------------------------------------Clear

      System.out.print("\033[H\033[2J");
      System.out.flush();

      // ------------------------------------------Set--------------------------------------------------
      
      supervisorRef.setIDNumber(idNumber);
      supervisorRef.setName(name);
      supervisorRef.setGroup(group);
      supervisorRef.setArea(area);
      supervisorRef.createLeaderList(area, firstNumbers);

      supervisorArr.add(supervisorRef);
    }

    return true;

  }

  public void showEmployeesList() {
    
    for (int i = 0; i < supervisorArr.size(); i++) {
      
      ShiftSupervisor shiftRef = supervisorArr.get(i);
      
      System.out.printf("%n------------------------- Supervisor(%s) [%s] {%s} -------------------------%n", shiftRef.getName(), shiftRef.getArea(),
      shiftRef.getIDNumber());
      shiftRef.showLeaderList();
      
    }
  }
}