package chapter_8;

public class TripleStep {
    public int countWays(int numSteps) {
        return countWays(numSteps, new int[numSteps + 1]);
    }

    private int countWays(int numSteps, int[] results) {
        if (numSteps < 0) {
            return 0;
        } else if (numSteps == 0) {
            return 1;
        } else if (results[numSteps] == 0) {
            results[numSteps] = countWays(numSteps - 1, results) + countWays(numSteps - 2, results)
                    + countWays(numSteps - 3, results);
        }

        return results[numSteps];
    }
}
