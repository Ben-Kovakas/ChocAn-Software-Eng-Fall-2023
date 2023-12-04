package edu.ua.cs.cs200.project4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Creates a Summary Report
 * 
 * @Author Javier Caldwell
 * @version 1.0
 */
public class SummaryReport {

  private int totalProviders;

  private int totalConsultions;

  private double totalFees;

  ProviderRecords providerRecords = new ProviderRecords();

  /** Constructor. Creates the Summary Report using the global list of providers
   * 
   * */
  public SummaryReport() {

    totalConsultions = 0;
    totalFees = 0;

    List<Provider> tempProviderList = providerRecords.getAllProviders();
    Provider tempProvider;
    for(int i = 0; i < tempProviderList.size(); i++) {
      tempProvider = tempProviderList.get(i);
      if(tempProvider.getConsultations() != 0) {
        totalConsultions += tempProvider.getConsultations();
        List<ServiceRecord> tempServiceRecord = tempProvider.getServiceRecords();
        for(int j = 0; j < tempServiceRecord.size(); j++) {
          totalFees += tempServiceRecord.get(j).getFee();
        }
      }
    }
    totalProviders = tempProviderList.size();
  }

  /**
   * Gets the total number of providers
   * @return a int
   */
  public int getTotalProviders() {
    return totalProviders;
  }

  /**
   * Gets the total number of consultations
   * @return a int
   */
  public int getTotalConsultations() {
    return totalConsultions;
  }

  /**
   * Gets the total amount of fees
   * @return a double
   */
  public double getTotalFees() {
    return totalFees;
  }
  
  public void printSummaryToFile() {
    // Get the current date
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    LocalDateTime currentDateTime = LocalDateTime.now();
    String formattedDateTime = currentDateTime.format(formatter);


    // Create a file name based on the current date
    String fileName = "summary_" + formattedDateTime + ".txt";

    try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
        // Write summary header
        writer.println("Summary Report - " + formattedDateTime);

        // Variables for overall summary
        int overallTotalProviders = 0;
        int overallTotalConsultations = 0;
        double overallTotalFees = 0;

        // Iterate through the providers
        List<Provider> providers = providerRecords.getAllProviders();
        for (Provider provider : providers) {
            int providerConsultations = provider.getConsultations();
            List<ServiceRecord> serviceRecords = provider.getServiceRecords();
            double providerTotalFees;
            if (serviceRecords != null)
              providerTotalFees = serviceRecords.stream().mapToDouble(ServiceRecord::getFee).sum();
            else
              providerTotalFees = 0;

            // Write provider details to the file
            writer.println("Provider: " + provider.getName());
            writer.println("Consultations: " + providerConsultations);
            writer.println("Total Fees: $" + providerTotalFees);
            writer.println(); // Separate providers

            // Update overall summary
            if (providerConsultations > 0) {
                overallTotalProviders++;
                overallTotalConsultations += providerConsultations;
                overallTotalFees += providerTotalFees;
            }
        }

        // Write overall summary to the file
        writer.println("Overall Total Providers: " + overallTotalProviders);
        writer.println("Overall Total Consultations: " + overallTotalConsultations);
        writer.println("Overall Total Fees: $" + overallTotalFees);

        System.out.println("Summary report has been written to: " + fileName);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
