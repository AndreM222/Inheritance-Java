package Classes;

import java.util.Scanner;
import java.util.ArrayList;

public class ShiftSupervisor extends Employee {


  Scanner inputSC = new Scanner(System.in);
  private int leadersCounter;
  public ArrayList<TeamLeader> leaderArr = new ArrayList<TeamLeader>();

  public void createLeaderList(String area, String firstNumbers) {

    do {

      System.out.print("---   Input Leaders Amount: ");

      try {

        leadersCounter = Integer.parseInt(inputSC.nextLine());

      } catch (NumberFormatException e) {

        System.err.println("Incorrect Input Type");

      }

    } while (leadersCounter < 1);

    for (int i = 0; i < leadersCounter; i++) {

      TeamLeader leaderRef = new TeamLeader();
      String name, group, idNumber, secondNumbers;
      char setupNumbers;

      secondNumbers = firstNumbers;

      // ---------------------------------------Input--------------------------------------------------

      System.out.printf("-------- Input Leader[%d] Information: %n", i);

      System.out.print("----------  Input Name: ");
      name = inputSC.nextLine();
      System.out.print("----------  Input Group: ");
      group = inputSC.nextLine();

      do {

        System.out.print("----------  Input 4 Digit ID Number: ");
        idNumber = inputSC.nextLine();

      } while (idNumber.length() != 4);

      for (int i2 = 2; i2 < 4; i2++) {

        setupNumbers = idNumber.charAt(i2);
        secondNumbers = secondNumbers + setupNumbers;

      }

      // -------------------------------------Clear
      // Console---------------------------------------------

      System.out.print("\033[H\033[2J");
      System.out.flush();

      // ------------------------------------------Set--------------------------------------------------

      leaderRef.setIDNumber(firstNumbers + idNumber);
      leaderRef.setName(name);
      leaderRef.setGroup(group);
      leaderRef.setArea(area);

      leaderRef.createWorkerList(group, area, secondNumbers);
      leaderArr.add(leaderRef);

    }

  }

  public void showLeaderList() {

    for (int i = 0; i < leaderArr.size(); i++) {

      TeamLeader leaderArrRef = leaderArr.get(i);
      // ---------------------------------------Input-------------------------------------------------

      System.out.printf("%n-------------------- Leader(%s) [%s]->[%s] {%s} --------------------%n",
          leaderArrRef.getName(), leaderArrRef.getArea(),
          leaderArrRef.getGroup(), leaderArrRef.getIDNumber());

      leaderArr.get(i).showWorkerList();

    }

  }

}
