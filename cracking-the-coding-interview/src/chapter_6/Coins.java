package chapter_6;

import java.util.HashMap;
import java.util.Map;

public class Coins {
  public long numWays(int n) {
    Map<Tuple, Long> map = new HashMap<Tuple, Long>();
    long numWays = numWaysMemoized(n, 0, new int[] { 25, 10, 5, 1 }, map);
    return numWays;
  }

  private long numWaysMemoized(int n, int index, int[] coins, Map<Tuple, Long> resultsMap) {
    if (n == 0) {
      return 1;
    }

    if (index >= coins.length) {
      return 0;
    } else {
      Tuple tuple = new Tuple(coins[index], n);
      if (!resultsMap.containsKey(tuple)) {
        long sum = 0;
        int numWays = (n / coins[index]);
        for (int i = 0; i <= numWays; i++) {
          sum += numWaysMemoized(n - (i * coins[index]), index + 1, coins, resultsMap);
        }
        resultsMap.put(tuple, sum);
      }

      return resultsMap.get(tuple);
    }
  }

  class Tuple {
    int coin;
    int n;

    Tuple(int coin, int n) {
      this.coin = coin;
      this.n = n;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + coin;
      result = prime * result + n;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Tuple other = (Tuple) obj;
      if (!getOuterType().equals(other.getOuterType()))
        return false;
      if (coin != other.coin)
        return false;
      if (n != other.n)
        return false;
      return true;
    }

    private Coins getOuterType() {
      return Coins.this;
    }
  }
}
