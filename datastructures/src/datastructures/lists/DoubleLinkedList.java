package datastructures.lists;

import datastructures.common.DoubleNode;

public class DoubleLinkedList<T> {
  private DoubleNode<T> head = null;
  private DoubleNode<T> tail = null;
  private int size = 0;

  public void add(T data) {
    if (head == null) {
      head = new DoubleNode<T>();
      head.data = data;
      tail = head;
    } else {
      DoubleNode<T> node = new DoubleNode<T>();
      node.data = data;
      tail.next = node;
      node.prev = tail;
      tail = node;
    }
    size++;
  }

  public boolean remove(Object o) {
    DoubleNode<T> current = head;

    if (current.equals(o)) {
      head = head.next;
      head.prev = null;
      return true;
    }

    while (current != null) {
      if (current.equals(o)) {
        if (current.equals(tail)) {
          current = current.prev;
          current.next = null;
        } else {
          current.next = current.next.next;
          current.next.prev = current.prev;
        }
        size--;
        return true;
      }
      current = current.next;
    }

    return false;
  }

  public DoubleNode<T> head() {
    return this.head;
  }
  
  public DoubleNode<T> tail() {
    return this.tail;
  }
  
  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return (this.size == 0);
  }

  public void print() {
    System.out.println(this.toString());
  }
  
  public void printReverse() {
    StringBuilder builder = new StringBuilder();
    DoubleNode<T> current = tail;
    builder.append("null<-");
    while(current.prev != null) {
      builder.append(current.data).append("<=>");
      current = current.prev;
    }
    builder.append(current.data);
    builder.append("->null");
    System.out.println(builder.toString());
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    DoubleNode<T> current = head;
    builder.append("null<-");
    while(current.next != null) {
      builder.append(current.data).append("<=>");
      current = current.next;
    }
    builder.append(current.data).append("->null");
    return builder.toString();
  }
  
}
