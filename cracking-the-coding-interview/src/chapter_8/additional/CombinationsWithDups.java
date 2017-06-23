/**
 *
 */
package chapter_8.additional;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Problem: https://www.youtube.com/watch?v=xTNFs5KRV_g
 *
 * @author Sudharsanan Muralidharan
 */
public class CombinationsWithDups {

    private void generateCombinations(char[] arr) {
        Map<Character, Integer> counterMap = new TreeMap<Character, Integer>();
        for (char c : arr) {
            counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);
        }

        List<Entry<Character, Integer>> counterList = counterMap.entrySet().stream().collect(Collectors.toList());
        combination(counterList, 0, new char[arr.length], 0);
    }

    private void combination(List<Entry<Character, Integer>> counterList, int start, char[] result, int index) {
        print(result, index);
        for (int i = start; i < counterList.size(); i++) {
            Entry<Character, Integer> entry = counterList.get(i);
            int count = entry.getValue();
            if (count > 0) {
                entry.setValue(count - 1);
                result[index] = entry.getKey();
                combination(counterList, i + 1, result, index + 1);
                entry.setValue(count);
            }
        }
    }

    private void print(char[] arr, int index) {
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i]);
        }
        System.out.print(", ");
    }
}
