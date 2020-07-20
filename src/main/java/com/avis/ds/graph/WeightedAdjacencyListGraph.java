package com.avis.ds.graph;

import java.util.*;

public class WeightedAdjacencyListGraph implements WeightedGraph<Integer> {
    private final List<Integer> vertices;
    private final List<Collection<WeightedEdge<Integer>>> adjList;

    public WeightedAdjacencyListGraph(int size) {
        this.vertices = new ArrayList<>(size);
        this.adjList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.vertices.add(i, i);
            this.adjList.add(i, new HashSet<>());
        }
    }

    @Override
    public Iterable<Integer> vertices() {
        return Collections.unmodifiableCollection(vertices);
    }

    @Override
    public void add(WeightedEdge<Integer> edge) {
        Integer v1= edge.any();
        adjList.get(v1).add(edge);
        adjList.get(edge.other(v1)).add(edge);
    }

    @Override
    public boolean connected(Integer v, Integer w) {
        for(WeightedEdge<Integer> e : adjList.get(v)){
            if(e.other(v).equals(w)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<WeightedEdge<Integer>> adj(Integer v) {
        return Collections.unmodifiableCollection(adjList.get(v));
    }

    @Override
    public Iterable<WeightedEdge<Integer>> edges() {
        Set<WeightedEdge<Integer>> set = new HashSet<>();
        for (Collection<WeightedEdge<Integer>> weightedEdges : adjList) {
            set.addAll(weightedEdges);
        }
        return set;
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