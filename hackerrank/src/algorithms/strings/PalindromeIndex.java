/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/palindrome-index
 * 
 * @author Sudharsanan Muralidharan
 */
public class PalindromeIndex {
  private static boolean matches(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      String s = in.next();
      int index = -1;
      for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
        if (s.charAt(i) != s.charAt(j)) {
          if (matches(s, i + 1, j)) {
            index = i;
          } else if (matches(s, i, j - 1)) {
            index = j;
          }
          break;
        }
      }
      System.out.println(index);
    }
    in.close();
  }
}
