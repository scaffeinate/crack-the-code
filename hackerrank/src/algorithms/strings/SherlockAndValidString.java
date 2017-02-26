/**
 * 
 */
package algorithms.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/sherlock-and-valid-string
 * 
 * @author Sudharsanan Muralidharan
 */
public class SherlockAndValidString {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    Map<Character, Integer> countMap = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      countMap.put(c, countMap.getOrDefault(c, 0) + 1);
    }

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (Entry<Character, Integer> entry : countMap.entrySet()) {
      int val = entry.getValue();
      map.put(val, map.getOrDefault(val, 0) + 1);
      if (val < min) {
        min = val;
      }

      if (val > max) {
        max = val;
      }
    }

    if ((max - min) == 0
        || ((max - min) == 1 && (map.get(min) > 1 && map.get(max) == 1) || map.get(max) > 1 && map.get(min) == 1)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }

    in.close();
  }
}
