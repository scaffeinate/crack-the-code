/**
 * 
 */
package algorithms.implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Challenge: https://www.hackerrank.com/challenges/absolute-permutation
 * 
 * @author Sudharsanan Muralidharan
 */
public class AbsolutePermutation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int k = in.nextInt();
      int[] p = new int[n + 1];
      Set<Integer> set = new HashSet<Integer>();
      boolean possible = true;

      for (int i = 1; i <= n; i++) {
        if (i - k > 0 && !set.contains(i - k)) {
          p[i] = i - k;
        } else if (i + k <= n && !set.contains(i + k)) {
          p[i] = i + k;
        } else {
          possible = false;
          break;
        }
        set.add(p[i]);
      }
      
      if(possible) {
        for(int i=1;i<=n;i++) {
          System.out.print(p[i] + " ");
        }
      } else {
        System.out.print(-1);
      }
      System.out.println();
    }
    in.close();
  }
}
