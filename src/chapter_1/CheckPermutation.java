package chapter_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question 1.2: Given two strings, write a method to determine whether one is a
 * permutation of the other.
 * 
 * @author Sudharsanan Muralidharan
 */
public class CheckPermutation {

  /**
   * Check if first string is a permutation of the second: Sort the strings and
   * compare each character: Complexity: O(nlogn)
   * 
   * @param first
   * @param second
   * @return isPermuatation
   */
  private boolean isPermutationSorted(String first, String second) {

    if (first.length() != second.length()) {
      return false;
    } else {
      char[] firstChars = first.toCharArray();
      char[] secondChars = second.toCharArray();

      Arrays.sort(firstChars);
      Arrays.sort(secondChars);

      for (int i = 0; i < firstChars.length; i++) {
        if (firstChars[i] != secondChars[i]) {
          return false;
        }
      }
    }

    return true;
  }

  /**
   * Check if first string is a permutation of the second: Use an Array[128] to
   * maintain a counter for each character, decrement while checking the second
   * String. If any value < 0 -> return false: Complexity: O(n), Space: O(1)
   * 
   * @param first
   * @param second
   * @return isPermutation
   */
  private boolean isPermutationArray(String first, String second) {
    int[] counter = new int[128];

    if (first.length() != second.length()) {
      return false;
    } else {
      int len = first.length();
      for (int i = 0; i < len; i++) {
        counter[first.charAt(i)]++;
      }

      for (int i = 0; i < len; i++) {
        counter[second.charAt(i)]--;
      }

      for (int i = 0; i < counter.length; i++) {
        if (counter[i] < 0) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CheckPermutation checkPermutation = new CheckPermutation();

    String first = scanner.nextLine();
    String second = scanner.nextLine();

    System.out.println(checkPermutation.isPermutationSorted(first, second));
    System.out.println(checkPermutation.isPermutationArray(first, second));
    scanner.close();
  }
}
