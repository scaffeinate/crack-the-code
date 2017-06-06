package dp;

public class FibonacciNumber {

  public long fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    } else {
      return fib(n - 1) + fib(n - 2);
    }
  }

  public long fibMemoized(int n) {
    return fibMemoized(n, new long[n + 1]);
  }

  private long fibMemoized(int n, long[] results) {
    if (n == 0 || n == 1) {
      results[n] = n;
    } else if (results[n] == 0) {
      results[n] = fibMemoized(n - 1, results) + fibMemoized(n - 2, results);
    }

    return results[n];
  }

  public long fibTabulated(int n) {
    
    if(n == 0 || n == 1) {
      return n;
    }
    
    long[] results = new long[n + 1];
    results[0] = 0;
    results[1] = 1;
    for (int i = 2; i <= n; i++) {
      results[i] = results[i - 1] + results[i - 2];
    }

    return results[n];
  }
}
