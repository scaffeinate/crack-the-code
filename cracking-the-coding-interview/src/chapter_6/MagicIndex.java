package chapter_6;

public class MagicIndex {
  public int findMagicIndex(int[] arr) {
    return findMagicIndex(arr, 0, arr.length);
  }

  private int findMagicIndex(int[] arr, int start, int end) {
    int middle = (start + end) / 2;
    if (middle == 0 || middle == arr.length - 1) {
      return arr[middle] == middle ? middle : -1;
    }

    if (arr[middle] == middle) {
      return middle;
    } else if (arr[middle] > middle) {
      return findMagicIndex(arr, start, middle);
    } else {
      return findMagicIndex(arr, middle + 1, end);
    }
  }
}
