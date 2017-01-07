package chapter_2;

import java.io.FileNotFoundException;

import chapter_2.list.CustomLinkedList;
import chapter_2.list.Node;
import util.InputUtil;

/**
 * Question 2.4: Write code to partition a linked list around a value x, such
 * that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list the values of x only need to be after the
 * elements less than x. The partition element x can appear anywhere in the
 * right "partition"; it does not need to appear between the left and right
 * partitions.
 * 
 * EXAMPLE:
 * 
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 (partition = 5) Output: 3 -> 1 -> 2
 * -> 5 -> 5 -> 8 -> 10
 * 
 * @author Sudharsanan Muralidharan
 */
public class Partition {

  /**
   * Create two linkedlists for lower and higher values. Find the partition
   * node.
   * 
   * leftLL->partitionNode->rightLL
   * 
   * Complexity: O(n), Extra Space: O(n)
   * 
   * @param list
   * @param partitionVal
   * @return Node<Integer> of New List head
   */
  private Node<Integer> partition(CustomLinkedList<Integer> list, int partitionVal) {
    CustomLinkedList<Integer> left = new CustomLinkedList<Integer>();
    CustomLinkedList<Integer> right = new CustomLinkedList<Integer>();
    Node<Integer> current = list.head();
    Node<Integer> start = null;
    Node<Integer> partitionNode = list.removeNode(Integer.valueOf(partitionVal));

    if (partitionNode != null) {
      current = list.head();
      while (current != null) {
        if (current.data.intValue() < partitionVal) {
          left.add(current.data);
        } else {
          right.add(current.data);
        }

        current = current.next;
      }

      start = (left.head() == null) ? partitionNode : left.head();

      if (left.head() != null) {
        left.tail().next = partitionNode;
      }

      if (right.head() != null) {
        partitionNode.next = right.head();
      }
    }

    return start;
  }

  /**
   * Algorithm to partition in place. This is the Book solution.
   * 
   * Basically it works like this. Start head, tail and current at start of the
   * linkedlist.
   * 
   * With each new node check val lesser or greater than partitionVal and link
   * it to head or tail accordingly. Store the next node before linking to move
   * the current pointer.
   * 
   * Eg: a->b->c->d->e
   * 
   * head = tail = current = a; next = b;
   * 
   * if(a < partition) { a.next = head; head = a; } else { tail.next = b; tail =
   * b; }
   * 
   * current = next;
   * 
   * So the link from current is broken while storing the next reference to move
   * it back again.
   * 
   * Complexity: O(n), Extra Space: O(1)
   * 
   * @param list
   * @param partitionVal
   * @return
   */
  private Node<Integer> partitionInplace(CustomLinkedList<Integer> list, int partitionVal) {
    Node<Integer> head = list.head();
    Node<Integer> tail = head;
    Node<Integer> current = head;

    while (current != null) {
      Node<Integer> next = current.next;
      if (current.data.intValue() < partitionVal) {
        current.next = head;
        head = current;
      } else {
        tail.next = current;
        tail = current;
      }

      current = next;
    }

    tail.next = null;

    return head;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Partition partition = new Partition();
    String[] contents = InputUtil.readContents(2, "partition");
    String[] elements;
    Node<Integer> head;

    for (String line : contents) {
      String[] values = line.split(" ");
      elements = values[0].split(":");
      int partitionVal = Integer.parseInt(values[1]);

      CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
      CustomLinkedList<Integer> list2;
      
      for (String e : elements) {
        list.add(Integer.parseInt(e));
      }

      list2 = new CustomLinkedList<Integer>(list);
      System.out.println("Partition: " + partitionVal + " & Original List: ");
      list.print();

      System.out.println("Using 2 Linked Lists:");
      head = partition.partition(list, partitionVal);
      list.print(head);
      
      System.out.println("Using Inplace:");
      head = partition.partitionInplace(list2, partitionVal);
      list2.print(head);
      
      System.out.println();
      
    }
  }
}
