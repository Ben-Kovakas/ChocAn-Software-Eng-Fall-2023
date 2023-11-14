package edu.ua.cs.cs200.project4;

import java.util.Scanner;

/**
 * This class is responsible for displaying the main menu and handling the main program logic, including startup and shutdown.
 * @author cchall5
 */
public class MainMenu {
	
	//class objects
	OperatorTerminal operatorTerminal;
    ManagerTerminal managerTerminal;
    ProviderTerminal providerTerminal;
    Timer timer;
    SystemRecords systemRecords;
	
	//main logic of program - displays main menu and handles user input
	public static void main(String[] args) {
		
		//initialize the program
		MainMenu mainMenu = new MainMenu();
		mainMenu.initialize();
		
		boolean go = true;
		while (go) {
			//display login screen
			System.out.println("Welcome to the ChocAn system!");
			System.out.println("Please choose an option:");
			System.out.println("1. Provider Terminal");
			System.out.println("2. Operator Terminal");
			System.out.println("3. Manager Terminal");
			System.out.println("4. Run Main Accounting Procedure");
			System.out.println("5. Exit");
			
			//read in an integer from user
			int input = 0;
			Scanner s = new Scanner(System.in);
			while(input < 1 || input > 5) {
				input = s.nextInt();
			}
	
			//logic for each option
			switch (input) {
				case 1:
					//provider terminal
					this.providerTerminal.main();
					break;
				case 2:
					//operator terminal
					this.operatorTerminal.main();
					break;
				case 3:
					//manager terminal
					this.managerTerminal.main();
					break;
				case 4:
					//run main accounting procedure
					this.timer.RunProcedure();
					break;
				case 5:
					//exit
					go = false;
					this.shutdown();	
					break;
			}
			s.close();
		}
		
    }
	
	//initialize the program
	public void initialize() {
		
		//TODO - persistence logic?
		
		//initialize class objects
		operatorTerminal = new OperatorTerminal();
		managerTerminal = new ManagerTerminal();
		providerTerminal = new ProviderTerminal();
		systemRecords = new SystemRecords();
		timer = new Timer();
		
    }

	//shutdown the program
    public void shutdown() {
    	//TODO - logic to shutdown program - persistence?

		System.out.println("Goodbye!");
    }
    
}
