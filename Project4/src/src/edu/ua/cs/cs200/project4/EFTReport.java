
public class EFTReport {

	
	private string providerName;
	
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
	public EFTReport(string name, int number, double fee) {
		providerName = name;
		providerNumber = number;
		amount = fee;
	}

	public string getProviderName(){
		return providerName;
	}
	
	public int getProviderNumber() {
		return providerNumber;
	}
	
	public double getAmount() {
		return amount;
	}
	
}
