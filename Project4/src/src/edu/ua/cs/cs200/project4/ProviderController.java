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
    
    //TODO write bill ChocAn (includes validate member)
    public boolean billChocAn() {
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

        // Get current date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        Date currentDate = new Date();
        String currentDateTime = dateFormat.format(currentDate);

        // Get provider number and member number
        int providerNumber = providerRecords.getProviderNumber(); // You need to implement this method
        int memberNumber = memberRecords.getMemberNumber(); // You need to implement this method

        

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
        int inputFee = scanner.next();

        ServiceRecord serviceRecord = new ServiceRecord(inputServiceCode, inputCurrentDate, inputServiceDate, inputFee, inputMemberName, inputMemberNumber);

        return true;
    }
    
    //TODO write request directory (deliver as file, will update directory class)
    //DJ is working on this
    public void requestProviderDirectory() {
    	//return providerDirectory.getDirectory();
    }
}