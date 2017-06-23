package chapter_5;

public class FlipBitToWin {

    public int flipBitToWin(String binaryString) {
        int max = Integer.MIN_VALUE;
        int val = Integer.parseInt(binaryString, 2);
        int leftCounter = 0, rightCounter = 0, zeroCounter = 0;
        while (val > 0) {
            if ((val & 1) != 0) {
                leftCounter++;
            } else {
                rightCounter = leftCounter;
                leftCounter = 0;
                zeroCounter = 1;
            }

            max = Math.max(max, (leftCounter + rightCounter + zeroCounter));
            val >>= 1;
        }

        return max;
    }

    public int flipBitToWin2(String binaryString) {
        int max = Integer.MIN_VALUE;
        ;
        int val = Integer.parseInt(binaryString, 2);
        int leftCounter = 0, rightCounter = 0;
        int allOnes = (1 << binaryString.length()) - 1;

        if ((allOnes - val) == 0) {
            return binaryString.length();
        }

        while (val > 0) {
            if ((val & 1) != 0) {
                leftCounter++;
            } else {
                rightCounter = ((val & 2) == 0) ? 0 : leftCounter;
                leftCounter = 0;
            }

            max = Math.max(max, (leftCounter + rightCounter + 1));
            val >>>= 1;
        }

        return max;
    }

}
