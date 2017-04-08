package linked_list;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;

public class MoveAllOccurancesToEnd {

  private CustomLinkedList<Integer> linkedList = null;

  public void constructLinkedList(String input) {
    linkedList = new CustomLinkedList<Integer>();
    String[] elements = input.split(" ");

    for (String e : elements) {
      if (e != null && !e.trim().isEmpty()) {
        linkedList.add(Integer.parseInt(e.toString()));
      }
    }
  }

  public CustomLinkedList<Integer> moveAllOccurancesToEnd(int key) {
    LinkedListNode<Integer> head = linkedList.head();
    LinkedListNode<Integer> tail = linkedList.tail();

    while ((head = linkedList.head()).data == key) {
      linkedList.head(head.next);
      head.next = null;
      linkedList.tail().next = head;
      linkedList.tail(head);
    }
    
    LinkedListNode<Integer> current = head;
    LinkedListNode<Integer> runner = current.next;

    while (!runner.equals(tail)) {
      int data = runner.data;
      if (data == key) {
        current.next = runner.next;
        runner.next = null;
        linkedList.tail().next = runner;
        linkedList.tail(runner);
        runner = current.next;
      } else {
        current = current.next;
        runner = runner.next;
      }
    }

    return linkedList;
  }
}
