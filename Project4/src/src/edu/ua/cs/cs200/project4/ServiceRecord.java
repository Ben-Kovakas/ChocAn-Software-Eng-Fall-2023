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

    // Public getter methods
    public int getServiceCode() {
        return serviceCode;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public String getFee() {
        return fee;
    }

    public int getMemberName() {
        return memberName;
    }

    public int getMemberNumber() {
        return memberNumber;
    }
}