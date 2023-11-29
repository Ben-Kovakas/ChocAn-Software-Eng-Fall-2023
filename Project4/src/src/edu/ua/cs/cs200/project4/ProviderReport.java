package edu.ua.cs.cs200.project4;

public class ProviderReport {
	
	private Provider provider;
	
	private int totalConsultions;
	
	private double totalFees;
		
	/** Constructor. Creates the Provider Report with the service records.
	 * 
	 * @Param tempProvider
	 * 					The inputed Provider
	 * 
	 * */
	public ProviderReport(Provider tempProvider) {
		provider = tempProvider;
		totalConsultations = provider.getConsultations();
		
		List<ServiceRecord> tempService = provider.getServiceRecords();
		
		for(int i = 0; i < tempService.size(); i++) {
			totalFees = totalFees + tempService.get(i).getFee();
		}		
	}	
	
	public Provider getProvider() {
		return provider;
	}
	
	public int getTotalConsultations() {
		return totalConsultions;
	}
	
	public double getTotalFees() {
		return totalFees;
	}


}
