package edu.ua.cs.cs200.project4;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Creates a Member Report
 * 
 * @Author Javier Caldwell
 * @version 1.0
 */
public class MemberReport {
	
	private List<ServiceRecord> services;
	
	private Member member;
	
	/** Constructor. Creates the Member Report using a member
	 * @param  newMember
	 * 					the inputed member
	 * */
	public MemberReport(Member newMember) {
		services = newMember.getServiceRecords();
		member = newMember;
	}
	
	/**
	 * Gets the service records
	 * @return a List of ServiceRecords
	 */
	public List<ServiceRecord> getMemberServices(){
		return services;
	}
	
    public void printToFile() {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
      LocalDateTime currentDateTime = LocalDateTime.now();
      String formattedDateTime = currentDateTime.format(formatter);

      String fileName = member.getName() + "_" + formattedDateTime + ".txt";

      try (FileWriter writer = new FileWriter(fileName)) {
          writer.write("Member Report\n\n");
          writer.write("Member ID: " + member.getMemberID() + "\n");
          writer.write("Name: " + member.getName() + "\n");
          writer.write("Address: " + member.getAddress() + "\n");
          writer.write("City: " + member.getCity() + "\n");
          writer.write("State: " + member.getState() + "\n");
          writer.write("ZIP Code: " + member.getZip() + "\n");
          // Add other member information as needed

      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}
