package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Question: http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/
 * Solution: http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/
 */
public class ActivitySelection {
    public static int maxActivities(Integer[][] activities) {
        int count = 1, current = 0;
        Arrays.sort(activities, Comparator.comparing(o -> o[1]));
        for (int i = 1; i < activities.length; i++) {
            if (activities[i][0] >= activities[current][1]) {
                count++;
                current = i;
            }
        }
        return count;
    }
}
