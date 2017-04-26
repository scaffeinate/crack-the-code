package chapter_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class PermutationsWithDups {

  public List<String> permutations(String word) {
    List<String> results = new ArrayList<String>();
    Map<Character, Integer> counterMap = new TreeMap<Character, Integer>();
    for (char c : word.toCharArray()) {
      counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);
    }
    permutate(counterMap, new StringBuilder(), results);
    return results;
  }

  private void permutate(Map<Character, Integer> map, StringBuilder builder, List<String> results) {
    Set<Entry<Character, Integer>> entrySet = map.entrySet();
    boolean nonZeroExists = false;
    for (Entry<Character, Integer> entry : entrySet) {
      char c = entry.getKey();
      int counter = entry.getValue();
      if (entry.getValue() > 0) {
        map.put(c, counter - 1);
        builder.append(c);
        permutate(map, builder, results);
        builder.setLength(builder.length() - 1);
        map.put(c, counter);
        nonZeroExists = true;
      }
    }

    if (!nonZeroExists) {
      results.add(builder.toString());
    }
  }
}
