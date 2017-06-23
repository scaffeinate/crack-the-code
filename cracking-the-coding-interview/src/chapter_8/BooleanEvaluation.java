package chapter_8;

import java.util.HashMap;
import java.util.Map;

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

    public int countWaysMemoized(String expression, boolean expected) {
        Map<BooleanExpression, Integer> results = new HashMap<>();
        return countWaysMemoized(expression, expected, results);
    }

    private int countWaysMemoized(String expression, boolean expected, Map<BooleanExpression, Integer> results) {
        BooleanExpression booleanExpression = new BooleanExpression(expression, expected);
        if (results.containsKey(booleanExpression)) {
            return results.get(booleanExpression);
        }

        int totalWaysToEvaluate = 0;

        if (expression.length() == 1) {
            boolean actual = expression.equals("1");
            totalWaysToEvaluate = (actual == expected) ? 1 : 0;
        } else {
            for (int i = 1; i < expression.length(); i += 2) {
                String leftExpression = expression.substring(0, i);
                String rightExpression = expression.substring(i + 1, expression.length());

                int leftTrue = countWaysMemoized(leftExpression, true, results);
                int leftFalse = countWaysMemoized(leftExpression, false, results);
                int rightTrue = countWaysMemoized(rightExpression, true, results);
                int rightFalse = countWaysMemoized(rightExpression, false, results);

                int totalWays = (leftTrue * rightFalse) + (leftTrue * rightTrue) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                int count = 0;
                switch (expression.charAt(i)) {
                    case '&':
                        count = (leftTrue * rightTrue);
                        break;
                    case '|':
                        count = (leftTrue * rightFalse) + (leftTrue * rightTrue) + (leftFalse * rightTrue);
                        break;
                    case '^':
                        count = (leftTrue * rightFalse) + (leftFalse * rightTrue);
                        break;
                }

                totalWaysToEvaluate += (expected) ? (count) : (totalWays - count);
            }
        }

        results.put(booleanExpression, totalWaysToEvaluate);
        return totalWaysToEvaluate;
    }

    private class BooleanExpression {
        private String expression;
        private boolean expected;

        public BooleanExpression(String expression, boolean expected) {
            this.expression = expression;
            this.expected = expected;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BooleanExpression that = (BooleanExpression) o;

            if (expected != that.expected) return false;
            return expression != null ? expression.equals(that.expression) : that.expression == null;
        }

        @Override
        public int hashCode() {
            int result = expression != null ? expression.hashCode() : 0;
            result = 31 * result + (expected ? 1 : 0);
            return result;
        }
    }
}
