package chapter_5;

public class Insertion {
  public String insertMIntoN(int m, int n, int i, int j) {
    int result = clearBits(n, i, j);
    return Integer.toBinaryString(result | (m << i));
  }

  private int clearBits(int n, int i, int j) {
    int val = Integer.MAX_VALUE >>> (31 - j - 1);
    int val2 = Integer.MAX_VALUE << i;
    int mask = val & val2;
    return n & ~(mask);
  }
}
