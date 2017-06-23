package datastructures.util;

import java.util.HashMap;
import java.util.Map;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;

public class ListUtil {

    public static <T> Map<String, CustomLinkedList<T>> getShorterAndLonger(CustomLinkedList<T> first,
                                                                           CustomLinkedList<T> second) {
        Map<String, CustomLinkedList<T>> resultMap = new HashMap<String, CustomLinkedList<T>>();

        CustomLinkedList<T> longer = (first.size() > second.size()) ? first : second;
        CustomLinkedList<T> shorter = (first.size() > second.size()) ? second : first;

        resultMap.put("longer", longer);
        resultMap.put("shorter", shorter);

        return resultMap;
    }

    public static <T> void printList(LinkedListNode<T> head) {
        LinkedListNode<T> current = head;

        if (current == null) {
            return;
        }

        StringBuilder builder = new StringBuilder();

        builder.append("|").append(current.data);
        current = current.next;

        while (current != null) {
            builder.append("->").append(current.data);
            current = current.next;
        }

        builder.append("|");

        System.out.println(builder.toString());
    }

    public static <T> CustomLinkedList<T> constructList(LinkedListNode<T> head) {
        CustomLinkedList<T> list = new CustomLinkedList<T>();

        return list;
    }
}
