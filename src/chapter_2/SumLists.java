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

  private int computeSum(CustomLinkedList<Integer> list, CustomLinkedList<Integer> list2) {
    int size1 = list.size();
    int size2 = list2.size();

    Node<Integer> current = size1 > size2 ? list.head() : list2.head();
    Node<Integer> current2 = size1 > size2 ? list2.head() : list.head();

    return computeSum(current, current2, 0, 0);
  }

  private int computeSum(Node<Integer> current, Node<Integer> current2, int carry, int place) {

    int total = 0, sum = 0;

    if (current2 != null) {
      sum = current.data + current2.data + carry;
      carry = sum / 10;
      total += Math.pow(10, place) * (sum % 10)
          + computeSum(current.next, current2.next, carry, ++place);
    } else if (current != null) {
      sum = current.data + carry;
      carry = sum / 10;
      total += Math.pow(10, place) * (sum % 10)
          + computeSum(current.next, null, carry, ++place);
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

    while (scanner.hasNextLine()) {
      input = scanner.nextLine();
      list = new CustomLinkedList<Integer>();
      list2 = new CustomLinkedList<Integer>();

      elements = input.split("\\+")[0].split(":");
      elements2 = input.split("\\+")[1].split(":");

      for (String e : elements) {
        list.add(Integer.parseInt(e));
      }

      for (String e : elements2) {
        list2.add(Integer.parseInt(e));
      }

      System.out.println(sumLists.computeSum(list, list2));
    }

    scanner.close();
  }
}
