package edu.ua.cs.cs200.project4;

import java.util.Scanner;

public class ProviderTerminal {
    
	//Classes
	private ProviderTerminal providerTerminal = new providerTerminal();
	private ProviderController providerController = new providerController();
}

// Main logic for the ProviderTerminal class
public static void main(String args[]) {
	
	ProviderTerminal providerTerminal = new ProviderTerminal()
	providerTerminal.startTerminal();
	
	public void startTerminal() {
	
		boolean go = true;
		while (go) {
			//display provider terminal
			System.out.println("Welcome to the ChocAn Provider Terminal!");
			System.out.println("Please choose an option:");
			System.out.println("1. Validate Member");
			System.out.println("2. Bill ChocAn");
			System.out.println("3. Request Provider Directory");
			System.out.println("4. Exit");
		
			//read in an integer from user
			int input = 0;
			Scanner s = new Scanner(System.in);
			while(input < 1 || input > 5) {
				input = s.nextInt();
			}
		
			//handle user input
			switch (input) {
			case 1:
				validateMember();
				break;
			case 2:
				billChocAn();
				break;
			case 3:
				requestProviderDirectory()
				break;
			case 4: //Return to main menu??
				go = false;
				break;
			}
		
			s.close();
		} 
	}
	
	public void validateMemeber() {
		providerController.main();
	}
	
	public void billChocAn() {
		providerController.main();
	}
	
	public void requestProviderDirectory() {
		providerController.main();
	}
}
