package edu.ua.cs.cs200.project4;


public class SummaryReport {
	
	private int totalProviders;
	
	private int totalConsultions;
	
	private double totalFees;
	
	/** Constructor. Creates the Summary Report with the Provider reports.
	 * 
	 * @Param ProviderRecords 
	 * 					The provider records.
	 * 
	 * */
	public void SummaryReport() { 
		/*for(int i = 0; i <; i++) {
		//cycle all providers
			//add consultations
			 * if provider consultations are 0, do not add to list
			//add fees
			 *if provider fees are 0, do not add to list
			//add total amount to pay (based on week)
			//list all provider names
			 */
			//Maybe have provider records make list public

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
