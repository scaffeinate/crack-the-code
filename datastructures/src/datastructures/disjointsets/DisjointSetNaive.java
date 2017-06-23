/**
 *
 */
package datastructures.disjointsets;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sudharsanan Muralidharan
 */
public class DisjointSetNaive<T> {

    private Map<T, DisjointSetListNode<T>> nodesMap = null;

    public DisjointSetNaive() {
        nodesMap = new HashMap<T, DisjointSetListNode<T>>();
    }

    public DisjointSetListNode<T> makeSet(T data) {
        DisjointSetList<T> DisjointSetList = new DisjointSetList<T>();
        DisjointSetListNode<T> node = DisjointSetList.insert(data);
        nodesMap.put(data, node);
        return node;
    }

    public void union(T setElement1, T setElement2) {

        DisjointSetListNode<T> node1 = nodesMap.get(setElement1);
        DisjointSetListNode<T> node2 = nodesMap.get(setElement2);

        if (node1 == null || node2 == null) {
            return;
        }

        DisjointSetList<T> list1 = node1.listRef;
        DisjointSetList<T> list2 = node2.listRef;

        if (list1.equals(list2)) {
            return;
        }

        if (list1.size() >= list2.size()) {
            list1.append(list2);
        } else {
            list2.append(list1);
        }
    }

    public T findSet(T setElement) {
        DisjointSetListNode<T> node = nodesMap.get(setElement);
        if (node == null || node.listRef == null) {
            return null;
        }

        return node.listRef.head().data;
    }
}
