package edu.ua.cs.cs200.project4;

public class ManagerTerminal {

    private ReportController reportController; 

    public ManagerTerminal(ReportController reportController) {
        this.reportController = reportController;
    }

    public void requestReport() {
        // check if the ReportController is available and ready
        if (reportController == null) {
            
            System.out.println("Report Controller is not available.");
            return;
        }

        // Trigger the report generation process.
        reportController.generateManagerReport();
        //  handle any exceptions that could be thrown by the generateManagerReport method.

        // Or handle the return value or status from the report generation.
    
    }

    public void displayReports(List<Report> reports) {
        // Check if reports list is not null or empty.
        if (reports == null || reports.isEmpty()) {
            System.out.println("No reports available to display.");
            return;
        }

        // Logic to display reports.
        for (Report report : reports) {
            System.out.println(report); // Assuming the Report class has a sensible toString() implementation.
        }
    }

 
}
