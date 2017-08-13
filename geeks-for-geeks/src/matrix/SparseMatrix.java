package matrix;

import java.util.LinkedList;

/**
 * Question: http://www.geeksforgeeks.org/sparse-matrix-representation/
 */
public class SparseMatrix {
    public static int[][] asArray(int[][] matrix) {
        int numNonZero = 0, k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) numNonZero++;
            }
        }

        int[][] sparseArray = new int[3][numNonZero];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    sparseArray[0][k] = i;
                    sparseArray[1][k] = j;
                    sparseArray[2][k] = matrix[i][j];
                    k++;
                }
            }
        }

        return sparseArray;
    }

    public static LinkedList<MatrixElement> asLinkedList(int[][] matrix) {
        LinkedList<MatrixElement> linkedList = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    linkedList.add(new MatrixElement(i, j, matrix[i][j]));
                }
            }
        }

        return linkedList;
    }


    static class MatrixElement {
        int i = 0, j = 0, value = 0;

        MatrixElement(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}
