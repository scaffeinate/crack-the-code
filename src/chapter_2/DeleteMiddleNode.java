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
 * Input: the node c from the linked list a->b->c->d->e->f
 * Output: nothing is returned, but the new linked list looks like a->b->d->e=>f
 * 
 * @author Sudharsanan Muralidharan
 */
public class DeleteMiddleNode {

  private void deleteMiddle(CustomLinkedList<Integer> list) {
    Node<Integer> slow = list.head();
    Node<Integer> fast = slow.next.next;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    slow.next = slow.next.next;
  }

  public static void main(String[] args) throws FileNotFoundException {
    FileReader fileReader = new FileReader("input_files/chapter_2/delete_middle");
    Scanner scanner = new Scanner(fileReader);
    DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();
    String input;
    String[] elements;
    CustomLinkedList<Integer> list;

    while (scanner.hasNextLine()) {
      input = scanner.nextLine();
      elements = input.split(":");
      list = new CustomLinkedList<Integer>();
      for (String e : elements) {
        list.add(Integer.parseInt(e));
      }

      System.out.println("Original Linked List:");
      list.print();

      deleteMiddleNode.deleteMiddle(list);
      System.out.println("After Deleting the Middle node: ");
      list.print();

      System.out.println();
    }

    scanner.close();
  }
}
