package algorithms.dp;

public class LongestCommonSubstring {

  public int lcsTabulated(String s1, String s2) {
    int[][] table = new int[s1.length() + 1][s2.length() + 1];
    int longest = table[0][0];
    for (int i = 1; i < table.length; i++) {
      for (int j = 1; j < table[0].length; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          table[i][j] = table[i - 1][j - 1] + 1;
        }
      }
    }

    for (int i = 1; i < table.length; i++) {
      for (int j = 1; j < table[0].length; j++) {
        longest = Math.max(table[i][j], longest);
      }
    }

    return longest;
  }
}
