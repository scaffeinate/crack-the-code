package chapter_5;

public class Conversion {

    public int numConversionBits(int n, int m) {
        int x = n ^ m;
        return countOnes(x);
    }

    private int countOnes(int n) {
        int counter = 0;
        while (n > 0) {
            n = (n & (n - 1));
            counter++;
        }

        return counter;
    }
}
