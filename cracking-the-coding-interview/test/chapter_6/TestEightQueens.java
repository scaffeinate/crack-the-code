package chapter_6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestEightQueens {
  EightQueens eightQueens = new EightQueens();

  @Test
  public void testEightQueens() {
    int[][] chessBoard = new int[8][8];
    eightQueens.arrangeQueens(chessBoard);
    int[][] expected = { { 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
        { 0, 0, 1, 0, 0, 0, 0, 0 } };

    assertEquals(expected.length, chessBoard.length);
    assertEquals(expected[0].length, chessBoard[0].length);

    for (int i = 0; i < expected.length; i++) {
      int[] row = expected[i];
      assertArrayEquals(row, chessBoard[i]);
    }
  }
}
