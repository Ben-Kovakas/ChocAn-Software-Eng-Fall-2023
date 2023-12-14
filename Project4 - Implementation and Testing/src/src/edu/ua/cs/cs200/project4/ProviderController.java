package edu.ua.cs.cs200.project4;

import java.util.List;
import java.util.Scanner;

import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ua.cs.cs200.project4.ProviderDirectory.ServiceInfo;
/**
 * @author Alexander Steffey
 */


public class ProviderController {

  public ProviderController() {
  }
  public String validateMember(int memberID) {
    Member member = MainMenu.systemRecords.memberRecords.getMember(memberID);

    if (member == null) {
      return "Error: Invalid member";
    }

    String status = member.getStatus();
    if (status.equals("VALID")) {
      return ("Member validated");
    } else if (status.equals("SUSPENDED")) {
      return ("Member is suspended. Services not allowed.");
    }
    return "Error: Invalid member";
  }
  //Main logic of Validate Member use case
  public boolean validateMember() {
    Scanner scanner = new Scanner(System.in);

    //Enter memberID
    System.out.print("Enter Member ID: ");
    int memberID = scanner.nextInt();

    Member member = MainMenu.systemRecords.memberRecords.getMember(memberID);

    //If no member found, print error
    if (member == null) {
      System.out.println("Error: Invalid member");
      return false;
    }

    //Return member status
    String status = member.getStatus();
    if (status.equals("VALID")) {
      System.out.println("Member validated");
      return true;
    } else if (status.equals("SUSPENDED")) {
      System.out.println("Member is suspended. Services not allowed.");
      return false;
    } 
    return false;
  }

  //Main logic of Bill ChocAn use case
  public boolean billChocAn(int providerID, int memberID) {
    if (!validateMember()) {
      return false;
    }

    Scanner scanner = new Scanner(System.in);

    //Find service code
    System.out.print("Enter the service name: ");
    String serviceName = scanner.nextLine();

    int serviceCode = MainMenu.systemRecords.providerDirectory.getServiceCode(serviceName);
    if (serviceCode == -1) {
      System.out.println("Error: Nonexistent service");
      return false;
    }
    System.out.println("Service code: " + serviceCode);

    //Confirm service code
    System.out.print("Enter the service code: ");
    int EnteredCode = scanner.nextInt();
    if (EnteredCode != serviceCode) {
      System.out.println("Error: Service codes do not match");
      return false;
    }

    //Confirm services
    System.out.println("Please choose an option:");
    System.out.println("1. Verify");
    System.out.println("2. Cancel");
    int option = scanner.nextInt();

    if (option == 2) {
      System.out.println("Service canceled.");
      return false;
    }

    System.out.print("Enter any additional comments (up to 100 characters): ");
    scanner.nextLine();
    String comments = scanner.nextLine();

    //TODO fix write a record, same as ProviderReport
    // Current date and time (MM–DD–YYYY HH:MM:SS). 
    //Date service was provided (MM–DD–YYYY). 
    //Provider number (9 digits).
    //Member number (9 digits). 
    //Service code (6 digits).
    //Comments (100 characters) (optional). 

    //Enter service record info
    double fee = MainMenu.systemRecords.providerDirectory.getServiceInfo(serviceCode).getFee();
    System.out.println("Fee: $" + fee);
    System.out.print("Enter the current date (MM-DD-YYYY): ");
    String inputCurrentDate = scanner.next();
    System.out.print("Enter the date of service (MM-DD-YYYY): ");
    String inputServiceDate = scanner.next();
    System.out.print("Enter member name: ");
    String inputMemberName = scanner.next();
    System.out.print("Enter member number: ");
    int inputMemberNumber = Integer.parseInt(scanner.next());
    System.out.print("Enter service code: ");
    int inputServiceCode = Integer.parseInt(scanner.next());
    System.out.print("Enter fee: ");
    double inputFee = Integer.parseInt(scanner.next());

    //Save service record info
    ServiceRecord serviceRecord = new ServiceRecord(inputServiceCode, inputCurrentDate, inputServiceDate, inputFee, inputMemberName, inputMemberNumber);
    Member member = MainMenu.systemRecords.memberRecords.getMember(memberID);
    if (member != null) {
      List<ServiceRecord> memberServiceRecords = member.getServiceRecords();
      memberServiceRecords.add(serviceRecord);
    }

    Provider provider = MainMenu.systemRecords.providerRecords.getProvider(providerID);
    if (provider != null) {
      List<ServiceRecord> providerServiceRecords = provider.getServiceRecords();
      providerServiceRecords.add(serviceRecord);
    }

    return true;
  }

  public boolean billChocAnGUI(int memberID, int providerID) {
    ServiceInfo nameInfo;
    JPanel panel = new JPanel(new GridLayout(0, 2));

    JTextField dateField = new JTextField();
    JTextField serviceCodeField = new JTextField();
    JTextField commentsField = new JTextField();
    
    panel.add(new JLabel("Service Code:"));
    panel.add(serviceCodeField);
    panel.add(new JLabel("Date of Service: (MM-DD-YYYY)"));
    panel.add(dateField);
    panel.add(new JLabel("Comments:"));
    panel.add(commentsField);

    int result = JOptionPane.showConfirmDialog(
        null, panel, "Enter Bill ChocAn Information", JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
      // User clicked OK, process the input
      String serviceCode = serviceCodeField.getText();
      String comments = commentsField.getText();
      String date = dateField.getText();
      nameInfo = MainMenu.systemRecords.providerDirectory.getServiceInfo(Integer.parseInt(serviceCode));
      if (nameInfo == null) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
      }
      else {
      panel.add(new JLabel("Service Name:"));
      panel.add(new JLabel(nameInfo.getServiceName()));

      int result1 = JOptionPane.showConfirmDialog(
          null, panel, "Enter Bill ChocAn Information", JOptionPane.YES_NO_OPTION);
      }
      if (result == JOptionPane.YES_OPTION) {
        //Save service record info
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm-dd-yyyy HH:MM:ss");
        LocalDateTime currentDateTime = LocalDateTime.now();
        String formattedDateTime = currentDateTime.format(formatter);
        ServiceRecord serviceRecord = new ServiceRecord(Integer.parseInt(serviceCode), formattedDateTime, date, MainMenu.systemRecords.providerDirectory.getServiceInfo(Integer.parseInt(serviceCode)).getFee(), MainMenu.systemRecords.memberRecords.getMember(memberID).getName(), memberID);
        Member member = MainMenu.systemRecords.memberRecords.getMember(memberID);
        if (member != null) {
          List<ServiceRecord> memberServiceRecords = member.getServiceRecords();
          memberServiceRecords.add(serviceRecord);
        }

        Provider provider = MainMenu.systemRecords.providerRecords.getProvider(providerID);
        if (provider != null) {
          List<ServiceRecord> providerServiceRecords = provider.getServiceRecords();
          providerServiceRecords.add(serviceRecord);
        }
        provider.setConsultations(provider.getConsultations()+1);
        JOptionPane.showMessageDialog(null, "ChocAn Billed! Record Saved", "Success!", JOptionPane.OK_OPTION);
      }
      
    } else {
      // User clicked Cancel or closed the dialog
    }
    
    return true;
  }

  //TODO write request directory (deliver as file, will update directory class)
  //DJ is working on this
  public String requestProviderDirectory() {
    return MainMenu.systemRecords.providerDirectory.getEntriesAlphabetically();
  }
}