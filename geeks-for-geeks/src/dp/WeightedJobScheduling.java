package dp;

import java.util.*;

/**
 * Question: http://www.geeksforgeeks.org/weighted-job-scheduling/
 * Follow-up: http://www.geeksforgeeks.org/weighted-job-scheduling-set-2-using-lis/
 * Solution: https://www.youtube.com/watch?v=cr6Ip0J9izc
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

    public List<Job> maxProfitJobs(List<Job> jobs) {
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.valueOf(o1.start).compareTo(o2.start);
            }
        });

        int[] memo = new int[jobs.size()];
        int[] sources = new int[jobs.size()];
        List<Job> results = new ArrayList<Job>();

        for (int i = 0; i < jobs.size(); i++) {
            memo[i] = jobs.get(i).profit;
            sources[i] = i;
        }

        for (int i = 1; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            for (int j = 0; j < i; j++) {
                if (jobs.get(j).end <= job.start) {
                    if (memo[i] < (memo[j] + job.profit)) {
                        memo[i] = (memo[j] + job.profit);
                        sources[i] = j;
                    }
                }
            }
        }

        int max = 0, k = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] > max) {
                max = memo[i];
                k = i;
            }
        }

        while (sources[k] != k) {
            results.add(jobs.get(k));
            k = sources[k];
        }

        results.add(jobs.get(k));
        return results;
    }
}
