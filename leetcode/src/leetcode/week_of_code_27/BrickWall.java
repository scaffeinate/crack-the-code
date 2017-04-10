package leetcode.week_of_code_27;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BrickWall {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    /*int[][] input = new int[][] { new int[] { 1, 2, 2, 1 }, new int[] { 3, 1, 2 }, new int[] { 1, 3, 2 },
        new int[] { 2, 4 }, new int[] { 3, 1, 2 }, new int[] { 1, 3, 1, 1 } };*/
    int[][] input = new int[][] { new int[] {1}, new int[] {1}, new int[] {1}};

    List<List<Integer>> wall = new ArrayList<List<Integer>>();
    for (int i = 0; i < input.length; i++) {
      List<Integer> temp = new ArrayList<Integer>();
      for (int j = 0; j < input[i].length; j++) {
        temp.add(input[i][j]);
      }
      wall.add(temp);
    }

    System.out.println(leastBricks(wall));

    in.close();
  }

  public static int leastBricks(List<List<Integer>> wall) {
    int leastCount = Integer.MAX_VALUE;

    Map<Double, Integer> counterArr = new HashMap<Double, Integer>();

    for (List<Integer> row : wall) {
      int i = 0, border = 0;
      for (Integer brick : row) {
        i += brick;
        for (double j = (border + 0.5); j < i; j += 0.5) {
          counterArr.put(j, counterArr.getOrDefault(j, 0) + 1);
        }
        border = i;
      }
    }

    for (Double key:counterArr.keySet()) {
      leastCount = Math.min(leastCount, counterArr.get(key));
    }

    return leastCount;
  }
}
