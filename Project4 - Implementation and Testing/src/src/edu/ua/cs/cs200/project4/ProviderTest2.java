package edu.ua.cs.cs200.project4;

import java.util.ArrayList;
import java.util.List;

public class ProviderTest2 {

    public static void main(String[] args) {
        testProviderGetterSetter();
    }

    public static void testProviderGetterSetter() {
        // Creating a sample ServiceRecord
        ServiceRecord serviceRecord = new ServiceRecord(/* provide necessary constructor arguments */);

        // Creating a list of ServiceRecords
        List<ServiceRecord> serviceRecords = new ArrayList<>();
        serviceRecords.add(serviceRecord);

        // Creating a Provider object
        Provider provider = new Provider(1, "John Doe", "123 Main St", "City", "ST", 12345, 0, serviceRecords);

        // Testing getters and setters
        provider.setProviderID(2);
        if (provider.getProviderID() == 2) {
            System.out.println("Provider ID getter/setter: Passed");
        } else {
            System.out.println("Provider ID getter/setter: Failed");
        }

        provider.setName("Jane Doe");
        if ("Jane Doe".equals(provider.getName())) {
            System.out.println("Name getter/setter: Passed");
        } else {
            System.out.println("Name getter/setter: Failed");
        }

        provider.setAddress("456 Second St");
        if ("456 Second St".equals(provider.getAddress())) {
            System.out.println("Address getter/setter: Passed");
        } else {
            System.out.println("Address getter/setter: Failed");
        }

        // ... (similar checks for other getters and setters)
    }
}

