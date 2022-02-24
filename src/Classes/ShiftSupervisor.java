package Classes;
import java.util.Scanner;
public class ShiftSupervisor extends Employee {
    
    Scanner inputSC = new Scanner(System.in);
    private int leadersCounter;
    
    public void leaderList() {
        
        System.out.println("Test-----------------------------------------------------------------------------");  
        System.out.print("---   Input Leaders Amount: ");
        
        leadersCounter = Integer.parseInt(inputSC.nextLine()); 
        Classes.TeamLeader[] leaderArr = new Classes.TeamLeader[leadersCounter];

        for (int i = 0; i < leaderArr.length; i++) {

            leaderArr[i] = new TeamLeader();

          //---------------------------------------Input--------------------------------------------------  

            System.out.println("\n-----Input Leader[" + i + "] Information: -----\n-----");

            System.out.print("-----  Input Name: ");
            String name = inputSC.nextLine();
            System.out.print("-----  Input Group: ");
            String group = inputSC.nextLine();
            System.out.print("-----  Input ID Number: ");
            int idNumber = inputSC.nextInt();  
            
          //-------------------------------------Clear Console--------------------------------------------- 

            System.out.print("\033[H\033[2J");
            System.out.flush();

          //------------------------------------------Set--------------------------------------------------  

            leaderArr[i].setIDNumber(idNumber);
            leaderArr[i].setName(name);
            leaderArr[i].setGroup(group);
            
            leaderArr[i].workerList(group);
 
        }

        for (int i = 0; i < leaderArr.length; i++) {

            System.out.println("---------- " + leaderArr[i].getName() + "(" + leaderArr[i].getIDNumber() + ")" + "Group: " + leaderArr[i].getGroup());

            for (int i2 = 0; i2 < leaderArr.length; i2++){}

        }

    }

}
