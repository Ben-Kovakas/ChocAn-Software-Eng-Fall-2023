package edu.ua.cs.cs200.project4;

public class ServiceRecord {
    // Private attributes
    private int serviceCode;
    private String currentDate;
    private String serviceDate;
    private String fee;
    private int memberName;
    private int memberNumber;

    // Constructor
    public ServiceRecord(int serviceCode, String currentDate, String serviceDate, String fee, int memberName, int memberNumber) {
        this.serviceCode = serviceCode;
        this.currentDate = currentDate;
        this.serviceDate = serviceDate;
        this.fee = fee;
        this.memberName = memberName;
        this.memberNumber = memberNumber;
    }

    // Getter and Setter methods
    public int getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public int getMemberName() {
        return memberName;
    }

    public void setMemberName(int memberName) {
        this.memberName = memberName;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }
}