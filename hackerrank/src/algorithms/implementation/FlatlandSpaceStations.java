/**
 * 
 */
package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/flatland-space-stations
 * 
 * @author Sudharsanan Muralidharan
 */
public class FlatlandSpaceStations {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int c[] = new int[m];
    for (int i = 0; i < m; i++) {
      c[i] = in.nextInt();
    }
    Arrays.sort(c);
    int largest = Integer.MIN_VALUE;

    for (int i = 0; i < c.length - 1; i++) {
      int range = (c[i + 1] - c[i]) / 2;
      if (range > largest) {
        largest = range;
      }
    }

    if ((c[0]) > largest) {
      largest = c[0];
    }

    if (n - 1 - c[c.length - 1] > largest) {
      largest = n - 1 - c[c.length - 1];
    }

    System.out.println(largest);

    in.close();
  }
}
