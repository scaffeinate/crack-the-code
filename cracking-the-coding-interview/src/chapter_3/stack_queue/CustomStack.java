package chapter_3.stack_queue;

import chapter_2.list.Node;

/**
 * Simple Stack implementation
 * 
 * @author Sudharsanan Muralidharan
 * @param <T>
 */
public class CustomStack<T> {
  private Node<T> top = null;
  private int size = 0;

  public CustomStack() {
  }

  /**
   * Pushes data into the stack
   * 
   * @param data
   */
  public void push(T data) {
    if (top == null) {
      top = new Node<T>();
      top.data = data;
      top.next = null;
    } else {
      Node<T> node = new Node<T>();
      node.data = data;
      node.next = top;
      top = node;
    }

    size++;
  }

  /**
   * Pop top of the stack
   */
  public void pop() {
    if (top != null) {
      top = top.next;
      size--;
    }
  }

  /**
   * Returns data in top of the stack
   * 
   * @return top
   */
  public T peek() {
    if (top != null) {
      return top.data;
    }
    return null;
  }

  /**
   * Check if stack is Empty
   * 
   * @return
   */
  public boolean isEmpty() {
    return (size == 0);
  }

  /**
   * Get stack size
   * 
   * @return size
   */
  public int size() {
    return this.size;
  }

  /**
   * @Override toString()
   * Returns the content of the stack
   */
  @Override
  public String toString() {
    Node<T> current = top;
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    while (current != null) {
      builder.append(current.data);
      builder.append((current.next != null) ? " " : "]");
      current = current.next;
    }
    return builder.toString();
  }
}
