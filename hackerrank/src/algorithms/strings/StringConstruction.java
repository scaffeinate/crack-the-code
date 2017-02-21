/**
 * 
 */
package algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Challenge: https://www.hackerrank.com/challenges/string-construction
 * @author Sudharsanan Muralidharan
 */
public class StringConstruction {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    while (n-- > 0) {
      Set<Character> set = new HashSet<Character>();
      String s = in.next();
      for (int i = 0; i < s.length(); i++) {
        set.add(s.charAt(i));
      }
      System.out.println(set.size());
    }
    in.close();
  }
}
