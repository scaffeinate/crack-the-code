/**
 * 
 */
package algorithms.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater
 * 
 * @author Sudharsanan Muralidharan
 */
public class BiggerisGreater {

  static class Greater {
    String word;
    int count;
  }

  private static String findGreater(String w) {
    Map<Character, Integer> counterMap = new TreeMap<Character, Integer>();
    int index = 0;
    for (int i = 0; i < w.length(); i++) {
      char c = w.charAt(i);
      counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);
    }

    List<Entry<Character, Integer>> charList = new ArrayList<Entry<Character, Integer>>();
    Set<Entry<Character, Integer>> entrySet = counterMap.entrySet();
    Map<Character, Integer> indexesMap = new HashMap<Character, Integer>();
    for (Entry<Character, Integer> entry : entrySet) {
      indexesMap.put(entry.getKey(), index);
      charList.add(entry);
      index++;
    }

    Greater greater = findGreater(charList, indexesMap, w, 0, new StringBuilder(), new Greater());
    return greater.word;
  }

  private static Greater findGreater(List<Entry<Character, Integer>> charList, Map<Character, Integer> indexesMap,
      String w, int position, StringBuilder builder, Greater greater) {

    if (builder.toString().length() == w.length()) {
      greater.count++;
      if (greater.count == 2) {
        greater.word = builder.toString();
      }

      return greater;
    }

    int start = 0;
    if (greater.count == 0) {
      char c = w.charAt(position);
      start = indexesMap.get(c);
    }
    for (int i = start; i < charList.size(); i++) {
      Entry<Character, Integer> entry = charList.get(i);
      int charCount = entry.getValue();
      if (charCount > 0) {
        builder.append(entry.getKey());
        entry.setValue(charCount - 1);
        greater = findGreater(charList, indexesMap, w, position + 1, builder, greater);
        if(greater.word != null) {
          break;
        }
        entry.setValue(charCount);
        builder.setLength(builder.length() - 1);
      }
    }

    return greater;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      String w = in.next();
      String result = findGreater(w);
      System.out.println((result == null) ? "no answer" : result);
    }
    in.close();
  }
}
