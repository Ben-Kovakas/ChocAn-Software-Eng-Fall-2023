package edu.ua.cs.cs200.project4;

public class UpdateMemberController {

    private MemberRecords memberRecords;

//    public UpdateMemberController(MemberRecords memberRecords) {
//        this.memberRecords = memberRecords;
//    }
    
    public void main() {
    	memberRecords = new MemberRecords();
    }

    // Basic function to add a new member
    public void addMember(int memberID, String name, String address, String city, String state, int zip, String status)
            throws IllegalArgumentException {
        validateInputLength(name, address, city, state, status);
        Member newMember = new Member(memberID, name, address, city, state, zip, status);
        memberRecords.addMember(newMember);
    }

    // Basic function to edit member data
    public void editMemberData(int memberID, String newName, String newAddress, String newCity, String newState,
            int newZip, String newStatus) throws IllegalArgumentException {
        validateInputLength(newName, newAddress, newCity, newState, newStatus);
        Member existingMember = memberRecords.getMember(memberID);

        if (existingMember != null) {
            // Update member data
            existingMember.setName(newName);
            existingMember.setAddress(newAddress);
            existingMember.setCity(newCity);
            existingMember.setState(newState);
            existingMember.setZip(newZip);
            existingMember.setStatus(newStatus);
        } else {
            System.out.println("Member not found. Unable to edit data.");
        }
    }

    // Basic function to delete a member
    public void deleteMember(int memberID) {
        Member existingMember = memberRecords.getMember(memberID);

        if (existingMember != null) {
            // Remove the member from the records
            memberRecords.removeMember(existingMember);
        } else {
            System.out.println("Member not found. Unable to delete.");
        }
    }

    // Method to validate input lengths
    private void validateInputLength(String name, String address, String city, String state, String status)
            throws IllegalArgumentException {
        if (name.length() > 25 || address.length() > 25 || city.length() > 14 || state.length() > 2
                || status.length() > 20 || zip.length() > 5)  {
            throw new IllegalArgumentException("Input length exceeds limit.");
        }
    }
}
