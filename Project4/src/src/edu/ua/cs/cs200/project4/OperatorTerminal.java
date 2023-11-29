package edu.ua.cs.cs200.project4;

import java.util.Scanner;

/**
 * @author cchall5
 */
public class OperatorTerminal {
	
	static OperatorTerminal operatorTerminal = new OperatorTerminal();
	UpdateMemberController memberController;
	UpdateProviderController providerController;

  public static void main(String[] args) {
	
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
			operatorTerminal.updateMemberRecords();
			break;
		case 2:
			operatorTerminal.updateProviderRecords();
			break;
		case 3:
			go = false;
			break;
		}
		
		s.close();
	}

  }
  
  public void updateMemberRecords() {
	  memberController = new UpdateMemberController();
  }
  
  public void updateProviderRecords() {
	  providerController = new UpdateProviderController();
  }

}