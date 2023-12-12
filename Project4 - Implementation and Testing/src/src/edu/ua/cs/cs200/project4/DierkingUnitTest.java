package edu.ua.cs.cs200.project4;

import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.*;
/* 
* @author dddierking
*/
public class DierkingUnitTest {
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testMemberConstructor() {
    Member x = new Member(0, null, null, null, null, 0, null, null);
    assertEquals(0, x.getMemberID());
  }
  
  @Test
  public void testProviderConstructor() {
    Provider x = new Provider(0, null, null, null, null, 0, 0, null);
    assertEquals(0, x.getProviderID());
  }
  
  @Test
  public void testProviderConstructorName() {
    Provider x = new Provider(0, null, null, null, null, 0, 0, null);
    assertNull(x.getName());
  }
}