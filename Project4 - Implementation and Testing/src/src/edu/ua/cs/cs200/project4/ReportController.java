package edu.ua.cs.cs200.project4;

import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Manages the creation of all types of reports
 * 
 * @Author Javier Caldwell
 * @version 1.0
 */
public class ReportController {

  SummaryReport SumReport = new SummaryReport();
  List<ProviderReport> ProReports = new ArrayList<ProviderReport>();
  List<MemberReport> MemReports = new ArrayList<MemberReport>();

  /**
   * Generates a Summary report
   * @return a SummaryReport
   */
  public SummaryReport generateSummaryReport() {
    SummaryReport tempReport = new SummaryReport();
    tempReport.printSummaryToFile();
    return tempReport;
  }

  /**
   * Generates a Provider report
   */
  public void generateProviderReport() {
    // Provider tempProvider;
    // ProviderReport tempReport;

    // tempProvider = providerRecords.getProvider(ID);

    // tempReport = new ProviderReport(tempProvider);
    // return tempReport;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
      LocalDateTime currentDateTime = LocalDateTime.now();
      String formattedDateTime = currentDateTime.format(formatter);

      String fileName = "ALL_Provider_Reports_" + formattedDateTime + ".txt";
      
      try (FileWriter writer = new FileWriter(fileName)) {
    	  
    	  //providers
        writer.write("Provider Reports\n");
        List<Provider> tempProvList = MainMenu.systemRecords.providerRecords.getAllProviders();
        ProviderReport tempProvReport;
        String currProvider;
        for(int i = 0; i <tempProvList.size(); i++) {
          tempProvReport = new ProviderReport(tempProvList.get(i));
          currProvider = tempProvReport.toString();
          writer.write(currProvider);
        }

      } catch (IOException e) {
          e.printStackTrace();
      }

  }

  /**
   * Generates a Member report
   */
  public void generateMemberReport() {
    // Member tempMember;
    // MemberReport tempReport;

    // tempMember = memberRecords.getMember(ID);


    // tempReport = new MemberReport(tempMember);
    // return tempReport;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
      LocalDateTime currentDateTime = LocalDateTime.now();
      String formattedDateTime = currentDateTime.format(formatter);

      String fileName = "ALL_Member_Reports_" + formattedDateTime + ".txt";
      
      try (FileWriter writer = new FileWriter(fileName)) {

        //members
        writer.write("Member Reports\n");
        List<Member> tempMemList = MainMenu.systemRecords.memberRecords.getAllMembers();
        MemberReport tempMemReport;
        String currMember;
        for(int i = 0; i <tempMemList.size(); i++) {
          tempMemReport = new MemberReport(tempMemList.get(i));
          currMember = tempMemReport.toString();
          writer.write(currMember);
        }

      } catch (IOException e) {
          e.printStackTrace();
      }

  }

  /**
   * Generates all reports
   *
   */
  public void generateAllReports() {
	  
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
      LocalDateTime currentDateTime = LocalDateTime.now();
      String formattedDateTime = currentDateTime.format(formatter);

      String fileName = "ALL_Reports_" + formattedDateTime + ".txt";
      
      try (FileWriter writer = new FileWriter(fileName)) {
          
    	  //summary report
    	  writer.write(SumReport.toString());
    	  
    	  //providers
        writer.write("Provider Reports\n");
        List<Provider> tempProvList = MainMenu.systemRecords.providerRecords.getAllProviders();
        ProviderReport tempProvReport;
        String currProvider;
        for(int i = 0; i <tempProvList.size(); i++) {
          tempProvReport = new ProviderReport(tempProvList.get(i));
          currProvider = tempProvReport.toString();
          writer.write(currProvider);
        }

        //members
        writer.write("Member Reports\n");
        List<Member> tempMemList = MainMenu.systemRecords.memberRecords.getAllMembers();
        MemberReport tempMemReport;
        String currMember;
        for(int i = 0; i <tempMemList.size(); i++) {
          tempMemReport = new MemberReport(tempMemList.get(i));
          currMember = tempMemReport.toString();
          writer.write(currMember);
        }

      } catch (IOException e) {
          e.printStackTrace();
      }
      
  }

  public SummaryReport getSummaryReport() {
    return SumReport;
  }

  public List<ProviderReport> getProviderReports() {
    return ProReports;
  }

  public List<MemberReport> getMemberReports() {
    return MemReports;
  }
}
