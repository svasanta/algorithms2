package com.avis.ds.graph;

public interface Graph<V> {
    Iterable<V> vertices();
    void connect(V v, V w);
    boolean connected(V v, V w);
    Iterable<V> adj(V v);
}
