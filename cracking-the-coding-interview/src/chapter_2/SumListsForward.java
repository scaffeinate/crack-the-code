package chapter_2;

import java.io.FileNotFoundException;
import java.util.Stack;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;
import util.InputUtil;

/**
 * Question 2.5: You have two numbers represented by a linked list, where each
 * node contains a single digit. The digits are stored in reverse order, such
 * that the 1's digit is at the head of the list. Write a function that adds the
 * two numbers and returns the sum as a linked list.
 * 
 * FOLLOW UP
 * 
 * **Suppose the digits are stored in forward order. Repeat the above problem.**
 * 
 * @author Sudharsanan Muralidharan
 */
public class SumListsForward {

  /**
   * Compute Sum Forward in a LinkedList.
   * 
   * For eg: 9->9->8->1 + 8->3->4 which is 9981+834 should return 1->0->8->1->5
   * 
   * Used an iterative approach to store the digits and carry over in 2 stacks.
   * When popping off the stack the results are added to the list.
   * 
   * Complexity: O(n), Extra Space: O(n)
   * 
   * @param current
   * @param current2
   * @return
   */
  private CustomLinkedList<Integer> computeSum(LinkedListNode<Integer> current, LinkedListNode<Integer> current2) {
    CustomLinkedList<Integer> resultList = new CustomLinkedList<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    int sum = 0, temp = 0;
    /*
     * Add the digits and carry over to the stack & stack2 respectively
     */
    while (current != null) {
      sum = (current.data + current2.data);
      stack.push((sum % 10));
      stack2.push((sum / 10));
      current = current.next;
      current2 = current2.next;
    }

    /*
     * Pop the right most digit which can be directly added to list
     */
    resultList.add(stack.pop());

    /*
     * Pop each item from the stack and add to stack2 and temp which is the
     * current carry over value
     */
    while (!stack.isEmpty()) {
      sum = stack.pop() + stack2.pop() + temp;
      resultList.addToFront(sum % 10);
      temp = sum / 10;
    }

    /*
     * The stack2 will have the carry over for left most digit. If more than 0
     * add it to list.
     */
    if ((temp = stack2.pop()) != 0) {
      resultList.addToFront(temp);
    }

    return resultList;
  }

  /**
   * Compute Sum Forward in a LinkedList.
   * 
   * For eg: 9->9->8->1 + 8->3->4 which is 9981+834 should return 1->0->8->1->5
   * 
   * Call Recursive function sumForwardRecurse
   * 
   * Complexity: O(n), Space: O(n) for recursive function
   * 
   * The recursive method returns the NodeWrapper head which needs to be added
   * to front of linked list.
   * 
   * @param current
   * @param current2
   * @return
   */
  private CustomLinkedList<Integer> computeSumRecurse(LinkedListNode<Integer> current, LinkedListNode<Integer> current2) {
    CustomLinkedList<Integer> resultList = new CustomLinkedList<Integer>();
    NodeWrapper<Integer> resultNodeWrapper = sumFowardRecurse(current, current2);
    LinkedListNode<Integer> head = resultNodeWrapper.node;

    /*
     * If there is a carry in the first digit it needs to be added as a new
     * node.
     * 
     * Eg: In 9->2->3 + 1->8->2, 9 + 1 + 1(carry) will yeild 11. The carry now
     * is also 1 which needs to be added to list.
     */
    if (resultNodeWrapper.temp != 0) {
      LinkedListNode<Integer> node = new LinkedListNode<Integer>();
      node.data = resultNodeWrapper.temp;
      resultList.add(node.data);
    }
    
    while (head != null) {
      resultList.add(head.data);
      head = head.next;
    }

    return resultList;
  }

  /**
   * Recursive function to sum list forward.
   * 
   * In order for this to work we need to pass back the node as well as the
   * carry when we reach the tail. So NodeWrapper class holds the reference to
   * the node and also the carry value. Took the hint for using Wrapper class
   * from Book. But implementation might differ.
   * 
   * @param current
   * @param current2
   * @return NodeWrapper head
   */
  private NodeWrapper<Integer> sumFowardRecurse(LinkedListNode<Integer> current, LinkedListNode<Integer> current2) {
    NodeWrapper<Integer> currentNode = new NodeWrapper<Integer>();
    LinkedListNode<Integer> node = new LinkedListNode<Integer>();
    int sum = 0, temp = 0;

    sum = current.data + current2.data;
    node.data = (sum % 10);
    temp = (sum / 10);

    currentNode.node = node;

    if (current.next == null) {
      node.next = null;
      currentNode.temp = temp;
    } else {
      NodeWrapper<Integer> resultWrapper = sumFowardRecurse(current.next, current2.next);
      node.next = resultWrapper.node; // Link the node to the NodeWrapper which
                                      // has next node & carry in stack

      /*
       * When the stack returns compute the new sum with the carry from previous
       * call and update the carry and digit in list
       */
      sum += resultWrapper.temp;
      node.data = (sum % 10);
      currentNode.temp += (sum / 10);
    }

    return currentNode;
  }

  /**
   * Prepend the shorter linkedList with 0 so the correct digits gets added.
   * 
   * For eg: 1->2->3->4 + 0->0->8->9
   * 
   * @param list
   * @param list2
   */
  private void padLinkedList(CustomLinkedList<Integer> list, CustomLinkedList<Integer> list2) {
    CustomLinkedList<Integer> shorter = (list.size() > list2.size()) ? list2 : list;

    for (int i = 0; i < Math.abs((list2.size() - list.size())); i++) {
      LinkedListNode<Integer> node = new LinkedListNode<Integer>();
      node.data = 0;
      node.next = shorter.head();
      shorter.head(node);
    }
  }

  public static void main(String[] args) throws FileNotFoundException {

    SumListsForward sumListsForward = new SumListsForward();
    String[] input = InputUtil.readContents(2, "sum_lists");
    String[] elements, elements2;
    CustomLinkedList<Integer> list, list2;
    StringBuilder builder;

    for (String line : input) {
      list = new CustomLinkedList<Integer>();
      list2 = new CustomLinkedList<Integer>();
      builder = new StringBuilder();

      elements = line.split("\\+")[0].split(":");
      elements2 = line.split("\\+")[1].split(":");

      if (elements != null) {
        for (String e : elements) {
          list.add(Integer.parseInt(e));
          builder.append(e).append("->");
        }
      }

      if (elements2 != null) {
        builder.append(" + ");

        for (String e : elements2) {
          list2.add(Integer.parseInt(e));
          builder.append(e).append("->");
        }
      }

      System.out.println(builder.toString());
      sumListsForward.padLinkedList(list, list2);

      System.out.println("Using Iteration: ");
      CustomLinkedList<Integer> result = sumListsForward.computeSum(list.head(), list2.head());
      result.print();

      System.out.println("Using Recursion: ");
      CustomLinkedList<Integer> resultRecurse = sumListsForward.computeSumRecurse(list.head(), list2.head());
      resultRecurse.print();

      System.out.println();
    }
  }

  class NodeWrapper<T> {
    LinkedListNode<T> node;
    int temp = 0;
  }
}
