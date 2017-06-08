package sort;

public class BubbleSort<T> extends Sort<T> {

  @Override
  public T[] sort(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - 1; j++) {
        if (compare(arr[j], arr[j + 1]) > 0) {
          swap(arr, j, j + 1);
        }
      }
    }

    return arr;
  }

}
