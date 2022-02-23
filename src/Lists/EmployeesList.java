package Lists;

import java.util.Scanner;

public class EmployeesList {

    Scanner inputSC = new Scanner(System.in);
    private int supervisorsCount;
    
    public EmployeesList() {
        
        System.out.print("Input Supervisors Amount: ");

        supervisorsCount = Integer.parseInt(inputSC.nextLine());
    
        Classes.ShiftSupervisor[] supervisorArr = new Classes.ShiftSupervisor[supervisorsCount];

        for (int i = 0; i < supervisorArr.length; i++) {

            System.out.println("\n--Input Supervisor[" + i + "] Information: --\n--");

            System.out.print("--  Input Name: ");
            String name = inputSC.nextLine();
            System.out.print("--  Input Group: ");
            String group = inputSC.nextLine();
            System.out.print("--  Input ID Number: ");
            int idNumber = inputSC.nextInt();
            
            supervisorArr[i].setIDNumber(idNumber);
            supervisorArr[i].setName(name);
            supervisorArr[i].setGroup(group);
            
            supervisorArr[i].leaderList();

        }

    }

}
