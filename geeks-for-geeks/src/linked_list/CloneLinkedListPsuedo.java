package linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/
 * 
 * @author Sudharsanan Muralidharan
 */
public class CloneLinkedListPsuedo {
  public CustomLinkedListPsuedo constructList(String[] input) {
    CustomLinkedListPsuedo linkedList = new CustomLinkedListPsuedo();
    Map<Integer, LinkedListNodePsuedo> nodesMap = new HashMap<Integer, LinkedListNodePsuedo>();
    for (String line : input) {
      String[] values = line.split(" ");
      switch (values[0]) {
      case "insert":
        String[] listValues = values[1].split("->");
        for (String listValue : listValues) {
          LinkedListNodePsuedo node = linkedList.insert(Integer.parseInt(listValue));
          nodesMap.put(Integer.parseInt(listValue), node);
        }
        break;
      case "psuedoLink":
        LinkedListNodePsuedo node = nodesMap.get(Integer.parseInt(values[1]));
        LinkedListNodePsuedo node2 = nodesMap.get(Integer.parseInt(values[2]));
        node.psuedo = node2;
        break;
      }
    }

    return linkedList;
  }

  public CustomLinkedListPsuedo clone(CustomLinkedListPsuedo linkedList) {
    CustomLinkedListPsuedo resultList = new CustomLinkedListPsuedo();
    LinkedListNodePsuedo current = linkedList.head;

    while (current != null) {
      LinkedListNodePsuedo node = new LinkedListNodePsuedo(current.data);
      node.next = current.next;
      current.next = node;
      current = node.next;
    }

    current = linkedList.head;

    while (current != null && current.next != null) {
      if (current.psuedo != null) {
        current.next.psuedo = current.psuedo.next;
      }
      current = current.next.next;
    }

    current = linkedList.head;
    LinkedListNodePsuedo runner = current.next;

    while (runner != null) {
      LinkedListNodePsuedo temp = (runner.next != null) ? runner.next.next : runner.next;
      current.next = (current.next != null) ? current.next.next : current.next;
      resultList.insert(runner);
      runner = temp;
      current = current.next;
    }

    return resultList;
  }

  public CustomLinkedListPsuedo clone2(CustomLinkedListPsuedo linkedList) {
    CustomLinkedListPsuedo resultList = new CustomLinkedListPsuedo();
    LinkedListNodePsuedo current = linkedList.head;
    LinkedListNodePsuedo current2 = null;
    LinkedListNodePsuedo temp = null;

    while (current != null) {
      current2 = resultList.insert(current.data);
      temp = current.next;
      current.next = current2;
      if (current.psuedo != null) {
        current2.psuedo = current;
      }
      current = temp;
    }

    current2 = resultList.head;
    while (current2 != null) {
      if (current2.psuedo != null && current2.psuedo.psuedo != null) {
        current2.psuedo = current2.psuedo.psuedo.next;
      }
      current2 = current2.next;
    }

    return resultList;
  }

  public class CustomLinkedListPsuedo {
    LinkedListNodePsuedo head = null, tail = null;

    public LinkedListNodePsuedo insert(int data) {
      if (head == null) {
        head = new LinkedListNodePsuedo(data);
        tail = head;
      } else {
        LinkedListNodePsuedo node = new LinkedListNodePsuedo(data);
        tail.next = node;
        tail = node;
      }
      return tail;
    }

    public LinkedListNodePsuedo insert(LinkedListNodePsuedo node) {
      if (head == null) {
        head = node;
        tail = head;
      } else {
        tail.next = node;
        tail = node;
      }
      node.next = null;

      return node;
    }

    public void print() {
      LinkedListNodePsuedo current = head;
      while (current != null) {
        System.out.print(current.data + "->" + ((current.next != null) ? current.next.data : "null") + "=>"
            + ((current.psuedo != null) ? current.psuedo.data : "null") + " ");
        current = current.next;
      }

      System.out.println();
    }
  }

  public class LinkedListNodePsuedo {
    int data = 0;
    LinkedListNodePsuedo next = null;
    LinkedListNodePsuedo psuedo = null;

    public LinkedListNodePsuedo(int data) {
      this.data = data;
    }
  }
}
