package Classes;
import java.util.Scanner;
public class TeamLeader extends Employee {
    
    Scanner inputSC = new Scanner(System.in);
    private int workersCounter;
    
    
    public void workerList(String group) {
        
        System.out.print("--------   Input Workers Amount: ");

        workersCounter = Integer.parseInt(inputSC.nextLine()); 
        Classes.ProductionWorker[] workerArr = new Classes.ProductionWorker[workersCounter];
        
        for (int i = 0; i < workerArr.length; i++) {

            workerArr[i] = new ProductionWorker();
        
          //---------------------------------------Input-------------------------------------------------  

            System.out.println("\n----------Input Worker[" + i + "] Information: ----------\n----------");

            System.out.print("----------  Input Name: ");
            String name = inputSC.nextLine();
            System.out.print("----------  Input ID Number: ");
            int idNumber = inputSC.nextInt();
            
          //-------------------------------------Clear Console---------------------------------------------  

            System.out.print("\033[H\033[2J");
            System.out.flush();

          //------------------------------------------Set--------------------------------------------------   

            workerArr[i].setIDNumber(idNumber);
            workerArr[i].setName(name);
            workerArr[i].setGroup(group);

        }

    }

}
