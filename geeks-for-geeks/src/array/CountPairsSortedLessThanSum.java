package array;

/**
 * Question: http://www.geeksforgeeks.org/count-pairs-array-whose-sum-less-x/
 *
 * @author Sudharsanan Muralidharan
 */
public class CountPairsSortedLessThanSum {

    public int countPairs(int[] arr, int result) {
        int count = 0;
        for (int i = 0; i < arr.length && arr[i] < result; i++) {
            int j = i + 1;
            while (j < arr.length && (arr[i] + arr[j]) < result) {
                count++;
                j++;
            }
        }
        return count;
    }

    public int countPairs2(int[] arr, int result) {
        int count = 0, i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] < result) {
                count += (j - i);
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
