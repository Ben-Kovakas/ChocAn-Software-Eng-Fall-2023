import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexander Steffey
 */


public class ProviderDirectoryTest {

    private ProviderDirectory providerDirectory;
    private Member member;

    @Before
    public void setUp() {
        providerDirectory = new ProviderDirectory();

        // Create a sample member for testing
        List<ServiceRecord> serviceRecords = new ArrayList<>();
        member = new Member(123, "John Doe", "123 Main St", "Anytown", "CA", 12345, "VALID", serviceRecords);
    }

    // Tests for ProviderDirectory

    @Test
    public void testAddServiceSuccess() {
        // Test adding a new service successfully
        String serviceName = "New Service";
        int serviceCode = 123456;
        double fee = 75.00;

        providerDirectory.addService(serviceName, serviceCode, fee);

        // Check if the service was added successfully
        assertEquals(serviceCode, providerDirectory.getServiceCode(serviceName));
    }

    @Test
    public void testAddServiceFailure() {
        // Test adding a service with an existing name (should fail)
        String existingServiceName = "Dietitian Consultation";
        int serviceCode = 999999;  // A different code than the existing service

        // Attempt to add the service, should not overwrite the existing service
        providerDirectory.addService(existingServiceName, serviceCode, 50.00);

        // Check if the service code remains the same for the existing service
        assertNotEquals(serviceCode, providerDirectory.getServiceCode(existingServiceName));
    }

    @Test
    public void testGetServiceCodeSuccess() {
        // Test retrieving the code for an existing service successfully
        String existingService = "Dietitian Consultation";
        int expectedCode = 598470;

        // Check if the service code is correct for an existing service
        assertEquals(expectedCode, providerDirectory.getServiceCode(existingService));
    }

    @Test
    public void testGetServiceCodeNonexistent() {
        // Test retrieving the code for a nonexistent service
        String nonexistentService = "Nonexistent Service";

        // Check if the service code is -1 for a nonexistent service
        assertEquals(-1, providerDirectory.getServiceCode(nonexistentService));
    }

    // New tests for Member

    @Test
    public void testGetMemberID() {
        // Test getting the member ID
        assertEquals(123, member.getMemberID());
    }

    @Test
    public void testSetMemberIDSuccess() {
        // Test setting a new member ID successfully
        member.setMemberID(456);
        assertEquals(456, member.getMemberID());
    }

    @Test
    public void testSetMemberIDFailureNegative() {
        // Test setting a negative member ID (should not change the current ID)
        member.setMemberID(-789);
        assertEquals(123, member.getMemberID());
    }

    @Test
    public void testSetMemberIDFailureZero() {
        // Test setting a member ID to zero (should not change the current ID)
        member.setMemberID(0);
        assertEquals(123, member.getMemberID());
    }

    // Add more test cases as needed

}