package chapter_8;

/**
 * Created by sudharti on 5/24/17.
 */
public class BooleanEvaluation {
  public int countWays(String expression, boolean expected) {
    if (expression.length() == 1) {
      boolean actual = expression.equals("1");
      return (actual == expected) ? 1 : 0;
    }

    int totalEvaluationCount = 0;

    for (int i = 1; i < expression.length(); i += 2) {
      String leftExpression = expression.substring(0, i);
      String rightExpression = expression.substring(i + 1, expression.length());

      int leftTrue = countWays(leftExpression, true);
      int rightTrue = countWays(rightExpression, true);
      int leftFalse = countWays(leftExpression, false);
      int rightFalse = countWays(rightExpression, false);

      int count = 0;

      switch (expression.charAt(i)) {
        case '&':
          count += (leftTrue * rightTrue);
          break;
        case '|':
          count += (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
          break;
        case '^':
          count += (leftTrue * rightFalse) + (leftFalse * rightTrue);
          break;
      }

      int totalWays = (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue) + (leftFalse * rightFalse);

      totalEvaluationCount += expected ? count : (totalWays - count);
    }

    return totalEvaluationCount;
  }
}
