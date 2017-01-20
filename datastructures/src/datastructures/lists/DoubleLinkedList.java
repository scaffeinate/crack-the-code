package datastructures.lists;

public class DoubleLinkedList<T> extends AbstractList<T> {
  
  @Override
  public boolean add(T data) {
    boolean added = false;
    if (head == null) {
      head = new LinkedListNode<T>(data);
      tail = head;
      added = true;
    } else {
      LinkedListNode<T> node = new LinkedListNode<T>(data);
      tail.next = node;
      node.prev = tail;
      tail = node;
      added = true;
    }
    size++;
    return added;
  }
  
  @Override
  public boolean add(int index, T data) {
    if (index < 0 || index >= size) {
      return false;
    }

    if (index == 0) {
      return addToFront(data);
    } else if (index == (size - 1)) {
      return add(data);
    } else {
      return addAt(data, index);
    }
  }
  
  @Override
  public boolean remove(Object o) {
    if (head.data.equals(o)) {
      return removeFirst();
    } else if (tail.data.equals(o)) {
      return removeLast();
    } else {
      LinkedListNode<T> current = head;
      while (current != null) {
        if (current.data.equals(o)) {
          current.prev.next = current.next;
          current.next.prev = current.prev;
          size--;
          return true;
        }
        current = current.next;
      }
    }
    
    return false;
  }
  
  @Override
  public T remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    if (index == 0) {
      if(removeFirst()) {
        return head.data;
      }
    } else if (index == size - 1) {
      if(removeLast()) {
        return tail.data;
      }
    } else {
      LinkedListNode<T> current = head;
      int i = 0;

      while (current != null) {
        if (i == index) {
          current.prev.next = current.next;
          current.next.prev = current.prev;
          size--;
          return current.data;
        }
        i++;
        current = current.next;
      }
    }
    
    return null;
  }
  
  @Override
  public T get(int index) {
    LinkedListNode<T> current = head;
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
  @Override
  public T set(int index, T data) {
    LinkedListNode<T> current = head;
    int i = 0;
    while(current != null) {
      if(i == index) {
        current.data = data;
        return current.data;
      }
      i++;
      current = current.next;
    }
    return null;
  }
  
  public boolean addToFront(T data) {
    LinkedListNode<T> node = new LinkedListNode<T>(data, head);
    head.prev = node;
    head = node;
    size++;
    return true;
  }
  
  public boolean removeFirst() {
    if(head == null) {
      return false;
    }
    head = head.next;
    head.prev = null;
    size--;
    return true;
  }

  public boolean removeLast() {
    if(tail == null) {
      return false;
    }
    tail = tail.prev;
    tail.next = null;
    size--;
    return true;
  }
  
  private boolean addAt(T data, int index) {
    LinkedListNode<T> current = head;
    int i = 1;

    while (current != null) {
      if (i == index) {
        LinkedListNode<T> node = new LinkedListNode<T>(data, current.next, current);
        current.next.prev = node;
        current.next = node;
        size++;
        return true;
      }

      i++;
      current = current.next;
    }
    
    return false;
  }
  
  public void print() {
    System.out.println(this.toString());
  }

  public void printReverse() {
    StringBuilder builder = new StringBuilder();
    LinkedListNode<T> current = tail;
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
    LinkedListNode<T> current = head;
    builder.append("null<-");
    while (current.next != null) {
      builder.append(current.data).append("<=>");
      current = current.next;
    }
    builder.append(current.data).append("->null");
    return builder.toString();
  }
}
