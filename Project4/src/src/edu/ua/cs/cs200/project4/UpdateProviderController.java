package edu.ua.cs.cs200.project4;

public class UpdateProviderController {

    private ProviderRecords providerRecords;

    public void main() {
        providerRecords = new ProviderRecords();
    }

    // Basic function to add a new provider
    public void addProvider(int providerID, String name, String address, String city, String state, int zip, String status)
            throws IllegalArgumentException {
        validateInputLength(name, address, city, state, status);
        Provider newProvider = new Provider(providerID, name, address, city, state, zip, consultations,serviceRecords );
        providerRecords.addProvider(newProvider);
    }

    // Basic function to edit provider data
    public void editProviderData(int providerID, String newName, String newAddress, String newCity, String newState,
                                 int newZip, String newStatus) throws IllegalArgumentException {
        validateInputLength(newName, newAddress, newCity, newState, newStatus);
        Provider existingProvider = providerRecords.getProvider(providerID);

        if (existingProvider != null) {
            // Update provider data
            existingProvider.setName(newName);
            existingProvider.setAddress(newAddress);
            existingProvider.setCity(newCity);
            existingProvider.setState(newState);
            existingProvider.setZipCode(newZip);
            existingProvider.setStatus(newStatus);
        } else {
            System.out.println("Provider not found. Unable to edit data.");
        }
    }

    // Basic function to delete a provider
    public void deleteProvider(int providerID) {
        Provider existingProvider = providerRecords.getProvider(providerID);

        if (existingProvider != null) {
            // Remove the provider from the records
            providerRecords.removeProvider(existingProvider);
        } else {
            System.out.println("Provider not found. Unable to delete.");
        }
    }

    // Method to validate input lengths
    private void validateInputLength(String name, String address, String city, String state, String status)
            throws IllegalArgumentException {
        if (name.length() > 25 || address.length() > 25 || city.length() > 14 || state.length() > 2
                || status.length() > 20) {
            throw new IllegalArgumentException("Input length exceeds limit.");
        }
    }
}
