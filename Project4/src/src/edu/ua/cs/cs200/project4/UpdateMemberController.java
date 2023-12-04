package edu.ua.cs.cs200.project4;

/**
 * The UpdateMemberController class manages operations related to members in the system.
 */
public class UpdateMemberController {
  /**
   * Initializes the member records.
   */
  private static MemberRecords memberRecords = new MemberRecords();

  public static void main(String[] args) {
  }
  /**
   * Adds a new member to the system.
   *
   * @param memberID The ID of the member.
   * @param name     The name of the member.
   * @param address  The address of the member.
   * @param city     The city of the member.
   * @param state    The state of the member.
   * @param zip      The ZIP code of the member.
   * @param status   The status of the member.
   * @throws IllegalArgumentException if any input length exceeds the specified limit.
   */
  public void addMember(int memberID, String name, String address, String city, String state, int zip, String status)
      throws IllegalArgumentException {
    validateInputLength(name, address, city, state, zip, status);
    Member newMember = new Member(memberID, name, address, city, state, zip, status, null);
    memberRecords.addMember(newMember);

  }
  /**
   * Edits the data of an existing member in the system.
   *
   * @param memberID   The ID of the member to be edited.
   * @param newName    The new name for the member.
   * @param newAddress The new address for the member.
   * @param newCity    The new city for the member.
   * @param newState   The new state for the member.
   * @param newZip     The new ZIP code for the member.
   * @param newStatus  The new status for the member.
   * @throws IllegalArgumentException if any input length exceeds the specified limit.
   */
  public void editMemberData(int memberID, String newName, String newAddress, String newCity, String newState,
      int newZip, String newStatus) throws IllegalArgumentException {
    validateInputLength(newName, newAddress, newCity, newState, newZip, newStatus);
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

  /**
   * Deletes a member from the system.
   *
   * @param memberID The ID of the member to be deleted.
   */
  public void deleteMember(int memberID) {
    Member existingMember = memberRecords.getMember(memberID);

    if (existingMember != null) {
      // Remove the member from the records
      memberRecords.removeMember(memberID);
    } else {
      System.out.println("Member not found. Unable to delete.");
    }
  }

  /**
   * Validates input lengths to ensure they do not exceed specified limits.
   *
   * @param name   The name to validate.
   * @param address The address to validate.
   * @param city    The city to validate.
   * @param state   The state to validate.
   * @param zip     The ZIP code to validate.
   * @param status  The status to validate.
   * @throws IllegalArgumentException if any input length exceeds the specified limit.
   */
  private void validateInputLength(String name, String address, String city, String state, int zip, String status)
      throws IllegalArgumentException {
    if (name.length() > 25 || address.length() > 25 || city.length() > 14 || state.length() > 2
        || status.length() > 20 || String.valueOf(zip).length() != 5) {
      throw new IllegalArgumentException("Input length exceeds limit.");
    }
  }
}
