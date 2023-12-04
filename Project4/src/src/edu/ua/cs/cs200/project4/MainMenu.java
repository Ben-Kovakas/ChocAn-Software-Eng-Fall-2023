package edu.ua.cs.cs200.project4;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class is responsible for displaying the main menu and handling the main program logic, including startup and shutdown.
 * @author cchall5
 */
public class MainMenu {

  //class objects
  static OperatorTerminal operatorTerminal = new OperatorTerminal();
  static ManagerTerminal managerTerminal = new ManagerTerminal();
  static ProviderTerminal providerTerminal = new ProviderTerminal();
  static Timer timer = new Timer();
  SystemRecords systemRecords;
  
  public static JFrame frame;
  public static JPanel mainPanel;
  public static JPanel cardPanel;
  public static JButton provTerminal, opTerminal, manTerminal, map, exit;

  //main logic of program - displays main menu and handles user input
  public static void main(String[] args) {
    GUI();
    //initialized when the program is started since this is the main function
    //still need to call methods later to load persistence characteristics 

    boolean go = true;
    while (go) {
      //display login screen
      GUI();
      initialize();
      System.out.println("Please choose an option:");
      System.out.println("1. Provider Terminal");
      System.out.println("2. Operator Terminal");
      System.out.println("3. Manager Terminal");
      System.out.println("4. Run Main Accounting Procedure");
      System.out.println("5. Exit");

      //read in an integer from user
      int input = 0;
      Scanner s = new Scanner(System.in);
      while(input < 1 || input > 5) {
        input = s.nextInt();
      }

      //logic for each option
      switch (input) {
      case 1:
        //provider terminal
        providerTerminal = new ProviderTerminal();
        break;
      case 2:
        //operator terminal
        operatorTerminal = new OperatorTerminal();
        break;
      case 3:
        //manager terminal
        managerTerminal = new ManagerTerminal();
        break;
      case 4:
        //run main accounting procedure
        timer = new Timer();
        timer.RunProcedure();
        break;
      case 5:
        //exit
        go = false;
        shutdown();	
        break;
      }
      s.close();
    }
  }
    //initialize the program
    public static void initialize() {

      //TODO - persistence logic?

      //initialize class objects - done in main()
      //		operatorTerminal = new OperatorTerminal();
      //		managerTerminal = new ManagerTerminal();
      //		providerTerminal = new ProviderTerminal();
      //		systemRecords = new SystemRecords();
      //		timer = new Timer();

    }

    private static void GUI() {
      frame = new JFrame("ChocAn System");
      frame.setSize(800, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      mainPanel = new JPanel(); // Use FlowLayout for horizontal arrangement
      cardPanel = new JPanel(new CardLayout());

      addButtonToPanel("Provider Terminal");
      addButtonToPanel("Operator Terminal");
      addButtonToPanel("Manager Terminal");
      addButtonToPanel("Map");
      addButtonToPanel("Exit");

      frame.setLayout(new BorderLayout());
      frame.add(mainPanel, BorderLayout.CENTER);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    }

    private static void addButtonToPanel(String buttonText) {
      JButton button = new JButton(buttonText);
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          handleButtonClick(buttonText);
        }
      });

      mainPanel.add(button); // Do not specify BorderLayout.NORTH here
    }

    private static void handleButtonClick(String buttonText) {
      if ("Exit".equals(buttonText)) {
        frame.dispose();
        System.exit(0);
      } else {
        openNewTerminal(buttonText);
      }
    }

      private static void openNewTerminal(String terminalType) {
        JFrame terminalFrame = new JFrame(terminalType);
        terminalFrame.setSize(800, 400);

        if ("Provider Terminal".equals(terminalType)) {
          terminalFrame.add(ProviderTerminal.createProviderPanel(terminalFrame));
        } else if ("Operator Terminal".equals(terminalType)) {
          terminalFrame.add(OperatorTerminal.createOperatorPanel(terminalFrame));
        } else if ("Manager Terminal".equals(terminalType)) {
          terminalFrame.add(ManagerTerminal.createManagerPanel(terminalFrame));
        } else if ("Map".equals(terminalType)) {
          terminalFrame.add(createMapPanel());
        }

        terminalFrame.setLocationRelativeTo(null);
        terminalFrame.setVisible(true);
      }

      private static JPanel createMapPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Welcome to the Map!");
        panel.add(label);
        return panel;
      }

      //shutdown the program
      public static void shutdown() {
        //TODO - logic to shutdown program - persistence?

        System.out.println("Goodbye!");
      }

    }
