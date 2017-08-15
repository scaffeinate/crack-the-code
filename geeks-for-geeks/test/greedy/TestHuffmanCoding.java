package greedy;

import datastructures.util.InputUtil;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sudharti on 8/14/17.
 */
public class TestHuffmanCoding {
    private static String inputFile = "input_files/greedy/huffman_coding/test_case";
    private static String[] input = null;
    private HuffmanCoding huffmanCoding = null;

    @BeforeClass
    public static void setup() {
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        input = null;
    }

    @Before
    public void setupTest() {
        huffmanCoding = new HuffmanCoding();
    }

    @After
    public void teardownTest() {
        huffmanCoding = null;
    }

    @Test
    public void testHuffmanCodingTestCase1() {
        assertHuffmanCoding(input[0]);
    }

    @Test
    public void testHuffmanCodingTestCase2() {
        assertHuffmanCoding(input[1]);
    }

    @Test
    public void testHuffmanCodingTestCase3() {
        assertHuffmanCoding(input[2]);
    }

    @Test
    public void testHuffmanCodingTestCase4() {
        assertHuffmanCoding(input[3]);
    }

    @Test
    public void testHuffmanCodingTestCase5() {
        assertHuffmanCoding(input[4]);
    }

    private void assertHuffmanCoding(String input) {
        assertEquals(input, huffmanCoding.decode(huffmanCoding.encode(input)));
    }
}
