package chapter_10;

/**
 * Questio
 */
public class SparseSearch {
    public int sparseSearch(String[] arr, String s) {
        if (arr.length == 0) return -1;
        return search(arr, 0, arr.length - 1, s);
    }

    private int search(String[] arr, int start, int end, String s) {
        if (start >= end) return (arr[start].equals(s)) ? start : -1;
        int middle = (start + end) / 2;
        if (arr[middle].isEmpty()) {
            int index = search(arr, start, middle - 1, s);
            if (index == -1) {
                index = search(arr, middle + 1, end, s);
            }
            return index;
        } else if (arr[middle].equals(s)) {
            return middle;
        } else if (arr[middle].compareTo(s) > 0) {
            return search(arr, start, middle - 1, s);
        } else {
            return search(arr, middle + 1, end, s);
        }
    }
}
