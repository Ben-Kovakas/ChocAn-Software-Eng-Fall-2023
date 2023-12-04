package edu.ua.cs.cs200.project4;

import java.util.Scanner;

/**
 * @author Alexander Steffey
 */

public class ProviderController {
    private ProviderDirectory providerDirectory;
    private MemberRecords memberRecords;
    private ProviderRecords providerRecords;
    
    public ProviderController() {
    	providerDirectory = new ProviderDirectory();
    	memberRecords = new MemberRecords();
    	providerRecords = new ProviderRecords();
    }
    
    //Main logic of Validate Member use case
    public boolean validateMember() {
    	Scanner scanner = new Scanner(System.in);
    	
    	//Enter memberID
    	System.out.print("Enter Member ID: ");
        int memberID = scanner.nextInt();
        
        Member member = memberRecords.getMember(memberID);
        
        //If no member found, print error
        if (member == null) {
            System.out.println("Error: Invalid member");
            return false;
        }
        
        //Return member status
        String status = member.getStatus();
        if (status.equals("VALID")) {
            System.out.println("Member validated");
            return true;
        } else if (status.equals("SUSPENDED")) {
            System.out.println("Member is suspended. Services not allowed.");
            return false;
        } 
        return false;
    }
    
    //Main logic of Bill ChocAn use case
    public boolean billChocAn(int providerID) {
    	if (!validateMember()) {
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        
        //Find service code
        System.out.print("Enter the service name: ");
        String serviceName = scanner.nextLine();
        
        int serviceCode = providerDirectory.getServiceCode(serviceName);
        if (serviceCode == -1) {
            System.out.println("Error: Nonexistent service");
            return false;
        }
        System.out.println("Service code: " + serviceCode);
        
        //Confirm service code
        System.out.print("Enter the service code: ");
        int EnteredCode = scanner.nextInt();
        if (EnteredCode != serviceCode) {
            System.out.println("Error: Service codes do not match");
            return false;
        }

        //Confirm services
        System.out.println("Please choose an option:");
        System.out.println("1. Verify");
        System.out.println("2. Cancel");
        int option = scanner.nextInt();

        if (option == 2) {
            System.out.println("Service canceled.");
            return false;
        }

        System.out.print("Enter any additional comments (up to 100 characters): ");
        scanner.nextLine();
        String comments = scanner.nextLine();

        //TODO fix write a record, same as ProviderReport
        // Current date and time (MM–DD–YYYY HH:MM:SS). 
        //Date service was provided (MM–DD–YYYY). 
        //Provider number (9 digits).
        //Member number (9 digits). 
        //Service code (6 digits).
        //Comments (100 characters) (optional). 
        
        //Enter service record info
        double fee = providerDirectory.getServiceFee(serviceCode);
        System.out.println("Fee: $" + fee);
        System.out.print("Enter the current date (MM-DD-YYYY): ");
        String inputCurrentDate = scanner.next();
        System.out.print("Enter the date of service (MM-DD-YYYY): ");
        String inputServicetDate = scanner.next();
        System.out.print("Enter member name: ");
        String inputMemberName = scanner.next();
        System.out.print("Enter member number: ");
        int inputMemberNumber = scanner.next();
        System.out.print("Enter service code: ");
        int inputServiceCode = scanner.next();
        System.out.print("Enter fee: ");
        double inputFee = scanner.next();

        //Save service record info
        ServiceRecord serviceRecord = new ServiceRecord(inputServiceCode, inputCurrentDate, inputServiceDate, inputFee, inputMemberName, inputMemberNumber);
        Member member = memberRecords.getMember(memberID);
        if (member != NULL) {
        	List<ServiceRecord> memberServiceRecords = member.getServiceRecords();
            memberServiceRecords.add(serviceRecord);
        }
        
        Provider provider = providerRecords.getProvider(providerID);
        if (provider != NULL) {
        	List<ServiceRecord> providerServiceRecords = provider.getServiceRecords();
            providerServiceRecords.add(serviceRecord);
        }
        
        return true;
    }
    
    //TODO write request directory (deliver as file, will update directory class)
    //DJ is working on this
    public void requestProviderDirectory() {
    	//return providerDirectory.getDirectory();
    }
}