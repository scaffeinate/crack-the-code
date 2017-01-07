package util;

import java.util.HashMap;
import java.util.Map;

import chapter_2.list.CustomLinkedList;

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
}
