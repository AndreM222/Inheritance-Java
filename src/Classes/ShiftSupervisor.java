package Classes;

import java.util.Scanner;
import java.util.ArrayList;

public class ShiftSupervisor extends Employee {

  Scanner inputSC = new Scanner(System.in);
  private int leadersCounter;
  ArrayList<Classes.TeamLeader> leaderArr = new ArrayList<Classes.TeamLeader>();
  
  public void createLeaderList(String area, String firstNumbers) {
    
    System.out.print("---   Input Leaders Amount: ");
    // 
    Classes.TeamLeader leaderRef = new Classes.TeamLeader();
    leadersCounter = inputSC.nextInt();
    
    for (int i = 0; i < leadersCounter; i++) {
      
      String name, group, idNumber, secondNumbers;
      char setupNumbers;

      secondNumbers = firstNumbers;
      leaderArr.add(leaderRef);

      // ---------------------------------------Input--------------------------------------------------

      System.out.println("\n-----Input Leader[" + i + "] Information: -----\n-----");

      System.out.print("-----  Input Name: ");
      name = inputSC.nextLine();
      System.out.print("-----  Input Group: ");
      group = inputSC.nextLine();
      System.out.print("-----  Input 4 Digit ID Number: ");
      idNumber = inputSC.nextLine();

      for (int i2 = 2; i2 < 4; i2++) {

        setupNumbers = idNumber.charAt(i2);
        secondNumbers = secondNumbers + setupNumbers;

      }

      // -------------------------------------Clear
      // Console---------------------------------------------

      System.out.print("\033[H\033[2J");
      System.out.flush();

      // ------------------------------------------Set--------------------------------------------------

      leaderArr.get(i).setIDNumber(firstNumbers + idNumber);
      leaderArr.get(i).setName(name);
      leaderArr.get(i).setGroup(group);
      leaderArr.get(i).setArea(area);
      
      leaderArr.get(i).createWorkerList(group, area, secondNumbers);

    }

  }

  public void showLeaderList() {

    for (int i = 0; i < leaderArr.size(); i++) {

      // ---------------------------------------Input-------------------------------------------------

      System.out.println(

        "\n-------------------- Leader(" + leaderArr.get(i).getName() + ") [" + leaderArr.get(i).getArea() + "]->["
        + leaderArr.get(i).getGroup() + "] ID: " + leaderArr.get(i).getIDNumber() + " --------------------\n"
        
      );

      leaderArr.get(i).showWorkerList();

    }

  }

}
