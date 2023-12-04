import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexander Steffey
 */

public class ProviderDirectoryTest {

    private ProviderDirectory providerDirectory;

    @Before
    public void setUp() {
        providerDirectory = new ProviderDirectory();
    }

    @Test
    public void testAddServiceAndRetrieveCode() {
        // Test adding a new service and retrieving its code
        String serviceName = "New Service";
        int serviceCode = 123456;
        double fee = 75.00;

        providerDirectory.addService(serviceName, serviceCode, fee);

        // Check if the service was added successfully
        assertEquals(serviceCode, providerDirectory.getServiceCode(serviceName));
    }

    @Test
    public void testGetServiceCodeNonexistent() {
        // Test retrieving the code for a nonexistent service
        String nonexistentService = "Nonexistent Service";

        // Check if the service code is -1 for a nonexistent service
        assertEquals(-1, providerDirectory.getServiceCode(nonexistentService));
    }

    // Add more test cases as needed

}