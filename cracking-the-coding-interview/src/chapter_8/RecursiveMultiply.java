package chapter_8;

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
}
