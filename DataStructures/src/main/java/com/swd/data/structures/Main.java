package com.swd.data.structures;

import com.swd.data.structures.graph.Graph;
import com.swd.data.structures.linkedlist.DoublyLinkedList;
import com.swd.data.structures.stack.Stack;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {

        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");

        System.out.println("Graph:");
        myGraph.printAdjacencyMatrix();

    }

}