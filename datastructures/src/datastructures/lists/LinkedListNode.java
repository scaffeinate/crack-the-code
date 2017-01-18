/**
 * 
 */
package datastructures.lists;

/**
 * @author Sudharsanan Muralidharan
 */
public class LinkedListNode<T> {
  public T data;
  public LinkedListNode<T> next;

  public LinkedListNode() {
  }

  public LinkedListNode(T data) {
    this(data, null);
  }

  public LinkedListNode(T data, LinkedListNode<T> next) {
    this.data = data;
    this.next = next;
  }
}
