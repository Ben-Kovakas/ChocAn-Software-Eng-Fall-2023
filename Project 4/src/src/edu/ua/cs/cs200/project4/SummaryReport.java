package edu.ua.cs.cs200.project4;

/**
 * Creates a Summary Report
 * 
 * @Author Javier Caldwell
 * @version 1.0
 */
public class SummaryReport {
	
	private int totalProviders;
	
	private int totalConsultions;
	
	private double totalFees;
	
	/** Constructor. Creates the Summary Report using the global list of providers
	 * 
	 * */
	public void SummaryReport() {

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

		totalProviders = tempProviderList.size();
	}
	
	/**
	 * Gets the total number of providers
	 * @return a int
	 */
	public int getTotalProviders() {
		return totalProviders;
	}
	
	/**
	 * Gets the total number of consultations
	 * @return a int
	 */
	public int getTotalConsultations() {
		return totalConsultions;
	}
	
	/**
	 * Gets the total amount of fees
	 * @return a double
	 */
	public double getTotalFees() {
		return totalFees;
	}

}
