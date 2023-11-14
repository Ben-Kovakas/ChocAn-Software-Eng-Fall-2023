package edu.ua.cs.cs200.project4;

public class EFTReport {

	
	private String providerName;
	
	private int providerNumber;
	
	private double amount;
	
	/** Constructor. Creates the EFT Report with the EFT data.
	 * 
	 * @Param  name
	 * 			The provider's name
	 * 
	 * @param number
	 * 			The provider's number
	 * 
	 * @param fee
	 * 			The fee to be paid to the provider	
	 * 
	 * */
	public EFTReport(String name, int number, double fee) {
		providerName = name;
		providerNumber = number;
		amount = fee;
	}

	public String getProviderName(){
		return providerName;
	}
	
	public int getProviderNumber() {
		return providerNumber;
	}
	
	public double getAmount() {
		return amount;
	}
	
}
