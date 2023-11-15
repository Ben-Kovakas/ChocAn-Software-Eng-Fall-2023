package edu.ua.cs.cs200.project4;

public class ProviderController {
    private ProviderDirectory providerDirectory;
    private MemberRecords memberRecords;
    private ProviderRecords providerRecords;
    
    public ProviderController() {
    	providerDirectory = new ProviderDirectory();
    	memberRecords = new MemberRecords();
    	providerRecords = new ProviderRecords();
    }
    
    //TODO write validate member (no arguments)
    public boolean validateMember(int memberID) {
    	//Search members by memberID
        //check for correct status
    	if (null != memberRecords.getMember(memberID)) return true;
    	return false;
    	
    }
    
    //TODO write bill ChocAn (includes validate member)
    public boolean billChocAn(int memberID) {
    	validateMember(memberID);
    	System.out.println("Enter the date of service (MM-DD-YYYY)");
    	//Search Provider Directory for code
    	System.out.println("Enter the service code");
    	//Search and Print service
    	return false;
    }
    
    //TODO write request directory (deliver as file, will update directory class)
    //DJ is working on this
    public void requestProviderDirectory() {
    	//return providerDirectory.getDirectory();
    }
}