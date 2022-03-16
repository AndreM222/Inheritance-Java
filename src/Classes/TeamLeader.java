package Classes;

import java.util.Scanner;
import java.util.ArrayList;

public class TeamLeader extends Employee {

  Scanner inputSC = new Scanner(System.in);
  private int workersCounter;
  private String idNumber, name;
  public ArrayList<Classes.ProductionWorker> workerArr = new ArrayList<Classes.ProductionWorker>();

  public void createWorkerList(String group, String area, String secundaryID) {

    
    do {
      
      System.out.print("--------   Input Workers Amount: ");
      
      try {

        workersCounter = Integer.parseInt(inputSC.nextLine());

      } catch (NumberFormatException e) {

        System.err.println("Incorrect Input Type");

      }

      
    } while (workersCounter < 1);
    
    for (int i = 0; i < workersCounter; i++) {
      
      Classes.ProductionWorker workerRef = new Classes.ProductionWorker();
      
      // ---------------------------------------Input-------------------------------------------------
      
      System.out.printf("-------- Input Worker[%d] Information: %n", i);
      
      System.out.print("----------  Input Name: ");
      name = inputSC.nextLine();
      
      do {
        
        System.out.print("----------  Input 2 Digit ID Number: ");
        idNumber = inputSC.nextLine();

      } while (idNumber.length() != 2);
      
      // -------------------------------------Clear
      // Console---------------------------------------------
      
      System.out.print("\033[H\033[2J");
      System.out.flush();
      
      // ------------------------------------------Set--------------------------------------------------
      
      workerRef.setIDNumber(secundaryID + idNumber);
      workerRef.setName(name);
      workerRef.setGroup(group);
      workerRef.setArea(area);
      
      workerArr.add(workerRef);

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
