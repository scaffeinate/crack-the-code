package linked_list;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;

public class MergeSortedLinkedListsReverse {
  CustomLinkedList<Integer> list = null;
  CustomLinkedList<Integer> list2 = null;

  public MergeSortedLinkedListsReverse() {
    list = new CustomLinkedList<Integer>();
    list2 = new CustomLinkedList<Integer>();
  }

  public void constructLists(String[] input, String[] input2) {
    for (String e : input) {
      if (!e.equals("NULL")) {
        list.add(Integer.parseInt(e));
      }
    }

    for (String e : input2) {
      if (!e.equals("NULL")) {
        list2.add(Integer.parseInt(e));
      }
    }
  }

  public CustomLinkedList<Integer> merge() {
    CustomLinkedList<Integer> resultList = new CustomLinkedList<Integer>();
    LinkedListNode<Integer> current = list.head();
    LinkedListNode<Integer> current2 = list2.head();

    while (current != null && current2 != null) {
      if (current.data < current2.data) {
        resultList.add(current.data);
        current = current.next;
      } else {
        resultList.add(current2.data);
        current2 = current2.next;
      }
    }

    while (current != null) {
      resultList.add(current.data);
      current = current.next;
    }

    while (current2 != null) {
      resultList.add(current2.data);
      current2 = current2.next;
    }

    reverseLinkedList(resultList);

    return resultList;
  }

  private void reverseLinkedList(CustomLinkedList<Integer> linkedList) {
    if (linkedList.isEmpty()) {
      return;
    }
    
    LinkedListNode<Integer> current = linkedList.head();
    LinkedListNode<Integer> runner = current.next;
    LinkedListNode<Integer> temp = null;

    current.next = null;

    while (runner != null) {
      temp = runner.next;
      runner.next = current;
      current = runner;
      runner = temp;
    }

    linkedList.head(current);
  }
}
