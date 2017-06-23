package sort;

/**
 * Question: http://www.geeksforgeeks.org/selection-sort/
 *
 * @param <T>
 */
public class SelectionSort<T> extends Sort<T> {

    @Override
    public T[] sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (compare(arr[i], arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

}