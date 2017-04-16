package leetcode.week_of_code_28;

import java.util.Scanner;

public class StudentAttendanceRecord {

  public static boolean checkRecord(String s) {
    int aCount = 0;
    int i = 0;
    while(i < s.length()) {
      char c = s.charAt(i);
      if(c == 'A' || c == 'P') {
        aCount += (c == 'A') ? 1 : 0;
        if(aCount > 1) return false;
        i++;
      } else if(c == 'L') {
        int count = 0;
        while(i < s.length() && ((c = s.charAt(i)) == 'L')) {
          count++;
          if(count > 2) {
            return false;
          }
          i++;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    System.out.println(checkRecord(s));
    in.close();
  }
}
