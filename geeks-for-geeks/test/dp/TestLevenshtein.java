package dp;

import static org.hamcrest.Matchers.contains;

import java.util.List;

import dp.Levenshtein;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import datastructures.util.InputUtil;

public class TestLevenshtein {
    private static String inputFile = "input_files/dp/levenshtein/test_case";
    private static Levenshtein levenshtein = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        levenshtein = new Levenshtein();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        levenshtein = null;
        input = null;
    }

    @Test
    public void testLevenshteinTestCase1() {
        String[] values = input[0].split(" ");
        String[] actions = input[1].split(",");
        assertLevenshtein(values, actions);
    }

    @Test
    public void testLevenshteinTestCase2() {
        String[] values = input[2].split(" ");
        String[] actions = input[3].split(",");
        assertLevenshtein(values, actions);
    }

    @Test
    public void testLevenshteinTestCase3() {
        String[] values = input[4].split(" ");
        String[] actions = input[5].split(",");
        assertLevenshtein(values, actions);
    }

    @Test
    public void testLevenshteinTestCase4() {
        String[] values = input[6].split(" ");
        String[] actions = input[7].split(",");
        assertLevenshtein(values, actions);
    }

    @Test
    public void testLevenshteinTestCase5() {
        String[] values = input[8].split(" ");
        String[] actions = input[9].split(",");
        assertLevenshtein(values, actions);
    }

    @Test
    public void testLevenshteinTestCase6() {
        String[] values = input[10].split(" ");
        String[] actions = input[11].split(",");
        assertLevenshtein(values, actions);
    }

    private void assertLevenshtein(String[] values, String[] actions) {
        levenshtein.setStrings(values[0], values[1]);
        assertEquals(Integer.parseInt(values[2]), levenshtein.computeEditDistance());
        List<String> actionsList = levenshtein.getActions();
        assertThat(actionsList, contains(actions));
    }
}
