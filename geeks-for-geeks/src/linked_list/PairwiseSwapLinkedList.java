package linked_list;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;

public class PairwiseSwapLinkedList {
    private CustomLinkedList<Integer> linkedList = null;

    public void constructLinkedList(String input) {
        linkedList = new CustomLinkedList<Integer>();
        String[] elements = input.split(" ");

        for (String e : elements) {
            if (e != null && !e.trim().isEmpty()) {
                linkedList.add(Integer.parseInt(e.toString()));
            }
        }
    }

    public CustomLinkedList<Integer> pairwiseSwap() {
        LinkedListNode<Integer> current = linkedList.head();
        LinkedListNode<Integer> runner = current.next;
        LinkedListNode<Integer> prev = null;

        while (runner != null) {
            current.next = runner.next;
            if (prev != null) {
                prev.next = runner;
            }
            runner.next = current;
            if (current.equals(linkedList.head())) {
                linkedList.head(runner);
            }

            prev = current;
            current = current.next;
            runner = (current != null) ? current.next : null;
        }

        return linkedList;
    }
}
