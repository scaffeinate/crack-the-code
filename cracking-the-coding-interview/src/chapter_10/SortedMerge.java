package chapter_10;

/**
 * Question 10.1:
 */
public class SortedMerge {
    public void mergeSorted(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) arr1[k--] = arr1[i--];
            else arr1[k--] = arr2[j--];
        }
        while (i >= 0) arr1[k--] = arr1[i--];
        while (j >= 0) arr1[k--] = arr2[j--];
    }
}
