package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Question: http://www.geeksforgeeks.org/merge-sort/
 *
 * @param <T>
 */
public class MergeSort<T> extends Sort<T> {
    private Class<?> clazz;

    public MergeSort(Class<?> clazz) {
        this.clazz = clazz;
    }

    public T[] sort(T[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private T[] mergeSort(T[] arr, int start, int end) {
        if (start == end) {
            return Arrays.copyOfRange(arr, start, end + 1);
        }

        int middle = (start + end) / 2;
        T[] result = merge(mergeSort(arr, start, middle), mergeSort(arr, middle + 1, end));

        return result;
    }

    @SuppressWarnings("unchecked")
    private T[] merge(T[] left, T[] right) {
        int n = left.length;
        int m = right.length;
        T[] result = (T[]) Array.newInstance(clazz, m + n);
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            int compare = compare(left[i], right[j]);
            if (compare < 0) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < m) {
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }

}
