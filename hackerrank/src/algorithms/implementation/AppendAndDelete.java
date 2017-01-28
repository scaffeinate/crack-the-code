/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * 
 * Challenge: https://www.hackerrank.com/challenges/append-and-delete/
 * 
 * @author Sudharsanan Muralidharan
 */
public class AppendAndDelete {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String t = in.next();
    int k = in.nextInt();

    /*
     * If the k is greater than the combination of string lengths then obviously
     * we can make two passes in String s, One for deletion and another for
     * addition. Also since deleting an empty character results in empty again
     * this can be done any number of times making it even more flexible.
     */
    if (k >= (s.length() + t.length())) {
      System.out.println("Yes");
    } else {
      int deviates = -1;
      int i = 0;

      /*
       * Otherwise we find the point where the strings deviate
       */
      while (i < s.length() && i < t.length()) {
        if (s.charAt(i) != t.charAt(i)) {
          deviates = i;
          break;
        }
        i++;
      }

      /*
       * No deviation one is a substring of another. So we set deviates to the
       * length of shorter string
       */
      if (deviates == -1) {
        deviates = Math.min(s.length(), t.length());
      }

      // Calculate the number of deletions and additions to be done
      int numDeletions = (s.length() - deviates);
      int numAdditions = (t.length() - deviates);

      // Subtract number of characters to be deleted from s
      k = k - numDeletions;

      /*
       * If the numAdditions is greater than k(Which is TotalNumber of
       * operations - numDeletions) then we check if k and numAdditions are both
       * even or both odd.
       */
      if (k >= numAdditions && ((k % 2) == (numAdditions % 2))) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }

    in.close();
  }
}
