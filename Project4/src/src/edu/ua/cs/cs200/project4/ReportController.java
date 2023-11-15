package edu.ua.cs.cs200.project4;

public class ReportController {

	public void generateSummaryReport() {
		
	}
	
	public ProviderReport generateProviderReport(int ID) {
		Provider tempProvider;
		ProviderReport tempReport;
		
		getProvider(ID);
		
		tempReport = new ProviderReport(tempProvider);
		return tempReport;
	}
	
	public void generateMemberReport(int ID) {
		Member tempMember;
		MemberReport tempReport;
		getMember(ID);
		
		tempReport = new MemberReport(tempMember);
		return tempReport;
	}
	
	public void generateEFTReport() {
		
	}
	
	public void generateAllReports() {
		//open all reports individuallly
			//repeat steps as above, for each report
			//Maybe return list of reports?
		
		for(int i = 0, i </*providerRecords list size*/; i++) {
			
		}
	}
	
}
