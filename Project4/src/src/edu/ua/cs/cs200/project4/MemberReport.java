package edu.ua.cs.cs200.project4;

import java.util.List;

/**
 * Creates a Member Report
 * 
 * @Author Javier Caldwell
 * @version 1.0
 */
public class MemberReport {
	
	private List<ServiceRecord> services;
	
	private Member member;
	
	/** Constructor. Creates the Member Report using a member
	 * @param  newMember
	 * 					the inputed member
	 * */
	public MemberReport(Member newMember) {
		services = newMember.getServiceRecords();
		member = newMember;
	}
	
	/**
	 * Gets the service records
	 * @return a List of ServiceRecords
	 */
	public List<ServiceRecord> getMemberServices(){
		return services;
	}
	
}
