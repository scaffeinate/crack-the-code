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

  public void add(T data, int index) {
    if (index < 0 || index >= size) {
      return;
    }

    if (index == 0) {
      addToFront(data);
    } else if (index == (size - 1)) {
      add(data);
    } else {
      addAt(data, index);
    }
  }

  public void addToFront(T data) {
    DoubleNode<T> node = new DoubleNode<T>();
    node.data = data;
    node.next = head;
    head.prev = node;
    head = node;
    size++;
  }

  private void addAt(T data, int index) {
    DoubleNode<T> current = head;
    int i = 1;

    while (current != null) {
      if (i == index) {
        DoubleNode<T> node = new DoubleNode<T>();
        node.data = data;
        node.next = current.next;
        node.prev = current;
        current.next.prev = node;
        current.next = node;
        size++;
        return;
      }

      i++;
      current = current.next;
    }
  }

  public void remove(T data) {
    if (head.data.equals(data)) {
      removeHead();
    } else if (tail.data.equals(data)) {
      removeTail();
    } else {
      DoubleNode<T> current = head;
      while (current != null) {
        if (current.data.equals(data)) {
          current.prev.next = current.next;
          current.next.prev = current.prev;
          size--;
          break;
        }
        current = current.next;
      }
    }
  }

  public void remove(int index) {
    if (index < 0 || index >= size) {
      return;
    }

    if (index == 0) {
      removeHead();
    } else if (index == size - 1) {
      removeTail();
    } else {
      DoubleNode<T> current = head;
      int i = 0;

      while (current != null) {
        if (i == index) {
          current.prev.next = current.next;
          current.next.prev = current.prev;
          size--;
          break;
        }
        i++;
        current = current.next;
      }
    }
  }

  public T get(int index) {
    DoubleNode<T> current = head;
    int i = 0;
    while (current != null) {
      if (i == index) {
        return current.data;
      }
      i++;
      current = current.next;
    }

    return null;
  }

  public void set(T data, int index) {
    DoubleNode<T> current = head;
    int i = 0;
    while(current != null) {
      if(i == index) {
        current.data = data;
      }
      i++;
      current = current.next;
    }
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
    while (current.prev != null) {
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
    while (current.next != null) {
      builder.append(current.data).append("<=>");
      current = current.next;
    }
    builder.append(current.data).append("->null");
    return builder.toString();
  }

  private void removeHead() {
    head = head.next;
    head.prev = null;
    size--;
  }

  private void removeTail() {
    tail = tail.prev;
    tail.next = null;
    size--;
  }
}
