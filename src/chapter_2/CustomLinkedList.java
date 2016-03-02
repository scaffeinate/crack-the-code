/**
 * 
 */
package chapter_2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Sudharsanan Muralidharan
 */
public class CustomLinkedList<T> implements List<T> {

  private Node<T> head = null;
  private Node<T> tail = null;
  private int size = 0;

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return size;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    // TODO Auto-generated method stub
    Node<T> current = head;
    while (current != tail.next) {
      if (current.data.equals(o)) {
        return true;
      }
      current = current.next;
    }

    return false;
  }

  @Override
  public Iterator<T> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object[] toArray() {
    // TODO Auto-generated method stub
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

  @Override
  public <T> T[] toArray(T[] a) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean add(T e) {
    // TODO Auto-generated method stub
    if (head == null) {
      head = new Node<T>();
      head.data = e;
      head.next = null;
      tail = head;
    } else {
      Node<T> current = new Node<T>();
      current.data = e;
      current.next = null;
      tail.next = current;
      tail = current;
    }

    size++;

    return false;
  }

  @Override
  public boolean remove(Object o) {
    // TODO Auto-generated method stub
    Node<T> slow = head;
    Node<T> fast = slow.next;

    while (fast != null) {
      if (fast.data.equals(o)) {
        slow.next = fast.next;
        size--;
        return true;
      }

      slow = slow.next;
      fast = fast.next;

    }
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub

  }

  @Override
  public T get(int index) {
    // TODO Auto-generated method stub
    Node<T> current = head;
    int i = 0;
    while (current != tail.next) {
      if (i == index && current.data != null) {
        return current.data;
      }
      i++;
      current = current.next;
    }

    return null;
  }

  @Override
  public T set(int index, T element) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void add(int index, T element) {
    // TODO Auto-generated method stub

  }

  @Override
  public T remove(int index) {
    // TODO Auto-generated method stub
    Node<T> current = head;
    Node<T> removedNode = null;
    int i = 0;
    boolean removed = false;
    
    while(current != null) {
      if(i == index) {
        removedNode = current;
        removed = remove(current.data);
      }
      i++;
      current = current.next;
    }
    
    if(removed) {
      return removedNode.data;
    }
    
    return null;
  }

  @Override
  public int indexOf(Object o) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public ListIterator<T> listIterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    // TODO Auto-generated method stub
    return null;
  }

}
