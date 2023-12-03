package edu.ua.cs.cs200.project4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Javier Caldwell
 */
public class JavierUnitTests{
	
	SummaryReport testSummaryReport;
	Provider testProvider;

	@Before
	void setUp() throws Exception {
		testSummaryReport = new SummaryReport();
		testProvider = new Provider(0, "name", "address", "city", "state", 0, 0, null);
	}

	@Test
	public void testGetTotalProviders() {
		assertEquals(0, testSummaryReport.getTotalProviders());
	}
	
	@Test
	public void testGetTotalFees() {
		assertEquals(0, testSummaryReport.getTotalFees());
	}
	
	@Test
	public void testProviderSetName() {
		testProvider.setName("New");
		assertEquals("New", testProvider.getName());
	}

}
