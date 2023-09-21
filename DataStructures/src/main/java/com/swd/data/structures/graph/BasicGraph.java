package com.swd.data.structures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasicGraph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public HashMap<String, ArrayList<String>> getAdjList() {
        return adjList;
    }

    public void printAdjacencyList() {
        System.out.println(adjList);
    }

    public void printAdjacencyMatrix() {
        int size = adjList.entrySet().size();
        String[][] matrix = new String[size][size];
        String[] vertices = new String[size];

        int outerIndex = 0;

        System.out.print(" ");
        for(String vertex : adjList.keySet()) {
            System.out.print(" " + vertex);
            vertices[outerIndex] = vertex;
            outerIndex++;
        }

        System.out.println();

        outerIndex = 0;
        for(Map.Entry<String, ArrayList<String>> vertex : adjList.entrySet()) {

            System.out.print(vertex.getKey() + " ");

            for (int i = 0; i < vertices.length; i++) {
                matrix[outerIndex][i] = vertex.getValue().contains(vertices[i]) ? "1" : "0";
                System.out.print(matrix[outerIndex][i] + " ");
            }

            outerIndex++;
            System.out.println();
        }
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null) return false;
        for (String otherVertex : adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

}
