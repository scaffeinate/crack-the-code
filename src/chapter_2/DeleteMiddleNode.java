package chapter_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Question 2.3: Implement an algorithm to delete a node in the middle(i.e. any
 * node between first and last node, not necessarily the exact middle) of a
 * singly linked list.
 * 
 * EXAMPLE
 * 
 * Input: the node c from the linked list a->b->c->d->e->f Output: nothing is
 * returned, but the new linked list looks like a->b->d->e=>f
 * 
 * @author Sudharsanan Muralidharan
 */
public class DeleteMiddleNode {

  private void deleteMiddle(CustomLinkedList<Integer> list, int m) {
    Node<Integer> slow = list.head();
    Node<Integer> fast = slow.next;

    if (m < 0) {
      return;
    }
    
    for (int i = 0; i < list.size() - m; i++) {
      if (fast.next != null) {
        fast = fast.next;
      }
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    if (slow.next != null) {
      slow.next = slow.next.next;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    FileReader fileReader = new FileReader("input_files/chapter_2/delete_middle");
    Scanner scanner = new Scanner(fileReader);
    DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();
    String input;
    String[] elements;
    CustomLinkedList<Integer> list;
    int m = 0;

    while (scanner.hasNextLine()) {
      input = scanner.nextLine();
      m = Integer.parseInt(input.split(" ")[0]);
      elements = input.split(" ")[1].split(":");
      list = new CustomLinkedList<Integer>();
      for (String e : elements) {
        list.add(Integer.parseInt(e));
      }

      System.out.println("Original Linked List:");
      list.print();

      deleteMiddleNode.deleteMiddle(list, m);
      System.out.println("After Deleting the the node: " + m);
      list.print();

      System.out.println();
    }

    scanner.close();
  }
}
