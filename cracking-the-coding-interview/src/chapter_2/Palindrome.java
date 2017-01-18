package chapter_2;

import java.io.FileNotFoundException;
import java.util.Stack;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;
import util.InputUtil;

/**
 * Question 2.6: Implement a function to check if a linked list is a palindrome.
 * 
 * @author Sudharsanan Muralidharan
 *
 */
public class Palindrome {

  /**
   * Check if list is a palindrome by reversing the half and checking.
   * 
   * Complexity: O(n), Space: O(1)
   * 
   * @param list
   * @return
   */
  private boolean isPalindrome(CustomLinkedList<Character> list) {
    LinkedListNode<Character> head = list.head();
    LinkedListNode<Character> center = list.getNode(list.size() / 2);

    LinkedListNode<Character> current, runner, temp;

    current = center;
    runner = center.next;
    current.next = null;

    while (runner != null) {
      temp = runner.next;
      runner.next = current;
      current = runner;
      runner = temp;
    }

    while (!head.equals(center)) {
      if (!current.data.equals(head.data)) {
        return false;
      }

      current = current.next;
      head = head.next;
    }

    return true;
  }

  /**
   * Checks if the list is a palindrome using a Stack.
   * 
   * Complexity: O(n), Space: O(n)
   * 
   * @param list
   * @return
   */
  private boolean isPalindrome2(CustomLinkedList<Character> list) {
    LinkedListNode<Character> head = list.head();
    Stack<Character> stack = new Stack<Character>();

    if (list.size() == 1) {
      return true;
    }

    LinkedListNode<Character> center = list.getNode(list.size() / 2);

    while (center != null) {
      stack.push(center.data);
      center = center.next;
    }

    while (!head.equals(center) && !stack.isEmpty()) {
      if (!head.data.equals(stack.pop())) {
        return false;
      }

      head = head.next;
    }

    return true;
  }

  /**
   * Recursive solution to check if it's a Palindrome. This is the same approach
   * as in Book but implementation is a little different. Start with the head
   * and recurse through center which can be checked when len hits 0 or 1. We
   * reduce the length by 2 every call. Return center or center.next when this
   * condition is true.
   * 
   * The ref is passed back the calling function. Say we have 5 nodes where 2nd
   * index is the center. Now 3rd index will be compared to 1st index. If data
   * is equal we move the ref to ref.next and pass it back to the calling
   * function and let memory stack do it's job.
   * 
   * 
   * @param current
   * @param len
   * @return wrapper which has node and isPalindrome flag
   */
  private NodeWrapper<Character> isParlindromeRecurse(LinkedListNode<Character> current, int len) {
    NodeWrapper<Character> resultWrapper = null;

    if (len == 1) {
      return new NodeWrapper<Character>(current.next);
    } else if (len == 0) {
      return new NodeWrapper<Character>(current);
    }

    resultWrapper = isParlindromeRecurse(current.next, len - 2);

    if (resultWrapper.isPalindrome) {
      if (current.data.equals(resultWrapper.node.data)) {
        resultWrapper.node = resultWrapper.node.next;
      } else {
        resultWrapper.isPalindrome = false;
      }
    }

    return resultWrapper;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Palindrome palindrome = new Palindrome();
    String[] input = InputUtil.readContents(2, "palindrome");
    CustomLinkedList<Character> inputList;
    CustomLinkedList<Character> list;

    for (String line : input) {
      line = line.toLowerCase();
      inputList = new CustomLinkedList<Character>();

      for (int i = 0; i < line.length(); i++) {
        inputList.add(line.charAt(i));
      }

      System.out.println("Input: " + line);

      list = new CustomLinkedList<Character>(inputList);
      System.out.println("Is it Palindrome? - Inline " + palindrome.isPalindrome(list));

      list = new CustomLinkedList<Character>(inputList);
      System.out.println("Is it Palindrome? - Stack " + palindrome.isPalindrome2(list));

      list = new CustomLinkedList<Character>(inputList);
      System.out.println(
          "Is it Palindrome? - Recurse " + palindrome.isParlindromeRecurse(list.head(), list.size()).isPalindrome);

      System.out.println();
    }
  }

  class NodeWrapper<T> {
    LinkedListNode<T> node;
    boolean isPalindrome = true;

    NodeWrapper(LinkedListNode<T> node) {
      this.node = node;
    }
  }
}
