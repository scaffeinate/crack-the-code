package datastructures.disjointsets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DisjointSetWithPathCompression<T> {

    private Map<T, DisjointSetNode<T>> nodesMap = null;
    private Set<DisjointSetNode<T>> disjointSets = null;

    public DisjointSetWithPathCompression() {
        nodesMap = new HashMap<T, DisjointSetNode<T>>();
        setDisjointSets(new HashSet<DisjointSetNode<T>>());
    }

    public DisjointSetNode<T> makeSet(T data) {
        DisjointSetNode<T> node = new DisjointSetNode<T>(data);
        nodesMap.put(data, node);
        getDisjointSets().add(node);
        return node;
    }

    public boolean union(T setElement1, T setElement2) {
        DisjointSetNode<T> node1 = nodesMap.get(setElement1);
        DisjointSetNode<T> node2 = nodesMap.get(setElement2);

        if (node1 == null || node2 == null) {
            return false;
        }

        DisjointSetNode<T> parent1 = parent(node1);
        DisjointSetNode<T> parent2 = parent(node2);

        if (parent1.equals(parent2)) {
            return false;
        }

        if (parent1.rank == parent2.rank) {
            parent2.parent = parent1;
            getDisjointSets().remove(parent2);
            parent1.rank++;
        } else {
            DisjointSetNode<T> greater = (parent1.rank > parent2.rank) ? parent1 : parent2;
            DisjointSetNode<T> smaller = (parent1.rank > parent2.rank) ? parent2 : parent1;
            smaller.parent = greater;
            getDisjointSets().remove(smaller);
        }

        return true;
    }

    public T findSet(T data) {
        DisjointSetNode<T> node = nodesMap.get(data);
        if (node == null) {
            return null;
        }

        return parent(node).data;
    }

    public Set<T> disjointSets() {
        Set<T> disjointSetValues = new HashSet<T>();
        for (DisjointSetNode<T> node : getDisjointSets()) {
            disjointSetValues.add(node.data);
        }
        return disjointSetValues;
    }

    private DisjointSetNode<T> parent(DisjointSetNode<T> node) {
        if (!node.parent.equals(node)) {
            node.parent = parent(node.parent);
        }

        return node.parent;
    }

    public Set<DisjointSetNode<T>> getDisjointSets() {
        return disjointSets;
    }

    public void setDisjointSets(Set<DisjointSetNode<T>> disjointSets) {
        this.disjointSets = disjointSets;
    }
}
