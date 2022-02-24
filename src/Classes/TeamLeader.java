package Classes;
import java.util.Scanner;
public class TeamLeader extends Employee {

    /* ------------- Driver -----------------
    
    public TeamLeader(int idNumber, String name, String job) {
        
        System.out.println("------------------ Team Leader -------------------\n");

        super.informationInput(idNumber, name, job);

    } */
    
    Scanner inputSC = new Scanner(System.in);
    private int workersCounter;
    
    
    public void workerList(String group) {
        
        System.out.print("--------   Input Workers Amount: ");

        workersCounter = Integer.parseInt(inputSC.nextLine()); 
        
        Classes.ProductionWorker[] workerArr = new Classes.ProductionWorker[workersCounter];
        
        for (int i = 0; i < workerArr.length; i++) {

            workerArr[i] = new ProductionWorker();
        
            System.out.println("\n----------Input Worker[" + i + "] Information: ----------\n----------");

            System.out.print("----------  Input Name: ");
            String name = inputSC.nextLine();
            System.out.print("----------  Input ID Number: ");
            int idNumber = inputSC.nextInt();
            
            workerArr[i].setIDNumber(idNumber);
            workerArr[i].setName(name);
            workerArr[i].setGroup(group);

        }

    }

}
