package edu.ua.cs.cs200.project4;

/**
 * This class is responsible for running the main accounting procedure.
 * @author cchall5
 */
public class Timer {
	
	ReportController reportController;
	
	//runs the main accounting procedure, generating all reports
	public void RunProcedure() {
		
		reportController = new ReportController();
		reportController.generateAllReports();
		
	}
	
}
