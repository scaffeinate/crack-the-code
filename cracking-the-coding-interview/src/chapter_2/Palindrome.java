package chapter_2;

import java.io.FileNotFoundException;
import java.util.Stack;

import chapter_2.list.CustomLinkedList;
import chapter_2.list.Node;
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
    Node<Character> head = list.head();
    Node<Character> center = list.getNode(list.size() / 2);

    Node<Character> current, runner, temp;

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
    Node<Character> head = list.head();
    Stack<Character> stack = new Stack<Character>();

    if (list.size() == 1) {
      return true;
    }

    Node<Character> center = list.getNode(list.size() / 2);

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
      System.out.println("Is it Palindrome? " + palindrome.isPalindrome(list));

      list = new CustomLinkedList<Character>(inputList);
      System.out.println("Is it Palindrome - Method 2? " + palindrome.isPalindrome2(list));

      System.out.println();
    }
  }
}
