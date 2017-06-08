package sort;

/**
 * Question: http://www.geeksforgeeks.org/insertion-sort/
 *
 * @param <T>
 */
public class InsertionSort<T> extends Sort<T> {

  @Override
  public T[] sort(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int j = i;
      while (j > 0) {
        if (compare(arr[j], arr[j - 1]) < 0) {
          swap(arr, j, j - 1);
        }
        j--;
      }
    }
    return arr;
  }

}
