package com.avis.ds.graph;

import com.google.common.collect.Iterables;

import java.util.*;

public class MSTSiva {
    private final WeightedGraph<Integer> graph;

    public MSTSiva(WeightedGraph<Integer> graph) {
        this.graph = graph;
    }

    public List<WeightedEdge<Integer>> edges() {
        List<WeightedEdge<Integer>> result = new ArrayList<>();
        List<Integer> grayList = new ArrayList<>();

        Set<WeightedEdge<Integer>> sortedEdges = new TreeSet<>(Comparator.comparing(WeightedEdge::weight));
        graph.edges().forEach(sortedEdges::add);
        grayList.add(0);
        while (grayList.size() != Iterables.size(graph.vertices())) {
            for (Iterator<WeightedEdge<Integer>> iterator = sortedEdges.iterator(); iterator.hasNext(); ) {
                WeightedEdge<Integer> we = iterator.next();
                Integer v1 = we.any();
                Integer v2 = we.other(v1);
                if (grayList.contains(v1) && !grayList.contains(v2)) {
                    grayList.add(v2);
                    iterator.remove();
                    result.add(we);
                    break;
                } else if (grayList.contains(v2) && !grayList.contains(v1)) {
                    grayList.add(v1);
                    iterator.remove();
                    result.add(we);
                    break;
                }
            }
        }
        return result;
    }
}
