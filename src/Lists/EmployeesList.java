package Lists;

import java.util.Scanner;

import Classes.ShiftSupervisor;

public class EmployeesList {

    Scanner inputSC = new Scanner(System.in);
    private int supervisorsCount;
    
    public EmployeesList() {
        
        System.out.print("Input Supervisors Amount: ");

        supervisorsCount = Integer.parseInt(inputSC.nextLine());
        Classes.ShiftSupervisor[] supervisorArr = new Classes.ShiftSupervisor[supervisorsCount];

        for (int i = 0; i < supervisorArr.length; i++) {

            supervisorArr[i] = new ShiftSupervisor();

          //---------------------------------------Input-------------------------------------------------  

            System.out.println("\n--Input Supervisor[" + i + "] Information: --\n--");

            System.out.print("--  Input Name: ");
            String name = inputSC.nextLine();
            System.out.print("--  Input Group: ");
            String group = inputSC.nextLine();
            System.out.print("--  Input ID Number: ");
            int idNumber = inputSC.nextInt();
            
          //-------------------------------------Clear Console---------------------------------------------  
            
            System.out.print("\033[H\033[2J");
            System.out.flush();

          //------------------------------------------Set--------------------------------------------------   

            supervisorArr[i].setIDNumber(idNumber);
            supervisorArr[i].setName(name);
            supervisorArr[i].setGroup(group);
            
            supervisorArr[i].leaderList();

        }

    }

}
