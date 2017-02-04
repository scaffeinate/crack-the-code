/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/happy-ladybugs
 * 
 * @author Sudharsanan Muralidharan
 */
public class HappyLadyBugs {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while (t-- > 0) {
      boolean happy = true;
      int[] values = new int[27];

      int n = in.nextInt();
      String b = in.next();

      for (int i = 0; i < n; i++) {
        if (b.charAt(i) == '_') {
          values[26]++;
        } else {
          values[b.charAt(i) - 'A']++;
        }
      }

      if (values[26] == 0) {
        for (int i = 0; i < n; i++) {
          boolean prev = false, next = false;
          if (i - 1 >= 0) {
            prev = b.charAt(i) == b.charAt(i - 1);
          }

          if (i + 1 < n) {
            next = b.charAt(i) == b.charAt(i + 1);
          }
          
          if(!prev && !next) {
            happy = false;
            break;
          }
        }
      } else {
        for (int i = 0; i < 26; i++) {
          if (values[i] == 1) {
            happy = false;
            break;
          }
        }
      }

      System.out.println(happy ? "YES" : "NO");
    }
    in.close();
  }
}
