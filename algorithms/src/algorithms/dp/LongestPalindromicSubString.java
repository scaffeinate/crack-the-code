package algorithms.dp;

import java.util.Scanner;

/**
 * Question: http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * 
 * @author Sudharsanan Muralidharan
 */
public class LongestPalindromicSubString {

  public int getLongest(String s) {
    return getLongest(s, 0, s.length() - 1).maxVal;
  }

  private Wrapper getLongest(String s, int i, int j) {
    if (i > j) {
      return new Wrapper(0);
    } else if (i == j) {
      return new Wrapper(1);
    }

    if (s.charAt(i) == s.charAt(j)) {
      Wrapper wrapper = getLongest(s, i + 1, j - 1);
      if (wrapper.matches) {
        wrapper.maxVal += 2;
      }

      return wrapper;
    } else {
      Wrapper wrapper = getLongest(s, i, j - 1);
      Wrapper wrapper2 = getLongest(s, i + 1, j);
      Wrapper result = (wrapper.maxVal > wrapper2.maxVal) ? wrapper : wrapper2;
      result.matches = false;
      return result;
    }
  }

  class Wrapper {
    int maxVal;
    boolean matches = true;

    Wrapper(int maxVal) {
      this.maxVal = maxVal;
    }

    Wrapper(int maxVal, boolean matches) {
      this.maxVal = maxVal;
      this.matches = matches;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    LongestPalindromicSubString longest = new LongestPalindromicSubString();
    String s = in.nextLine();
    System.out.println(longest.getLongest(s));
    in.close();
  }
}
