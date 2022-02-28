package Lists;
import java.util.Scanner;

public class TerminalStart {
    
    EmployeesList employeesList = new EmployeesList();
    String[] commandList = new String[5];
    Scanner inputSC = new Scanner(System.in);
    
    public void startTerminal() {
        
        String inputCommand;

        // ---- commands
        
        System.out.println("---------- Type ( help ) For List Of Commands ----------");

        commandList[0] = "help";
        commandList[1] = "create";
        commandList[2] = "exit";
        commandList[3] = "show list";
        commandList[4] = "show";

        inputCommand = inputSC.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        if(inputCommand.equals(commandList[0])){

            System.out.println("------------------- All Commands ------------------------");
            
            for(int i = 0; i < commandList.length; i++){

                System.out.println("\n- " + commandList[i]);
                
            }
            
            System.out.println("------Enter To Return------");
            inputCommand = inputSC.nextLine();
            startTerminal();

        } else if (inputCommand.equals(commandList[1])) {

            employeesList.createEmployeesList();

        } else if(inputCommand.equals(commandList[2])){

            System.out.println("Exiting..... "); 
            
        } else if(inputCommand.equals(commandList[3])){ 
            
            // employeesList.showEmployeesList();
            System.out.println(employeesList.supervisorArr); 
            System.out.println("------Enter To Return------");
            inputCommand = inputSC.nextLine();
            startTerminal();
        
        } else { startTerminal(); }

        inputSC.close();

    }

}
