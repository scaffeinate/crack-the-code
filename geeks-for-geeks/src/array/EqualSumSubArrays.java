package array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question: http://www.geeksforgeeks.org/split-array-two-equal-sum-subarrays/
 *
 * @author Sudharsanan Muralidharan
 */
public class EqualSumSubArrays {
    public Result subArrays(int[] arr) {
        Result result = new Result();

        int sum = 0, leftSum = 0, index = -1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        Scanner s;

        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            sum -= arr[i];
            if (leftSum == sum) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            result.leftArr = Arrays.copyOfRange(arr, 0, index + 1);
            result.rightArr = Arrays.copyOfRange(arr, index + 1, arr.length);
        } else {
            result.leftArr = new int[]{};
            result.rightArr = new int[]{};
        }

        return result;
    }

    class Result {
        int[] leftArr;
        int[] rightArr;
    }
}
