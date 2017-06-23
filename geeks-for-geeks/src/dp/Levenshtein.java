package dp;

import java.util.ArrayList;
import java.util.List;

public class Levenshtein {

    private String s1, s2;
    private int[][] matrix;

    public void setStrings(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.matrix = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = i;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = j;
        }
    }

    public int computeEditDistance() {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = minOf(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1, matrix[i - 1][j - 1] + 1);
                }
            }
        }
        return matrix[s1.length()][s2.length()];
    }

    public List<String> getActions() {
        List<String> actions = new ArrayList<String>();
        int i = matrix.length - 1, j = matrix[0].length - 1;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                i--;
                j--;
            } else {
                int current = matrix[i][j];
                if (current == (matrix[i - 1][j - 1] + 1)) {
                    actions.add(new String("modify " + s2.charAt(j - 1) + " to " + s1.charAt(i - 1)));
                    i--;
                    j--;
                } else if (current == (matrix[i][j - 1] + 1)) {
                    actions.add(new String("delete " + s2.charAt(j - 1)));
                    j--;
                } else if (current == (matrix[i - 1][j] + 1)) {
                    actions.add(new String("add " + s1.charAt(i - 1)));
                    i--;
                }
            }
        }

        return actions;
    }

    private int minOf(int... numbers) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            min = Math.min(numbers[i], min);
        }

        return min;
    }
}
