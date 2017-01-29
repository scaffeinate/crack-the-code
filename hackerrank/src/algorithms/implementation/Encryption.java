/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/encryption
 * 
 * @author Sudharsanan Muralidharan
 */
public class Encryption {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    double l = Math.sqrt(s.length());
    int rows = (int) Math.floor(l);
    int columns = (int) Math.ceil(l);
    
    if(rows * columns < s.length()) {
      rows++;
    }
    
    StringBuilder builder = new StringBuilder();
    
    for(int i = 0; i < columns; i++) {
      for(int j = 0; j < rows; j++) {
        int index = (j * columns) + i;
        if(index > s.length() - 1) {
          rows--;
        } else {
          builder.append(s.charAt(index));
        }
      }
      builder.append(" ");
    }
    
    System.out.println(builder.toString());
    in.close();
  }
}
