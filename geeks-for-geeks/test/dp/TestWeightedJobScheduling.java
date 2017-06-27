package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestWeightedJobScheduling {
    private static String inputFile = "input_files/dp/weighted_job_scheduling/test_case";
    private static WeightedJobScheduling weightedJobScheduling = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        weightedJobScheduling = new WeightedJobScheduling();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        weightedJobScheduling = null;
        input = null;
    }

    @Test
    public void testWeightedJobSchedulingTestCase1() {
        String[] values = input[0].split(" ");
        assertWeightedJobScheduling(values);
    }

    @Test
    public void testWeightedJobSchedulingTestCase2() {
        String[] values = input[1].split(" ");
        assertWeightedJobScheduling(values);
    }

    @Test
    public void testWeightedJobSchedulingTestCase3() {
        String[] values = input[2].split(" ");
        assertWeightedJobScheduling(values);
    }

    private void assertWeightedJobScheduling(String[] input) {
        String[] jobsStr = input[0].split(",");
        List<Job> jobs = new ArrayList<Job>();

        for (String jobS : jobsStr) {
            String[] values = jobS.split(":");
            Job job = new Job(Integer.parseInt(values[0]),
                    Integer.parseInt(values[1]), Integer.parseInt(values[2]));
            jobs.add(job);
        }

        assertEquals(Integer.parseInt(input[1]), weightedJobScheduling.maxProfit(jobs));
    }
}
