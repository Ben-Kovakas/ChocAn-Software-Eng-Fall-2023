package edu.ua.cs.cs200.project4;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *The UpdateProviderController class manages operations related to providers in the system.
 *@author: Ben Kovakas
 */
public class UpdateProviderController {

    private ProviderRecords providerRecords;

    /**
     * Initializes the provider records.
     */
    public void main() {
        providerRecords = new ProviderRecords();
    }

    /**
     * Adds a new provider to the system.
     *
     * @param providerID The ID of the provider.
     * @param name       The name of the provider.
     * @param address    The address of the provider.
     * @param city       The city of the provider.
     * @param state      The state of the provider.
     * @param zip        The ZIP code of the provider.
     * @param status     The status of the provider.
     * @throws IllegalArgumentException if any input length exceeds the specified limit.
     */
    public void addProvider(int providerID, String name, String address, String city, String state, int zip, String status)
            throws IllegalArgumentException {
        validateInputLength(name, address, city, state, status);
        List<ServiceRecord> serviceRecords = new ArrayList<ServiceRecord>();
        Provider newProvider = new Provider(providerID, name, address, city, state, zip, 0, serviceRecords);
        providerRecords.addProvider(newProvider);
    }

    /**
     * Edits the data of an existing provider in the system.
     *
     * @param providerID The ID of the provider to be edited.
     * @param newName    The new name for the provider.
     * @param newAddress The new address for the provider.
     * @param newCity    The new city for the provider.
     * @param newState   The new state for the provider.
     * @param newZip     The new ZIP code for the provider.
     * @param newStatus  The new status for the provider.
     * @throws IllegalArgumentException if any input length exceeds the specified limit.
     */
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

        } else {
            System.out.println("Provider not found. Unable to edit data.");
        }
    }

    /**
     * Deletes a provider from the system.
     *
     * @param providerID The ID of the provider to be deleted.
     */
    public void deleteProvider(int providerID) {
        Provider existingProvider = providerRecords.getProvider(providerID);

        if (existingProvider != null) {
            // Remove the provider from the records
            providerRecords.removeProvider(existingProvider);
        } else {
            System.out.println("Provider not found. Unable to delete.");
        }
    }

    /**
     * Validates input lengths to ensure they do not exceed specified limits.
     *
     * @param name    The name to validate.
     * @param address The address to validate.
     * @param city    The city to validate.
     * @param state   The state to validate.
     * @param status  The status to validate.
     * @throws IllegalArgumentException if any input length exceeds the specified limit.
     */
    private void validateInputLength(String name, String address, String city, String state, String status)
            throws IllegalArgumentException {
        if (name.length() > 25 || address.length() > 25 || city.length() > 14 || state.length() > 2
                || status.length() > 20) {
            throw new IllegalArgumentException("Input length exceeds limit.");
        }
    }
}
