package Lists;

import java.util.Scanner;

public class TerminalStart {

    EmployeesList employeesList = new EmployeesList();
    String[] commandList = new String[7];
    Scanner inputSC = new Scanner(System.in);
    String inputCommand;

    public TerminalStart() {

        // ---- commands

        commandList[0] = "help";
        commandList[1] = "create";
        commandList[2] = "exit";
        commandList[3] = "show list";
        commandList[4] = "find";
        commandList[5] = "clear";
        commandList[6] = "add";

    }

    public void startTerminal() {

        System.out.println("---------- Type ( help ) For List Of Commands ----------");

        inputCommand = inputSC.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        if (inputCommand.equals(commandList[0])) {

            System.out.println("------------------- All Commands ------------------------");

            for (int i = 0; i < commandList.length; i++) {

                System.out.println("\n- " + commandList[i]);

            }

            inputCommand = inputSC.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();

        } else if (inputCommand.equals(commandList[1])) {

            if (employeesList.createEmployeesList()) { startTerminal(); }

        } else if (inputCommand.equals(commandList[2])) {

            System.out.println("Exiting..... ");

        } else if (inputCommand.equals(commandList[3])) {

            employeesList.showEmployeesList();
            System.out.print("------Enter To Return------");
            inputCommand = inputSC.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            startTerminal();

        } else if (inputCommand.equals(commandList[4])) {

            employeesList.findEmployee();
            System.out.print("------Enter To Return------");
            inputCommand = inputSC.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            startTerminal();

        } else if (inputCommand.equals(commandList[5])){

            startTerminal();
            
        } else {

            startTerminal();

        }

        inputSC.close();

    }

}
