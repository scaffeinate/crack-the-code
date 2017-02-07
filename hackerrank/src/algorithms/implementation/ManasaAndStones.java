/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

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

      int min = Math.min(a, b);
      int max = Math.max(a, b);

      if(a == b) {
        System.out.println(n * a);
        continue;
      }
      
      System.out.print((n * min) + " ");
      for (int i = 0; i < n; i++) {
        System.out.print(((max * (i + 1)) + (n - i - 1) * min) + " ");
      }

      System.out.println();

    }
    in.close();
  }
}
