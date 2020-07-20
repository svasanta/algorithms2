package com.avis.ds.graph;

import java.util.*;

public class MSTKruskal {
    private final WeightedGraph<Integer> graph;

    public MSTKruskal(WeightedGraph<Integer> graph) {
        this.graph = graph;
    }

    public List<WeightedEdge<Integer>> edges() {
        List<WeightedEdge<Integer>> result = new ArrayList<>();
        Set<Integer> grayList = new HashSet<>();
        Set<WeightedEdge<Integer>> sortedEdges = new TreeSet<>(Comparator.comparing(WeightedEdge::weight));
        graph.edges().forEach(sortedEdges::add);
        for (WeightedEdge<Integer> we : sortedEdges) {
            Integer v1 = we.any();
            Integer v2 = we.other(v1);
            if (!grayList.contains(v1) && !grayList.contains(v2)) {
                grayList.add(v1);
                grayList.add(v2);
                result.add(we);
            }
        }
        return result;
    }
}
