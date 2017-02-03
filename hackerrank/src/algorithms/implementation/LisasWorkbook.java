/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/lisa-workbook
 * 
 * @author Sudharsanan Muralidharan
 */
public class LisasWorkbook {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] t = new int[n];

    for (int i = 0; i < n; i++) {
      t[i] = in.nextInt();
    }

    int page = 0;
    int special = 0;
    for (int i = 0; i < t.length; i++) {
      int num = t[i];
      int start = 0, end = 0;
      while (num > 0) {
        start = end + 1;
        page++;
        if (num > k) {
          num = num - k;
          end += k;
        } else {
          end += num;
          num = 0;
        }
        
        if (page >= start && page <= end) {
          special++;
        }
      }
    }

    System.out.println(special);
    in.close();
  }
}
