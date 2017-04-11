package linked_list;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListPsuedo {
  private CustomLinkedListPsuedo linkedList = null;
  private Map<Integer, LinkedListNodePsuedo> nodesMap = null;

  public CloneLinkedListPsuedo() {
    linkedList = new CustomLinkedListPsuedo();
    nodesMap = new HashMap<Integer, LinkedListNodePsuedo>();
  }

  public void constructList(String[] input) {
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
    
    linkedList.print();
  }

  public CustomLinkedListPsuedo clone() {
    CustomLinkedListPsuedo resultList = new CustomLinkedListPsuedo();
    LinkedListNodePsuedo current = linkedList.head;
    LinkedListNodePsuedo current2 = null;
    LinkedListNodePsuedo temp = null;
    
    while (current != null) {
      current2 = resultList.insert(current.data);
      temp = current.next;
      current.next = current2;
      current2.psuedo = current;
      current = temp;
    }

    current = linkedList.head;
    current2 = resultList.head;

    while (current != null) {
      if(current.next != null && current.psuedo != null) {
        current.next.psuedo = current.psuedo.next;
      }
      if(current.next != null && current.next.next != null) {
        current.next = current.next.next.psuedo;
      }

      current = current.next;
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

    public void print() {
      LinkedListNodePsuedo current = head;
      while (current != null) {
        System.out.print(current.toString() + " -> ");
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

    @Override
    public String toString() {
      return "LinkedListNodePsuedo [data=" + data + ", next=" + (next != null ? next.data : "null") + ", psuedo="
          + (psuedo != null ? psuedo.data : "null") + "]";
    }
  }
}
