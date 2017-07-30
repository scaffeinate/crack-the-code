package graph;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestFloydWarshallShortestPath {
    private static final String basePath = "input_files/graph/all_pairs_shortest_path/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private FloydWarshallShortestPath floydWarshall = null;

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
        floydWarshall = new FloydWarshallShortestPath();
    }

    @After
    public void tearDownTest() {
        floydWarshall = null;
    }

    @Test
    public void testFloydWarshallShortestPathTestCase1() {
        String[] input = inputList.get(0);
        floydWarshall.constructGraph(input);
        floydWarshall.computeShortestPath();
        assertShortestPath(input);
    }

    @Test
    public void testFloydWarshallShortestPathTestCase2() {
        String[] input = inputList.get(1);
        floydWarshall.constructGraph(input);
        floydWarshall.computeShortestPath();
        assertShortestPath(input);
    }

    @Test
    public void testFloydWarshallShortestPathTestCase3() {
        String[] input = inputList.get(2);
        floydWarshall.constructGraph(input);
        floydWarshall.computeShortestPath();
        assertShortestPath(input);
    }

    private void assertShortestPath(String[] input) {
        for (String line : input) {
            String[] values = line.split(" ");
            switch (values[0]) {
                case "shortestPath":
                    String[] expected = values[3].split(",");
                    if (expected[0].equals("empty")) {
                        assertThat(floydWarshall.getShortestPathTo(values[1], values[2]), IsEmptyCollection.empty());
                    } else {
                        assertThat(floydWarshall.getShortestPathTo(values[1], values[2]), contains(expected));
                    }
                    break;
                case "shortestDistance":
                    Integer expectedDistance = null;
                    if (values[3].equals("infinity")) {
                        expectedDistance = Integer.MAX_VALUE;
                    } else if (values[3].equals("-infinity")) {
                        expectedDistance = Integer.MIN_VALUE;
                    } else {
                        expectedDistance = Integer.parseInt(values[3]);
                    }
                    assertThat(floydWarshall.getShortestDistanceTo(values[1], values[2]), is(expectedDistance));
                    break;
            }
        }
    }
}
