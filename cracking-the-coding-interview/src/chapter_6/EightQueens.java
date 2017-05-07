package chapter_6;

public class EightQueens {
  public void arrangeQueens(int[][] chessBoard) {
    System.out.println(canPlaceQueen(6, 7, chessBoard));
  }

  private boolean arrange8Queens(int row, int column, int n, int[][] chessBoard) {
    return false;
  }

  private boolean canPlaceQueen(int row, int column, int[][] chessBoard) {
    for (int i = 0; i < chessBoard[0].length; i++) {
      if (chessBoard[row][i] == 1) {
        return false;
      }
    }

    for (int i = 0; i < chessBoard.length; i++) {
      if (chessBoard[i][column] == 1) {
        return false;
      }
    }

    for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
      if (chessBoard[i][j] == 1) {
        return false;
      }
    }

    for (int i = row, j = column; i < chessBoard.length && j < chessBoard[0].length; i++, j++) {
      if (chessBoard[i][j] == 1) {
        return false;
      }
    }

    return true;
  }
  
  public static void main(String[] args) {
    EightQueens eightQueens = new EightQueens();
    int[][] chessBoard = new int[][] { new int[] { 1, 0, 0, 0, 0, 0, 0, 0 }, new int[] { 0, 1, 0, 0, 0, 0, 0, 0 },
      new int[] { 0, 0, 1, 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 1, 0, 0, 0, 0 },
      new int[] { 0, 0, 0, 0, 1, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0, 1, 0, 0 },
      new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0, 0, 0, 0 } };
    eightQueens.arrangeQueens(chessBoard);
  }
}
