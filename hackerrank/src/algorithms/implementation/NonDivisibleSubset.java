/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/non-divisible-subset
 * 
 * @author Sudharsanan Muralidharan
 */
public class NonDivisibleSubset {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] modArr = new int[k];

    while (n-- > 0) {
      int input = in.nextInt();
      modArr[input % k]++;
    }

    int count = 0;
    count += (modArr[0] != 0) ? 1 : 0;
    modArr[0] = -1;

    for (int i = 1; i < modArr.length; i++) {
      if (modArr[i] != -1) {
        int diff = k - i;
        int index = (modArr[i] >= modArr[diff]) ? i : diff;
        int other = (modArr[i] >= modArr[diff]) ? diff : i;

        if (index == other) {
          count += 1;
          modArr[index] = -1;
        } else {
          modArr[other] = -1;
          count += modArr[index];
          modArr[index] = 0;
        }
      }
    }

    System.out.println(count);
    in.close();
  }
}
