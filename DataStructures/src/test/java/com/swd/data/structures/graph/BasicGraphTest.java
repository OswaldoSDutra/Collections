package com.swd.data.structures.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BasicGraphTest {

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
    public void should_print_adjacencyList(){
        BasicGraph myGraph = new BasicGraph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");

        System.out.println("Graph:");
        myGraph.printAdjacencyList();

        String output = testStream.toString();
        assertTrue(output.contains("{A=[B, C], B=[A, C], C=[A, B]}"));
    }

    @Test
    public void should_print_adjacencyMatrix() {
        BasicGraph myGraph = new BasicGraph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");

        System.out.println("Graph:");
        myGraph.printAdjacencyMatrix();

        String output = testStream.toString();

        assertTrue(output.contains("A 0 1 1"));
        assertTrue(output.contains("B 1 0 1"));
        assertTrue(output.contains("C 1 1 0"));
    }

}
