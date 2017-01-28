/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * @author Sudharsanan Muralidharan
 */
public class FindDigits {

  private static int countDigits(int n) {
    int count = 0;
    int num = n;
    while (n > 0) {
      int digit = n % 10;
      if (digit != 0 && num % digit == 0) {
        count++;
      }
      n = n / 10;
    }

    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      System.out.println(countDigits(n));
    }
    in.close();
  }
}
