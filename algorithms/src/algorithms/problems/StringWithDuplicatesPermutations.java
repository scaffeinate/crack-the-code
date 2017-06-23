/**
 *
 */
package algorithms.problems;

import datastructures.util.InputUtil;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

/**
 * Problem: https://www.youtube.com/watch?v=nYFd7VHKyWQ
 * <p>
 * Complexity: O(n * n!)
 *
 * @author Sudharsanan Muralidharan
 */
public class StringWithDuplicatesPermutations {

    public List<String> generatePermutations(char[] arr) {
        Map<Character, Integer> counterMap = new TreeMap<Character, Integer>();
        List<String> resultList = new ArrayList<String>();
        for (char c : arr) {
            counterMap.put(Character.valueOf(c), counterMap.getOrDefault(c, 0) + 1);
        }

        permutate(counterMap, new char[arr.length], 0, resultList);
        return resultList;
    }

    private void permutate(Map<Character, Integer> counterMap, char[] result, int index, List<String> resultList) {
        boolean allZeros = true;
        Set<Entry<Character, Integer>> entrySet = counterMap.entrySet();
        for (Entry<Character, Integer> entry : entrySet) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (count > 0) {
                allZeros = false;
                counterMap.put(c, count - 1);
                result[index] = c;
                permutate(counterMap, result, index + 1, resultList);
                counterMap.put(c, count);
            }
        }

        if (allZeros) {
            resultList.add(stringify(result));
        }
    }

    private String stringify(char[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
        }

        return builder.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] input = InputUtil.readContents("input_files/test_permutations_duplicates");
        StringWithDuplicatesPermutations permuations = new StringWithDuplicatesPermutations();
        for (String line : input) {
            System.out.println(permuations.generatePermutations(line.toCharArray()));
        }
    }
}
