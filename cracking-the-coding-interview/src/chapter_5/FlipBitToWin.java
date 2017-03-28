package chapter_5;

public class FlipBitToWin {

  public int flipBitToWin(String binaryString) {
    int max = Integer.MIN_VALUE;
    int val = Integer.parseInt(binaryString, 2);
    int i = 0, counter = 0, numFlipsLeft = 1; 
    while (val > 0) {
      if(isBitSet(val, i)) {
        counter++;
      } else if(numFlipsLeft > 0) {
        counter++;
        numFlipsLeft--;
      } else {
        max = Math.max(max, counter);
        counter = 0;
        numFlipsLeft = 1;
      }
      
      val >>= 1;
    }

    return Math.max(max, counter);
  }

  private boolean isBitSet(int val, int i) {
    return (val & (1 << i)) != 0;
  }
}
