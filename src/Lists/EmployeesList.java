package Lists;

import java.util.Scanner;
import java.util.ArrayList;

public class EmployeesList {

  Scanner inputSC = new Scanner(System.in);
  private int supervisorsCount;
  ArrayList<Classes.ShiftSupervisor> supervisorArr = new ArrayList<Classes.ShiftSupervisor>();
  
  public boolean createEmployeesList() {
    
    System.out.print("Input Supervisors Amount: ");
    
    Classes.ShiftSupervisor supervisorRef = new Classes.ShiftSupervisor();
    supervisorsCount = inputSC.nextInt();
    
    for (int i = 0; i < supervisorsCount; i++) {
      
      String name, group, area, idNumber, firstNumbers;
      char setupNumbers;
    
      supervisorArr.add(supervisorRef);
      
      // ---------------------------------------Input-------------------------------------------------
      
      System.out.println("\n--Input Supervisor[" + i + "] Information: --\n--");
      
      System.out.print("--  Input Name: ");
      name = inputSC.nextLine();
      System.out.print("--  Input Group: ");
      group = inputSC.nextLine();
      System.out.print("--  Input Area: ");
      area = inputSC.nextLine();
      System.out.print("--  Input 6 Digit ID Number: ");
      idNumber = inputSC.nextLine();
      setupNumbers = idNumber.charAt(0);
      firstNumbers = null;

      for(int i2 = 0; i2 < 2; i2++){

        setupNumbers = idNumber.charAt(i2);
        firstNumbers = firstNumbers + setupNumbers;

      }
      
      // -------------------------------------Clear
      
      System.out.print("\033[H\033[2J");
      System.out.flush();
      
      // ------------------------------------------Set--------------------------------------------------
      
      supervisorArr.get(i).setIDNumber(idNumber);
      supervisorArr.get(i).setName(name);
      supervisorArr.get(i).setGroup(group);
      supervisorArr.get(i).setArea(area);
      
      supervisorArr.get(i).createLeaderList(area, firstNumbers);

    } 
    
    return true;
    
  }

  public void showEmployeesList() {
    System.out.println(supervisorArr.size());
    for (int i = 0; i < supervisorArr.size(); i++) {

      // ---------------------------------------Input-------------------------------------------------
      System.out.println("\n------------------------- Supervisor(" + supervisorArr.get(i).getName() + ") [" + supervisorArr.get(i).getArea() + "] -------------------------\n");

      supervisorArr.get(i).showLeaderList();

    }
  
  }

}