package dp;

/**
 * Question: http://www.geeksforgeeks.org/longest-common-substring/
 *
 * @author Sudharsanan Muralidharan
 */
public class LongestCommonSubstring {

    public String lcsTabulated(String s1, String s2) {
        int[][] table = new int[s1.length() + 1][s2.length() + 1];
        int longest = table[0][0];
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                }
            }
        }

        int[] longestTuple = new int[2];

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (table[i][j] > longest) {
                    longest = table[i][j];
                    longestTuple[0] = i;
                    longestTuple[1] = j;
                }
            }
        }

        return lcsString(s1, table, longestTuple[0], longestTuple[1]);
    }

    private String lcsString(String s1, int[][] table, int i, int j) {
        StringBuilder builder = new StringBuilder();
        while (table[i][j] != 0) {
            builder.append(s1.charAt(i - 1));
            i--;
            j--;
        }

        return builder.reverse().toString();
    }
}
