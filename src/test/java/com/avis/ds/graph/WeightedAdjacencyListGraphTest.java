package com.avis.ds.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeightedAdjacencyListGraphTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testVertices() {
        WeightedAdjacencyListGraph graph = new WeightedAdjacencyListGraph(10);
        graph.add(new WeightedIntEdge(1, 2, 10));
        graph.add(new WeightedIntEdge(1, 4, 1.0f));
        System.out.println(graph);
    }
}