package chapter_6;

public class EightQueens {
  public void arrangeQueens(int[][] chessBoard) {
    arrange8Queens(0, 0, chessBoard);
  }

  private boolean arrange8Queens(int column, int n, int[][] chessBoard) {
    if (n == chessBoard.length) {
      return true;
    }

    for (int i = 0; i < chessBoard.length; i++) {
      if (canPlaceQueen(i, column, chessBoard)) {
        chessBoard[i][column] = 1;
        if (arrange8Queens(column + 1, n + 1, chessBoard)) {
          return true;
        } else {
          chessBoard[i][column] = 0;
        }
      }
    }

    return false;
  }

  private boolean canPlaceQueen(int row, int column, int[][] chessBoard) {
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

  private void printBoard(int[][] chessBoard) {
    for (int i = 0; i < chessBoard.length; i++) {
      for (int j = 0; j < chessBoard[0].length; j++) {
        System.out.print(chessBoard[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    EightQueens eightQueens = new EightQueens();
    int[][] chessBoard = new int[][] { new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0, 0, 0, 0 },
        new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0, 0, 0, 0 },
        new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0, 0, 0, 0 },
        new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0, 0, 0, 0 } };
    eightQueens.arrangeQueens(chessBoard);
    eightQueens.printBoard(chessBoard);
  }
}
