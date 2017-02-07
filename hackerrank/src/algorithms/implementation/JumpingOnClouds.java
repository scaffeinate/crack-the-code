/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * @author Sudharsanan Muralidharan
 */
public class JumpingOnClouds {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int c[] = new int[n];
    for (int i = 0; i < n; i++) {
      c[i] = in.nextInt();
    }

    int i = 0, count = 0;
    while (i < n - 1) {
      i += 2;
      if (i > n - 1 || c[i] == 1) {
        i--;
      }

      count += (c[i] == 0) ? 1 : 0;
    }

    System.out.println(count);
    in.close();
  }
}
