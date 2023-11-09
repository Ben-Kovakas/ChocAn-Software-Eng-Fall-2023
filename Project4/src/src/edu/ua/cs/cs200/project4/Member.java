package edu.ua.cs.cs200.project4;

public class Member {
  // Private attributes
  private int memberID;
  private String name;
  private String address;
  private String city;
  private String state;
  private int zip;
  private String status;

  // Constructor
  public Member(int memberID, String name, String address, String city, String state, int zip, String status) {
    this.memberID = memberID;
    this.name = name;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.status = status;
  }

  // Constructor with comma-separated string argument
  public Member(String inputString) {
    String[] attributes = inputString.split(",");

    if (attributes.length == 7) {
      this.memberID = Integer.parseInt(attributes[0]);
      this.name = attributes[1];
      this.address = attributes[2];
      this.city = attributes[3];
      this.state = attributes[4];
      this.zip = Integer.parseInt(attributes[5]);
      this.status = attributes[6];
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

  public String toString() {
    return memberID + "," + name + "," + address + "," + city + "," + state + "," + zip + "," + status;
  }
}