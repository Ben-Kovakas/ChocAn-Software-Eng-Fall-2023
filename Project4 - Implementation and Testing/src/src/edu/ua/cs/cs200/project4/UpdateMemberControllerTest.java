package edu.ua.cs.cs200.project4;

import static org.junit.Assert.fail;

import org.junit.Test;

public class UpdateMemberControllerTest {

    @Test
    public void testAddMember() {
        try {
            UpdateMemberController.main(null);
            UpdateMemberController updateMemberController = new UpdateMemberController();
            updateMemberController.addMember(1, "John Doe", "123 Main St", "City", "ST", 12345, "Active");
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testEditAndDeleteMember() {
        try {
            UpdateMemberController.main(null);
            UpdateMemberController updateMemberController = new UpdateMemberController();
            updateMemberController.addMember(1, "John Doe", "123 Main St", "City", "ST", 12345, "Active");
            updateMemberController.editMemberData(1, "Jane Doe", "456 Second St", "New City", "NY", 54321, "Inactive");
            updateMemberController.deleteMember(1);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidInputLength() {
        try {
            UpdateMemberController.main(null);
            UpdateMemberController updateMemberController = new UpdateMemberController();
            updateMemberController.addMember(2, "John Doe John Doe John Doe John Doe", "123 Main St", "City", "ST", 12345, "Active");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException ignored) {
            // Expected behavior, IllegalArgumentException should be thrown
        }
    }
}
