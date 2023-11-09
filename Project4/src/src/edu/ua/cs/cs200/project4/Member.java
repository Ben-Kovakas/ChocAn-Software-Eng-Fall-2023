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

    // Public getter methods
    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getStatus() {
        return status;
    }
}