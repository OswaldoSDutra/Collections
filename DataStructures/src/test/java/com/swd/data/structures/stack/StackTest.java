package com.swd.data.structures.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class StackTest {

    private final ByteArrayOutputStream testStream = new ByteArrayOutputStream();
    private final PrintStream systemStream = System.out;

    @Before
    public void tearUp(){
        System.setOut(new PrintStream(testStream));
    }

    @After
    public void tearDown(){
        System.setOut(systemStream);
    }

    @Test
    public void sould_print_all() {

        BasicStack myStack = new BasicStack(4);

        myStack.printAll();

        String message = testStream.toString();

        assertTrue(message.contains("Top: 4"));
        assertTrue(message.contains("Height: 1"));
        assertTrue(message.contains("Stack:"));

        /*
            EXPECTED OUTPUT:
            ----------------
            Top: 4
            Height: 1

            Stack:
            4
        */
    }


}
