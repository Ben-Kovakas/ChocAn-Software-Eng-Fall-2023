package edu.ua.cs.cs200.project4;

import java.util.List;

/**
 * Manages the creation of all types of reports
 * 
 * @Author Javier Caldwell
 * @version 1.0
 */
public class ReportController {
	
	SummaryReport SumReport;
	List<ProviderReport> ProReports;
	List<MemberReport> MemReports;
	

	/**
	 * Generates a Summary report
	 * @return a SummaryReport
	 */
	public SummaryReport generateSummaryReport() {
		SummaryReport tempReport = new SummaryReport();
		return tempReport;
	}
	
	/**
	 * Generates a Provider report
	 * @return a ProviderReport
	 */
	public ProviderReport generateProviderReport(int ID) {
		Provider tempProvider;
		ProviderReport tempReport;
		
		tempProvider = getProvider(ID);
		
		tempReport = new ProviderReport(tempProvider);
		return tempReport;
	}
	
	/**
	 * Generates a Manager report
	 * @return a ManagerReport
	 */
	public MemberReport generateMemberReport(int ID) {
		Member tempMember;
		MemberReport tempReport;
		
		tempMember = MemberRecords.getMember(ID);
		
		tempReport = new MemberReport(tempMember);
		return tempReport;
	}
	
	/**
	 * Generates all reports
	 *
	 */
	public void generateAllReports() {
		generateSummaryReport();
		
		ProviderReport tempReport;
		List<Provider> tempList = ProviderRecords.getAllProviders();
		
		for(int i = 0; i <tempList.size(); i++) {
			tempReport = new ProviderReport(tempList.get(i));
			ProReports.add(tempReport);
		}
		
		tempList = MemberRecords.getAllMembers();
		
		for(int i = 0; i <tempList.size(); i++) {
			tempReport = new MemberReport(tempList.get(i));
			MemReports.add(tempReport);
		}
	}
	
	public SummaryReport getSummaryReport() {
		return SumReport;
	}
	
	public List<ProviderReport> getProviderReports() {
		return ProReports;
	}
	
	public List<MemberReport> getMemberReports() {
		return MemReports;
	}
}
