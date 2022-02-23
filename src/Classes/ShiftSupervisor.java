package Classes;
import java.util.Scanner;
public class ShiftSupervisor extends Employee {

    /* ------------- Driver -----------------

    public ShiftSupervisor(int idNumber, String name, String job) {
        
        System.out.println("------------------ Shift Supervisor -------------------\n");
        
        super.informationInput(idNumber, name, job);
            
    } */
    
    
    Scanner inputSC = new Scanner(System.in);
    private int leadersCounter;
    
    public void leaderList() {
        
        System.out.println("Test-----------------------------------------------------------------------------");  
        System.out.print("---   Input Leaders Amount: ");
        
        leadersCounter = Integer.parseInt(inputSC.nextLine()); 
    
        Classes.TeamLeader[] leaderArr = new Classes.TeamLeader[leadersCounter];

        for (int i = 0; i < leaderArr.length; i++) {

            System.out.println("\n-----Input Leader[" + i + "] Information: -----\n-----");

            System.out.print("-----  Input Name: ");
            String name = inputSC.nextLine();
            System.out.print("-----  Input Group: ");
            String group = inputSC.nextLine();
            System.out.print("-----  Input ID Number: ");
            int idNumber = inputSC.nextInt();  
            
            leaderArr[i].setIDNumber(idNumber);
            leaderArr[i].setName(name);
            leaderArr[i].setGroup(group);
            
            leaderArr[i].workerList(group);;

        }

    }

}
