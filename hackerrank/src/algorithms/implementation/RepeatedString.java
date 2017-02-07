/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * @author Sudharsanan Muralidharan
 */
public class RepeatedString {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    long n = in.nextLong();
    int count = 0;
    int countRemaining = 0;
    long repetitions = n / s.length();
    long remaining = n % s.length();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a') {
        if (i < remaining) {
          countRemaining++;
        }
        count++;
      }
    }

    System.out.println((repetitions * count) + countRemaining);
    in.close();
  }
}
