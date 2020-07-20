package com.avis.ds.graph;

import java.util.Objects;

public class WeightedIntEdge implements WeightedEdge<Integer>{
    private final Integer v1;
    private final Integer v2;
    private final float weight;

    public WeightedIntEdge(Integer v1, Integer v2, float weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public Integer any() {
        return v1;
    }

    @Override
    public Integer other(Integer i) {
        return i.equals(v1) ? v2 : v1;
    }

    @Override
    public float weight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightedIntEdge that = (WeightedIntEdge) o;
        return Float.compare(that.weight, weight) == 0 &&
                v1.equals(that.v1) &&
                v2.equals(that.v2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, weight);
    }

    @Override
    public String toString() {
        return "[" + v1 + "," + v2 + "," + weight + "]";
    }
}
