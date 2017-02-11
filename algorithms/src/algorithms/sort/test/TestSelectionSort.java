package algorithms.sort.test;

import java.io.FileNotFoundException;

import algorithms.sort.SelectionSort;
import algorithms.util.InputUtil;

public class TestSelectionSort {
  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("test_sort");
    SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
    for (String line : input) {
      String[] elements = line.split(" ");
      Integer[] arr = new Integer[elements.length];

      for (int i = 0; i < elements.length; i++) {
        arr[i] = Integer.parseInt(elements[i]);
      }

      arr = selectionSort.sort(arr);
      System.out.print("Sorted Array: ");
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
  }
}
