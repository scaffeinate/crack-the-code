package chapter_5;

public class NextNumber {

  public int getNext(int n) {
    int onesCount = countOnes(n);
    for (int i = n + 1; i <= Integer.MAX_VALUE; i++) {
      if (countOnes(i) == onesCount) {
        return i;
      }
    }
    return n;
  }

  public int getPrevious(int n) {
    int onesCount = countOnes(n);
    for (int i = n - 1; i >= 0; i--) {
      if (countOnes(i) == onesCount) {
        return i;
      }
    }
    return n;
  }

  private int countOnes(int n) {
    int numOnes = 0;
    for (int i = 0; i < 32; i++) {
      numOnes += ((n & (1 << i)) == 0) ? 0 : 1;
    }

    return numOnes;
  }
}
