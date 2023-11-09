
public class ProviderReport {
	
	private int provider;
	
	private List services;
	
	private int totalConsultions;
	
	private double totalFees;
		
	/** Constructor. Creates the Provider Report with the service records.
	 * 
	 * @Param ServiceRecords 
	 * 					The service records.
	 * 
	 * */
	public SummaryReport(List ServiceRecords) {
		services = ServiceRecords;
	}

}
