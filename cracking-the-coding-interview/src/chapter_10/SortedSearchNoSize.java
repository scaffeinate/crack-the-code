package chapter_10;

/**
 * Question 10.4
 */
public class SortedSearchNoSize {
    public int search(Listy listy, int target) {
        int i = 1;
        while (listy.get(i) != -1) {
            i *= 2;
        }
        int bound = findBound(listy, i / 2, i - 1);
        return search(listy, 0, bound, target);
    }

    private int search(Listy listy, int start, int end, int target) {
        if (start >= end) return (listy.get(start) == target) ? start : -1;
        int middle = (start + end) / 2;
        int current = listy.get(middle);
        if (current == target) {
            return middle;
        } else if (current > target) {
            return search(listy, start, middle - 1, target);
        } else {
            return search(listy, middle + 1, end, target);
        }

    }

    private int findBound(Listy listy, int start, int end) {
        if (start >= end) return start;
        int middle = (start + end) / 2;
        if (listy.get(middle) != -1 && listy.get(middle + 1) == -1) {
            return middle;
        } else if (listy.get(middle) == -1) {
            return findBound(listy, start, middle - 1);
        } else {
            return findBound(listy, middle + 1, end);
        }
    }
}
