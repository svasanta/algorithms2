package com.avis.ds.graph;

import com.google.common.collect.Iterables;

import java.util.*;

public class MSTGready {
    private final WeightedGraph<Integer> graph;
    Set<Integer> blackList = new HashSet<>();
    List<WeightedEdge<Integer>> edges = new ArrayList<>();

    public MSTGready(WeightedGraph<Integer> graph) {
        this.graph = graph;
    }

    public List<WeightedEdge<Integer>> edges() {
        blackList.add(0);
        while (edges.size() != Iterables.size(graph.vertices()) -1){
            WeightedEdge<Integer> e = nextSmallest();
            edges.add(e);
            blackList.add(e.any());
            blackList.add(e.other(e.any()));
        }
        return edges;
    }

    private WeightedEdge<Integer> nextSmallest() {
        WeightedEdge<Integer> result = null;
        for (Integer v : blackList){
            for(WeightedEdge<Integer> e : graph.adj(v)){
                if(! blackList.contains(e.other(v))) {
                    result = (result == null ? e : (result.weight() < e.weight() ? result : e));
                }
            }
        }
        return result;
    }
}
