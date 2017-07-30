package graph;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestDetectCycleUndirectedGraph {
    private static final String basePath = "input_files/graph/detect_cycle/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4",
            "test_case_5"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private DetectCycleUndirectedGraph detectCycleUndirectedGraph = null;

    @BeforeClass
    public static void setup() {
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        testCases = null;
        inputList = null;
    }

    @Before
    public void setupTest() {
        detectCycleUndirectedGraph = new DetectCycleUndirectedGraph();
    }

    @After
    public void tearDownTest() {
        detectCycleUndirectedGraph = null;
    }

    @Test
    public void testDetectCycleUndirectedGraphTestCase1() {
        String[] input = inputList.get(0);
        detectCycleUndirectedGraph.constructGraph(input);
        assertEquals(true, detectCycleUndirectedGraph.detectCycle());
    }

    @Test
    public void testDetectCycleUndirectedGraphTestCase2() {
        String[] input = inputList.get(1);
        detectCycleUndirectedGraph.constructGraph(input);
        assertEquals(false, detectCycleUndirectedGraph.detectCycle());
    }

    @Test
    public void testDetectCycleUndirectedGraphTestCase3() {
        String[] input = inputList.get(2);
        detectCycleUndirectedGraph.constructGraph(input);
        assertEquals(true, detectCycleUndirectedGraph.detectCycle());
    }

    @Test
    public void testDetectCycleUndirectedGraphTestCase4() {
        String[] input = inputList.get(3);
        detectCycleUndirectedGraph.constructGraph(input);
        assertEquals(true, detectCycleUndirectedGraph.detectCycle());
    }

    @Test
    public void testDetectCycleUndirectedGraphTestCase5() {
        String[] input = inputList.get(4);
        detectCycleUndirectedGraph.constructGraph(input);
        assertEquals(true, detectCycleUndirectedGraph.detectCycle());
    }
}
