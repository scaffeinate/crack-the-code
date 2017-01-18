package datastructures.lists;

public class CircularLinkedList<T> {
  private LinkedListNode<T> head = null;
  private LinkedListNode<T> tail = null;
  private int size = 0;

  public CircularLinkedList() {
  }

  public void add(T data) {
    if (head == null) {
      head = new LinkedListNode<T>();
      head.data = data;
      tail = head;
    } else {
      LinkedListNode<T> node = new LinkedListNode<T>();
      node.data = data;
      tail.next = node;
      tail = node;
    }
    size++;
    tail.next = head;
  }

  public void addToFront(T data) {
    LinkedListNode<T> node = new LinkedListNode<T>();
    node.data = data;
    node.next = head;
    head = node;
    tail.next = head;
  }

  public void add(T data, int index) {
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
          LinkedListNode<T> node = new LinkedListNode<T>();
          node.data = data;
          current.next = node;
          node.next = runner;
          return;
        }
        i++;
        current = current.next;
        runner = runner.next;
      }
    }
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

  public boolean isEmpty() {
    return (this.size == 0);
  }

  public int size() {
    return this.size;
  }
}
