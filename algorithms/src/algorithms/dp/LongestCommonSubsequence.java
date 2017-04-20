package algorithms.dp;

/**
 * Question:
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * 
 * @author Sudharsanan Muralidharan
 */
public class LongestCommonSubsequence {

  public int lcs(String s1, String s2) {
    return lcs(s1, s2, s1.length() - 1, s2.length() - 1);
  }

  private int lcs(String s1, String s2, int i, int j) {
    if (i == -1 || j == -1) {
      return 0;
    } else if (s1.charAt(i) == s2.charAt(j)) {
      return lcs(s1, s2, i, j) + 1;
    } else {
      return Math.max(lcs(s1, s2, i, j - 1), lcs(s1, s2, i - 1, j));
    }
  }

  public int lcsTabulated(String s1, String s2) {
    int[][] table = new int[s1.length() + 1][s2.length() + 1];

    for (int i = 1; i < table.length; i++) {
      for (int j = 1; j < table[0].length; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          table[i][j] = table[i - 1][j - 1] + 1;
        } else {
          table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
        }
      }
    }

    return table[s1.length()][s2.length()];
  }

  public int lcsMemoized(String s1, String s2) {
    int[][] results = new int[s1.length() + 1][s2.length()];
    for (int i = 0; i < results.length; i++) {
      for (int j = 0; j < results[0].length; j++) {
        results[i][j] = -1;
      }
    }
    return lcsMemoized(s1, s2, s1.length() - 1, s2.length() - 1, results);
  }

  private int lcsMemoized(String s1, String s2, int i, int j, int[][] results) {
    if (i == -1 || j == -1) {
      return 0;
    }

    if (results[i][j] == -1) {
      if (s1.charAt(i) == s2.charAt(j)) {
        results[i][j] = lcsMemoized(s1, s2, i - 1, j - 1, results) + 1;
      } else {
        results[i][j] = Math.max(lcsMemoized(s1, s2, i, j - 1, results), lcsMemoized(s1, s2, i - 1, j, results));
      }
    }
    return results[i][j];
  }
}
