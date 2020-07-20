package com.avis.ds.graph;

import org.junit.jupiter.api.Test;

class MSTTest {

    @Test
    void edges() {
        WeightedAdjacencyListGraph g = new WeightedAdjacencyListGraph(8);
        g.add(new WeightedIntEdge(0,7, 0.16f));
        g.add(new WeightedIntEdge(2,3, 0.17f));
        g.add(new WeightedIntEdge(1,7, 0.19f));
        g.add(new WeightedIntEdge(0,2, 0.26f));
        g.add(new WeightedIntEdge(5,7, 0.28f));
        g.add(new WeightedIntEdge(1,3, 0.29f));
        g.add(new WeightedIntEdge(1,5, 0.32f));
        g.add(new WeightedIntEdge(2,7, 0.34f));
        g.add(new WeightedIntEdge(4,5, 0.35f));
        g.add(new WeightedIntEdge(1,2, 0.36f));
        g.add(new WeightedIntEdge(4,7, 0.37f));
        g.add(new WeightedIntEdge(0,4, 0.38f));
        g.add(new WeightedIntEdge(6,2, 0.40f));
        g.add(new WeightedIntEdge(3,6, 0.52f));
        g.add(new WeightedIntEdge(6,0, 0.58f));
        g.add(new WeightedIntEdge(6,4, 0.93f));
        System.out.println(g);

        //MSTSiva mst = new MSTSiva(g);

        //MSTGready mst = new MSTGready(g);
        MSTKruskal mst =  new MSTKruskal(g);
        System.out.println(mst.edges());
    }
}