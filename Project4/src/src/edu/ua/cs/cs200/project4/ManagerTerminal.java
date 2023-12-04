package edu.ua.cs.cs200.project4;

import java.util.Scanner;

/**
 * The {@code ManagerTerminal} class represents the interface for the system manager.
 * It allows a manager to generate various reports about the state of the ChocAn system.
 * 
 * @author rmmilsap
 */
public class ManagerTerminal {

    private ReportController reportController;

    /**
     * Constructs a {@code ManagerTerminal} and initializes the associated {@code ReportController}.
     */
    public ManagerTerminal() {
        reportController = new ReportController();
    }

    /**
     * The main method that invokes the report request method.
     * It acts as an entry point for the manager's interactions.
     */
    public void main() {
        requestReport();
    }

    /**
     * Displays a menu for the manager to generate specific reports.
     * Handles the user input to select the type of report to generate.
     */
    public void requestReport() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        do {
            System.out.println("\n--- Manager Terminal ---");
            System.out.println("Please choose an option:");
            System.out.println("1. Generate Summary Report");
            System.out.println("2. Generate Provider Report");
            System.out.println("3. Generate Member Report");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    reportController.generateSummaryReport();
                    break;
                case 2:
                    System.out.print("Enter Provider ID: ");
                    int providerID = scanner.nextInt();
                    reportController.generateProviderReport(providerID);
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    int memberID = scanner.nextInt();
                    reportController.generateMemberReport(memberID);
                    break;
                case 4:
                    System.out.println("Exiting Manager Terminal.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (input != 4);

        scanner.close();
        }

    
}
