package datastructures.util;

import java.util.HashMap;
import java.util.Map;

import datastructures.common.Node;
import datastructures.lists.CustomLinkedList;

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

  public static <T> void printList(Node<T> head) {
    Node<T> current = head;

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
  
  public static <T> CustomLinkedList<T> constructList(Node<T> head) {
    CustomLinkedList<T> list = new CustomLinkedList<T>();
    
    return list;
  }
}
