/**
 * 
 */
package algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Challenge: https://www.hackerrank.com/challenges/gem-stones
 * 
 * @author Sudharsanan Muralidharan
 */
public class Gemstones {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int counter = 0;
    int[] gemCounter = new int[26];

    for (int i = 0; i < n; i++) {
      char[] s = in.next().toCharArray();
      Set<Character> set = new HashSet<Character>();
      for (char c : s) {
        set.add(c);
      }

      for (Character c : set) {
        gemCounter[c - 'a']++;
      }
    }
    for (int i = 0; i < 26; i++) {
      if (gemCounter[i] >= n) {
        counter++;
      }
    }

    System.out.println(counter);
    in.close();
  }
}
