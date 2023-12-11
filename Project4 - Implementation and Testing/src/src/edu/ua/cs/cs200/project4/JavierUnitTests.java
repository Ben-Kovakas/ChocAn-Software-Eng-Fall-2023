package edu.ua.cs.cs200.project4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Javier Caldwell
 */
public class JavierUnitTests{
	
	ProviderReport testProviderReport;
	Provider testProvider;

	@Before
	public void setUp() throws Exception {
		testProvider = new Provider(0, "name", "address", "city", "state", 0, 1, null);
		testProviderReport = new ProviderReport(testProvider);
	}

	@Test
	public void testGetTotalConsultations() {
		assertEquals(1, testProviderReport.getTotalConsultations()); 
	}
	
	
	@Test
	public void testGetTotalFees() {
		assertEquals(0, testProviderReport.getTotalFees(), 0.1);
	}
	
	@Test
	public void testProviderSetName() {
		testProvider.setName("New");
		assertEquals("New", testProvider.getName());
	}

}
