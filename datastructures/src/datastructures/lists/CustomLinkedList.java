/**
 * 
 */
package datastructures.lists;

import datastructures.util.ListUtil;

/**
 * CustomLinkedList: Simple LinkedList implementation.
 * 
 * @author Sudharsanan Muralidharan
 */
public class CustomLinkedList<T> extends AbstractList<T> {

  public CustomLinkedList() {
  }

  public CustomLinkedList(LinkedListNode<T> head) {
    this.head = head;
  }

  public CustomLinkedList(CustomLinkedList<T> copyList) {
    LinkedListNode<T> current = copyList.head;
    while (current != null) {
      this.add(current.data);
      current = current.next;
    }
  }

  /**
   * Add new object to LinkedList
   * 
   * @param e
   * @return added
   */
  @Override
  public boolean add(T data) {
    boolean added = false;

    if (head == null) {
      head = new LinkedListNode<T>(data);
      tail = head;
      added = true;
    } else {
      LinkedListNode<T> current = new LinkedListNode<T>(data);
      tail.next = current;
      tail = current;
      added = true;
    }

    size++;
    return added;
  }
  
  /**
   * Add an element at the index
   * 
   * @param index
   * @param element
   */
  @Override
  public boolean add(int index, T data) {
    LinkedListNode<T> current = head;
    int i = 0;

    if (index == 0) {
      LinkedListNode<T> node = new LinkedListNode<T>(data, head);
      head = node;
      size++;
      return true;
    }
    
    if(index == size-1) {
      LinkedListNode<T> node = new LinkedListNode<T>(data, head);
      tail = node;
      size++;
      return true;
    }

    while (current != null) {
      if (i == index - 1) {
        LinkedListNode<T> node = new LinkedListNode<T>(data, current.next);
        current.next = node;
        size++;
        return true;
      }

      current = current.next;
      i++;
    }
    
    return false;
  }

  /**
   * Removes the object from the list
   * 
   * @param o
   * @return removed
   */
  @Override
  public boolean remove(Object o) {
    LinkedListNode<T> current = head;
    LinkedListNode<T> runner = current.next;

    if (head.data.equals(o)) {
      head = head.next;
      size--;
      return true;
    }

    while (runner != null) {
      if (runner.data.equals(o)) {
        current.next = runner.next;
        size--;
        if (runner.equals(tail)) {
          tail = current;
        }
        return true;
      } else {
        current = current.next;
      }
      runner = runner.next;
    }

    return false;
  }

  /**
   * Removes the object at index from list
   * 
   * @param index
   * @return removed
   */
  @Override
  public T remove(int index) {
    LinkedListNode<T> current = head;
    LinkedListNode<T> runner = current.next;
    int i = 0;
    T removed = null;

    if (index == 0) {
      removed = head.data;
      head = head.next;
      size--;
      return removed;
    }

    while (runner != null) {
      if (i == index - 1) {
        removed = runner.data;
        current.next = runner.next;
        size--;

        if (i == size - 1) {
          tail = current;
        }

      } else {
        current = current.next;
      }

      runner = runner.next;
      i++;
    }

    return removed;
  }

  /**
   * Get the element value at the index
   * 
   * @param index
   * @return found.data
   */
  @Override
  public T get(int index) {
    LinkedListNode<T> node = find(index);
    if (node != null) {
      return node.data;
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
  @Override
  public T set(int index, T element) {
    LinkedListNode<T> node = find(index);
    if (node != null) {
      node.data = element;
      return node.data;
    }
    return null;
  }

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

  public boolean addToFront(T e) {
    boolean added = false;

    if (head == null) {
      head = new LinkedListNode<T>();
      head.data = e;
      head.next = null;
      tail = head;
      added = true;
    } else {
      LinkedListNode<T> node = new LinkedListNode<T>();
      node.data = e;
      node.next = head;
      head = node;
      added = true;
    }

    return added;
  }
  
  /**
   * Prints the list
   */
  public void print() {
    ListUtil.printList(this.head);
  }

  /**
   * Returns the Node<T> at index
   * 
   * @param index
   * @return Node<T>
   */
  public LinkedListNode<T> getNode(int index) {
    return find(index);
  }
  
  /**
   * Returns the Node<T> at the index
   * 
   * @param index
   * @return node
   */
  public LinkedListNode<T> find(int index) {
    LinkedListNode<T> current = head;
    int i = 0;

    if (index == 0) {
      return current;
    }

    while (current != null) {
      if (i == index) {
        return current;
      }
      i++;
      current = current.next;
    }

    return null;
  }
}
