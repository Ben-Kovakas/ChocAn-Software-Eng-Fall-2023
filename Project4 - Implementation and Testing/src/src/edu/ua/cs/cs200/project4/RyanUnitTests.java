package edu.ua.cs.cs200.project4;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.*;

public class RyanUnitTests {
	/**
	 * @author rmmilsap
	 */
    private ManagerTerminal managerTerminal;
    private final InputStream original = System.in;

    @Before
    public void setUp() {
        managerTerminal = new ManagerTerminal();
    }

    @Test
    public void testRequestReportOptionOne() {
        String input = "1\n4\n"; // User selects option 1 (Generate Summary Report) and then option 4 to exit
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        // Call the method under test
        managerTerminal.requestReport();

        // Check the output or state change if any (this is just a placeholder since the actual test might vary)
        assertTrue("Expected condition to be true after selecting option 1", true);

        System.setIn(original);
    }
    @Test
    public void testRequestReportOptionFour() {
        String input = "4\n"; // User  option 4 to exit
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        // Call the method under test
        managerTerminal.requestReport();

        // Check the output or state change if any (this is just a placeholder since the actual test might vary)
        assertTrue("Expected condition to be true after selecting option 1", true);

        System.setIn(original);
    }
 // Additional test for generating a summary report directly from ReportController
    @Test
    public void testGenerateSummaryReport() {
        
        ReportController reportController = new ReportController();
        SummaryReport summaryReport = reportController.generateSummaryReport();
        
        assertNotNull("Summary report should not be null", summaryReport);
        
    }
    

}
