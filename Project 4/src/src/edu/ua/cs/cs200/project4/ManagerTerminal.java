package edu.ua.cs.cs200.project4;

import java.util.Scanner;

//Class that interacts with the manager
public class ManagerTerminal {

    private ReportController reportController;

    
    //constructor for ManagerTerminal, and initializes the ReportController
    public ManagerTerminal() {
        reportController = new ReportController();
    }
//main - calls the requestReport
    public void main() {
        requestReport(); 
    }
//Presents the report generation menu to the manager 
    public void requestReport() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        
//Loop until the manager decides to exit
        do {
        	//display the option menu
            System.out.println("\n--- Manager Terminal ---");
            System.out.println("Please choose an option:");
            System.out.println("1. Generate Summary Report");
            System.out.println("2. Generate Provider Report");
            System.out.println("3. Generate Member Report");
            System.out.println("4. Exit");

            //get user input
            System.out.print("Enter choice: ");
            input = scanner.nextInt();
// switch statement in order to go with what the user selects
            switch (input) {
                case 1:
                	// gen the summary report
                    reportController.generateSummaryReport();
                    break;
                    
                case 2:
                	//gen the provider report
                	System.out.print("Enter Provider ID: ");
                	int providerID = 0;
                    providerID = scanner.nextInt();
                    reportController.generateProviderReport(providerID);
                    break;
                    
                case 3:
                	//gen the member report
                	
                	System.out.print("Enter Member ID: ");
                	int memberID = 0;
                    memberID = scanner.nextInt();
                    reportController.generateMemberReport(memberID);
                    break;
                
              
                case 4:
                    System.out.println("Exiting Manager Terminal.");
                    break;
                default:
                	//handle invalids
                    System.out.println("Invalid option. Please try again.");
            }
        } while (input != 4);

        scanner.close();        
      
    }
}