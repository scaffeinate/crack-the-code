/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * @author Sudharsanan Muralidharan
 */
public class EqualizeArray {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] countArr = new int[101];

    for (int i = 0; i < n; i++) {
      int num = in.nextInt();
      countArr[num]++;
    }

    int max = countArr[0];
    for (int i = 1; i < countArr.length; i++) {
      if (countArr[i] > max) {
        max = countArr[i];
      }
    }

    System.out.println(n - max);

    in.close();
  }
}
