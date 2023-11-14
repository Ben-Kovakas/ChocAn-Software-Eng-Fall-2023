package edu.ua.cs.cs200.project4;

import java.util.Scanner;

/**
 * @author cchall5
 */
public class OperatorTerminal {
	
	OperatorTerminal operatorTerminal;
	UpdateMemberController memberController;
	UpdateProviderController providerController;

  public static void main(String[] args) {
	  
	//initialize new objects
   	operatorTerminal = new OperatorTerminal();
	memberController = new UpdateMemberController();
	providerController = new UpdateProviderController();
	
	//operator terminal menu
	boolean go = true;
	while (go) {
		
		//display menu
		System.out.println("Welcome to the ChocAn Operator Terminal!");
		System.out.println("Please choose an option:");
		System.out.println("1. Update Member");
		System.out.println("2. Update Provider");
		System.out.println("3. Exit");
		
		//read in an integer from user
		int input = 0;
		Scanner s = new Scanner(System.in);
		while(input < 1 || input > 3) {
			input = s.nextInt();
		}
		
		//handle user input
		switch (input) {
		case 1:
			updateMemberRecords();
			break;
		case 2:
			updateProviderRecords();
			break;
		case 3:
			go = false;
			break;
		}
		
		s.close();
	}

  }
  
  public void updateMemberRecords() {
	  memberController.main();
  }
  
  public void updateProviderRecords() {
	  providerController.main();
  }

}