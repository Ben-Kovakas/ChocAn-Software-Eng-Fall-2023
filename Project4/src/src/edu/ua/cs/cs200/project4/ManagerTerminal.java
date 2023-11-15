package edu.ua.cs.cs200.project4;

import java.util.Scanner;

public class ManagerTerminal {

    private ReportController reportController;

    public ManagerTerminal() {
        reportController = new ReportController();
    }

    public void main() {
        requestReport(); 
    }

    public void requestReport() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        do {
            System.out.println("\n--- Manager Terminal ---");
            System.out.println("Please choose an option:");
            System.out.println("1. Generate Summary Report");
            System.out.println("2. Generate Provider Report");
            System.out.println("3. Generate Member Report");
            System.out.println("4. Generate EFT Report");
            System.out.println("5. Generate All Reports");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    reportController.generateSummaryReport();
                    break;
                case 2:
                    reportController.generateProviderReport();
                    break;
                case 3:
                    reportController.generateMemberReport();
                    break;
                
                case 4:
                    reportController.generateAllReports();
                    break;
                case 5:
                    System.out.println("Exiting Manager Terminal.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (input != 5);

      
    }
}