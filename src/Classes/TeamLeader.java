package Classes;

import java.util.Scanner;
import java.util.ArrayList;

public class TeamLeader extends Employee {

  Scanner inputSC = new Scanner(System.in);
  private int workersCounter;
  ArrayList<Classes.ProductionWorker> workerArr = new ArrayList<Classes.ProductionWorker>();

  public void createWorkerList(String group, String area, String secundaryID) {

    System.out.print("--------   Input Workers Amount: ");

    Classes.ProductionWorker workerRef = new Classes.ProductionWorker();
    workersCounter = inputSC.nextInt();

    for (int i = 0; i < workersCounter; i++) {

      workerArr.add(workerRef);
      
      // ---------------------------------------Input-------------------------------------------------
      
      System.out.println("\n----------Input Worker[" + i + "] Information: ----------\n----------");
      
      System.out.print("----------  Input Name: ");
      String name = inputSC.nextLine();
      System.out.print("----------  Input 2 Digit ID Number: ");
      String idNumber = inputSC.nextLine();
      
      // -------------------------------------Clear
      // Console---------------------------------------------
      
      System.out.print("\033[H\033[2J");
      System.out.flush();
      
      // ------------------------------------------Set--------------------------------------------------
      
      workerArr.get(i).setIDNumber(secundaryID + idNumber);
      workerArr.get(i).setName(name);
      workerArr.get(i).setGroup(group);
      workerArr.get(i).setArea(area);
      
    }

  }

  public void showWorkerList() {

    for (int i = 0; i < workerArr.size(); i++) {

      // ---------------------------------------Input-------------------------------------------------

      System.out.println("\n--------------- Worker(" + workerArr.get(i).getName() + ")\n");

      System.out.println(workerArr.get(i));

    }

  }

}
