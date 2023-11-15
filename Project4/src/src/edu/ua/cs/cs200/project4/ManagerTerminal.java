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
            System.out.println("4. Generate EFT Report");
            System.out.println("5. Generate All Reports");
            System.out.println("6. Exit");

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
                    reportController.generateProviderReport();
                    break;
                    
                case 3:
                	//gen the member report
                    reportController.generateMemberReport();
                    break;
                
                case 4:
                	//gen all reports
                    reportController.generateAllReports();
                    break;
                case 5:
                    System.out.println("Exiting Manager Terminal.");
                    break;
                default:
                	//handle invalids
                    System.out.println("Invalid option. Please try again.");
            }
        } while (input != 5);

        
        //not closing scanner so it doesnt affect other parts of program
      
    }
}