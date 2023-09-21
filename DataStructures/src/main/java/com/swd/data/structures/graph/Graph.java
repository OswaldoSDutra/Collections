package com.swd.data.structures.graph;

import java.util.*;

public class Graph {

    private class GraphVertex{
        public String value;
        public ArrayList<GraphEdge> edges;

        public GraphVertex(String value){
            this.value = value;
            this.edges = new ArrayList<>();
        }
    }

    private class GraphEdge{
        public String value;
        public GraphVertex nodeTo;

        public GraphEdge(String value, GraphVertex to){
            this.value = value;
            this.nodeTo = to;
        }
    }

    private final Map<String, GraphVertex> vertices;
    private final List<String> visited;

    public Graph(){
        this.vertices =  new HashMap<>();
        this.visited = new ArrayList<>();
    }

    public void addVertex(String vertex){
        GraphVertex graphVertex = new GraphVertex(vertex);
        addVertex(graphVertex);
    }

    private void addVertex(GraphVertex vertex){

        if(!vertices.containsKey(vertex.value))
            vertices.put(vertex.value,vertex);
    }

    public void addEdge(String value, String from, String to){

        if(! vertices.containsKey(from))
            addVertex(from);

        if(! vertices.containsKey(to))
            addVertex(to);

        GraphVertex f =  vertices.get(from);
        GraphVertex t =  vertices.get(to);

        f.edges.add(new GraphEdge(value, t));
        //t.edges.add(new GraphEdge(value, f));
    }

    public void printVertices(){
        for (String v : vertices.keySet()) {
            System.out.println(v);
        }
    }

    public void printEdges(){
        for (Map.Entry<String, GraphVertex> v : vertices.entrySet()) {
            for(GraphEdge e : v.getValue().edges) {
                System.out.printf("\nFrom: %s, To: %s, Distance: %s ", v.getValue().value, e.nodeTo.value, e.value);
            }
        }
    }

    private void printDFS(GraphVertex vertex){

        if(visited.contains(vertex.value))
            return;

        visited.add(vertex.value);

        for(GraphEdge e : vertex.edges) {
            System.out.printf("\nVertex: %s, To: %s, Distance: %s ", vertex.value, e.nodeTo.value, e.value);
            printDFS(e.nodeTo);
        }
    }

    public void printDFS(String vertex){
        visited.clear();
        printDFS(vertices.get(vertex));
    }

    private void printBFS(GraphVertex vertex){

        System.out.printf("\nVertex: %s", vertex.value);
        visited.add(vertex.value);

        Queue<GraphEdge> queue = new ArrayDeque<>(vertex.edges);
        while (!queue.isEmpty()){
            GraphEdge current = queue.poll();

            if(!visited.contains(current.nodeTo.value)) {
                System.out.printf("\nTo: %s, Distance: %s ", current.nodeTo.value, current.value);
                visited.add(current.nodeTo.value);
                queue.addAll(current.nodeTo.edges);
            }
        }
    }

    public void printBFS(String vertex){
        visited.clear();
        printBFS(vertices.get(vertex));
    }

}
