package edu.ua.cs.cs200.project4;

import java.util.ArrayList;
import java.util.List;

public class SystemRecords {
  public ProviderRecords providerRecords;
  public MemberRecords memberRecords;
  public EFTRecords eftRecords;
  public List<SummaryReport> summaryReports;
  public List<MemberReport> memberReports;
  
  public SystemRecords() {
    providerRecords = new ProviderRecords();
    memberRecords = new MemberRecords();
    eftRecords = new EFTRecords();
    summaryReports = new ArrayList<SummaryReport>();
    memberReports = new ArrayList<MemberReport>();
  }
}
