package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Question: http://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/
 */
public class JobSequencing {
    public static int maxProfit(Integer[][] jobs) {
        int profit = 0;
        Arrays.sort(jobs, Comparator.comparing(o -> o[0]));
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        for (int i = 0; i < jobs.length; i++) {
            int k = jobs[i][0];
            if (queue.size() >= k && jobs[i][1] > queue.peek()[1]) {
                queue.poll();
                queue.offer(jobs[i]);
            } else if (queue.size() < k) {
                queue.offer(jobs[i]);
            }
        }

        while (!queue.isEmpty()) {
            profit += queue.poll()[1];
        }

        return profit;
    }
}
