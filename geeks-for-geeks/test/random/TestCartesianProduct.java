package random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestCartesianProduct {
    private static final String basePath = "input_files/problems/cartesian_product/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private CartesianProduct cartesianProduct = null;

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
        cartesianProduct = new CartesianProduct();
    }

    @After
    public void tearDownTest() {
        cartesianProduct = null;
    }

    @Test
    public void testCartesianProductTestCase1() {
        String[] input = inputList.get(0);
        String[] expected = new String[]{
                "[green, cricket, monday, 0]", "[green, cricket, monday, 1]", "[green, cricket, tuesday, 0]", "[green, cricket, tuesday, 1]", "[green, cricket, wednesday, 0]", "[green, cricket, wednesday, 1]", "[green, hockey, monday, 0]", "[green, hockey, monday, 1]", "[green, hockey, tuesday, 0]", "[green, hockey, tuesday, 1]", "[green, hockey, wednesday, 0]", "[green, hockey, wednesday, 1]", "[green, soccer, monday, 0]", "[green, soccer, monday, 1]", "[green, soccer, tuesday, 0]", "[green, soccer, tuesday, 1]", "[green, soccer, wednesday, 0]", "[green, soccer, wednesday, 1]", "[green, tennis, monday, 0]", "[green, tennis, monday, 1]", "[green, tennis, tuesday, 0]", "[green, tennis, tuesday, 1]", "[green, tennis, wednesday, 0]", "[green, tennis, wednesday, 1]", "[red, cricket, monday, 0]", "[red, cricket, monday, 1]", "[red, cricket, tuesday, 0]", "[red, cricket, tuesday, 1]", "[red, cricket, wednesday, 0]", "[red, cricket, wednesday, 1]", "[red, hockey, monday, 0]", "[red, hockey, monday, 1]", "[red, hockey, tuesday, 0]", "[red, hockey, tuesday, 1]", "[red, hockey, wednesday, 0]", "[red, hockey, wednesday, 1]", "[red, soccer, monday, 0]", "[red, soccer, monday, 1]", "[red, soccer, tuesday, 0]", "[red, soccer, tuesday, 1]", "[red, soccer, wednesday, 0]", "[red, soccer, wednesday, 1]", "[red, tennis, monday, 0]", "[red, tennis, monday, 1]", "[red, tennis, tuesday, 0]", "[red, tennis, tuesday, 1]", "[red, tennis, wednesday, 0]", "[red, tennis, wednesday, 1]", "[yellow, cricket, monday, 0]", "[yellow, cricket, monday, 1]", "[yellow, cricket, tuesday, 0]", "[yellow, cricket, tuesday, 1]", "[yellow, cricket, wednesday, 0]", "[yellow, cricket, wednesday, 1]", "[yellow, hockey, monday, 0]", "[yellow, hockey, monday, 1]", "[yellow, hockey, tuesday, 0]", "[yellow, hockey, tuesday, 1]", "[yellow, hockey, wednesday, 0]", "[yellow, hockey, wednesday, 1]", "[yellow, soccer, monday, 0]", "[yellow, soccer, monday, 1]", "[yellow, soccer, tuesday, 0]", "[yellow, soccer, tuesday, 1]", "[yellow, soccer, wednesday, 0]", "[yellow, soccer, wednesday, 1]", "[yellow, tennis, monday, 0]", "[yellow, tennis, monday, 1]", "[yellow, tennis, tuesday, 0]", "[yellow, tennis, tuesday, 1]", "[yellow, tennis, wednesday, 0]", "[yellow, tennis, wednesday, 1]"
        };
        executeAndAssert(input, expected);
    }

    @Test
    public void testCartesianProductTestCase2() {
        String[] input = inputList.get(1);
        String[] expected = new String[]{
                "[a, i, x]", "[a, i, y]", "[a, j, x]", "[a, j, y]", "[b, i, x]", "[b, i, y]", "[b, j, x]", "[b, j, y]"
        };
        executeAndAssert(input, expected);
    }

    @Test
    public void testCartesianProductTestCase3() {
        String[] input = inputList.get(2);
        String[] expected = new String[]{"[a]"};
        executeAndAssert(input, expected);
    }

    @Test
    public void testCartesianProductTestCase4() {
        String[] input = inputList.get(3);
        String[] expected = new String[]{"[]"};
        executeAndAssert(input, expected);
    }

    private void executeAndAssert(String[] input, String[] expected) {
        List<Integer> sizes = new ArrayList<Integer>();
        for (String line : input) {
            String[] values = line.split(" ");
            sizes.add(values.length);
            cartesianProduct.addList(values);
        }

        List<List<String>> results = cartesianProduct.product();
        List<String> actual = new ArrayList<String>();
        for (List<String> list : results) {
            actual.add(list.toString());
        }

        assertThat(results, hasSize(sizes.stream().reduce(1, (a, b) -> a * b)));
        assertThat(actual, containsInAnyOrder(expected));
    }
}
