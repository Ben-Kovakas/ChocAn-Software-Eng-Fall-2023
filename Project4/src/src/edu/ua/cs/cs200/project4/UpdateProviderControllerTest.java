package edu.ua.cs.cs200.project4;

import static org.junit.Assert.fail;
import org.junit.Test;

public class UpdateProviderControllerTest {

    @Test
    public void testAddProvider() {
        try {
            UpdateProviderController updateProviderController = new UpdateProviderController();
            updateProviderController.main();
            updateProviderController.addProvider(1, "John Doe", "123 Main St", "City", "ST", 12345, "Active");
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testEditAndDeleteProvider() {
        try {
            UpdateProviderController updateProviderController = new UpdateProviderController();
            updateProviderController.main();
            updateProviderController.addProvider(1, "John Doe", "123 Main St", "City", "ST", 12345, "Active");
            updateProviderController.editProviderData(1, "Jane Doe", "456 Second St", "New City", "NY", 54321, "Inactive");
            updateProviderController.deleteProvider(1);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidInputLength() {
        try {
            UpdateProviderController updateProviderController = new UpdateProviderController();
            updateProviderController.main();
            updateProviderController.addProvider(2, "John Doe John Doe John Doe John Doe", "123 Main St", "City", "ST", 12345, "Active");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException ignored) {
            // Expected behavior, IllegalArgumentException should be thrown
        }
    }
}

