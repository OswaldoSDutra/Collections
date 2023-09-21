package com.swd.data.structures;

import com.swd.data.structures.graph.Graph;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

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

        //graph.printVertices();
        //graph.printEdges();
        //graph.printDFS("1");

        graph.printBFS("1");
    }

}