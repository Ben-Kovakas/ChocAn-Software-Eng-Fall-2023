package edu.ua.cs.cs200.project4;

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

    for(int i = 0; i < tempService.size(); i++) {
      totalFees = totalFees + tempService.get(i).getFee();
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
}
