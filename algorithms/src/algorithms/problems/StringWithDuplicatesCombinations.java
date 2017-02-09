/**
 * 
 */
package algorithms.problems;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import algorithms.util.InputUtil;

/**
 * Problem: https://www.youtube.com/watch?v=xTNFs5KRV_g
 * 
 * @author Sudharsanan Muralidharan
 */
public class StringWithDuplicatesCombinations {

  private void generateCombinations(char[] arr) {
    Map<Character, Integer> counterMap = new TreeMap<Character, Integer>();
    for (char c : arr) {
      counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);
    }

    List<Entry<Character, Integer>> counterList = counterMap.entrySet().stream().collect(Collectors.toList());
    combination(counterList, 0, new StringBuilder());
  }

  private void combination(List<Entry<Character, Integer>> counterList, int index, StringBuilder builder) {
    int counterSum = 0;
    for (int i = index; i < counterList.size(); i++) {
      Entry<Character, Integer> entry = counterList.get(i);
      int count = entry.getValue();
      if (count > 0) {
        counterSum++;
        entry.setValue(count - 1);
        builder.append(entry.getKey());
        combination(counterList, index + 1, builder);
        builder.setLength(builder.length() - 1);
        entry.setValue(count);
      }
    }
    
    if(counterSum == 0) {
      System.out.println(builder.toString());
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("permutations");
    StringWithDuplicatesCombinations combinations = new StringWithDuplicatesCombinations();
    for (String line : input) {
      combinations.generateCombinations(line.toCharArray());
    }
  }
}
