package Classes;

import java.util.Scanner;
import java.util.ArrayList;

public class ShiftSupervisor extends Employee {
  
  Scanner inputSC = new Scanner(System.in);
  private int leadersCounter;
  ArrayList<Classes.TeamLeader> leaderArr = new ArrayList<Classes.TeamLeader>();
  
  public void createLeaderList(String area) {
    
    System.out.print("---   Input Leaders Amount: ");
    
    Classes.TeamLeader leaderRef = new Classes.TeamLeader();
    leadersCounter = inputSC.nextInt(); 
    
    
    for (int i = 0; i < leadersCounter; i++) {
      
        leaderArr.add(leaderRef);
        
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
        
        leaderArr.get(i).setIDNumber(idNumber);
        leaderArr.get(i).setName(name);
        leaderArr.get(i).setGroup(group);
        leaderArr.get(i).setArea(area);
        
        leaderArr.get(i).createWorkerList(group, area);
        
      }
    }
    
    public void showLeaderList() {
      
      for (int i = 0; i < leaderArr.size(); i++) {
        
        // ---------------------------------------Input-------------------------------------------------
        
        System.out.println("\n-------------------- Leader(" + leaderArr.get(i).getName() + ") [" + leaderArr.get(i).getArea() + "]->[" + leaderArr.get(i).getGroup() + "] ID: " + leaderArr.get(i).getIDNumber() + " --------------------\n");
        
        leaderArr.get(i).showWorkerList();
        
      }
      
    }

  }
  