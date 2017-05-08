package chapter_6;

import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class TestEightQueens {
  EightQueens eightQueens = new EightQueens();

  @Test
  public void testEightQueens() {
    Integer[][] chessBoard = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0 } };
    List<Integer[][]> results = eightQueens.arrangeQueens(chessBoard);
    assertThat(results, hasSize(92));
  }
}
