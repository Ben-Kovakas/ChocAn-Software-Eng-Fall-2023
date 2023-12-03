package edu.ua.cs.cs200.project4;

/**
 * Manages the creation of all types of reports
 * 
 * @Author Javier Caldwell
 * @version 1.0
 */
public class ReportController {

	/**
	 * Generates a Summary report
	 * @return a SummaryReport
	 */
	public SummaryReport generateSummaryReport() {
		SummaryReport tempReport = new SummaryReport;
		return tempReport;
	}
	
	/**
	 * Generates a Provider report
	 * @return a ProviderReport
	 */
	public ProviderReport generateProviderReport(int ID) {
		Provider tempProvider;
		ProviderReport tempReport;
		
		getProvider(ID);
		
		tempReport = new ProviderReport(tempProvider);
		return tempReport;
	}
	
	/**
	 * Generates a Manager report
	 * @return a ManagerReport
	 */
	public void generateMemberReport(int ID) {
		Member tempMember;
		MemberReport tempReport;
		getMember(ID);
		
		tempReport = new MemberReport(tempMember);
		return tempReport;
	}
	
}
