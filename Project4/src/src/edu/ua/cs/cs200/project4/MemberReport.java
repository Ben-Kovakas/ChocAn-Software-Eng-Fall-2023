package edu.ua.cs.cs200.project4;

import java.util.List;

public class MemberReport {
	private List<ServiceRecord> service;
	
	public MemberReport(List<ServiceRecord> ServiceRecords) {
		service = ServiceRecords;
	}
	
	public ServiceRecord getMemberReport(String memberName){
		ServiceRecord tempService;
		
		for(int i = 0; i < service.size(); i++) {
			tempService = service.get(i);
			
			if(tempService.getMemberName() == memberName) {
			  System.out.println("hello");
				return tempService;
			}
		}
		
		return null;

	}
	
	public ServiceRecord getMemberReport(int memberNumber){
		ServiceRecord tempService;
		
		for(int i = 0; i < service.size(); i++) {
			tempService = service.get(i);
			
			if(tempService.getMemberNumber() == memberNumber) {
				return tempService;
			}
		}
		
		return null;

	}
	
}
