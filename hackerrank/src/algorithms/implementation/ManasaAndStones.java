/**
 * 
 */
package algorithms.implementation;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Challenge: https://www.hackerrank.com/challenges/manasa-and-stones
 * 
 * @author Sudharsanan Muralidharan
 */
public class ManasaAndStones {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while (t-- > 0) {
      int n = in.nextInt() - 1;
      int a = in.nextInt();
      int b = in.nextInt();
      Set<Integer> valuesSet = new LinkedHashSet<Integer>();

      int min = Math.min(a, b);
      int max = Math.max(a, b);

      valuesSet.add(n * min);
      for (int i = 0; i < n; i++) {
        valuesSet.add((max * (i + 1)) + (n - i - 1) * min);
      }

      for (Integer val : valuesSet) {
        System.out.print(val + " ");
      }
      System.out.println();

    }
    in.close();
  }
}
