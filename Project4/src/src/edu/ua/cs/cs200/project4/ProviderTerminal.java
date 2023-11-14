package edu.ua.cs.cs200.project4;

import java.util.Scanner;

public class ProviderTerminal {
    
    private ProviderRecords providerRecords;
    private ProviderDirectory providerDirectory;

    // Constructor
    public ProviderTerminal() {
        providerRecords = new ProviderRecords();
        providerDirectory = new ProviderDirectory();
    }

    // Main method for the ProviderTerminal class
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter provider number: ");
        int providerNumber = scanner.nextInt();

        // Validate the provider number
        if(validateProvider(providerNumber)) {
            System.out.println("Provider number is valid.");
            // Proceed with other operations for the provider terminal
            // ...
        } else {
            System.out.println("Invalid provider number.");
        }

        scanner.close();
    }

    // Validates that a provider exists
    public boolean validateProvider(int providerID) {
        // Use the getProvider() method to check if a provider exists
        return providerRecords.getProvider(providerID) != null;
    }

    // Logic for billing service
    public void billService(int memberID, int serviceCode) {
        if (!validateProvider(serviceCode)) {
            System.out.println("Invalid service code or provider does not exist.");
            return;
        }

        // Additional logic for billing service
        // ...
    }

    // Request the provider directory
    public void requestDirectory() {
        // This could print out the provider directory or return it
        // Depending on how you want to handle it
    	// we might need to add the getservices to providerdirectory, or i could change how i do it
        System.out.println(providerDirectory.getServices());
    }

    
}
