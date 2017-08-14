package greedy;

import java.util.*;

/**
 * Question: http://www.geeksforgeeks.org/fractional-knapsack-problem/
 * Solution: http://www.geeksforgeeks.org/fractional-knapsack-problem/
 */
public class FractionalKnapsack {
    public static double maxValue(int[][] items, int W) {
        double currentCapacity = 0, maxValue = 0;
        Map<Integer, Double> pricePerPound = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            pricePerPound.put(i, ((double) items[i][1]) / items[i][0]);
        }

        Set<Map.Entry<Integer, Double>> entrySet = pricePerPound.entrySet();
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(entrySet);
        Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<Integer, Double> entry : entryList) {
            int index = entry.getKey();
            int numPounds = items[index][0];
            if ((currentCapacity + numPounds) <= W) {
                currentCapacity += numPounds;
                maxValue += (items[index][1]);
            } else {
                maxValue += (entry.getValue() * (W - currentCapacity));
                break;
            }
        }

        return Math.round(maxValue * 100d) / 100d;
    }
}
