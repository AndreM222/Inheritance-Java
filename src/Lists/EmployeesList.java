package Lists;

import java.util.Scanner;

import Classes.ProductionWorker;
import Classes.ShiftSupervisor;
import Classes.TeamLeader;

import java.util.ArrayList;

public class EmployeesList {

  Scanner inputSC = new Scanner(System.in);
  private int supervisorsCount;
  public ArrayList<ShiftSupervisor> supervisorArr = new ArrayList<ShiftSupervisor>();

  public boolean createEmployeesList() {

    do {

      System.out.print("Input Supervisors Amount: ");

      try {

        supervisorsCount = Integer.parseInt(inputSC.nextLine());

      } catch (NumberFormatException e) {

        System.err.println("Incorrect Input Type");

      }

    } while (supervisorsCount < 1);

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

      do {

        System.out.print("----------  Input 6 Digit ID Number: ");
        idNumber = inputSC.nextLine();

      } while (idNumber.length() != 6);

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

      System.out.printf("%n------------------------- Supervisor(%s) [%s] {%s} -------------------------%n",
          shiftRef.getName(), shiftRef.getArea(),
          shiftRef.getIDNumber());
      shiftRef.showLeaderList();

    }
  }

  public void findEmployee() {

    System.out.print("Type Employee ID: ");
    String employeeSID = inputSC.nextLine();
    System.out.print("\033[H\033[2J");

    boolean foundEmployee = false, searchFail = false;
    int position = 0, currentSupervisor, currentLeader, currentWorker;
    ShiftSupervisor uSupervisorRef = new ShiftSupervisor();
    TeamLeader uLeaderRef = new TeamLeader();

    do {

      switch (position) {

        // ---------------------------Check for supervisor--------------------------
        case 0:
          if (position == 0 && foundEmployee == false && searchFail == false) {

            for (currentSupervisor = 0; currentSupervisor < supervisorArr.size(); currentSupervisor++) {

              ShiftSupervisor supervisorRef = supervisorArr.get(currentSupervisor);
              Boolean superChildFound = (employeeSID.charAt(0) == supervisorRef.getIDNumber().charAt(0)
                  && employeeSID.charAt(1) == supervisorRef.getIDNumber().charAt(1));

              // ------------------Look for employee start

              if (employeeSID.equals(supervisorRef.getIDNumber())) {

                System.out.println(supervisorRef);
                foundEmployee = true;

              } else if (superChildFound) {

                uSupervisorRef = supervisorRef;
                position++;

              } else if (currentSupervisor == supervisorArr.size()) {

                System.out.printf("Not Found the employee: (%s)%n", employeeSID);
                searchFail = true;

              }

            }

          }

          // ------------------------------Check for leader-------------------------

        case 1:

          if (position == 1 && foundEmployee == false && searchFail == false) {

            for (currentLeader = 0; currentLeader < uSupervisorRef.leaderArr.size(); currentLeader++) {

              TeamLeader leaderRef = uSupervisorRef.leaderArr.get(currentLeader);
              Boolean leaderChildFound = employeeSID.charAt(2) == leaderRef.getIDNumber().charAt(2)
                  && employeeSID.charAt(3) == leaderRef.getIDNumber().charAt(3);

              // ------------------Look for employee middle

              if (employeeSID.equals(leaderRef.getIDNumber())) {

                System.out.println(leaderRef);
                foundEmployee = true;

              } else if (leaderChildFound) {

                uLeaderRef = leaderRef;
                position++;

              } else if (currentLeader == uSupervisorRef.leaderArr.size()) {

                System.out.printf("Not Found the employee test: (%s)%n", employeeSID);
                searchFail = true;

              }

            }

          }

          // ------------------------------Check for worker-------------------------

        case 2:

          if (position == 2 && foundEmployee == false && searchFail == false) {

            for (currentWorker = 0; currentWorker < uLeaderRef.workerArr.size(); currentWorker++) {
              
              ProductionWorker workerRef = uLeaderRef.workerArr.get(currentWorker);

              // ------------------Look for employee end

              if (employeeSID.equals(workerRef.getIDNumber())) {

                System.out.println(workerRef);
                foundEmployee = true;

              } else if (currentWorker == uLeaderRef.workerArr.size()) {

                System.out.printf("Not Found the employee: (%s)%n", employeeSID);
                searchFail = true;

              }

            }

          }

      }

    } while (foundEmployee == false && searchFail == false);

  }

}