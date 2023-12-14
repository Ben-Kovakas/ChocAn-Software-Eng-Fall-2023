package edu.ua.cs.cs200.project4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Steffey
 */

public class Provider {
  // Private attributes
  private int providerID;
  private String name;
  private String address;
  private String city;
  private String state;
  private int zipCode;
  private int consultations;
  private List<ServiceRecord> serviceRecords;

  // Constructor
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

  //Constructor with string representation
  public Provider(String inputString) {
    String[] parts = inputString.split(",");

    if (parts.length >= 7) {
      this.providerID = Integer.parseInt(parts[0]);
      this.name = parts[1];
      this.address = parts[2];
      this.city = parts[3];
      this.state = parts[4];
      this.zipCode = Integer.parseInt(parts[5]);
      this.consultations = Integer.parseInt(parts[6]);
      this.serviceRecords = new ArrayList<>();

      // Parse service records if available
      if (parts.length > 7) {
        String[] serviceRecordsString = parts[7].split(";");
        for (String serviceRecordString : serviceRecordsString) {
          ServiceRecord serviceRecord = new ServiceRecord(serviceRecordString);
          this.serviceRecords.add(serviceRecord);
        }
      }
    } else {
      // Handle incorrect input length (throw an exception, log an error, etc.)
      // For simplicity, we'll just set default values or leave attributes
      // uninitialized.
    }
  }

  // Getter and Setter methods
  public int getProviderID() {
    return providerID;
  }

  public void setProviderID(int providerID) {
    this.providerID = providerID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public int getZipCode() {
    return zipCode;
  }

  public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
  }

  public int getConsultations() {
    return consultations;
  }

  public void setConsultations(int consultations) {
    this.consultations = consultations;
  }

  public List<ServiceRecord> getServiceRecords() {
    return serviceRecords;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    // Append provider information
    result.append(providerID).append(",").append(name).append(",").append(address)
    .append(",").append(city).append(",").append(state).append(",")
    .append(zipCode).append(",").append(consultations).append(",");

    if (serviceRecords != null) {
      // Append service records
      for (ServiceRecord record : serviceRecords) {
        result.append(record.toString()).append(";");
      }
    }

    return result.toString();
  }
}
