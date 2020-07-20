package com.avis.ds.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MSTPrimes {
    private final WeightedGraph<Integer> graph;

    public MSTPrimes(WeightedGraph<Integer> graph) {
        this.graph = graph;
    }

    public List<WeightedEdge<Integer>> edges() {
        List<WeightedEdge<Integer>> result = new ArrayList<>();
        PriorityQueue<WeightedEdge<Integer>> minWQ = new PriorityQueue<>( Comparator.comparing(WeightedEdge::weight));
        List<Integer> grayList = new ArrayList<>();
        grayList.add(0);
        graph.adj(0).forEach( minWQ::add);
        while (! minWQ.isEmpty()){
            WeightedEdge<Integer> we = minWQ.poll();
            Integer v1 = we.any();
            Integer v2 = we.other(v1);
            if (grayList.contains(v1) && !grayList.contains(v2)) {
                grayList.add(v2);
                result.add(we);
                break;
            } else if (grayList.contains(v2) && !grayList.contains(v1)) {
                grayList.add(v1);
                result.add(we);
                break;
            }//ignore
        }
        return result;
    }
}
