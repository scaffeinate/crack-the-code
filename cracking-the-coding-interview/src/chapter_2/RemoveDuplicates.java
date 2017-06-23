package chapter_2;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Question 2.1: Write code to remove duplicates from an unsorted linked list.
 * <p>
 * FOLLOW UP
 * <p>
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * @author Sudharsanan Muralidharan
 */
public class RemoveDuplicates {

    /**
     * Remove duplicates from the list using a set
     * <p>
     * Complexity: O(n), Space: O(n)
     *
     * @param list
     */
    public void removeSet(CustomLinkedList<Integer> list) {
        LinkedListNode<Integer> current = list.head();
        LinkedListNode<Integer> runner = current.next;
        Set<Integer> set = new HashSet<Integer>();
        set.add(current.data);

        while (runner != null) {
            if (set.contains(runner.data)) {
                current.next = runner.next;
                runner = runner.next;
            } else {
                set.add(runner.data);
                current = current.next;
                runner = runner.next;
            }
        }
    }

    /**
     * Use two pointers to check and remove duplicates from the list.
     * <p>
     * Complexity: O(n2), Space: O(1)
     *
     * @param list
     */
    public void remove(CustomLinkedList<Integer> list) {
        LinkedListNode<Integer> current = list.head();
        while (current != null) {
            LinkedListNode<Integer> current2 = current;
            LinkedListNode<Integer> runner2 = current2.next;

            while (runner2 != null) {
                if (runner2.data.equals(current.data)) {
                    current2.next = runner2.next;
                } else {
                    current2 = current2.next;
                }
                runner2 = runner2.next;
            }

            current = current.next;
        }
    }
}
