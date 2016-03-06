package chapter_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
  private int findElement(CustomLinkedList<Integer> list, int k) {
    Node<Integer> current = list.head();
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
  private int findElement2(CustomLinkedList<Integer> list, int k) {
    Node<Integer> current = list.head();
    Node<Integer> runner = current;

    if(k < 0) {
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

  public static void main(String[] args) throws FileNotFoundException {
    FileReader fileReader = new FileReader("input_files/chapter_2/k_last");
    Scanner scanner = new Scanner(fileReader);
    KthToLast kthToLast = new KthToLast();
    String input;
    String[] elements;
    int k;

    while (scanner.hasNextLine()) {
      input = scanner.nextLine();
      k = Integer.parseInt(input.split(" ")[0]);
      elements = input.split(" ")[1].split(":");
      CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
      for (String e : elements) {
        list.add(Integer.parseInt(e));
      }

      System.out.println("Value of K:" + k);
      System.out.println("Linked List:");
      list.print();

      System.out.print("Element at k from last: " + kthToLast.findElement(list, k) + "\n");
      System.out.print("Element at k from last - Method 2: " + kthToLast.findElement2(list, k) + "\n");
      System.out.println();
    }

    scanner.close();
  }
}
