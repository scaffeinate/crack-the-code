package chapter_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Question 2.5: You have two numbers represented by a linked list, where each
 * node contains a single digit. The digits are stored in reverse order, such
 * that the 1's digit is at the head of the list. Write a function that adds the
 * two numbers and returns the sum as a linked list.
 * 
 * EXAMPLE
 * 
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is 617 + 295. Output: 2 -> 1 ->
 * 9.That is, 912.
 * 
 * FOLLOW UP
 * 
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * 
 * @author Sudharsanan Muralidharan
 */
public class SumLists {

  /**
   * Returns the sum of digits from the linked lists. Note that the digits are
   * stored in reverse.
   * 
   * @param list
   * @param list2
   * @return sum
   */
  private int computeSum(CustomLinkedList<Integer> list, CustomLinkedList<Integer> list2) {
    int size1 = list.size();
    int size2 = list2.size();

    /*
     * to handle length mismatch, fetch the larger and smaller lists head.
     * current node points the head of the larger linked list current2 points
     * the other list.
     */
    Node<Integer> current = size1 > size2 ? list.head() : list2.head();
    Node<Integer> current2 = size1 > size2 ? list2.head() : list.head();

    return add(current, current2, 0, 0);
  }

  /**
   * Recursive function which computes the sum of digits
   * 
   * @param current
   * @param current2
   * @param carry
   * @param place
   * @return sum
   */
  private int add(Node<Integer> current, Node<Integer> current2, int carry, int place) {

    int total = 0, sum = 0;

    /*
     * current2 points to the smaller list and current to the larger. Add the
     * digits till current2 runs out and then compute the rest of the digits for
     * current
     */
    if (current2 != null) {
      // compute the sum of digits + carryover
      sum = current.data + current2.data + carry;
      // compute new carryover
      carry = sum / 10;
      // (10^place) * digit + add() of rest of the digits
      total += Math.pow(10, place) * (sum % 10) + add(current.next, current2.next, carry, ++place);
    } else if (current != null) {
      // since the smaller list digits are exhausted add digit + carryover
      sum = current.data + carry;
      // compute new carryover
      carry = sum / 10;
      total += Math.pow(10, place) * (sum % 10) + add(current.next, null, carry, ++place);
    } else {
      total += Math.pow(10, place) * carry;
    }

    return total;
  }

  public static void main(String[] args) throws FileNotFoundException {
    FileReader fileReader = new FileReader("input_files/chapter_2/sum_lists");
    Scanner scanner = new Scanner(fileReader);
    SumLists sumLists = new SumLists();
    String input;
    String[] elements, elements2;
    CustomLinkedList<Integer> list, list2;
    StringBuilder builder;

    while (scanner.hasNextLine()) {
      input = scanner.nextLine();
      builder = new StringBuilder();
      list = new CustomLinkedList<Integer>();
      list2 = new CustomLinkedList<Integer>();

      elements = input.split("\\+")[0].split(":");
      elements2 = input.split("\\+")[1].split(":");

      for (String e : elements) {
        list.add(Integer.parseInt(e));
        builder.append(e);
      }

      builder.append('+');

      for (String e : elements2) {
        list2.add(Integer.parseInt(e));
        builder.append(e);
      }

      System.out.print(builder.reverse().toString() + "=");
      System.out.print(sumLists.computeSum(list, list2));
      System.out.println();
    }

    scanner.close();
  }
}
