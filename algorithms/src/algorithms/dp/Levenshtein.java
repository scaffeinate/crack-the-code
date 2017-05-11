package algorithms.dp;

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

  private int minOf(int... numbers) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < numbers.length; i++) {
      min = Math.min(numbers[i], min);
    }

    return min;
  }
}
