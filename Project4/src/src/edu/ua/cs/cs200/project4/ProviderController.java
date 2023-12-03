package edu.ua.cs.cs200.project4;

import java.util.Scanner;

public class ProviderController {
    private ProviderDirectory providerDirectory;
    private MemberRecords memberRecords;
    private ProviderRecords providerRecords;
    
    public ProviderController() {
    	providerDirectory = new ProviderDirectory();
    	memberRecords = new MemberRecords();
    	providerRecords = new ProviderRecords();
    }
    
    public boolean validateMember() {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.print("Enter Member ID: ");
        int memberID = scanner.nextInt();
        
        Member member = memberRecords.getMember(memberID);
        
        if (member == null) {
            System.out.println("Error: Invalid member");
            return false;
        }
        
        String status = member.getStatus();
        if (status.equals("VALID")) {
            System.out.println("Member validated");
            return true;
        } else if (status.equals("SUSPENDED")) {
            System.out.println("Member is suspended. Services not allowed.");
            return false;
        } 	
    }
    
    public boolean billChocAn(int providerID) {
    	if (!validateMember()) {
            return false;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the service name: ");
        String serviceName = scanner.nextLine();
        
        int serviceCode = providerDirectory.getServiceCode(serviceName);
        if (serviceCode == -1) {
            System.out.println("Error: Nonexistent service");
            return false;
        }
        System.out.println("Service code: " + serviceCode);

        System.out.print("Enter the service code: ");
        int EnteredCode = scanner.nextInt();
        if (EnteredCode != serviceCode) {
            System.out.println("Error: Service codes do not match");
            return false;
        }

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

        //TODO fix write a record, same as ServiceRecord??
        // Current date and time (MM–DD–YYYY HH:MM:SS). 
        //Date service was provided (MM–DD–YYYY). 
        //Provider number (9 digits).
        //Member number (9 digits). 
        //Service code (6 digits).
        //Comments (100 characters) (optional). 

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