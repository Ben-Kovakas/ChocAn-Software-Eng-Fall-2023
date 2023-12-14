package edu.ua.cs.cs200.project4;

import java.util.ArrayList;
import java.util.List;
/* 
 * @author dddierking
 */
public class Member {
  // Private attributes
  private int memberID;
  private String name;
  private String address;
  private String city;
  private String state;
  private int zip;
  private String status;
  private List<ServiceRecord> serviceRecords;

  // Constructor
  public Member(int memberID, String name, String address, String city, String state, int zip, String status, List<ServiceRecord> serviceRecords) {
    this.memberID = memberID;
    this.name = name;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.status = status;
    this.serviceRecords = serviceRecords;
  }

  // Constructor with comma-separated string argument
  public Member(String inputString) {
    String[] parts = inputString.split(",");

    if (parts.length >= 7) {
      this.memberID = Integer.parseInt(parts[0]);
      this.name = parts[1];
      this.address = parts[2];
      this.city = parts[3];
      this.state = parts[4];
      this.zip = Integer.parseInt(parts[5]);
      this.status = parts[6];

      // Parse service records if available
      this.serviceRecords = new ArrayList<>();

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
  public int getMemberID() {
    return memberID;
  }

  public void setMemberID(int memberID) {
    this.memberID = memberID;
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

  public int getZip() {
    return zip;
  }

  public void setZip(int zip) {
    this.zip = zip;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<ServiceRecord> getServiceRecords() {
    return serviceRecords;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    // Append member information
    result.append(memberID).append(",").append(name).append(",").append(address)
    .append(",").append(city).append(",").append(state).append(",")
    .append(zip).append(",").append(status).append(",");

    if (serviceRecords != null) {
      // Append service records
      for (ServiceRecord record : serviceRecords) {
        result.append(record.toString()).append(";");
      }
    }

    return result.toString();
  }
}