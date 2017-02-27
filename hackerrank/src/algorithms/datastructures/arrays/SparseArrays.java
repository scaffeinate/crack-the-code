/**
 * 
 */
package algorithms.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * Challenge: https://www.hackerrank.com/challenges/sparse-arrays
 * 
 * Ref: https://en.wikipedia.org/wiki/Sparse_array
 * 
 * @author Sudharsanan Muralidharan
 */
public class SparseArrays {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Map<String, Integer> countMap = new HashMap<String, Integer>();
    while (n-- > 0) {
      String input = in.next();
      int count = 0;
      if (countMap.containsKey(input)) {
        count = countMap.get(input);
      }

      countMap.put(input, count + 1);
    }

    int q = in.nextInt();
    while (q-- > 0) {
      Integer count = countMap.get(in.next());
      System.out.println(count == null ? 0 : count);
    }
    in.close();
  }
}
