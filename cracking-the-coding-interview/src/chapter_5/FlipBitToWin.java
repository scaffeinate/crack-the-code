package chapter_5;

public class FlipBitToWin {

  public int flipBitToWin(String binaryString) {
    int max = Integer.MIN_VALUE;
    int val = Integer.parseInt(binaryString, 2);
    int leftCounter = 0, rightCounter = 0, zeroVal = 0;
    while (val > 0) {
      if ((val & (1 << 0)) != 0) {
        leftCounter++;
      } else {
        rightCounter = leftCounter;
        leftCounter = 0;
        zeroVal = 1;
      }
      
      max = Math.max(max, (leftCounter + rightCounter + zeroVal));      
      val >>= 1;
    }

    return max;
  }

}
