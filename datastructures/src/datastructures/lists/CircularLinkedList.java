package datastructures.lists;

public class CircularLinkedList<T> extends AbstractList<T> {
  
  public CircularLinkedList() {
  }

  @Override
  public boolean add(T data) {
    if (head == null) {
      head = new LinkedListNode<T>(data);
      tail = head;
    } else {
      LinkedListNode<T> node = new LinkedListNode<T>(data);
      tail.next = node;
      tail = node;
    }
    size++;
    tail.next = head;
    return true;
  }

  @Override
  public boolean add(int index, T data) {
    if (index == 0) {
      addToFront(data);
    } else if (index == size - 1) {
      add(data);
    } else {
      LinkedListNode<T> current = head;
      LinkedListNode<T> runner = current.next;
      int i = 1;
      while(runner != null) {
        if(i == index) {
          LinkedListNode<T> node = new LinkedListNode<T>(data);
          current.next = node;
          node.next = runner;
          return true;
        }
        i++;
        current = current.next;
        runner = runner.next;
      }
    }
    return false;
  }

  @Override
  public boolean addToFront(T data) {
    LinkedListNode<T> node = new LinkedListNode<T>(data, head);
    head = node;
    tail.next = head;
    return true;
  }

  @Override
  public boolean remove(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public T remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean removeFirst() {
    if(head == null) {
      return false;
    }
    
    head = head.next;
    tail.next = head;
    return true;
  }

  @Override
  public boolean removeLast() {
    LinkedListNode<T> current = head;
    LinkedListNode<T> runner = current.next;
    
    while(!runner.equals(head)) {
      if(runner.equals(tail)) {
        current.next = head;
        tail = current;
        return true;
      }
    }
    
    return false;
  }

  @Override
  public T get(int index) {
    return null;
  }

  @Override
  public T set(int index, T data) {
    return null;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    LinkedListNode<T> current = head;
    builder.append("List: [");
    while (current.next != head) {
      builder.append(current.data).append("->");
      current = current.next;
    }

    builder.append(current.data).append("]. Tail->next: ").append(tail.next.data).append("\n");
    builder.append("Tail linked to head? ").append(tail.next.equals(head));

    return builder.toString();
  }
}
