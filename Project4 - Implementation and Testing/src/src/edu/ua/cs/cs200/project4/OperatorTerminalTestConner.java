package edu.ua.cs.cs200.project4;

import static org.junit.Assert.*;

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
public class OperatorTerminalTestConner {

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
    public void testMainMethodQuit() {
     
    	//3 to quit
        provideInput("3\n");

        // Call the main method
        OperatorTerminal.main(new String[]{});

        // Verify the output
        String output = outContent.toString();
        assertTrue(output.contains("Closing Operator Terminal."));
        
    }

}
