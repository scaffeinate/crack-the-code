package datastructures.disjointsets;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetWithPathCompression<T> {

  private Map<T, DisjointSetNode<T>> nodesMap = null;

  public DisjointSetWithPathCompression() {
    nodesMap = new HashMap<T, DisjointSetNode<T>>();
  }

  public DisjointSetNode<T> makeSet(T data) {
    DisjointSetNode<T> node = new DisjointSetNode<T>(data);
    nodesMap.put(data, node);
    return node;
  }

  public void union(T setElement1, T setElement2) {
    DisjointSetNode<T> node1 = nodesMap.get(setElement1);
    DisjointSetNode<T> node2 = nodesMap.get(setElement2);

    if (node1 == null || node2 == null) {
      return;
    }

    DisjointSetNode<T> parent1 = parent(node1);
    DisjointSetNode<T> parent2 = parent(node2);

    if (parent1.equals(parent2)) {
      return;
    }

    if (parent1.rank == parent2.rank) {
      parent2.parent = parent1;
      parent1.rank++;
    } else {
      DisjointSetNode<T> greater = (parent1.rank > parent2.rank) ? parent1 : parent2;
      DisjointSetNode<T> smaller = (parent1.rank > parent2.rank) ? parent2 : parent1;
      smaller.parent = greater;
    }
  }

  public T findSet(T data) {
    DisjointSetNode<T> node = nodesMap.get(data);
    if (node == null) {
      return null;
    }

    DisjointSetNode<T> parent = parent(node);
    node.parent = parent;
    return parent.data;
  }

  private DisjointSetNode<T> parent(DisjointSetNode<T> node) {
    if (node != null && node.parent.equals(node)) {
      return node;
    } else {
      return parent(node.parent);
    }
  }
}
