package matrix;

import java.util.*;

/**
 * Part1: http://www.geeksforgeeks.org/sparse-matrix-representation/
 * Part2: http://www.geeksforgeeks.org/sparse-matrix-representations-using-list-lists-dictionary-keys/
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

    public static List<List<Integer[]>> asListOfLists(int[][] matrix) {
        List<List<Integer[]>> listOfLists = new ArrayList<List<Integer[]>>();
        for (int i = 0; i < matrix.length; i++) {
            List<Integer[]> list = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    list.add(new Integer[]{j, matrix[i][j]});
                }
            }
            listOfLists.add(list);
        }
        return listOfLists;
    }

    public static Map<Cell, Integer> asDictionaryOfKeys(int[][] matrix) {
        Map<Cell, Integer> dictionary = new LinkedHashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    dictionary.put(new Cell(i, j), matrix[i][j]);
                }
            }
        }

        return dictionary;
    }

    static class Cell {
        int i = 0, j = 0;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;
            return (i == cell.i) && (j == cell.j);
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
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
