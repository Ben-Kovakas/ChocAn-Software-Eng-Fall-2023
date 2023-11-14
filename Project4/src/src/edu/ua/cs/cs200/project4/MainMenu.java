package edu.ua.cs.cs200.project4;

import java.util.Scanner;

/**
 * This class is responsible for displaying the main menu and handling the main program logic, including startup and shutdown.
 * @author cchall5
 */
public class MainMenu {
	
	//class objects
	static OperatorTerminal operatorTerminal;
	static ManagerTerminal managerTerminal;
	static ProviderTerminal providerTerminal;
	static Timer timer;
    SystemRecords systemRecords;
	
	//main logic of program - displays main menu and handles user input
	public static void main(String[] args) {
		
		//initialized when the program is started since this is the main function
	    //still need to call methods later to load persistence characteristics 
		
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
					providerTerminal = new ProviderTerminal();
					break;
				case 2:
					//operator terminal
					operatorTerminal = new OperatorTerminal();
					break;
				case 3:
					//manager terminal
					managerTerminal = new ManagerTerminal();
					break;
				case 4:
					//run main accounting procedure
					timer = new Timer();
					timer.RunProcedure();
					break;
				case 5:
					//exit
					go = false;
					shutdown();	
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
    public static void shutdown() {
    	//TODO - logic to shutdown program - persistence?

		System.out.println("Goodbye!");
    }
    
}
