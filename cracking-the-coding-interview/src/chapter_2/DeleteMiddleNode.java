package chapter_2;

import java.io.FileNotFoundException;

import datastructures.common.Node;
import datastructures.lists.CustomLinkedList;
import util.InputUtil;

/**
 * Question 2.3: Implement an algorithm to delete a node in the middle(i.e. any
 * node between first and last node, not necessarily the exact middle) of a
 * singly linked list given access to that node.
 * 
 * EXAMPLE
 * 
 * Input: the node c from the linked list a->b->c->d->e->f Output: nothing is
 * returned, but the new linked list looks like a->b->d->e=>f
 * 
 * @author Sudharsanan Muralidharan
 */
public class DeleteMiddleNode {

  /**
   * Deletes the middle node n by traversing from head till node.
   * 
   * Complexity: O(n)
   * 
   * @param list
   * @param node
   */
  @SuppressWarnings("unused")
  private void deleteMiddle(CustomLinkedList<Integer> list, Node<Integer> node) {
    Node<Integer> current = list.head();

    if (node.equals(current)) {
      list.head(current.next);
    }

    while (current.next != null) {
      if (current.next.equals(node)) {
        current.next = current.next.next;
        return;
      }

      current = current.next;
    }
  }

  /**
   * Deletes the middle node n by copying the next node value to current and
   * change the next reference to next.next
   * 
   * Complexity: O(1)
   * 
   * @param list
   * @param node
   */
  private void deleteMiddle2(CustomLinkedList<Integer> list, Node<Integer> node) {
    if (node.next != null) {
      node.data = node.next.data;
      node.next = node.next.next;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {

    DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();
    String[] input = InputUtil.readContents(2, "delete_middle");
    String[] elements;
    CustomLinkedList<Integer> list;
    int m = 0;

    for (String line : input) {
      String[] lineArr = line.split(" ");

      if (lineArr != null && lineArr.length == 2) {
        m = Integer.parseInt(lineArr[0]);
        elements = lineArr[1].split(":");
        list = new CustomLinkedList<Integer>();
        for (String e : elements) {
          if (e != null && !e.trim().isEmpty()) {
            list.add(Integer.parseInt(e));
          }
        }

        System.out.println("Original Linked List:");
        list.print();

        Node<Integer> node = list.getNode(m);
        if (node != null) {
          // deleteMiddleNode.deleteMiddle(list, node);
          deleteMiddleNode.deleteMiddle2(list, node);
          System.out.println("After Deleting the the node: " + m);
        }
        list.print();

        System.out.println();
      }
    }
  }
}
