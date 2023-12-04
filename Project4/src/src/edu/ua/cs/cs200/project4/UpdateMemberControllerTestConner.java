package edu.ua.cs.cs200.project4;

import org.junit.Before;
import org.junit.Test;

/**
 * @author cchall5
 */
public class UpdateMemberControllerTestConner {

	public UpdateMemberController testController;
	
	@Before
	public void setUp() throws Exception {
		testController = new UpdateMemberController();
	}

	@Test (expected = IllegalArgumentException.class)
	public void testName() {
		testController.addMember(42069, "thisNameIsWayTooLonggggggggggggggggg", "address", "city", "state", 12345, "status");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddress() {
		testController.addMember(42069, "name", "thisAddressIsWayyyyyyTooLonggggggg", "city", "state", 12345, "status");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCity() {
		testController.addMember(42069, "name", "address", "thisCityNameIsWayTooooooooLonggggggg", "state", 12345, "status");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testState() {
		testController.addMember(42069, "name", "address", "city", "thisStateNameIsWayTooooooLongggggggg", 12345, "status");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testZip() {
		testController.addMember(42069, "name", "address", "city", "state", 123456789, "status");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testStatus() {
		testController.addMember(42069, "name", "address", "city", "state", 12345, "thisStatusNameIsWayyyyyyTooLong");
	}

}
