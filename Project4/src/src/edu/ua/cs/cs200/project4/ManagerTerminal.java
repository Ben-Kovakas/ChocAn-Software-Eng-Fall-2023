package edu.ua.cs.cs200.project4;

import java.util.List;

public class ManagerTerminal {

    private ReportController reportController;

    public ManagerTerminal(ReportController reportController) {
        this.reportController = reportController;
    }

    public void requestReports() {
        if (reportController == null) {
            System.out.println("Report Controller is not initialized.");
            return;
        }
        // check the reportController status or existence here
        List<Report> reports = reportController.generateManagerReport();
        displayReports(reports);
    }

    public void displayReports(List<Report> reports) {
        if (reports == null || reports.isEmpty()) {
            System.out.println("No reports to display.");
            return;
        }

        for (Report report : reports) {
            System.out.println(report.toString());
        }
    }
    
    // NOTES: THE REPORT IS A PLACEHOLDER UNTIL FIGURED OUT
}
