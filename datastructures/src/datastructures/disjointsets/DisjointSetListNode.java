/**
 *
 */
package datastructures.disjointsets;

/**
 * @author Sudharsanan Muralidharan
 */
public class DisjointSetListNode<T> {

    protected T data;

    protected DisjointSetListNode<T> next;

    protected DisjointSetList<T> listRef;

    public DisjointSetListNode(T data) {
        this(data, null);
    }

    public DisjointSetListNode(T data, DisjointSetList<T> listRef) {
        this.data = data;
        this.listRef = listRef;
    }
}