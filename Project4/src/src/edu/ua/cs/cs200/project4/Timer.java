package edu.ua.cs.cs200.project4;

/**
 * This class is responsible for running the main accounting procedure.
 * @author cchall5
 */
public class Timer {
	
	ReportController reportController;
	
	public void RunProcedure() {
		
		reportController = new ReportController();
		reportController.generateAllReports();
		
	}
	
}
