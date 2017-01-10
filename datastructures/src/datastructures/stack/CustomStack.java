package datastructures.stack;

import java.util.EmptyStackException;

import datastructures.common.Node;

/**
 * Simple Stack implementation
 * 
 * @author Sudharsanan Muralidharan
 * @param <T>
 */
public class CustomStack<T> extends AbstractStack<T> {
  private Node<T> top = null;

  public CustomStack() {
  }

  /**
   * Pushes data into the stack
   * 
   * @param data
   */
  @Override
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
  @Override
  public T pop() {
    T result = null;
    if (top == null) {
      throw new EmptyStackException();
    }

    result = top.data;
    top = top.next;
    size--;

    return result;
  }

  /**
   * Returns data in top of the stack
   * 
   * @return top
   */
  @Override
  public T peek() {
    if (top == null) {
      throw new EmptyStackException();
    }

    return top.data;
  }

  /**
   * Return the Node<T> at top
   * @return top
   */
  public Node<T> top() {
    return this.top;
  }

  /**
   * @Override toString() Returns the content of the stack
   */
  @Override
  public String toString() {
    if (this.isEmpty()) {
      return "";
    }

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
