/**
 * 
 */
package datastructures.disjointsets;

/**
 * @author Sudharsanan Muralidharan
 */
public class DisjointSet<T> {

  public DisjointSetListNode<T> makeSet(T data) {
    DisjointSetList<T> DisjointSetList = new DisjointSetList<T>();
    return DisjointSetList.insert(data);
  }

  public void union(DisjointSetListNode<T> setElement1, DisjointSetListNode<T> setElement2) {
    DisjointSetList<T> list1 = setElement1.listRef;
    DisjointSetList<T> list2 = setElement2.listRef;

    if (list1.equals(list2)) {
      return;
    }

    if (list1.size() >= list2.size()) {
      list1.append(list2);
    } else {
      list2.append(list1);
    }
  }

  public T findSet(DisjointSetListNode<T> setElement) {
    if (setElement == null || setElement.listRef == null) {
      return null;
    }

    return setElement.listRef.head().data;
  }
}
