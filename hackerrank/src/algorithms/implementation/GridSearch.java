/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * @author Sudharsanan Muralidharan
 */
public class GridSearch {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int R = in.nextInt();
      int C = in.nextInt();
      String gridString, searchString;
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < R; i++) {
        builder.append(in.next());
      }
      gridString = builder.toString();

      builder = new StringBuilder();
      int r = in.nextInt();
      int c = in.nextInt();

      for (int i = 0; i < r; i++) {
        builder.append(in.next());
      }
      searchString = builder.toString();

      int startColumn = 0, startRow = 0;
      boolean matching = true;
      while (startRow <= R - r) {
        matching = true;
        while (startColumn <= (C - c)) {
          matching = true;
          for (int i = 0, I = startRow; i < r; i++, I++) {
            for (int j = 0, J = startColumn; (j < c); j++, J++) {
              if (gridString.charAt(I * C + J) != searchString.charAt(i * c + j)) {
                matching = false;
                break;
              }
            }

            if (!matching) {
              break;
            }
          }
          startColumn++;
          if (matching) {
            break;
          }
        }
        startRow++;
        startColumn = 0;
        if (matching) {
          break;
        }
      }

      System.out.println(matching ? "YES" : "NO");
    }
    in.close();
  }
}