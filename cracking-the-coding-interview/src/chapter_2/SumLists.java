package chapter_2;

import java.io.FileNotFoundException;
import java.util.Map;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;
import datastructures.util.ListUtil;
import util.InputUtil;

/**
 * Question 2.5: You have two numbers represented by a linked list, where each
 * node contains a single digit. The digits are stored in reverse order, such
 * that the 1's digit is at the head of the list. Write a function that adds the
 * two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * <p>
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is 617 + 295. Output: 2 -> 1 ->
 * 9.That is, 912.
 * <p>
 * FOLLOW UP
 * <p>
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
    private CustomLinkedList<Integer> computeSum(CustomLinkedList<Integer> list, CustomLinkedList<Integer> list2) {
        Map<String, CustomLinkedList<Integer>> nodeMap = ListUtil.getShorterAndLonger(list, list2);
        LinkedListNode<Integer> current = nodeMap.get("longer").head();
        LinkedListNode<Integer> current2 = nodeMap.get("shorter").head();

        CustomLinkedList<Integer> resultList = add(current, current2);
        return resultList;
    }

    private CustomLinkedList<Integer> computeSumRecurse(CustomLinkedList<Integer> list, CustomLinkedList<Integer> list2) {
        Map<String, CustomLinkedList<Integer>> nodeMap = ListUtil.getShorterAndLonger(list, list2);
        LinkedListNode<Integer> current = nodeMap.get("longer").head();
        LinkedListNode<Integer> current2 = nodeMap.get("shorter").head();

        LinkedListNode<Integer> resultHead = addRecursive(current, current2, 0);

        return new CustomLinkedList<Integer>(resultHead);
    }

    /**
     * Using an iterative approach to add two LinkedList elements
     * <p>
     * Complexity: O(n), Space: O(n)
     *
     * @param longerHead
     * @param shorterHead
     * @return resultList
     */
    private CustomLinkedList<Integer> add(LinkedListNode<Integer> longerHead, LinkedListNode<Integer> shorterHead) {
        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
        int temp = 0, sum = 0;
        while (shorterHead != null) {
            sum = shorterHead.data + longerHead.data + temp;
            list.add(sum % 10);
            temp = (sum / 10);

            shorterHead = shorterHead.next;
            longerHead = longerHead.next;
        }

        while (longerHead != null) {
            sum = longerHead.data + temp;
            list.add(sum % 10);
            temp = (sum / 10);
            longerHead = longerHead.next;
        }

        if (temp != 0) {
            list.add(temp);
        }

        return list;
    }

    /**
     * Recursive function which computes the sum of digits
     * <p>
     * Complexity: O(n), Space: O(n) [Recursive call, stack is used for memory]
     *
     * @param current
     * @param current2
     * @param carry
     * @param place
     * @return resultList head
     */
    private LinkedListNode<Integer> addRecursive(LinkedListNode<Integer> current, LinkedListNode<Integer> current2, int temp) {
        int sum = 0;

        if (current != null) {
            sum += current.data;
        }

        if (current2 != null) {
            sum += current2.data;
        }

        sum += temp;

        LinkedListNode<Integer> resultNode = new LinkedListNode<Integer>();
        resultNode.data = (sum % 10);
        temp = (sum / 10);
        resultNode.next = null;

        if (current.next == null) {
            if (temp != 0) {
                LinkedListNode<Integer> node = new LinkedListNode<Integer>();
                node.data = temp;
                node.next = null;
                resultNode.next = node;
            }
            return resultNode;
        }

        resultNode.next = addRecursive((current != null) ? current.next : null, (current2 != null) ? current2.next : null,
                temp);

        return resultNode;
    }

    public static void main(String[] args) throws FileNotFoundException {

        SumLists sumLists = new SumLists();
        String[] input = InputUtil.readContents(2, "sum_lists");
        String[] elements, elements2;
        CustomLinkedList<Integer> list, list2;
        StringBuilder builder;

        for (String line : input) {
            list = new CustomLinkedList<Integer>();
            list2 = new CustomLinkedList<Integer>();
            builder = new StringBuilder();

            elements = line.split("\\+")[0].split(":");
            elements2 = line.split("\\+")[1].split(":");

            if (elements != null) {
                for (String e : elements) {
                    list.add(Integer.parseInt(e));
                    builder.append(e).append("->");
                }
            }

            if (elements2 != null) {
                builder.append(" + ");

                for (String e : elements2) {
                    list2.add(Integer.parseInt(e));
                    builder.append(e).append("->");
                }
            }

            System.out.println(builder.toString());

            System.out.println("Using Iteration: ");
            CustomLinkedList<Integer> result = sumLists.computeSum(list, list2);
            result.print();

            System.out.println("Using Recursion: ");
            CustomLinkedList<Integer> resultRecurse = sumLists.computeSumRecurse(list, list2);
            resultRecurse.print();

            System.out.println();
        }
    }
}
