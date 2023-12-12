package edu.ua.cs.cs200.project4;

import java.util.ArrayList;
import java.util.List;
/**
 * Manages the creation of all types of reports
 * 
 * @Author Javier Caldwell
 * @version 1.0
 */
public class ReportController {

  SummaryReport SumReport;
  List<ProviderReport> ProReports = new ArrayList<ProviderReport>();
  List<MemberReport> MemReports = new ArrayList<MemberReport>();;
  MemberRecords memberRecords = new MemberRecords();
  ProviderRecords providerRecords = new ProviderRecords();
  


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
   * @return a ProviderReport
   */
  public ProviderReport generateProviderReport(int ID) {
    Provider tempProvider;
    ProviderReport tempReport;

    tempProvider = providerRecords.getProvider(ID);

    tempReport = new ProviderReport(tempProvider);
    return tempReport;
  }

  /**
   * Generates a Manager report
   * @return a ManagerReport
   */
  public MemberReport generateMemberReport(int ID) {
    Member tempMember;
    MemberReport tempReport;

    tempMember = memberRecords.getMember(ID);


    tempReport = new MemberReport(tempMember);
    return tempReport;
  }

  /**
   * Generates all reports
   *
   */
  public void generateAllReports() {
    generateSummaryReport();

    ProviderReport tempProvReport;
    MemberReport tempMemReport;
    List<Provider> tempProvList = providerRecords.getAllProviders();
    List<Member> tempMemList = memberRecords.getAllMembers();

    for(int i = 0; i <tempProvList.size(); i++) {
      tempProvReport = new ProviderReport(tempProvList.get(i));
      tempProvReport.printToFile();
      ProReports.add(tempProvReport);
    }


    for(int i = 0; i <tempMemList.size(); i++) {
      tempMemReport = new MemberReport(tempMemList.get(i));
      tempMemReport.printToFile();
      MemReports.add(tempMemReport);
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
