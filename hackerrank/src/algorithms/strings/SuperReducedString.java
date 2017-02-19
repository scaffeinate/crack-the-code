/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/reduced-string/
 * 
 * @author Sudharsanan Muralidharan
 */
public class SuperReducedString {

  private static String reduceString(String s) {
    int count = 1;
    StringBuilder builder = new StringBuilder();
    int i = 0;
    for (i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) != s.charAt(i + 1)) {
        if (count % 2 != 0) {
          builder.append(s.charAt(i));
        }
        count = 1;
      } else {
        count++;
      }
    }

    if (i > 0 && count % 2 != 0) {
      builder.append(s.charAt(i));
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    int size = s.length();
    String reduced = reduceString(s);

    while (reduced.length() < size) {
      size = reduced.length();
      reduced = reduceString(reduced);
    }

    System.out.println(reduced.isEmpty() ? "Empty String" : reduced);

    in.close();
  }
}
