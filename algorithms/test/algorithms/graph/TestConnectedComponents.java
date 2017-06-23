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

public class TestConnectedComponents {
    private static final String basePath = "input_files/graph/connected_components/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private ConnectedComponents connectedComponents = null;

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
        connectedComponents = new ConnectedComponents();
    }

    @After
    public void tearDownTest() {
        connectedComponents = null;
    }

    @Test
    public void testConnectedComponentsTestCase1() {
        String[] input = inputList.get(0);
        connectedComponents.constructGraph(input);
        assertConnectedComponents(input);
    }

    @Test
    public void testConnectedComponentsTestCase2() {
        String[] input = inputList.get(1);
        connectedComponents.constructGraph(input);
        assertConnectedComponents(input);
    }

    @Test
    public void testConnectedComponentsTestCase3() {
        String[] input = inputList.get(2);
        connectedComponents.constructGraph(input);
        assertConnectedComponents(input);
    }

    private void assertConnectedComponents(String[] input) {
        for (String line : input) {
            String[] values = line.split(" ");
            if (values[0].equals("sameComponent")) {
                assertEquals(connectedComponents.sameComponent(values[1], values[2]), Boolean.parseBoolean(values[3]));
            }
        }
    }
}
