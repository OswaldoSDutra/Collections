package com.swd.data.structures.heap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MaxHeapTest {

    MaxHeap myHeap = new MaxHeap();

    @Before
    public void tearUp(){

        myHeap.insert(95);
        myHeap.insert(75);
        myHeap.insert(80);
        myHeap.insert(55);
        myHeap.insert(60);
        myHeap.insert(50);
        myHeap.insert(65);
    }

    @After
    public void tearDown(){
        myHeap = null;
    }

    @Test
    public void should_remove_max(){

        assertEquals(myHeap.getHeap(), Arrays.asList(95, 75, 80, 55, 60, 50, 65));

        myHeap.remove();

        assertEquals(myHeap.getHeap(), Arrays.asList(80, 75, 65, 55, 60, 50));

    }

}
