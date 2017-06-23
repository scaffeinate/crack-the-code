package chapter_5;

public class NextNumber {

    public int getNext(int n) {
        if (n == 0) {
            return 0;
        }

        int onesCount = countOnes(n);
        for (int i = n + 1; i <= Integer.MAX_VALUE; i++) {
            if (countOnes(i) == onesCount) {
                return i;
            }
        }
        return n;
    }

    public int getPrevious(int n) {
        if (n == 0) {
            return 0;
        }

        int onesCount = countOnes(n);
        for (int i = n - 1; i >= 0; i--) {
            if (countOnes(i) == onesCount) {
                return i;
            }
        }
        return n;
    }

    public int getNext2(int n) {
        int numOnes = 0, p = 0;
        for (int i = 0; i < 32; i++) {
            if (isBitSet(n, i)) {
                numOnes++;
            } else if (numOnes > 0) {
                p = i;
                n = setBit(n, p);
                break;
            }
        }

        int mask = ~((1 << p) - 1);
        n = n & mask;

        int rightOnesMask = (1 << (numOnes - 1)) - 1;

        return n | rightOnesMask;
    }

    public int getPrevious2(int n) {
        int numZeros = 0, p = 0;
        for (int i = 0; i < 32; i++) {
            if (isBitSet(n, i)) {
                if (numZeros > 0) {
                    p = i;
                    n = unsetBit(n, i);
                    break;
                }
            } else {
                numZeros++;
            }
        }

        int mask = ~((1 << p) - 1);
        n = n & mask;

        int rightOnesMask = ((1 << (p)) - 1);
        int zerosMask = (~0) << (numZeros - 1);
        rightOnesMask &= zerosMask;

        return n | rightOnesMask;
    }

    private int countOnes(int n) {
        int numOnes = 0;
        while (n > 0) {
            numOnes += ((n & 1) != 0) ? 1 : 0;
            n >>>= 1;
        }
        return numOnes;
    }

    private int setBit(int n, int i) {
        return n | (1 << i);
    }

    private int unsetBit(int n, int i) {
        return n & (~(1 << i));
    }

    private boolean isBitSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}
