package edu.ua.cs.cs200.project4;

import java.util.List;

public class MemberReport {
	private List<ServiceRecord> service;
	private Member member;
	
	//CHANGE member should have list of services in itself.
	public MemberReport(List<ServiceRecord> ServiceRecords, Member newMember) {
		service = ServiceRecords;
		member = newMember;
	}
	
	public ServiceRecord getMemberService(String memberName){
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
	
	public ServiceRecord getMemberService(int memberNumber){
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
