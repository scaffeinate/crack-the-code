package leetcode.week_of_code_28;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAttendanceRecord2 {

  public static int checkRecord(int n) {
    return count(n, new StringBuilder(), new HashMap<String, Integer>(), 0, 0);
  }

  private static int count(int n, StringBuilder builder, Map<String, Integer> map, int numA, int numConsecutiveLs) {
    if (builder.length() == n) {
      //System.out.println(builder.toString());
      return 1;
    } else if (builder.length() < n) {
      int count = 0;
      if (numA < 1) {
        builder.append('A');
        numA++;
        if (!map.containsKey(builder.toString())) {
          int result = count(n, builder, map, numA, numConsecutiveLs);
          map.put(builder.toString(), result);
          count += result;
        } else {
          count += map.get(builder.toString());
        }
        builder.setLength(builder.length() - 1);
        numA--;
      } else {
        return 0;
      }

      if (numConsecutiveLs < 2) {
        builder.append('L');
        numConsecutiveLs++;
        if (!map.containsKey(builder.toString())) {
          int result = count(n, builder, map, numA, numConsecutiveLs);
          map.put(builder.toString(), result);
          count += result;
        } else {
          count += map.get(builder.toString());
        }
        builder.setLength(builder.length() - 1);
        numConsecutiveLs--;
      } else {
        return 0;
      }

      builder.append('P');
      if (!map.containsKey(builder.toString())) {
        int result = count(n, builder, map, numA, numConsecutiveLs);
        map.put(builder.toString(), result);
        count += result;
      } else {
        count += map.get(builder.toString());
      }

      builder.setLength(builder.length() - 1);
      return count;
    }

    return 0;

  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(checkRecord(n));
    in.close();
  }
}
