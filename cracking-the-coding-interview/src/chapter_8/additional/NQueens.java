package chapter_8.additional;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<Integer[][]> arrangeNQueens(int n) {
        List<Integer[][]> results = new ArrayList<Integer[][]>();
        Integer[][] chessBoard = new Integer[n][n];

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                chessBoard[i][j] = 0;
            }
        }

        arrangeNQueens(0, chessBoard, results);
        return results;
    }

    private void arrangeNQueens(int column, Integer[][] chessBoard, List<Integer[][]> results) {
        if (column == chessBoard.length) {
            results.add(deepCopy(chessBoard));
            return;
        }

        for (int i = 0; i < chessBoard.length; i++) {
            if (canPlaceQueen(i, column, chessBoard)) {
                chessBoard[i][column] = 1;
                arrangeNQueens(column + 1, chessBoard, results);
                chessBoard[i][column] = 0;
            }
        }
    }

    private boolean canPlaceQueen(int row, int column, Integer[][] chessBoard) {
        for (int i = 0; i < column; i++) {
            if (chessBoard[row][i] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = column; i < chessBoard.length && j >= 0; i++, j--) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private Integer[][] deepCopy(Integer[][] chessBoard) {
        Integer[][] clone = new Integer[chessBoard.length][chessBoard.length];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                clone[i][j] = chessBoard[i][j];
            }
        }

        return clone;
    }
}
