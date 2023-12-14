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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author cchall5
 * The operator terminal class. Handles operator functions: updating members and providers.
 */
public class OperatorTerminal {

  static UpdateMemberController memberController = new UpdateMemberController();;
  static UpdateProviderController providerController = new UpdateProviderController();
  static JPanel mainPanel = new JPanel(new BorderLayout());

  public static void main(String[] args) {

    //operator terminal menu
    boolean go = true;
    while (go) {

      //display menu
      System.out.println("Welcome to the ChocAn Operator Terminal!");
      System.out.println("Please choose an option:");
      System.out.println("1. Update Member");
      System.out.println("2. Update Provider");
      System.out.println("3. Exit");

      //read in an integer from user
      int input = 0;
      Scanner s = new Scanner(System.in);
      while(input < 1 || input > 3) {
        input = s.nextInt();
      }

      //handle user input
      switch (input) {
      case 1:
        updateMemberRecords();
        break;
      case 2:
        updateProviderRecords();
        break;
      case 3:
        System.out.println("Closing Operator Terminal.");
        go = false;
        break;
      }

      s.close();
    }
  }
  public static JPanel createOperatorPanel(JFrame myFrame) {
    JPanel providerPanel = new JPanel();

    // Ask for the password using a JOptionPane
    String enteredPassword = getPasswordFromUser();
    String password = "password";
    // Check if the entered password is correct
    if (enteredPassword == null || !enteredPassword.equals(password)) {
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
      providerPanel.add(buttonPanel, BorderLayout.CENTER);
      return providerPanel; // Do not proceed if the password is incorrect
    }
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(3, 3, 5, 5));

    JButton editMemberButton = new JButton("Edit Member");
    JButton editProviderButton = new JButton("Edit Provider");
    JButton exitButton = new JButton("Exit");

    buttonPanel.add(editMemberButton);
    buttonPanel.add(editProviderButton);
    buttonPanel.add(exitButton);

    editMemberButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton editButton = new JRadioButton("Edit Member");
        JRadioButton addButton = new JRadioButton("Add Member");
        JRadioButton deleteButton = new JRadioButton("Delete Member");

        buttonGroup.add(editButton);
        buttonGroup.add(addButton);
        buttonGroup.add(deleteButton);

        panel.add(editButton);
        panel.add(addButton);
        panel.add(deleteButton);

