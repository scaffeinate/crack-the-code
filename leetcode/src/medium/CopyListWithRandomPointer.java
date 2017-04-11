package medium;

/**
 * Problem: https://leetcode.com/problems/copy-list-with-random-pointer
 * 
 * @author Sudharsanan Muralidharan
 */
public class CopyListWithRandomPointer {
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null)
      return null;
    clone(head);
    RandomListNode current = head;
    RandomListNode runner = head.next;
    RandomListNode result = runner;

    while (runner != null) {
      current.next = (current.next != null) ? current.next.next : current.next;
      runner.next = (runner.next != null) ? runner.next.next : runner.next;

      runner = runner.next;
      current = current.next;
    }

    return result;
  }

  private void clone(RandomListNode head) {
    RandomListNode current = head;
    while (current != null) {
      RandomListNode node = new RandomListNode(current.label);
      node.next = current.next;
      current.next = node;
      current = node.next;
    }

    while (head != null && head.next != null) {
      if (head.random != null) {
        head.next.random = head.random.next;
      }
      head = head.next.next;
    }
  }

  class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
      this.label = x;
    }
  }
}
