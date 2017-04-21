package chapter_6;

public class MagicIndex {
  public int findMagicIndex(int[] arr) {
    return findMagicIndex(arr, arr.length / 2);
  }

  private int findMagicIndex(int[] arr, int index) {
    if (index == 0) {
      return (arr[0] == 0) ? 0 : -1;
    } else if (arr[index] == index) {
      return index;
    } else {
      return findMagicIndex(arr, index / 2);
    }
  }
}
