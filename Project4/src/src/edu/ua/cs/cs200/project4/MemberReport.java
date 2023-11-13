package edu.ua.cs.cs200.project4;

import java.util.List;

public class MemberReport {
	
	private Member Member;
	private List<ServiceRecords> service;
	
	public MemberReport(List<ServiceRecords> ServiceRecords) {
		service = ServiceRecords;
	}
	
	public ServiceRecords getMemberReport(String memberName){
		ServiceRecord tempService;
		
		for(int i = 0; i < service.size(); i++) {
			ServiceRecord tempService = service.get(i);
			
			if(tempService.getMemberName() == memberName) {
				return tempService;
			}
		}
		
		return null;

	}
	
	public ServiceRecords getMemberReport(int memberNumber){
		ServiceRecord tempService;
		
		for(int i = 0; i < service.size(); i++) {
			ServiceRecord tempService = service.get(i);
			
			if(tempService.getMemberNumber() == memberNumber) {
				return tempService;
			}
		}
		
		return null;

	}
	
}
