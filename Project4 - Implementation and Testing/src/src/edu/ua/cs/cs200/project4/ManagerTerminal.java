package edu.ua.cs.cs200.project4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * The {@code ManagerTerminal} class represents the interface for the system manager.
 * It allows a manager to generate various reports about the state of the ChocAn system.
 * 
 * @author rmmilsap
 */
public class ManagerTerminal {

  private static ReportController reportController;

  /**
   * Constructs a {@code ManagerTerminal} and initializes the associated {@code ReportController}.
   */
  public ManagerTerminal() {
    reportController = new ReportController();
  }
  /**
   * The main method that invokes the report request method.
   * It acts as an entry point for the manager's interactions.
   */
  public static void main(String[] args) {
    requestReport(); 
  }

  public static JPanel createManagerPanel(JFrame myFrame) {
    JPanel providerPanel = new JPanel();

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(3, 3, 5, 5));

    JButton summaryReportButton = new JButton("Generate Summary Report");
    JButton providerReportButton = new JButton("Generate Provider Report");
    JButton memberReportButton = new JButton("Generate Member Report");
    JButton exitButton = new JButton("Exit");

    buttonPanel.add(summaryReportButton);
    buttonPanel.add(providerReportButton);
    buttonPanel.add(memberReportButton);
    buttonPanel.add(exitButton);

    summaryReportButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          reportController.generateSummaryReport();
          JOptionPane.showMessageDialog(null, "Summary Report Generated!");
        } catch (IllegalArgumentException ex) {
          // Handle invalid input or illegal argument exception
          JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid information.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    
    providerReportButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // JPanel panel1 = new JPanel(new GridLayout(0, 2));

        // JTextField providerIDField = new JTextField();

        // panel1.add(new JLabel("Provider ID:"));
        // panel1.add(providerIDField);

        // int result1 = JOptionPane.showConfirmDialog(
        //     null, panel1, "Add Member", JOptionPane.OK_CANCEL_OPTION);

        // if (result1 == JOptionPane.OK_OPTION) {
        //   // User clicked OK, process the input

        //   try {
        //     int providerID = Integer.parseInt(providerIDField.getText());
        //     if (reportController.providerRecords.getProvider(providerID) != null) {
        //       reportController.generateProviderReport(providerID).printToFile();
        //       JOptionPane.showMessageDialog(null, "Provider Report Generated!");
        //     }
        //     else {
        //       throw new IllegalArgumentException();
        //     }
        //   } catch (IllegalArgumentException ex) {
        //     // Handle invalid input or illegal argument exception
        //     JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid information.", "Input Error", JOptionPane.ERROR_MESSAGE);
        //   }

        // } else {
        //   // User clicked Cancel or closed the dialog
        // }

          reportController.generateProviderReport();
          JOptionPane.showMessageDialog(null, "Provider Report Generated!");

      }
    });
    
    memberReportButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // JPanel panel1 = new JPanel(new GridLayout(0, 2));

        // JTextField memberIDField = new JTextField();

        // panel1.add(new JLabel("Member ID:"));
        // panel1.add(memberIDField);

        // int result1 = JOptionPane.showConfirmDialog(
        //     null, panel1, "Add Member", JOptionPane.OK_CANCEL_OPTION);

        // if (result1 == JOptionPane.OK_OPTION) {
        //   // User clicked OK, process the input

        //   try {
        //     int memberID = Integer.parseInt(memberIDField.getText());
        //     if (reportController.memberRecords.getMember(memberID) != null) {
        //       reportController.generateMemberReport().printToFile();
        //       JOptionPane.showMessageDialog(null, "Member Report Generated!");
        //     }
        //     else {
        //       throw new IllegalArgumentException();
        //     }
        //   } catch (IllegalArgumentException ex) {
        //     // Handle invalid input or illegal argument exception
        //     JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid information.", "Input Error", JOptionPane.ERROR_MESSAGE);
        //   }

        // } else {
        //   // User clicked Cancel or closed the dialog
        // }

          reportController.generateMemberReport();
          JOptionPane.showMessageDialog(null, "Member Report Generated!");

      }
    });

    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        myFrame.dispose();
      }
    });

    providerPanel.setLayout(new BorderLayout());
    providerPanel.add(buttonPanel, BorderLayout.CENTER);

    return providerPanel;
  }

    /**
     * Displays a menu for the manager to generate specific reports.
     * Handles the user input to select the type of report to generate.
     */
    public static void requestReport() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        do {
            System.out.println("\n--- Manager Terminal ---");
            System.out.println("Please choose an option:");
            System.out.println("1. Generate Summary Report");
            System.out.println("2. Generate Provider Report");
            System.out.println("3. Generate Member Report");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    reportController.generateSummaryReport();
                    break;
                case 2:
                    // System.out.print("Enter Provider ID: ");
                    // int providerID = scanner.nextInt();
                    // reportController.generateProviderReport(providerID);
                    reportController.generateProviderReport();
                    break;
                case 3:
                    // System.out.print("Enter Member ID: ");
                    // int memberID = scanner.nextInt();
                    // reportController.generateMemberReport(memberID);
                    reportController.generateMemberReport();
                    break;
                case 4:
                    System.out.println("Exiting Manager Terminal.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (input != 4);

        scanner.close();
        }

    
}
