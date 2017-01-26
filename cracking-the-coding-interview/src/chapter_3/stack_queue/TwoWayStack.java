package chapter_3.stack_queue;

import datastructures.stack.GenericStack;

/**
 * TwoWayStack implementation where push is done to the top but pop can happen
 * from both top and bottom. And there is two way chaining between the elements
 * in order to pop from top and bottom.
 * 
 * @author Sudharsanan Muralidharan
 *
 * @param <T>
 */
public class TwoWayStack<T> implements GenericStack<T> {
  NodeTopBottom<T> top = null;
  NodeTopBottom<T> bottom = null;
  private int size = 0;

  /**
   * Push data to top of the stack
   */
  @Override
  public void push(T data) {
    if (top == null) {
      top = new NodeTopBottom<T>(data);
      bottom = top;
    } else {
      NodeTopBottom<T> node = new NodeTopBottom<T>(data);
      top.above = node;
      node.below = top;
      top = node;
    }
    size++;
  }

  /**
   * Pop element from top
   * 
   * @return data
   */
  @Override
  public T pop() {
    T data = null;
    if (top != null) {
      data = top.data;
      top = top.below;
      if (top != null) {
        top.above = null;
      }
      size--;
    }

    return data;
  }

  /**
   * Pop element from bottom
   * 
   * @return data
   */
  public T popBottom() {
    T data = null;
    if (bottom != null) {
      data = bottom.data;
      bottom = bottom.above;
      if (bottom != null) {
        bottom.below = null;
      }
      size--;
    }
    return data;
  }

  /**
   * Peek element at top
   * 
   * @return data
   */
  @Override
  public T peek() {
    T data = null;
    if (top != null) {
      data = top.data;
    }
    return data;
  }

  /**
   * Peek element at bottom
   * 
   * @return data
   */
  public T peekBelow() {
    T data = null;
    if (bottom != null) {
      data = bottom.data;
    }
    return data;
  }

  /**
   * @Override toString() Returns the content of the stack
   */
  @Override
  public String toString() {
    if (this.isEmpty()) {
      return "";
    }

    NodeTopBottom<T> current = top;
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    while (current != null) {
      builder.append(current.data);
      builder.append((current.below != null) ? " " : "]");
      current = current.below;
    }
    return builder.toString();
  }

  /**
   * Wrapper around stack Node<T>
   * 
   * @author sudhar
   *
   * @param <T>
   */
  @SuppressWarnings("hiding")
  class NodeTopBottom<T> {
    T data;
    NodeTopBottom<T> above;
    NodeTopBottom<T> below;

    public NodeTopBottom(T data) {
      this.data = data;
    }
  }

  /**
   * @return size
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * @return isEmpty
   */
  @Override
  public boolean isEmpty() {
    return (this.size == 0);
  }

}
