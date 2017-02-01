/**
 * 
 */
package algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/minimum-distances/
 * 
 * @author Sudharsanan Muralidharan
 */
public class MinimumDistances {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int minDistance = Integer.MAX_VALUE;
    Map<Integer, Integer> indexesMap = new HashMap<Integer, Integer>();

    for (int i = 0; i < n; i++) {
      int val = in.nextInt();
      if (indexesMap.containsKey(val)) {
        int distance = Math.abs(i - indexesMap.get(val));
        if (distance < minDistance) {
          minDistance = distance;
        }
        indexesMap.put(val, i);
      } else {
        indexesMap.put(val, i);
      }
    }
    
    System.out.println(minDistance == Integer.MAX_VALUE ? -1 : minDistance);
    in.close();
  }
}
