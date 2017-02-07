package datastructures.lists;

/**
 * AbstractList(Abstract class) implementation
 * 
 * @author Sudharsanan Muralidharan
 *
 * @param <T>
 */
public abstract class AbstractList<T> implements GenericList<T> {
  protected LinkedListNode<T> head = null;
  protected LinkedListNode<T> tail = null;
  protected int size = 0;

  /**
   * Returns whether the list contains the object o
   * 
   * @param o
   * @return contains
   */
  @Override
  public boolean contains(Object o) {
    LinkedListNode<T> current = head;

    while (current != null) {
      if (current.data.equals(o)) {
        return true;
      }
      current = current.next;
    }

    return false;
  }

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
   * Returns the tail
   * 
   * @return tail
   */
  @Override
  public LinkedListNode<T> tail() {
    return this.tail;
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
   * Convert the list toArray and return Object[]
   * 
   * @return orray[]
   */
  @Override
  public Object[] toArray() {
    Object[] array = new Object[size];
    int i = 0;
    LinkedListNode<T> node = head;

    while (node != null) {
      array[i] = node.data;
      node = node.next;
      i++;
    }

    return array;
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
