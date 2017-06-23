package chapter_2;

import java.io.FileNotFoundException;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;
import util.InputUtil;

/**
 * Question 2.7: Given two singly linked lists, determine if two lists
 * intersect. Return the intersecting node. Note that the intersection is
 * defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) as the jth node of the
 * second linked list, then they are intersecting.
 *
 * @author Sudharsanan Muralidharan
 */
public class Intersection {

    /**
     * Check if the two lists have an intersecting node. After the intersecting
     * node both the lists will be identical/merge. Determine the shorter and
     * longer lists and move the longer pointer d times where d = longer.size() -
     * shorter.size(). Check for intersection while moving since intersection can
     * happen between start and d.
     * <p>
     * Complexity: O(n), Space: O(1)
     *
     * @param firstList
     * @param secondList
     * @return isIntersecting
     */
    private LinkedListNode<Integer> isIntersecting(CustomLinkedList<Integer> firstList, CustomLinkedList<Integer> secondList) {
        LinkedListNode<Integer> current = firstList.head();
        LinkedListNode<Integer> current2 = secondList.head();
        int firstSize = 0, secondSize = 0;
        while (current != null) {
            firstSize++;
            current = current.next;
        }

        while (current2 != null) {
            secondSize++;
            current2 = current2.next;
        }

        current = (firstSize > secondSize) ? firstList.head() : secondList.head();
        current2 = (firstSize > secondSize) ? secondList.head() : firstList.head();

        for (int i = 0; i < Math.abs(firstSize - secondSize); i++) {
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

    /**
     * Pick a node from firstList and add it to secondList which will intersect
     * after this point.
     *
     * @param firstList
     * @param secondList
     */
    private void addIntersection(CustomLinkedList<Integer> firstList, CustomLinkedList<Integer> secondList) {
        LinkedListNode<Integer> node = firstList.getNode(4);
        int i = 0;
        LinkedListNode<Integer> current = secondList.head();
        while (current != null) {
            if (i == 2) {
                current.next = node;
            }
            i++;
            current = current.next;
        }
        System.out
                .println("Fetch 4th Node from firstList: " + firstList.get(4) + " and add it to 2nd position of secondList");
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

            LinkedListNode<Integer> intersectingNode = intersection.isIntersecting(firstList, secondList);
            System.out
                    .println("Does it intersect? " + ((intersectingNode != null) ? ("Yes " + intersectingNode.data) : "No"));

            System.out.println();
            i++;
        }
    }
}
