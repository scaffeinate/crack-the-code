package chapter_2;

import java.io.FileNotFoundException;
import java.util.Stack;

import chapter_2.list.CustomLinkedList;
import chapter_2.list.Node;
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
  private CustomLinkedList<Integer> computeSum(Node<Integer> current, Node<Integer> current2) {
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
      resultList.add(sum % 10);
      temp = sum / 10;
    }

    /*
     * The stack2 will have the carry over for left most digit. If more than 0
     * add it to list.
     */
    if ((temp = stack2.pop()) != 0) {
      resultList.add(temp);
    }

    return resultList;
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
      Node<Integer> node = new Node<Integer>();
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

      System.out.println();
    }
  }
}
