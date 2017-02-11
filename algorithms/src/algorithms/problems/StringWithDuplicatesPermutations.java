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

    permutate(counterMap, new char[arr.length], 0);
  }

  private void permutate(Map<Character, Integer> counterMap, char[] result, int index) {
    boolean allZeros = true;
    Set<Entry<Character, Integer>> entrySet = counterMap.entrySet();
    for (Entry<Character, Integer> entry : entrySet) {
      char c = entry.getKey();
      int count = entry.getValue();
      if (count > 0) {
        allZeros = false;
        counterMap.put(c, count - 1);
        result[index] = c;
        permutate(counterMap, result, index + 1);
        counterMap.put(c, count);
      }
    }

    if (allZeros) {
      print(result);
    }
  }

  private void print(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("permutations");
    StringWithDuplicatesPermutations permuations = new StringWithDuplicatesPermutations();
    for (String line : input) {
      permuations.generatePermutations(line.toCharArray());
    }
  }
}
