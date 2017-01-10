package chapter_2.additional;

import java.io.FileNotFoundException;
import java.util.Stack;

import datastructures.common.Node;
import datastructures.lists.CustomLinkedList;
import datastructures.util.ListUtil;
import util.InputUtil;

/**
 * Additional: Write a program to reverse a LinkedList. Sub solution for solving
 * the Palindrome LinkedList problem.
 * 
 * @author Sudharsanan Muralidharan
 */
public class ReverseLinkedList {

  /**
   * Using a Stack to reverse a LinkedList.
   * 
   * Pop each node from stack and link it to the new head.
   * 
   * Complexity: O(n), Extra Space: O(n) for the Stack
   * 
   * @param head
   * @return resultHead
   */
  private Node<String> reverseUsingStack(Node<String> head) {
    Node<String> resultHead = null;
    Stack<Node<String>> stack = new Stack<Node<String>>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }

    Node<String> current = null;
    while (!stack.isEmpty()) {
      if (resultHead == null) {
        resultHead = new Node<String>();
        resultHead = stack.pop();
        current = resultHead;
      } else {
        current.next = stack.pop();
        current = current.next;
        current.next = null;
      }
    }

    return resultHead;
  }

  /**
   * Using a Recursive strategy to reverse the LinkedList. The logic is simple.
   * Traverse the linkedList from current to tail then Create nodeWrapper
   * object; nodeWrapper.head = linkedList.tail; Pass back nodeWrapper object.
   * When returned the stack call link wrapper tail to current node and move the
   * wrapper tail to current node.
   * 
   * Return the nodeWrapper.head which points to original LinkedList tail and is
   * now reverse linked.
   * 
   * Complexity: O(n), Extra Space: O(n) for Recursive call Stack.
   * 
   * @param current
   * @return resultHead
   */
  private NodeWrapper<String> reverseRecursive(Node<String> current) {
    NodeWrapper<String> resultWrapper = null;

    if (current.next == null) {
      resultWrapper = new NodeWrapper<String>();
      resultWrapper.head = current;
      resultWrapper.tail = current;
    } else {
      resultWrapper = reverseRecursive(current.next);
      resultWrapper.tail.next = current;
      resultWrapper.tail = current;
      current.next = null;
    }

    return resultWrapper;
  }

  /**
   * Reverse LinkedList inline using two pointers. Simple Logic.
   * 
   * Complexity: O(n), Space: O(1)
   * 
   * @param head
   * @return resultHead
   */
  private Node<String> reverseInline(Node<String> head) {
    Node<String> resultHead = head;
    Node<String> runner = resultHead.next;
    Node<String> temp;

    resultHead.next = null;

    while (runner != null) {
      temp = runner.next;
      runner.next = resultHead;
      resultHead = runner;
      runner = temp;
    }

    return resultHead;
  }

  public static void main(String[] args) throws FileNotFoundException {
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    String[] input = InputUtil.readContents(2, "reverse_linked_list");
    CustomLinkedList<String> list = new CustomLinkedList<String>();
    CustomLinkedList<String> list2, list3;

    for (String line : input) {
      list = InputUtil.parseLinkedList(line);
      list2 = new CustomLinkedList<String>(list);
      list3 = new CustomLinkedList<String>(list);

      System.out.println("Original Linked List:");
      list.print();

      System.out.println("Reversed using Stack:");
      Node<String> result = reverseLinkedList.reverseUsingStack(list.head());
      ListUtil.printList(result);

      System.out.println("Reversed Recursive:");
      Node<String> resultRecurse = reverseLinkedList.reverseRecursive(list2.head()).head;
      ListUtil.printList(resultRecurse);

      System.out.println("Reversed Inline:");
      Node<String> resultInline = reverseLinkedList.reverseInline(list3.head());
      ListUtil.printList(resultInline);

      System.out.println();
    }
  }

  /**
   * Node wrapper class to store the new head and tail
   * 
   * @author Sudharsanan Muralidharan
   * @param <T>
   */
  class NodeWrapper<T> {
    Node<T> head;
    Node<T> tail;
  }
}