        int result = JOptionPane.showConfirmDialog(
            null, panel, "Modify Member List", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
          // User clicked OK, process the input

          if (editButton.isSelected()) {
            // Handle edit member logic
            JPanel panel1 = new JPanel(new GridLayout(0, 2));

            JTextField memberIDField = new JTextField();
            JTextField nameField = new JTextField();
            JTextField addressField = new JTextField();
            JTextField cityField = new JTextField();
            JTextField stateField = new JTextField();
            JTextField zipField = new JTextField();
            JTextField statusField = new JTextField();

            panel1.add(new JLabel("Member ID:"));
            panel1.add(memberIDField);
            panel1.add(new JLabel("Name:"));
            panel1.add(nameField);
            panel1.add(new JLabel("Address:"));
            panel1.add(addressField);
            panel1.add(new JLabel("City:"));
            panel1.add(cityField);
            panel1.add(new JLabel("State:"));
            panel1.add(stateField);
            panel1.add(new JLabel("ZIP:"));
            panel1.add(zipField);
            panel1.add(new JLabel("Status:"));
            panel1.add(statusField);

            int result1 = JOptionPane.showConfirmDialog(
                null, panel1, "Edit Member", JOptionPane.OK_CANCEL_OPTION);

            if (result1 == JOptionPane.OK_OPTION) {
              // User clicked OK, process the input

              try {
                int memberID = Integer.parseInt(memberIDField.getText());
                String name = nameField.getText();
                String address = addressField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                int zip = Integer.parseInt(zipField.getText());
                String status = statusField.getText();

                // Add member logic
                memberController.editMemberData(memberID, name, address, city, state, zip, status);
                JOptionPane.showMessageDialog(null, "Member edited successfully!");
              } catch (IllegalArgumentException ex) {
                // Handle invalid input or illegal argument exception
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid information.", "Input Error", JOptionPane.ERROR_MESSAGE);
              }
            } else {
              // User clicked Cancel or closed the dialog
            }
          } else if (addButton.isSelected()) {
            // Handle add member logic
            JPanel panel1 = new JPanel(new GridLayout(0, 2));

            JTextField memberIDField = new JTextField();
            JTextField nameField = new JTextField();
            JTextField addressField = new JTextField();
            JTextField cityField = new JTextField();
            JTextField stateField = new JTextField();
            JTextField zipField = new JTextField();
            JTextField statusField = new JTextField();

            panel1.add(new JLabel("Member ID:"));
            panel1.add(memberIDField);
            panel1.add(new JLabel("Name:"));
            panel1.add(nameField);
            panel1.add(new JLabel("Address:"));
            panel1.add(addressField);
            panel1.add(new JLabel("City:"));
            panel1.add(cityField);
            panel1.add(new JLabel("State:"));
            panel1.add(stateField);
            panel1.add(new JLabel("ZIP:"));
            panel1.add(zipField);
            panel1.add(new JLabel("Status:"));
            panel1.add(statusField);

            int result1 = JOptionPane.showConfirmDialog(
                null, panel1, "Add Member", JOptionPane.OK_CANCEL_OPTION);

            if (result1 == JOptionPane.OK_OPTION) {
              // User clicked OK, process the input

              try {
                int memberID = Integer.parseInt(memberIDField.getText());
                String name = nameField.getText();
                String address = addressField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                int zip = Integer.parseInt(zipField.getText());
                String status = statusField.getText();

                // Add member logic
                memberController.addMember(memberID, name, address, city, state, zip, status);
                JOptionPane.showMessageDialog(null, "Member added successfully!");
              } catch (IllegalArgumentException ex) {
                // Handle invalid input or illegal argument exception
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid information.", "Input Error", JOptionPane.ERROR_MESSAGE);
              }
            } else {
              // User clicked Cancel or closed the dialog
            }
          } else if (deleteButton.isSelected()) {
            // Handle delete member logic
            JPanel panel1 = new JPanel(new GridLayout(0, 2));

            JTextField memberIDField = new JTextField();

            panel1.add(new JLabel("Member ID:"));
            panel1.add(memberIDField);

            int result1 = JOptionPane.showConfirmDialog(
                null, panel1, "Delete Member", JOptionPane.OK_CANCEL_OPTION);

            if (result1 == JOptionPane.OK_OPTION) {
              // User clicked OK, process the input

              try {
                int memberID = Integer.parseInt(memberIDField.getText());
                memberController.deleteMember(memberID);
                JOptionPane.showMessageDialog(null, "Member deleted successfully!");
              } catch (IllegalArgumentException ex) {
                // Handle invalid input or illegal argument exception
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid information.", "Input Error", JOptionPane.ERROR_MESSAGE);
              }

            } else {
              // User clicked Cancel or closed the dialog
            }
          }
        }
      }
    });

    editProviderButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton editButton = new JRadioButton("Edit Provider");
        JRadioButton addButton = new JRadioButton("Add Provider");
        JRadioButton deleteButton = new JRadioButton("Delete Provider");

        buttonGroup.add(editButton);
        buttonGroup.add(addButton);
        buttonGroup.add(deleteButton);

        panel.add(editButton);
        panel.add(addButton);
        panel.add(deleteButton);

        int result = JOptionPane.showConfirmDialog(
            null, panel, "Modify Provider List", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
          // User clicked OK, process the input

          if (editButton.isSelected()) {
            // Handle edit provider logic
            JPanel panel1 = new JPanel(new GridLayout(0, 2));

            JTextField providerIDField = new JTextField();
            JTextField nameField = new JTextField();
            JTextField addressField = new JTextField();
            JTextField cityField = new JTextField();
            JTextField stateField = new JTextField();
            JTextField zipField = new JTextField();
            JTextField statusField = new JTextField();

            panel1.add(new JLabel("Provider ID:"));
            panel1.add(providerIDField);
            panel1.add(new JLabel("Name:"));
            panel1.add(nameField);
            panel1.add(new JLabel("Address:"));
            panel1.add(addressField);
            panel1.add(new JLabel("City:"));
            panel1.add(cityField);
            panel1.add(new JLabel("State:"));
            panel1.add(stateField);
            panel1.add(new JLabel("ZIP:"));
            panel1.add(zipField);
            panel1.add(new JLabel("Status:"));
            panel1.add(statusField);

            int result1 = JOptionPane.showConfirmDialog(
                null, panel1, "Edit Provider", JOptionPane.OK_CANCEL_OPTION);

            if (result1 == JOptionPane.OK_OPTION) {
              // User clicked OK, process the input

              try {
                int providerID = Integer.parseInt(providerIDField.getText());
                String name = nameField.getText();
                String address = addressField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                int zip = Integer.parseInt(zipField.getText());
                String status = statusField.getText();

                // Add provider logic
                providerController.editProviderData(providerID, name, address, city, state, zip, status);
                JOptionPane.showMessageDialog(null, "Provider edited successfully!");
              } catch (IllegalArgumentException ex) {
                // Handle invalid input or illegal argument exception
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid information.", "Input Error", JOptionPane.ERROR_MESSAGE);
              }
            } else {
              // User clicked Cancel or closed the dialog
            }
          } else if (addButton.isSelected()) {
            // Handle add provider logic
            JPanel panel1 = new JPanel(new GridLayout(0, 2));

            JTextField providerIDField = new JTextField();
            JTextField nameField = new JTextField();
            JTextField addressField = new JTextField();
            JTextField cityField = new JTextField();
            JTextField stateField = new JTextField();
            JTextField zipField = new JTextField();
            JTextField statusField = new JTextField();

            panel1.add(new JLabel("Provider ID:"));
            panel1.add(providerIDField);
            panel1.add(new JLabel("Name:"));
            panel1.add(nameField);
            panel1.add(new JLabel("Address:"));
            panel1.add(addressField);
            panel1.add(new JLabel("City:"));
            panel1.add(cityField);
            panel1.add(new JLabel("State:"));
            panel1.add(stateField);
            panel1.add(new JLabel("ZIP:"));
            panel1.add(zipField);
            panel1.add(new JLabel("Status:"));
            panel1.add(statusField);

            int result1 = JOptionPane.showConfirmDialog(
                null, panel1, "Add Provider", JOptionPane.OK_CANCEL_OPTION);

            if (result1 == JOptionPane.OK_OPTION) {
              // User clicked OK, process the input

              try {
                int providerID = Integer.parseInt(providerIDField.getText());
                String name = nameField.getText();
                String address = addressField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                int zip = Integer.parseInt(zipField.getText());
                String status = statusField.getText();

                // Add provider logic
                providerController.addProvider(providerID, name, address, city, state, zip, status);
                JOptionPane.showMessageDialog(null, "Provider added successfully!");
              } catch (IllegalArgumentException ex) {
                // Handle invalid input or illegal argument exception
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid information.", "Input Error", JOptionPane.ERROR_MESSAGE);
              }
            } else {
              // User clicked Cancel or closed the dialog
            }
          } else if (deleteButton.isSelected()) {
            // Handle delete provider logic
            JPanel panel1 = new JPanel(new GridLayout(0, 2));

            JTextField providerIDField = new JTextField();

            panel1.add(new JLabel("Provider ID:"));
            panel1.add(providerIDField);

            int result1 = JOptionPane.showConfirmDialog(
                null, panel1, "Delete Provider", JOptionPane.OK_CANCEL_OPTION);

            if (result1 == JOptionPane.OK_OPTION) {
              // User clicked OK, process the input

              try {
                int providerID = Integer.parseInt(providerIDField.getText());
                providerController.deleteProvider(providerID);
                JOptionPane.showMessageDialog(null, "Provider deleted successfully!");
              } catch (IllegalArgumentException ex) {
                // Handle invalid input or illegal argument exception
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid information.", "Input Error", JOptionPane.ERROR_MESSAGE);
              }

            } else {
              // User clicked Cancel or closed the dialog
            }
          }
        }
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


  //creates controller to handle updating a member
  public static void updateMemberRecords() {
    memberController = new UpdateMemberController();
  }

  //creates controller to handle updating a provider
  public static void updateProviderRecords() {
    providerController = new UpdateProviderController();
  }
  
  private static String getPasswordFromUser() {
    // Prompt the user for the password using a JOptionPane
    return JOptionPane.showInputDialog(null, "Enter Operator Password:", "Password Protection", JOptionPane.PLAIN_MESSAGE);
  }

}