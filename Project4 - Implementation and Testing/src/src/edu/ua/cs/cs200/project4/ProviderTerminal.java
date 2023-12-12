package edu.ua.cs.cs200.project4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * @author Alexander Steffey
 */

public class ProviderTerminal {

  //Classes
  private static ProviderController providerController = new ProviderController();
  // Declare a flag to track whether validateMemberButton has been pressed
  static boolean validateMemberButtonPressed = false;
  static boolean billChocAnButtonPressed = false;


  // Main logic for the ProviderTerminal class
  public static void main(String args[]) {
  }

  public static JPanel createProviderPanel(JFrame myFrame) {
    JPanel providerPanel = new JPanel();

    // Ask for the password using a JOptionPane
    String enteredPassword = getPasswordFromUser();

    // Check if the entered password is correct
    if (enteredPassword == null || null == providerController.providerRecords.getProvider(Integer.parseInt(enteredPassword))) {
      JOptionPane.showMessageDialog(null, "Incorrect password. Access denied.", "Authentication Error", JOptionPane.ERROR_MESSAGE);
      JPanel buttonPanel = new JPanel();
      JButton exitButton = new JButton("Exit");
      buttonPanel.add(exitButton);
      exitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          myFrame.dispose();
        }
      });
      providerPanel.setLayout(new BorderLayout());
      providerPanel.add(buttonPanel, BorderLayout.WEST);
      return providerPanel; // Do not proceed if the password is incorrect
    }

    JTextArea textArea = new JTextArea();
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);

    JPanel inputPanel = new JPanel();
    JTextField inputField = new JTextField(20);
    JButton submitButton = new JButton("Submit");

    inputPanel.add(inputField);
    inputPanel.add(submitButton);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4, 1, 5, 5));

    JButton validateMemberButton = new JButton("Validate Member");
    JButton billChocAnButton = new JButton("Bill ChocAn");
    JButton requestProviderDirectoryButton = new JButton("Request Provider Directory");
    JButton exitButton = new JButton("Exit");

    buttonPanel.add(validateMemberButton);
    buttonPanel.add(billChocAnButton);
    buttonPanel.add(requestProviderDirectoryButton);
    buttonPanel.add(exitButton);

    validateMemberButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append("Validating Member...\n");
            textArea.append("Input Member Number:\n");

            // Set the flag when validateMemberButton is pressed
            validateMemberButtonPressed = true;
        }
    });

    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (validateMemberButtonPressed) {
                // If validateMemberButton has been pressed, proceed with the logic
                String userInput = inputField.getText();
                textArea.append("User Input: " + userInput + "\n");

                try {
                    textArea.append(providerController.validateMember(Integer.parseInt(userInput)) + "\n");
                } catch (NumberFormatException ex) {
                    // Handle the case where the user input is not a valid int
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }

                // Reset the flag
                validateMemberButtonPressed = false;
            }
            if (billChocAnButtonPressed) {
              // If validateMemberButton has been pressed, proceed with the logic
              String userInput = inputField.getText();
              textArea.append("User Input: " + userInput + "\n");

              try {
                  textArea.append(providerController.validateMember(Integer.parseInt(userInput)) + "\n");
                  if (providerController.validateMember(Integer.parseInt(userInput)) == "Member validated") {
                    providerController.billChocAnGUI(Integer.parseInt(userInput), Integer.parseInt(enteredPassword));
                  }
              } catch (NumberFormatException ex) {
                  // Handle the case where the user input is not a valid int
                  JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
              }

              // Reset the flag
              billChocAnButtonPressed = false;
          }
        }
    });


    billChocAnButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textArea.append("Billing ChocAn:\n");
        textArea.append("Input Member Number:\n");
        billChocAnButtonPressed = true;
        
      }
    });

    requestProviderDirectoryButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textArea.append("Requesting Provider Directory...\n");
        textArea.append(providerController.requestProviderDirectory());
      }
    });

    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textArea.append("Exiting Provider Terminal...\n");
        myFrame.dispose();
      }
    });

    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String userInput = inputField.getText();
        //textArea.append("User Input: " + userInput + "\n");
        // Add your logic to handle the user input here
      }
    });

    providerPanel.setLayout(new BorderLayout());
    providerPanel.add(scrollPane, BorderLayout.CENTER);
    providerPanel.add(buttonPanel, BorderLayout.WEST);
    providerPanel.add(inputPanel, BorderLayout.SOUTH);

    return providerPanel;
  }

  private static String getPasswordFromUser() {
    // Prompt the user for the password using a JOptionPane
    return JOptionPane.showInputDialog(null, "Enter ProviderID:", "Password Protection", JOptionPane.PLAIN_MESSAGE);
  }

  public static void startTerminal() {

    boolean go = true;
    Scanner s = new Scanner(System.in);

    while (go) {
      //display provider terminal
      System.out.println("Welcome to the ChocAn Provider Terminal!");

      System.out.println("Please enter your provider ID number: ");
      int providerID = s.nextInt();

      System.out.println("Please choose an option:");
      System.out.println("1. Validate Member");
      System.out.println("2. Bill ChocAn");
      System.out.println("3. Request Provider Directory");
      System.out.println("4. Exit");

      //read in an integer from user
      int input = 0;
      while(input < 1 || input > 5) {
        input = s.nextInt();
      }

      //handle user input
      switch (input) {
      case 1:
        validateMember();
        break;
      case 2:
        billChocAn(0, 0);
        break;
      case 3:
        requestProviderDirectory();
        break;
      case 4:
        go = false;
        break;
      }

    }
  }

  public static void validateMember() {
    //finish implementing
    providerController.validateMember();
  }

  public static void billChocAn(int providerID, int memberID) {
    //finish implementing
    providerController.billChocAn(providerID, memberID);
  }

  public static void requestProviderDirectory() {
    //finish implementing
    //DJ is working on this
    providerController.requestProviderDirectory();
  }
}
