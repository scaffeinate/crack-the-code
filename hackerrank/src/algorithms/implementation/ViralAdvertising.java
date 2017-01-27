/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/strange-advertising
 * 
 * @author Sudharsanan Muralidharan
 */
public class ViralAdvertising {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int initial = 5;
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      initial = (int) (Math.floor(initial / 2));
      sum += (initial);
      initial *= 3;
    }

    System.out.println(sum);
    in.close();
  }
}
