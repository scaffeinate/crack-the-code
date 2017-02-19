/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/pangrams
 * 
 * @author Sudharsanan Muralidharan
 */
public class Pangrams {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine().toLowerCase();
    int val = 0;    
    
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c != ' ') {
        val |= (1 << (c - 'a'));
      }
    }
   
    System.out.println(val == 67108863 ? "pangram" : "not pangram");

    in.close();
  }
}
