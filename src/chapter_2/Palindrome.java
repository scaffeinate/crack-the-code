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

  private boolean isPalindrome(CustomLinkedList<Character> list) {
    Node<Character> head = list.head();
    Node<Character> center = list.getNode(list.size() / 2);

    Node<Character> prev, current, runner;

    prev = center;
    current = prev.next;

    while (current != null) {
      runner = current.next;
      current.next = prev;
      prev = current;
      current = runner;
    }

    while (!head.equals(center)) {
      if (!prev.data.equals(head.data)) {
        return false;
      }

      prev = prev.next;
      head = head.next;
    }

    return true;
  }

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
