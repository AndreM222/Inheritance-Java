package Lists;
import java.util.Scanner;

public class TerminalStart {
    
    public void startTerminal() {
        
        EmployeesList employeesList = new EmployeesList();
        Scanner inputSC = new Scanner(System.in);
        String[] commandList = new String[5];
        String inputCommand;

        // ---- commands
        
        System.out.println("---------- Type ( help ) For List Of Commands ----------");

        commandList[0] = "help";
        commandList[1] = "createl";
        commandList[2] = "adde";
        commandList[3] = "showl";
        commandList[4] = "exit";

        inputCommand = inputSC.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        if(inputCommand.equals(commandList[0])){

            System.out.println("------------------- All Commands ------------------------");
            
            for(int i = 0; i < commandList.length; i++){

                System.out.println(commandList[i]);
                
            }
            
            System.out.println("------Enter To Return------");
            inputCommand = inputSC.nextLine();
            startTerminal();

        } else if (inputCommand.equals(commandList[1])) {

            employeesList.createEmployeesList();

        } else if(inputCommand.equals(commandList[4])){ 
            
            System.out.println("Exiting..... "); 
        
        } else { startTerminal(); }

        inputSC.close();

    }

}
