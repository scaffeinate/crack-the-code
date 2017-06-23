package chapter_5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestDrawLine {
    private static String basePath = "input_files/chapter_5/draw_line/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4",
            "test_case_5"};
    private static DrawLine drawLine;
    private static List<String[]> inputList = new ArrayList<String[]>();

    @BeforeClass
    public static void setup() {
        drawLine = new DrawLine();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        drawLine = null;
        inputList = null;
    }

    @Test
    public void testDrawLineTestCase1() {
        assertDrawLine(inputList.get(0));
    }

    @Test
    public void testDrawLineTestCase2() {
        assertDrawLine(inputList.get(1));
    }

    @Test
    public void testDrawLineTestCase3() {
        assertDrawLine(inputList.get(2));
    }

    @Test
    public void testDrawLineTestCase4() {
        assertDrawLine(inputList.get(3));
    }

    @Test
    public void testDrawLineTestCase5() {
        assertDrawLine(inputList.get(4));
    }

    private void assertDrawLine(String[] input) {
        String[] values = input[0].split(" ");
        int i = 2;
        int width = Integer.parseInt(values[0]);
        int x1 = Integer.parseInt(values[1]);
        int x2 = Integer.parseInt(values[2]);
        int y = Integer.parseInt(values[3]);

        byte[] screen = new byte[Integer.parseInt(input[1])];
        readByteArray(i, input, width, screen);

        byte[] output = new byte[screen.length];
        readByteArray(i + ((screen.length * 8) / width) + 1, input, width, output);

        assertThat(Arrays.asList(output), contains(drawLine.drawLine(screen, width, x1, x2, y)));
    }

    private void readByteArray(int i, String[] input, int width, byte[] screen) {
        int j = 0;
        String line = "";
        while (!(line = input[i]).equals("---")) {
            int start = 0, end = 8;
            while (end <= width && j < screen.length) {
                screen[j] = (byte) Integer.parseInt(line.substring(start, end), 2);
                start += 8;
                end += 8;
                j++;
            }
            i++;
        }
    }
}
