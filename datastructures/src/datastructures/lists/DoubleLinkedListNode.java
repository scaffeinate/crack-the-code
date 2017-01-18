package datastructures.lists;

public class DoubleLinkedListNode<T> {
  public T data;
  public DoubleLinkedListNode<T> next;
  public DoubleLinkedListNode<T> prev;

  public DoubleLinkedListNode() {

  }

  public DoubleLinkedListNode(T data) {
    this(data, null, null);
  }

  public DoubleLinkedListNode(T data, DoubleLinkedListNode<T> next, DoubleLinkedListNode<T> prev) {
    this.data = data;
    this.next = next;
    this.prev = prev;
  }
}
