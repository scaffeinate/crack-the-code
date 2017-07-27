package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 7/18/17.
 */
public class TestTextJustification {
    private static String basePath = "input_files/dp/text_justification/";
    private static List<String[]> inputList = new ArrayList<>();
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4",
            "test_case_5", "test_case_6"};
    private static TextJustification textJustification = null;

    @BeforeClass
    public static void setup() {
        textJustification = new TextJustification();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        textJustification = null;
        inputList = null;
    }

    @Test
    public void testTextJustificationTestCase1() {
        assertTextJustification(inputList.get(0));
    }

    @Test
    public void testTextJustificationTestCase2() {
        assertTextJustification(inputList.get(1));
    }

    @Test
    public void testTextJustificationTestCase3() {
        assertTextJustification(inputList.get(2));
    }

    @Test
    public void testTextJustificationTestCase4() {
        assertTextJustification(inputList.get(3));
    }

    @Test
    public void testTextJustificationTestCase5() {
        assertTextJustification(inputList.get(4));
    }

    @Test
    public void testTextJustificationTestCase6() {
        assertTextJustification(inputList.get(5));
    }


    private void assertTextJustification(String[] input) {
        String[] inputArr = input[0].split(" ");
        String[] words = inputArr[0].split(",");
        int W = Integer.parseInt(inputArr[1]);
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < input.length; i++) {
            builder.append(input[i]).append("\n");
        }

        assertEquals(builder.toString(), textJustification.justify(words, W));
        assertEquals(builder.toString(), textJustification.justifyBottomUp(words, W));
    }
}
