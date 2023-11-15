package edu.ua.cs.cs200.project4;


public class SummaryReport {
	
	private int totalProviders;
	
	private int totalConsultions;
	
	private double totalFees;
	
	/** Constructor. Creates the Summary Report
	 * 
	 *
	 * 
	 * */
	public void SummaryReport() {
		
		totalProviders = 0;
		totalConsultations = 0;
		totalFees = 0;
		
		List<Provider> tempProviderList = getAllProviders();
		Provider tempProvider;

		for(int i = 0; i < tempProviderList.size(); i++) {
			tempProvider = tempProviderList.get(i);
				if(tempProvider.getConsultations() != 0) {
					totalConsultations += tempProvider.getConsultations();
					ServiceRecord tempServiceRecord = tempProvider.getServiceRecords();
					for(int j = 0; j < tempServiceRecord.size(); j++) {
						totalFee += tempServiceRecord.get(j).getFee();
					}
				}
		}
		/*
			//cycle all providers
			//add consultations
			 * if provider consultations are 0, do not add to list
			//add fees
			 *if provider fees are 0, do not add to list
			//add total amount to pay (based on week)
			//list all provider names
			 
			//Maybe have provider records make list public
			*/
	}
	
	public int getTotalProviders() {
		return totalProviders;
	}
	
	public int getTotalConsultations() {
		return totalConsultions;
	}
	
	public double getTotalFees() {
		return totalFees;
	}

}
