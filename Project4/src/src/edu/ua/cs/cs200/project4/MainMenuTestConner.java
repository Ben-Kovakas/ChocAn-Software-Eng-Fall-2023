package edu.ua.cs.cs200.project4;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cchall5
 */
public class MainMenuTestConner {

	private MainMenu mainMenu;
	
	private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void provideInput(String data) {
        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);
    }

    @Test
    public void testMainMethod() {
        // Simulate user input (e.g., choosing option 5 to exit)
        provideInput("5\n");

        // Call the main method
        MainMenu.main(new String[]{});

        // Verify the output
        String output = outContent.toString();
        assertTrue(output.contains("Welcome to the ChocAn System!"));
        assertTrue(output.contains("Please choose an option:"));
        assertTrue(output.contains("Goodbye!"));
    }

}
