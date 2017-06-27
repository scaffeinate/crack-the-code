package dp;

import java.util.Collections;
import java.util.List;

/**
 * Created by sudharti on 6/27/17.
 */
public class WeightedJobScheduling {
    public int maxProfit(List<Job> jobs) {
        Collections.sort(jobs, (o1, o2) -> Integer.valueOf(o1.end).compareTo(o2.end));
        int[] memo = new int[jobs.size()];
        for (int i = 0; i < jobs.size(); i++) {
            memo[i] = jobs.get(i).profit;
        }

        int j = 1;
        while (j < jobs.size()) {
            int i = 0;
            while (i < j) {
                if (canSelect(jobs.get(i), jobs.get(j))) {
                    memo[j] = Math.max(memo[j], memo[i] + jobs.get(j).profit);
                }
                i++;
            }
            j++;
        }

        int max = 0;

        for (int i = 0; i < memo.length; i++) {
            max = Math.max(max, memo[i]);
        }

        return max;
    }

    private boolean canSelect(Job job1, Job job2) {
        return job2.start >= job1.end;
    }
}
