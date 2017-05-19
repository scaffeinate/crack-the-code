package chapter_8;

import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TestEightQueens {
  EightQueens eightQueens = new EightQueens();

  @Test
  public void testEightQueens() {
    Integer[][] chessBoard = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0 } };
    List<Integer[][]> results = eightQueens.arrangeQueens(chessBoard);
    assertThat(results, hasSize(92));

    for (Integer[][] result : results) {
      assertResult(result);
    }
  }

  private void assertResult(Integer[][] chessBoard) {
    List<Integer[]> queens = new ArrayList<Integer[]>();
    for (int i = 0; i < chessBoard.length; i++) {
      for (int j = 0; j < chessBoard[0].length; j++) {
        if (chessBoard[i][j] == 1) {
          queens.add(new Integer[] { i, j });
        }
      }
    }

    for (Integer[] queen : queens) {
      assertTrue(isValidPosition(queen[0], queen[1], chessBoard));
    }
  }

  private boolean isValidPosition(int row, int column, Integer[][] chessBoard) {
    for (int i = 0; i < chessBoard.length; i++) {
      if (i != row && chessBoard[i][column] == 1) {
        return false;
      }
    }

    for (int i = 0; i < chessBoard.length; i++) {
      if (i != column && chessBoard[row][i] == 1) {
        return false;
      }
    }

    for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
      if (chessBoard[i][j] == 1) {
        return false;
      }
    }

    for (int i = row - 1, j = column + 1; i >= 0 && j < chessBoard.length; i--, j++) {
      if (chessBoard[i][j] == 1) {
        return false;
      }
    }

    for (int i = row + 1, j = column + 1; i < chessBoard.length && j < chessBoard.length; i++, j++) {
      if (chessBoard[i][j] == 1) {
        return false;
      }
    }

    for (int i = row + 1, j = column - 1; i < chessBoard.length && j >= 0; i++, j--) {
      if (chessBoard[i][j] == 1) {
        return false;
      }
    }

    return true;
  }
}
