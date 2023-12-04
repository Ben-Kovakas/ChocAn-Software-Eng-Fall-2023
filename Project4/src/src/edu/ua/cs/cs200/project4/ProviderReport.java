package edu.ua.cs.cs200.project4;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Creates a Provider Report
 * 
 * @Author Javier Caldwell
 * @version 1.0
 */
public class ProviderReport {

  private Provider provider;

  private int totalConsultations;

  private double totalFees;

  /** Constructor. Creates the Provider Report with a inputed provider.
   * 
   * @Param tempProvider
   * 					The inputed Provider
   * 
   * */
  public ProviderReport(Provider tempProvider) {
    provider = tempProvider;
    totalConsultations = provider.getConsultations();

    List<ServiceRecord> tempService = provider.getServiceRecords();
    if (tempService != null) {
      for(int i = 0; i < tempService.size(); i++) {
        totalFees = totalFees + tempService.get(i).getFee();
      }   
    } else {
      totalFees = 0;
    }
  }	

  /**
   * Gets the Provider from the report
   * @return a Provider
   */
  public Provider getProvider() {
    return provider;
  }

  /**
   * Gets the total amount of Consultations for the provider
   * @return a int
   */
  public int getTotalConsultations() {
    return totalConsultations;
  }

  /**
   * Gets the total amount of fees for the provider
   * @return a double
   */
  public double getTotalFees() {
    return totalFees;
  }

  public void printToFile() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    LocalDateTime currentDateTime = LocalDateTime.now();
    String formattedDateTime = currentDateTime.format(formatter);

    String fileName = provider.getName() + "_" + formattedDateTime + ".txt";

    try (FileWriter writer = new FileWriter(fileName)) {
        writer.write("Provider Report\n\n");
        writer.write("Provider ID: " + provider.getProviderID() + "\n");
        writer.write("Name: " + provider.getName() + "\n");
        writer.write("Address: " + provider.getAddress() + "\n");
        writer.write("State: " + provider.getState() + "\n");
        writer.write("Zip: " + Integer.toString(provider.getZipCode()) + "\n");
        // Add other provider information as needed

        writer.write("\nTotal Consultations: " + totalConsultations + "\n");
        writer.write("Total Fees: " + totalFees + "\n");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

  @Override
  public String toString() {
    StringBuilder reportString = new StringBuilder();
    reportString.append("Provider Report:\n");
    reportString.append("Provider ID: ").append(provider.getProviderID()).append("\n");
    reportString.append("Provider Name: ").append(provider.getName()).append("\n");
    reportString.append("Total Consultations: ").append(totalConsultations).append("\n");
    reportString.append("Total Fees: $").append(totalFees).append("\n");

    return reportString.toString();
  }
}
