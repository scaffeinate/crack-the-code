package algorithms.problems;

public class ExcelCell {

  public int getColumn(String s) {
    int sum = 0;

    for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
      char c = s.charAt(i);
      int val = c - 'A' + 1;
      sum += (val * Math.pow(26, j));
    }

    return sum;
  }

  public String getCell(int n) {
    return getCell(n, (n % 26) == 0);
  }

  private String getCell(int n, boolean modZero) {
    StringBuilder builder = new StringBuilder();
    if (n < 26) {
      return String.valueOf((Character.valueOf((char) (n + 'A' - (modZero ? 2 : 1)))));
    } else {
      if (n / 26 == 1) {
        return "Z";
      } else {
        builder.append(getCell((n / 26), (n % 26) == 0))
            .append((n % 26) == 0 ? 'Z' : Character.valueOf((char) ((n % 26) + 'A' - 1)));
      }
    }

    return builder.toString();
  }
}
