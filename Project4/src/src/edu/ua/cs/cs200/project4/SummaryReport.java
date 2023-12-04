package edu.ua.cs.cs200.project4;

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
  public void SummaryReport() {

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
}
