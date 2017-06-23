package chapter_2.additional;

import java.io.FileNotFoundException;
import java.util.Stack;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;
import datastructures.util.ListUtil;
import util.InputUtil;

/**
 * Additional: Write a program to reverse a LinkedList. Sub solution for solving
 * the Palindrome LinkedList problem.
 *
 * @author Sudharsanan Muralidharan
 */
public class ReverseLinkedList {

    /**
     * Using a Stack to reverse a LinkedList.
     * <p>
     * Pop each node from stack and link it to the new head.
     * <p>
     * Complexity: O(n), Extra Space: O(n) for the Stack
     *
     * @param head
     * @return resultHead
     */
    private LinkedListNode<String> reverseUsingStack(LinkedListNode<String> head) {
        LinkedListNode<String> resultHead = null;
        Stack<LinkedListNode<String>> stack = new Stack<LinkedListNode<String>>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        LinkedListNode<String> current = null;
        while (!stack.isEmpty()) {
            if (resultHead == null) {
                resultHead = new LinkedListNode<String>();
                resultHead = stack.pop();
                current = resultHead;
            } else {
                current.next = stack.pop();
                current = current.next;
                current.next = null;
            }
        }

        return resultHead;
    }

    /**
     * Using a Recursive strategy to reverse the LinkedList. The logic is simple.
     * Traverse the linkedList from current to tail then Create nodeWrapper
     * object; nodeWrapper.head = linkedList.tail; Pass back nodeWrapper object.
     * When returned the stack call link wrapper tail to current node and move the
     * wrapper tail to current node.
     * <p>
     * Return the nodeWrapper.head which points to original LinkedList tail and is
     * now reverse linked.
     * <p>
     * Complexity: O(n), Extra Space: O(n) for Recursive call Stack.
     *
     * @param current
     * @return resultHead
     */
    private NodeWrapper<String> reverseRecursive(LinkedListNode<String> current) {
        NodeWrapper<String> resultWrapper = null;

        if (current.next == null) {
            resultWrapper = new NodeWrapper<String>();
            resultWrapper.head = current;
            resultWrapper.tail = current;
        } else {
            resultWrapper = reverseRecursive(current.next);
            resultWrapper.tail.next = current;
            resultWrapper.tail = current;
            current.next = null;
        }

        return resultWrapper;
    }

    /**
     * Reverse LinkedList inline using two pointers. Simple Logic.
     * <p>
     * Complexity: O(n), Space: O(1)
     *
     * @param head
     * @return resultHead
     */
    private LinkedListNode<String> reverseInline(LinkedListNode<String> head) {
        LinkedListNode<String> current = head;
        LinkedListNode<String> runner = current.next;
        LinkedListNode<String> temp;

        current.next = null;

        while (runner != null) {
            temp = runner.next;
            runner.next = current;
            current = runner;
            runner = temp;
        }

        return current;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        String[] input = InputUtil.readContents(2, "reverse_linked_list");
        CustomLinkedList<String> list = new CustomLinkedList<String>();
        CustomLinkedList<String> list2, list3;

        for (String line : input) {
            list = InputUtil.parseLinkedList(line);
            list2 = new CustomLinkedList<String>(list);
            list3 = new CustomLinkedList<String>(list);

            System.out.println("Original Linked List:");
            list.print();

            System.out.println("Reversed using Stack:");
            LinkedListNode<String> result = reverseLinkedList.reverseUsingStack(list.head());
            ListUtil.printList(result);

            System.out.println("Reversed Recursive:");
            LinkedListNode<String> resultRecurse = reverseLinkedList.reverseRecursive(list2.head()).head;
            ListUtil.printList(resultRecurse);

            System.out.println("Reversed Inline:");
            LinkedListNode<String> resultInline = reverseLinkedList.reverseInline(list3.head());
            ListUtil.printList(resultInline);

            System.out.println();
        }
    }

    /**
     * Node wrapper class to store the new head and tail
     *
     * @param <T>
     * @author Sudharsanan Muralidharan
     */
    class NodeWrapper<T> {
        LinkedListNode<T> head;
        LinkedListNode<T> tail;
    }
}
