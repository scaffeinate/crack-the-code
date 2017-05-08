package chapter_6;

import java.util.HashMap;
import java.util.Map;

public class RecursiveMultiply {

  public long multiply(int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    }

    int min = (m < n) ? m : n;
    int max = (m < n) ? n : m;

    return recursiveMultiply(min, max);
  }

  private long recursiveMultiply(int m, int n) {
    if (m == 1) {
      return n;
    } else {
      return (recursiveMultiply((m >> 1), n) << 1) + ((m % 2 != 0) ? n : 0);
    }
  }

  public long multiply2(int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    }

    int min = (m < n) ? m : n;
    int max = (m < n) ? n : m;

    return recursiveMultipleMemoized(min, max, new HashMap<Tuple, Long>());
  }

  private long recursiveMultipleMemoized(int m, int n, Map<Tuple, Long> results) {
    if (m == 1) {
      return n;
    } else {
      Tuple tuple = new Tuple(m, n);
      if (!results.containsKey(tuple)) {
        results.put(tuple, ((recursiveMultipleMemoized((m >> 1), n, results) << 1) + ((m % 2) != 0 ? n : 0)));
      }

      return results.get(tuple);
    }
  }

  class Tuple {
    int m, n;

    Tuple(int m, int n) {
      this.m = m;
      this.n = n;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + m;
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
      if (m != other.m)
        return false;
      if (n != other.n)
        return false;
      return true;
    }

    private RecursiveMultiply getOuterType() {
      return RecursiveMultiply.this;
    }
  }
}
