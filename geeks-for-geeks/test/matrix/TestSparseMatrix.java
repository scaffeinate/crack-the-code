package matrix;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 8/12/17.
 */
public class TestSparseMatrix {
    private static String inputFile = "input_files/matrix/sparse_matrix/test_case";
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        input = null;
    }

    @Test
    public void testCircularMatrixTestCase1() {
        assertSparseMatrix(input);
    }

    private void assertSparseMatrix(String[] values) {
        List<SparseMatrix.MatrixElement> expected = new ArrayList<>();
        int[][] matrix = new int[values.length][];
        for (int i = 0; i < values.length; i++) {
            String[] columns = values[i].split(" ");
            int[] columnsArr = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                int val = Integer.parseInt(columns[j]);
                columnsArr[j] = val;
                if (val != 0) {
                    expected.add(new SparseMatrix.MatrixElement(i, j, val));
                }
            }
            matrix[i] = columnsArr;
        }

        int[][] asArray = SparseMatrix.asArray(matrix);
        for (int i = 0, k = 0; i < asArray[0].length; i++) {
            assertEquals(expected.get(k).i, asArray[0][i]);
            assertEquals(expected.get(k).j, asArray[1][i]);
            assertEquals(expected.get(k).value, asArray[2][i]);
            k++;
        }

        LinkedList<SparseMatrix.MatrixElement> asLinkedList = SparseMatrix.asLinkedList(matrix);
        for (int i = 0; i < asLinkedList.size(); i++) {
            assertEquals(expected.get(i).i, asLinkedList.get(i).i);
            assertEquals(expected.get(i).j, asLinkedList.get(i).j);
            assertEquals(expected.get(i).value, asLinkedList.get(i).value);
        }
    }
}
