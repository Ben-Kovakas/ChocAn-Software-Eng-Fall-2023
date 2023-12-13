package edu.ua.cs.cs200.project4;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Alexander Steffey
 */

public class ProviderDirectory {

  //Map structures to order services and codes
  private Map<String, Integer> serviceNameToCode;
  private Map<Integer, ServiceInfo> serviceCodeToInfo;

  public ProviderDirectory() {
    serviceNameToCode = new HashMap<>();
    serviceCodeToInfo = new HashMap<>();

    // Initialize the service directory with sample services
    addService("Dietitian Consultation", 598470, 100.00);
    addService("Aerobics Exercise Session", 883948, 50.00);
    // Add more services as needed
    saveRecordToFile();
  }

  //Add and search methods
  public void addService(String serviceName, int serviceCode, double fee) {
    serviceNameToCode.put(serviceName, serviceCode);
    serviceCodeToInfo.put(serviceCode, new ServiceInfo(serviceName, fee));
  }

  public int getServiceCode(String serviceName) {
    return serviceNameToCode.getOrDefault(serviceName, -1);
  }

  public ServiceInfo getServiceInfo(int serviceCode) {
    return serviceCodeToInfo.get(serviceCode);
  }
  
  public String getEntriesAlphabetically() {
    // Use TreeMap to automatically order entries by service name
    Map<String, Integer> sortedServiceNameToCode = new TreeMap<>(serviceNameToCode);

    StringBuilder result = new StringBuilder();

    for (String serviceName : sortedServiceNameToCode.keySet()) {
      int serviceCode = sortedServiceNameToCode.get(serviceName);
      ServiceInfo serviceInfo = serviceCodeToInfo.get(serviceCode);
      result.append("Service Name: ").append(serviceInfo.getServiceName())
            .append(", Service Code: ").append(serviceCode)
            .append(", Fee: $").append(serviceInfo.getFee())
            .append("\n");
    }

    return result.toString();
  }
  public void saveRecordToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter("providerDirectory.txt"))) {
        writer.println(getEntriesAlphabetically());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

  //Provider Service info
  public static class ServiceInfo {
    private String serviceName;
    private double fee;

    public ServiceInfo(String serviceName, double fee) {
      this.serviceName = serviceName;
      this.fee = fee;
    }

    public String getServiceName() {
      return serviceName;
    }

    public double getFee() {
      return fee;
    }
  }
}