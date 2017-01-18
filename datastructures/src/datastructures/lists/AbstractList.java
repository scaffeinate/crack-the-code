package datastructures.lists;

public abstract class AbstractList<T> implements GenericList<T> {
  protected LinkedListNode<T> head = null;
  protected LinkedListNode<T> tail = null;
  protected int size = 0;

  /**
   * Returns the head
   * 
   * @return head
   */
  @Override
  public LinkedListNode<T> head() {
    return this.head;
  }

  /**
   * Sets the head
   * 
   * @param node
   */
  @Override
  public void head(LinkedListNode<T> head) {
    this.head = head;
  }

  /**
   * Sets the tail
   * 
   * @param tail
   */
  @Override
  public void tail(LinkedListNode<T> tail) {
    this.tail = tail;
  }

  /**
   * Returns the tail
   * 
   * @return tail
   */
  @Override
  public LinkedListNode<T> tail() {
    return this.tail;
  }

  /**
   * Returns the current size of the LinkedList
   * 
   * @return size
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns whether list is empty of not
   * 
   * @return isEmpty
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }
}
