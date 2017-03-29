package chapter_5;

public class FlipBitToWin {

  public int flipBitToWin(String binaryString) {
    int max = Integer.MIN_VALUE;
    int val = Integer.parseInt(binaryString, 2);
    int leftCounter = 0, rightCounter = 0, zeroVal = 0;
    boolean firstZero = true;
    while (val > 0) {
      if ((val & (1 << 0)) != 0) {
        leftCounter++;
      } else {
        max = firstZero ? max : Math.max(max, (leftCounter + rightCounter + 1));
        firstZero = false;
        rightCounter = leftCounter;
        leftCounter = 0;
        zeroVal = 1;
      }

      val >>= 1;
    }

    return Math.max(max, (leftCounter + rightCounter + zeroVal));
  }

}
