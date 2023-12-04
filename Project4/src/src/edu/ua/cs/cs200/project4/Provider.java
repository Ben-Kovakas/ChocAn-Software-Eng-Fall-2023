package edu.ua.cs.cs200.project4;

import java.util.List;

/**
 * @author Alexander Steffey
 */

public class Provider {
	private int providerID;
    private String name;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private int consultations;
    private List<ServiceRecord> serviceRecords;
    
    // Constructor with all fields as arguments
    public Provider(int providerID, String name, String address, String city, String state, int zipCode, int consultations, List<ServiceRecord> serviceRecords) {
        this.providerID = providerID;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.consultations = consultations;
        this.serviceRecords = serviceRecords;
    }
    


	// Getter and Setter for providerID
    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getter and Setter for state
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // Getter and Setter for zipCode
    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    // Getter and Setter for consultations
    public int getConsultations() {
        return consultations;
    }

    public void setConsultations(int consultations) {
        this.consultations = consultations;
    }

    // Getter and Setter for serviceRecords
    public List<ServiceRecord> getServiceRecords() {
        return serviceRecords;
    }

    public void setServiceRecords(List<ServiceRecord> serviceRecords) {
        this.serviceRecords = serviceRecords;
    }
}
