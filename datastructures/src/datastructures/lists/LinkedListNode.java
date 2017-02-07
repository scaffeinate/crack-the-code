/**
 * 
 */
package datastructures.lists;

/**
 * Class LinkedListNode
 * 
 * @param<T>
 * 
 * @author Sudharsanan Muralidharan
 */
public class LinkedListNode<T> {
  public T data;
  public LinkedListNode<T> next;
  public LinkedListNode<T> prev;

  public LinkedListNode() {
  }

  public LinkedListNode(T data) {
    this(data, null);
  }

  public LinkedListNode(T data, LinkedListNode<T> next) {
    this.data = data;
    this.next = next;
  }

  public LinkedListNode(T data, LinkedListNode<T> next, LinkedListNode<T> prev) {
    this.data = data;
    this.next = next;
    this.prev = prev;
  }
}
