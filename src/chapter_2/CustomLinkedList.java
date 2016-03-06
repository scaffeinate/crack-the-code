/**
 * 
 */
package chapter_2;

/**
 * CustomLinkedList: Simple LinkedList implementation.
 * 
 * @author Sudharsanan Muralidharan
 */
public class CustomLinkedList<T> {

  private Node<T> head = null;
  private Node<T> tail = null;
  private int size = 0;

  /**
   * Returns the current size of the LinkedList
   * 
   * @return size
   */
  public int size() {
    return size;
  }

  /**
   * Returns whether list is empty of not
   * 
   * @return isEmpty
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Retuns whether the list contains the object o
   * 
   * @param o
   * @return contains
   */
  public boolean contains(Object o) {
    Node<T> current = head;

    while (current != tail.next) {
      if (current.data.equals(o)) {
        return true;
      }
      current = current.next;
    }

    return false;
  }

  /**
   * Convert the list toArray and return Object[]
   * 
   * @return orray[]
   */
  public Object[] toArray() {
    Object[] array = new Object[size];
    int i = 0;
    Node<T> node = head;

    while (node != null) {
      array[i] = node.data;
      node = node.next;
      i++;
    }

    return array;
  }

  /**
   * Add new object to LinkedList
   * 
   * @param e
   * @return added
   */
  public boolean add(T e) {
    boolean added = false;

    /*
     * create head if null i.e. list if empty
     */
    if (head == null) {
      head = new Node<T>();
      head.data = e;
      head.next = null;
      tail = head;
      added = true;
    } else {
      // add element to the tail and increment size
      Node<T> current = new Node<T>();
      current.data = e;
      current.next = null;
      tail.next = current;
      tail = current;
      added = true;
    }

    size++;

    return added;
  }

  /**
   * Removes the object from the list
   * 
   * @param o
   * @return removed
   */
  public boolean remove(Object o) {
    Node<T> current = head;

    /*
     * If head is to be removed
     */
    if (head.data.equals(o)) {
      head = head.next;
      size--;
      return true;
    }

    while (current.next != null) {
      if (current.next.data.equals(o)) {
        current.next = current.next.next;
        size--;
        if (current.next.equals(tail)) {
          tail = current;
        }
        return true;
      } else {
        current = current.next;
      }
    }

    return false;
  }

  /**
   * Removes the object at index from list
   * 
   * @param index
   * @return removed
   */
  public T remove(int index) {
    Node<T> current = head;
    int i = 1;
    T removed = null;

    if (index == 0) {
      T data = head.data;
      head = head.next;
      size--;
      return data;
    }

    while (current.next != null) {
      if (i == index) {
        removed = current.next.data;
        current.next = current.next.next;
        size--;

        if (index == size) {
          tail = current;
        }

        return removed;
      } else {
        current = current.next;
      }
      
      i++;
    }

    return null;
  }

  /**
   * Get the element value at the index
   * 
   * @param index
   * @return found.data
   */
  public T get(int index) {
    Node<T> found = find(index);
    if (found != null) {
      return found.data;
    }

    return null;
  }

  /**
   * Set the element value at the specified index
   * 
   * @param index
   * @param element
   * @return found.data
   */
  public T set(int index, T element) {
    Node<T> found = find(index);
    if (found != null) {
      found.data = element;
      return element;
    }
    return null;
  }

  /**
   * Add an element at the index
   * 
   * @param index
   * @param element
   */
  public void add(int index, T element) {
    Node<T> current = head;
    int i = 0;

    /*
     * if index is 0 then add it to front and update head
     */
    if (index == 0) {
      Node<T> node = new Node<T>();
      node.data = element;
      node.next = head;
      head = node;
      size++;
      return;
    }

    /*
     * if index is size - 1 then add to the end and update tail
     */
    if(index == size-1) {
      Node<T> node = new Node<T>();
      node.data = element;
      tail.next = node;
      tail = node;
      size++;
      return;
    }
    
    while (current != null) {
      if (index == i) {
        Node<T> node = new Node<T>();
        node.data = element;
        node.next = current.next;
        current.next = node;
        size++;
      }

      current = current.next;
      i++;
    }
  }

  /**
   * Prints the list
   */
  public void print() {
    Node<T> current = head;
    StringBuilder builder = new StringBuilder();

    builder.append("|").append(current.data);
    current = current.next;

    while (current != tail.next) {
      builder.append("->").append(current.data);
      current = current.next;
    }

    builder.append("|");

    System.out.println(builder.toString());
  }

  /**
   * Returns the head
   * 
   * @return head
   */
  public Node<T> head() {
    return this.head;
  }

  /**
   * Returns the Node<T> at the index
   * 
   * @param index
   * @return node
   */
  private Node<T> find(int index) {
    Node<T> current = head;
    int i = 0;

    if (index == 0) {
      return current;
    }

    while (current != tail.next) {
      if (i == index) {
        return current;
      }
      i++;
      current = current.next;
    }

    return null;
  }
}