package chapter_2;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import chapter_2.list.CustomLinkedList;
import chapter_2.list.Node;
import util.InputUtil;

/**
 * Question 2.1: Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP
 * 
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * @author Sudharsanan Muralidharan
 */
public class RemoveDuplicates {

  /**
   * Remove duplicates from the list using a set
   * 
   * Complexity: O(n), Space: O(n)
   * 
   * @param list
   */
  private void removeSet(CustomLinkedList<Integer> list) {
    Node<Integer> current = list.head();
    Node<Integer> runner = current.next;
    Set<Integer> set = new HashSet<Integer>();
    set.add(current.data);

    while (runner != null) {
      if (set.contains(runner.data)) {
        current.next = runner.next;
        runner = runner.next;
      } else {
        set.add(runner.data);
        current = current.next;
        runner = runner.next;
      }
    }
  }

  /**
   * Use two pointers to check and remove duplicates from the list.
   * 
   * Complexity: O(n2), Space: O(1)
   * 
   * @param list
   */
  private void remove(CustomLinkedList<Integer> list) {
    Node<Integer> current = list.head();
    while (current != null) {
      Node<Integer> current2 = current;
      Node<Integer> runner2 = current2.next;

      while (runner2 != null) {
        if (runner2.data.equals(current.data)) {
          current2.next = runner2.next;
        } else {
          current2 = current2.next;
        }
        runner2 = runner2.next;
      }

      current = current.next;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    RemoveDuplicates removeDuplicates = new RemoveDuplicates();
    String[] input = InputUtil.readContents(2, "remove_dups");
    String[] elements;

    for (String line : input) {
      elements = line.split(":");
      CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
      CustomLinkedList<Integer> list2 = new CustomLinkedList<Integer>(list);

      for (String e : elements) {
        if (e != null && !e.trim().isEmpty()) {
          list.add(Integer.parseInt(e));
          list2.add(Integer.parseInt(e));
        }
      }

      System.out.println("Original Linked List:");
      list.print();

      removeDuplicates.remove(list);
      System.out.println("After Removing Duplicates: ");
      list.print();

      System.out.println("Original Linked List:");
      list2.print();
      removeDuplicates.removeSet(list2);
      System.out.println("After Removing Duplicates using Set:");
      list2.print();

      System.out.println();

    }
  }
}
