package week_of_code_30;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RangeModularQueries {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = in.nextInt();
    int q = in.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    while (q-- > 0) {
      int count = 0;
      int left = in.nextInt();
      int right = in.nextInt();
      int x = in.nextInt();
      int y = in.nextInt();

      for (int i = left; i <= right; i++) {
        if(arr[i] % x == y) {
          count++;
        }
      }
      
      writer.write(String.valueOf(count));
      writer.newLine();
    }
    
    writer.flush();
    in.close();
  }
}
