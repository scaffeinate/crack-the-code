package chapter_5;

public class PairwiseSwap {
  
  public int swap(int n) {
    return ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
  }
}
