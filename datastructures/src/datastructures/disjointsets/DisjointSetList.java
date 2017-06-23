/**
 *
 */
package datastructures.disjointsets;

/**
 * @author Sudharsanan Muralidharan
 */
public class DisjointSetList<T> {

    private DisjointSetListNode<T> head = null;
    private DisjointSetListNode<T> tail = null;
    private int size = 0;

    public DisjointSetListNode<T> insert(T data) {
        DisjointSetListNode<T> setElement = new DisjointSetListNode<T>(data);
        head = tail = setElement;
        setElement.listRef = this;
        this.size++;
        return setElement;
    }

    public void append(DisjointSetList<T> set) {
        this.tail.next = set.head;
        this.tail = set.tail;
        DisjointSetListNode<T> current = set.head;
        while (current != null) {
            current.listRef = this;
            current = current.next;
        }

        this.size += set.size;
    }

    public DisjointSetListNode<T> head() {
        return this.head;
    }

    public int size() {
        return this.size;
    }
}
