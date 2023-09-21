package com.swd.data.structures.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class GraphTest {

    private final ByteArrayOutputStream testStream = new ByteArrayOutputStream();
    private final PrintStream systemStream = System.out;

    private final Graph graph = new Graph();

    @Before
    public void tearUp(){
        System.setOut(new PrintStream(testStream));

        /*

        Obs.: Graph reference in resources/images/graph-reference.png

        */

        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addVertex("7");
        graph.addVertex("8");
        graph.addVertex("9");
        graph.addVertex("10");
        graph.addVertex("11");
        graph.addVertex("12");

        graph.addEdge("10km", "1", "2");
        graph.addEdge("11Km", "1", "3");
        graph.addEdge("12Km", "1", "4");
        graph.addEdge("20Km", "2", "5");
        graph.addEdge("21Km", "2", "6");
        graph.addEdge("30Km", "4", "7");
        graph.addEdge("31Km", "4", "8");
        graph.addEdge("40Km", "5", "9");
        graph.addEdge("41Km", "5", "10");
        graph.addEdge("50Km", "7", "11");
        graph.addEdge("51Km", "7", "12");
    }

    @After
    public void tearDown(){
        System.setOut(systemStream);
    }

    @Test
    public void should_print_DFS(){

        graph.printDFS("1");

        String output = testStream.toString();

        assertTrue(output.contains("Vertex: 2, To: 5, Distance: 20Km "));
        assertTrue(output.contains("Vertex: 1, To: 2, Distance: 10km "));
        assertTrue(output.contains("Vertex: 5, To: 9, Distance: 40Km "));
        assertTrue(output.contains("Vertex: 5, To: 10, Distance: 41Km"));
        assertTrue(output.contains("Vertex: 2, To: 6, Distance: 21Km "));
        assertTrue(output.contains("Vertex: 1, To: 3, Distance: 11Km "));
        assertTrue(output.contains("Vertex: 1, To: 4, Distance: 12Km "));
        assertTrue(output.contains("Vertex: 4, To: 7, Distance: 30Km "));
        assertTrue(output.contains("Vertex: 7, To: 11, Distance: 50Km"));
        assertTrue(output.contains("Vertex: 7, To: 12, Distance: 51Km"));
        assertTrue(output.contains("Vertex: 4, To: 8, Distance: 31Km "));

    }

    @Test
    public void should_print_BSF(){

        graph.printBFS("1");

        String output = testStream.toString();

        assertTrue(output.contains("To: 2, Distance: 10km "));
        assertTrue(output.contains("To: 3, Distance: 11Km "));
        assertTrue(output.contains("To: 4, Distance: 12Km "));
        assertTrue(output.contains("To: 5, Distance: 20Km "));
        assertTrue(output.contains("To: 6, Distance: 21Km "));
        assertTrue(output.contains("To: 7, Distance: 30Km "));
        assertTrue(output.contains("To: 8, Distance: 31Km "));
        assertTrue(output.contains("To: 9, Distance: 40Km "));
        assertTrue(output.contains("To: 10, Distance: 41Km"));
        assertTrue(output.contains("To: 11, Distance: 50Km"));
        assertTrue(output.contains("To: 12, Distance: 51Km"));

    }

}
