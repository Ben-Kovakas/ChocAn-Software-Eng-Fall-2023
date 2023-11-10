package edu.ua.cs.cs200.project4;

public class ProviderTerminal {
    
    private MemberRecords memberRecords; 
    private ProviderDirectory providerDirectory;

    public boolean validateMember(int memberID) {
        if (memberID <= 0) {
            // Log error and return or throw an IllegalArgumentException
        }
        return memberRecords.isValidMember(memberID);
    }

    public void billService(int memberID, int serviceCode) {
        if (!validateMember(memberID)) {
            // Handle invalid member
        }
        
        // Additional checks for serviceCode...
        
        ServiceRecord newRecord = new ServiceRecord(memberID, serviceCode);
        // ... create the service record and update records accordingly
    }

    public List<Service> requestDirectory() {
        return providerDirectory.getServices();
    }

   
}

}
