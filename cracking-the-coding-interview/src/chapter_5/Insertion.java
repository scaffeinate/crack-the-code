package chapter_5;

public class Insertion {
  public String insertMIntoN(int m, int n, int i, int j) {
    int nCleared = clearBits(n, i, j);
    return Integer.toBinaryString(nCleared | (m << i));
  }

  private int clearBits(int n, int i, int j) {
    int leftCleared = -1 >>> (31 - j); // 00111111
    int rightCleared = -1 << i; // 11111100
    int mask = ~(leftCleared & rightCleared); // mask 00111100, ~(mask) 11000011
    return n & mask;
  }
}
