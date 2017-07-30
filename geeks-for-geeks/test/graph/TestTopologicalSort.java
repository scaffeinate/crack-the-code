package algorithms.graph;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestTopologicalSort {
    private static final String basePath = "input_files/graph/topological_sort/";
    private static String[] testCases = new String[]{"test_case_1"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private TopologicalSort topologicalSort = null;

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
        topologicalSort = new TopologicalSort();
    }

    @After
    public void tearDownTest() {
        topologicalSort = null;
    }

    @Test
    public void testTopologicalSortTestCase1() {
        String[] input = inputList.get(0);
        topologicalSort.constructGraph(input);
        List<String> actual = topologicalSort.topologicalSort();
        assertTopologicalSort(input, actual);
    }

    private void assertTopologicalSort(String[] input, List<String> topologicalSorted) {
        for (String line : input) {
            String[] values = line.split(" ");
            if (values[0].equals("check")) {
                String[] dependents = values[1].split("->");
                boolean check = checkIfExistsBefore(topologicalSorted, dependents[0], dependents[1]);
                assertEquals(Boolean.parseBoolean(values[2]), check);
            }
        }
    }

    private boolean checkIfExistsBefore(List<String> topologicalSorted, String vertex1, String vertex2) {
        int index1 = 0, index2 = 0, i = 0;
        for (String vertex : topologicalSorted) {
            if (vertex.equals(vertex1)) {
                index1 = i;
            } else if (vertex.equals(vertex2)) {
                index2 = i;
            }
            i++;
        }

        return (index2 > index1);
    }
}
