/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/fair-rations
 * 
 * @author Sudharsanan Muralidharan
 */
public class FairRations {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int b[] = new int[n];
    int oddCount = 0;
    int hops = 0;
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
      oddCount += (b[i] % 2 != 0) ? 1 : 0;
    }

    if (oddCount % 2 == 0) {
      int start = -1;
      for (int i = 0; i < n; i++) {
        if (b[i] % 2 != 0) {
          if (start == -1) {
            start = i;
          } else {            
            hops += (i - start) * 2;
            start = -1;
          }
        }
      }
      System.out.println(hops);
    } else {
      System.out.println("NO");
    }
    in.close();
  }
}
