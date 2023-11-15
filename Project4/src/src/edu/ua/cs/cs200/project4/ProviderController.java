package edu.ua.cs.cs200.project4;

public class ProviderController {
    private ProviderDirectory providerDirectory;
    private ServiceRecords serviceRecords;
    private List<Provider> providers;
    private List<Member> members;
    
    public ProviderController(ProviderDirectory providerDirectory, ServiceRecords serviceRecords) {
    	this.providerDirectory = providerDirectory;
    	this.serviceRecords = serviceRecords;
    	this.providers = providers;
    	this.members = members;
    }
    
    //TODO write validate member (no arguments)
    public boolean validateMember(int memberID) {
    	//Search members by memberID
    	getStatus();
    	
    }
    
    //TODO write bill ChocAn (includes validate member)
    public boolean billChocAn(int memberID) {
    	validateMember(memberID);
    	System.out.println("Enter the date of service (MM-DD-YYYY)");
    	//Search Provider Directory for code
    	System.out.println("Enter the service code");
    	//Search and Print service
    }
    
    //TODO write request directory (deliver as file, will update directory class)
    public requestProviderDirectory() {
    	return providerDirectory.getDirectory();
    }
}