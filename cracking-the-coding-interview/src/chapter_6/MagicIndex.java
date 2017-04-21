package chapter_6;

public class MagicIndex {
  public int findMagicIndex(int[] arr) {
    return findMagicIndex(arr, 0, arr.length - 1);
  }

  private int findMagicIndex(int[] arr, int start, int end) {
    if (start > end) {
      return -1;
    }

    int middle = (start + end) / 2;
    if (arr[middle] == middle) {
      return middle;
    } else if (arr[middle] > middle) {
      return findMagicIndex(arr, start, middle - 1);
    } else {
      return findMagicIndex(arr, middle + 1, end);
    }
  }
}
