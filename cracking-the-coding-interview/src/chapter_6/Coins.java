package chapter_6;

import java.util.HashMap;
import java.util.Map;

public class Coins {
  public long numWays(int n) {
    return numWaysMemoized(n, new int[] { 25, 10, 5, 1 }, new HashMap<Integer, Long>());
  }

  private long numWaysMemoized(int n, int[] coins, Map<Integer, Long> resultsMap) {
    if (n == 0) {
      return 1;
    } else if (n < 0) {
      return 0;
    } else if (!resultsMap.containsKey(n)) {
      long sum = 0;
      for (int coin : coins) {
        sum += numWaysMemoized(n - coin, coins, resultsMap);
      }
      resultsMap.put(n, sum);
    }

    return resultsMap.get(n);
  }
}
