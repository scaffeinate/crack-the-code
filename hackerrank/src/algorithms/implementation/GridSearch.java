/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/the-grid-search
 * 
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
      boolean matching = false;
      while (startRow <= R - r && !matching) {
        while (startColumn <= (C - c) && !matching) {
          for (int i = 0, I = startRow; i < r; i++, I++) {
            for (int j = 0, J = startColumn; (j < c); j++, J++) {
              matching = gridString.charAt(I * C + J) == searchString.charAt(i * c + j);
              if(!matching) {
                break;
              }
            }
            
            if (!matching) {
              break;
            }
          }
          startColumn++;
        }
        startRow++;
        startColumn = 0;
      }

      System.out.println(matching ? "YES" : "NO");
    }
    in.close();
  }
}