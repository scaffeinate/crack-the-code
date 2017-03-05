/**
 * 
 */
package datastructures.test;

import java.util.HashMap;

import datastructures.disjointsets.DisjointSetNaive;
import datastructures.disjointsets.DisjointSetListNode;

/**
 * @author Sudharsanan Muralidharan
 */
public class TestDisjointSetNaive {
  public static void main(String[] args) {
    DisjointSetNaive<Integer> disjointSet = new DisjointSetNaive<Integer>();
    HashMap<Integer, DisjointSetListNode> elementsMap = new HashMap<Integer, DisjointSetListNode>();
    elementsMap.put(1, disjointSet.makeSet(1));
    elementsMap.put(2, disjointSet.makeSet(2));
    elementsMap.put(3, disjointSet.makeSet(3));
    elementsMap.put(4, disjointSet.makeSet(4));
    elementsMap.put(5, disjointSet.makeSet(5));

    disjointSet.union(elementsMap.get(1), elementsMap.get(5));
    disjointSet.union(elementsMap.get(2), elementsMap.get(3));
    disjointSet.union(elementsMap.get(3), elementsMap.get(4));
    disjointSet.union(elementsMap.get(2), elementsMap.get(4));
    disjointSet.union(elementsMap.get(5), elementsMap.get(1));
    disjointSet.union(elementsMap.get(3), elementsMap.get(2));
    disjointSet.union(elementsMap.get(4), elementsMap.get(3));
    disjointSet.union(elementsMap.get(1), elementsMap.get(1));
    disjointSet.union(elementsMap.get(5), elementsMap.get(5));
    disjointSet.union(elementsMap.get(4), elementsMap.get(4));

    System.out.println(disjointSet.findSet(elementsMap.get(1)));
    System.out.println(disjointSet.findSet(elementsMap.get(2)));
    System.out.println(disjointSet.findSet(elementsMap.get(3)));
    System.out.println(disjointSet.findSet(elementsMap.get(4)));
    System.out.println(disjointSet.findSet(elementsMap.get(5)));
  }
}
