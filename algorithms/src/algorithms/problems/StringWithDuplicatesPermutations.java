/**
 * 
 */
package algorithms.problems;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import algorithms.util.InputUtil;

/**
 * Problem: https://www.youtube.com/watch?v=nYFd7VHKyWQ
 * 
 * Complexity: O(n)
 * 
 * @author Sudharsanan Muralidharan
 */
public class StringWithDuplicatesPermutations {

  public void generatePermutations(char[] arr) {
    Map<Character, Integer> counterMap = new TreeMap<Character, Integer>();
    for (char c : arr) {
      counterMap.put(Character.valueOf(c), counterMap.getOrDefault(c, 0) + 1);
    }

    permutate(counterMap, new StringBuilder());
  }

  private void permutate(Map<Character, Integer> counterMap, StringBuilder builder) {
    int counterSum = 0;
    Set<Entry<Character, Integer>> entrySet = counterMap.entrySet();
    for (Entry<Character, Integer> entry : entrySet) {
      char c = entry.getKey();
      int count = entry.getValue();
      if (count > 0) {
        counterSum++;
        counterMap.put(c, count - 1);
        builder.append(c);
        permutate(counterMap, builder);
        builder.setLength(builder.length() - 1);
        counterMap.put(c, count);
      }
    }

    if (counterSum == 0) {
      System.out.println(builder.toString());
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("permutations");
    StringWithDuplicatesPermutations permuations = new StringWithDuplicatesPermutations();
    for (String line : input) {
      permuations.generatePermutations(line.toCharArray());
    }
  }
}
