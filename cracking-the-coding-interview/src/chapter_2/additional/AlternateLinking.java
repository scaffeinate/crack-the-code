package chapter_2.additional;

import java.io.FileNotFoundException;

import chapter_2.list.CustomLinkedList;
import chapter_2.list.Node;
import util.InputUtil;

/**
 * Additional: Given a LinkedList of size n where n is an even number rearrange
 * the list such that alternate elements are linked. This example is given under
 * the Runner Technique of Chapter 2.
 * 
 * Eg:
 * 
 * Input: a1->a2->a3->b1->b2->b3
 * 
 * Output: a1->b1->a2->b2->a3->b3
 * 
 * 
 * @author Sudharsanan Muralidharan
 */
public class AlternateLinking {

  /**
   * Using two pointers alternate linking is possible in place without using additional memory.
   * 
   * Complexity: O(n), Space: O(1)
   * 
   * @param list
   */
  private void linkAlternates(CustomLinkedList<String> list) {
    Node<String> head = list.head();
    Node<String> current = head;
    Node<String> runner = head;
    
    //Using the Runner Technique here
    while (runner != null && runner.next != null) {
      current = current.next;
      runner = runner.next.next;
    }

    runner = current;
    current = head;

    Node<String> temp, temp2;
    while (current != null && runner != null) {
      temp = current.next;
      current.next = runner;
      if (runner.next == null) {
        break;
      } else {
        temp2 = runner.next;
        runner.next = temp;
        current = temp;
        runner = temp2;
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    AlternateLinking alternateLinking = new AlternateLinking();
    String[] input = InputUtil.readContents(2, "alternate_linking");
    String[] elements;

    for (String line : input) {
      elements = line.split(":");
      CustomLinkedList<String> list = new CustomLinkedList<String>();

      for (String e : elements) {
        if (e != null && !e.trim().isEmpty()) {
          list.add(e);
        }
      }

      System.out.println("Original Linked List:");
      list.print();

      alternateLinking.linkAlternates(list);
      System.out.println("After Linking Alternates: ");
      list.print();

      System.out.println();

    }
  }
}
