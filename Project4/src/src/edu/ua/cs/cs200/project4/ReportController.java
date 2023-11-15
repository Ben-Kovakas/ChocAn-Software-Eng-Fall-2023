package edu.ua.cs.cs200.project4;

public class ReportController {

	public void generateSummaryReport(String name) {
		
	}
	
	//maybe add version for ID number
	public ProviderReport generateProviderReport(String name) {
		//find Provider
			//use Provider object to create report using report class
				//return report
		Provider tempProvider;
		ProviderReport tempReport;
		boolean checker;
		//Providers: provider list
		for(int i = 0, i </*providerRecords list size*/; i++) {
			if(providers.get(i).getName() == name) {
				tempProvider = providers.get(i);
				checker = true;
			}
		}
		
		if(checker) {
			tempReport = new ProviderReport(tempProvider);
			return tempReport;
		} else {
			//maybe output saying provider not found?
			return null;	
		}
		
		
	}
	
	public void generateMemberReport(String name) {
		//find Member
			//use Member object to create report using report class
				//return report
		Member tempMember;
		MemberReport tempReport;
		boolean checker;
		//Members: member list
		for(int i = 0; i < /*memberRecords list size*/; i++) {
			if(members.get(i).getName() == name) {
				tempMember = members.get(i);
				checker = true;
			}
		}
		
		if(checker) {
			tempReport = new MemberReport(tempMember);
			return tempReport;
		} else {
			return null;
		}
	}
	
	public void generateAllReports() {
		//open all reports individuallly
			//repeat steps as above, for each report
			//Maybe return list of reports?
		
		for(int i = 0, i </*providerRecords list size*/; i++) {
			
		}
	}
	
}
