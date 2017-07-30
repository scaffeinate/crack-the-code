package graph;

import datastructures.util.InputUtil;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestDetectCycleDirectedGraph {
    private static final String basePath = "input_files/graph/detect_cycle/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4",
            "test_case_5"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private DetectCycleDirectedGraph detectCycleDirectedGraph = null;

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
        detectCycleDirectedGraph = new DetectCycleDirectedGraph();
    }

    @After
    public void tearDownTest() {
        detectCycleDirectedGraph = null;
    }

    @Test
    public void testDetectCycleDirectedGraphTestCase1() {
        String[] input = inputList.get(0);
        detectCycleDirectedGraph.constructGraph(input);
        assertEquals(true, detectCycleDirectedGraph.detectCycle());
    }

    @Test
    public void testDetectCycleDirectedGraphTestCase2() {
        String[] input = inputList.get(1);
        detectCycleDirectedGraph.constructGraph(input);
        assertEquals(false, detectCycleDirectedGraph.detectCycle());
    }

    @Test
    public void testDetectCycleDirectedGraphTestCase3() {
        String[] input = inputList.get(2);
        detectCycleDirectedGraph.constructGraph(input);
        assertEquals(true, detectCycleDirectedGraph.detectCycle());
    }

    @Test
    public void testDetectCycleDirectedGraphTestCase4() {
        String[] input = inputList.get(3);
        detectCycleDirectedGraph.constructGraph(input);
        assertEquals(false, detectCycleDirectedGraph.detectCycle());
    }

    @Test
    public void testDetectCycleDirectedGraphTestCase5() {
        String[] input = inputList.get(4);
        detectCycleDirectedGraph.constructGraph(input);
        assertEquals(true, detectCycleDirectedGraph.detectCycle());
    }
}
