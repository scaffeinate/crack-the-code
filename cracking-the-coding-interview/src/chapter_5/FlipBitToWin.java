package chapter_5;

public class FlipBitToWin {

  public int flipBitToWin(String binaryString) {
    int max = Integer.MIN_VALUE;
    int val = Integer.parseInt(binaryString, 2);
    int i = 0, counter = 0; 
    boolean canFlipBit = true;
    while (val > 0) {
      if(isBitSet(val, i)) {
        counter++;
      } else if(canFlipBit) {
        counter++;
        canFlipBit = false;
      } else {
        max = Math.max(max, counter);
        counter = 0;
        canFlipBit = true;
      }
      
      val >>= 1;
    }

    return Math.max(max, counter);
  }

  private boolean isBitSet(int val, int i) {
    return (val & (1 << i)) != 0;
  }
  
  public static void main(String[] args) {
    FlipBitToWin f = new FlipBitToWin();
    //System.out.println(f.flipBitToWin("11111110101101111"));
    //System.out.println(f.flipBitToWin("11011101111"));
    //System.out.println(f.flipBitToWin("00000000000000"));
    //System.out.println(f.flipBitToWin("1010101010101010"));
    //System.out.println(f.flipBitToWin("00001100110101011101101110"));
  }
}
