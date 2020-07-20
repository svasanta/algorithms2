package com.avis.ds.graph;

import java.util.*;

public class AdjacencyIntListGraph implements Graph<Integer>{
    private final List<Integer> vertices;
    private final List<Collection<Integer>> adjList;

    public AdjacencyIntListGraph(int size) {
        vertices = Arrays.asList(new Integer[size]);
        adjList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.vertices.set(i, i);
            this.adjList.add(i, new HashSet<>());
        }
    }

    @Override
    public Iterable<Integer> vertices() {
        return Collections.unmodifiableCollection(vertices);
    }

    @Override
    public void connect(Integer v, Integer w) {
        if (! adjList.get(v).contains(w) ){
            adjList.get(v).add(w);
        }

        if (! adjList.get(w).contains(v) ){
            adjList.get(w).add(v);
        }
    }

    @Override
    public boolean connected(Integer v, Integer w) {
        return adjList.get(v).contains(w);
    }

    @Override
    public Iterable<Integer> adj(Integer v) {
        return adjList.get(v);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Vertices =" + vertices).append("\n");
        for (int i = 0; i < adjList.size(); i++) {
            str.append(i).append(" -> ").append(adjList.get(i));
            str.append("\n");
        }
        return str.toString();
    }
}
