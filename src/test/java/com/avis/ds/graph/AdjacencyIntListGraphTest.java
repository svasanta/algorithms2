package com.avis.ds.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyIntListGraphTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testVertices() {
        AdjacencyIntListGraph graph = new AdjacencyIntListGraph(10);
        graph.connect(1, 5);
        graph.connect(3,6);
        graph.connect(1, 4);
        System.out.println(graph);
    }

    @Test
    void connect() {
    }

    @Test
    void connected() {
    }

    @Test
    void adj() {
    }
}