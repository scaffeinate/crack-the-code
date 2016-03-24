package chapter_2;

import java.io.FileNotFoundException;
import java.util.Map;

import chapter_2.list.CustomLinkedList;
import chapter_2.list.Node;
import util.InputUtil;
import util.ListUtil;

/**
 * Question 2.7: Given two singly linked lists, determine if two lists
 * intersect. Return the intersecting node. Note that the intersection is
 * defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) as the jth node of the
 * second linked list, then they are intersecting.
 * 
 * @author Sudharsanan Muralidharan
 *
 */
public class Intersection {

  private Node<Integer> isIntersecting(CustomLinkedList<Integer> firstList, CustomLinkedList<Integer> secondList) {
    Map<String, CustomLinkedList<Integer>> nodeMap = ListUtil.getShorterAndLonger(firstList, secondList);
    CustomLinkedList<Integer> longer = nodeMap.get("longer");
    CustomLinkedList<Integer> shorter = nodeMap.get("shorter");

    Node<Integer> current = longer.head();
    Node<Integer> current2 = shorter.head();
   
    for (int i = 0; i < longer.size() - shorter.size(); i++) {
      if (current.equals(current2)) {
        return current;
      }
      current = current.next;
    }

    while (current != null) {
      if (current.equals(current2)) {
        return current;
      }

      current = current.next;
      current2 = current2.next;
    }

    return null;
  }

  private void addIntersection(CustomLinkedList<Integer> firstList, CustomLinkedList<Integer> secondList) {
    secondList.addNode(3, firstList.getNode(4));
    System.out
        .println("Fetch 4th Node from firstList: " + firstList.get(3) + " and add it to 3rd position of secondList");
    firstList.print();
    secondList.print();
  }

  public static void main(String[] args) throws FileNotFoundException {
    Intersection intersection = new Intersection();
    String[] input = InputUtil.readContents(2, "intersection");
    CustomLinkedList<Integer> firstList, secondList;
    int i = 0;

    for (String line : input) {
      String[] lists = line.split(" ");
      firstList = new CustomLinkedList<Integer>();
      secondList = new CustomLinkedList<Integer>();

      String[] elements = lists[0].split(":");

      for (String element : elements) {
        firstList.add(Integer.parseInt(element));
      }

      elements = lists[1].split(":");
      for (String element : elements) {
        secondList.add(Integer.parseInt(element));
      }

      System.out.println("Input: " + line);

      if (i % 2 == 0) {
        intersection.addIntersection(firstList, secondList);
      }

      Node<Integer> intersectingNode = intersection.isIntersecting(firstList, secondList);
      System.out
          .println("Does it intersect? " + ((intersectingNode != null) ? ("Yes " + intersectingNode.data) : "No"));

      System.out.println();
      i++;
    }
  }
}
