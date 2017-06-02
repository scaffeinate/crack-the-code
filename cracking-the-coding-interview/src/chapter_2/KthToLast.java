package chapter_2;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;

/**
 * Question 2.2: Implement an algorithm to find the kth to last element of a
 * single linked list
 * 
 * @author Sudharsanan Muralidharan
 */
public class KthToLast {

  /**
   * Finds element at Kth position from the last element using the index
   * 
   * Complexity: O(n)
   * 
   * @param list
   * @param k
   * @return foundElement
   */
  public int findElement(CustomLinkedList<Integer> list, int k) {
    LinkedListNode<Integer> current = list.head();
    int i = 0;

    // return element if the index is at k distance from the size-1
    while (current != null) {
      if (i == list.size() - k - 1) {
        return current.data;
      }
      i++;
      current = current.next;
    }

    return -1;
  }

  /**
   * Finds element at Kth position from the last element using two pointers
   * 
   * Complexity: O(n)
   * 
   * @param list
   * @param k
   * @return
   */
  public int findElement2(CustomLinkedList<Integer> list, int k) {
    LinkedListNode<Integer> current = list.head();
    LinkedListNode<Integer> runner = current;

    if (k < 0) {
      return -1;
    }

    // move the fast pointer k positions from the current
    for (int i = 0; i < k + 1; i++) {
      if (runner != null) {
        runner = runner.next;
      } else {
        return -1;
      }
    }

    /*
     * when the runner reaches the end the current would be at k distances from
     * the end
     */
    while (runner != null) {
      current = current.next;
      runner = runner.next;
    }

    return current.data;
  }
}
