package com.avis.ds.graph;

public interface WeightedEdge<V> {
    V any();
    V other(V v);
    float weight();
}
