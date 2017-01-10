package datastructures.queue;

import java.util.EmptyStackException;

import datastructures.common.Node;

/**
 * Simple Queue Implementation
 * 
 * @author Sudharsanan Muralidharan
 * @param <T>
 */
public class CustomQueue<T> {
  private Node<T> head = null, tail = null;
  private int size = 0;

  public CustomQueue() {

  }

  /**
   * Push data into queue
   * @param data
   */
  public void add(T data) {
    if (head == null) {
      head = new Node<T>();
      head.data = data;
      head.next = null;
      tail = head;
    } else {
      Node<T> node = new Node<T>();
      node.data = data;
      node.next = null;
      tail.next = node;
      tail = node;
    }
    
    size++;
  }

  /**
   * Removes node from front of the queue
   */
  public T remove() {
    T result = null;
    if (head == null) {
      throw new EmptyStackException();
    }
    result = head.data;
    head = head.next;
    
    
    if(head == null) {
      tail = null;
    }
    
    size--;
    
    return result;
  }

  /**
   * Return data at front of the queue
   * @return head.data
   */
  public T peek() {
    if (head == null) {
      throw new EmptyStackException();
    }

    return head.data;
  }
  
  public T back() {
    if(tail == null) {
      throw new EmptyStackException();
    }
    
    return tail.data;
  }

  /**
   * Returns if queue is empty
   * 
   * @return size == 0
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Returns queue size
   * @return size
   */
  public int size() {
    return this.size;
  }

  /**
   * @Override
   * Append content of the queue to string and return
   * return queue.toString()
   */
  @Override
  public String toString() {
    if(this.isEmpty()) {
      return "";
    }
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    Node<T> current = head;
    while(current != null) {
      builder.append(current.data);
      builder.append((current.next != null) ? " " : "]");
      current = current.next;
    }
    
    return builder.toString();
  }
}
