package greedy;

import java.util.*;

/**
 * Question: http://www.geeksforgeeks.org/fractional-knapsack-problem/
 * Solution: http://www.geeksforgeeks.org/fractional-knapsack-problem/
 */
public class FractionalKnapsack {
    public static double maxValue(Integer[][] items, int W) {
        int currentCapacity = 0;
        double maxValue = 0;
        Arrays.sort(items, (o1, o2) -> Double.valueOf(((double) o2[1] / o2[0])).compareTo((double) o1[1] / o1[0]));

        for (int i = 0; i < items.length; i++) {
            int numPounds = items[i][0];
            if ((currentCapacity + numPounds) <= W) {
                currentCapacity += numPounds;
                maxValue += (items[i][1]);
            } else {
                maxValue += (((double) items[i][1]/items[i][0]) * (W - currentCapacity));
                break;
            }
        }

        return Math.round(maxValue * 100d) / 100d;
    }
}
