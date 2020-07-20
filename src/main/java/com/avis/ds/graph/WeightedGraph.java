package com.avis.ds.graph;

public interface WeightedGraph<V> {
    Iterable<V> vertices();
    void add(WeightedEdge<V> edge);
    boolean connected(V v, V w);
    Iterable<WeightedEdge<V>> adj(V v);
    Iterable<WeightedEdge<V>> edges();
}
