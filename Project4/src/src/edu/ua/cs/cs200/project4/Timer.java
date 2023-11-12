package edu.ua.cs.cs200.project4;

public class Timer {
	
	ReportController reportController;
	
	public void RunProcedure() {
		
		reportController = new ReportController();
		reportController.generateAllReports();
		
	}
	
}
