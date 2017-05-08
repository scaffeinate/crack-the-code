package chapter_6;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {
  public List<Integer[][]> arrangeQueens(Integer[][] chessBoard) {
    List<Integer[][]> results = new ArrayList<Integer[][]>();
    arrange8Queens(0, 0, chessBoard, results);
    return results;
  }

  private void arrange8Queens(int column, int n, Integer[][] chessBoard, List<Integer[][]> results) {
    if (n == chessBoard.length) {
      results.add(chessBoard);
      return;
    }

    for (int i = 0; i < chessBoard.length; i++) {
      if (canPlaceQueen(i, column, chessBoard)) {
        chessBoard[i][column] = 1;
        arrange8Queens(column + 1, n + 1, chessBoard, results);
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
}