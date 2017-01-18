package chapter_2;

import java.io.FileNotFoundException;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;
import util.InputUtil;

/**
 * Question 2.7: Given a circular linked list, implement an algorithm that
 * returns the node at the beginning of the loop.
 * 
 * DEFINITION: Circular Linked List: A (corrupt) linked list in which a node's
 * next pointer points to an earlier node, so as to make a loop in the linked
 * list.
 * 
 * EXAMPLE
 * 
 * Input: A -> B -> C -> D -> E -> C Output: C
 * 
 * @author Sudharsanan Muralidharan
 */
public class LoopDetection {

  /**
   * Solution using slow and fast pointers. Book and Online solution.
   * 
   * @param list
   * @return collisionNode
   */
  private LinkedListNode<String> detectLoop(CustomLinkedList<String> list) {
    LinkedListNode<String> current = list.head();
    LinkedListNode<String> current2 = list.head();

    current = current.next;
    current2 = current2.next.next;

    while (!current.equals(current2)) {
      current = current.next;
      current2 = current2.next.next;
    }

    current = list.head();

    while (!current.equals(current2)) {
      current = current.next;
      current2 = current2.next;
    }

    return current;
    // return list.find(counter);
  }

  public static void main(String[] args) throws FileNotFoundException {
    LoopDetection loopDetection = new LoopDetection();
    String[] input = InputUtil.readContents(2, "detect_loops");
    CustomLinkedList<String> list = new CustomLinkedList<String>();

    for (String line : input) {
      list = InputUtil.parseLinkedList(line);

      System.out.println("Original Linked List:");
      list.print();

      LinkedListNode<String> temp = list.find(0);
      System.out.println(temp.data + " " + list.tail().data);
      list.tail().next = temp;

      LinkedListNode<String> result = loopDetection.detectLoop(list);
      if (result != null) {
        System.out.println("Loop at:" + result.data);
      } else {
        System.out.println("No Loops found");
      }

      System.out.println();
    }
  }
}
