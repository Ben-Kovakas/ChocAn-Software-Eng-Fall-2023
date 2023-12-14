package edu.ua.cs.cs200.project4;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ProviderTest2 {

    @Test
    public void testProviderIDGetterSetter() {
        // Creating a Provider object
        Provider provider = new Provider(1, "John Doe", "123 Main St", "City", "ST", 12345, 0, new ArrayList<>());

        // Testing Provider ID getter and setter
        provider.setProviderID(2);
        assertEquals(2, provider.getProviderID());
    }

    @Test
    public void testNameGetterSetter() {
        // Creating a Provider object
        Provider provider = new Provider(1, "John Doe", "123 Main St", "City", "ST", 12345, 0, new ArrayList<>());

        // Testing Name getter and setter
        provider.setName("Jane Doe");
        assertEquals("Jane Doe", provider.getName());
    }

    @Test
    public void testAddressGetterSetter() {
        // Creating a Provider object
        Provider provider = new Provider(1, "John Doe", "123 Main St", "City", "ST", 12345, 0, new ArrayList<>());

        // Testing Address getter and setter
        provider.setAddress("456 Second St");
        assertEquals("456 Second St", provider.getAddress());
    }
}