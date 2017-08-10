package chapter_10;

/**
 * Question 10.3
 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start >= end) return (nums[start] == target) ? start : -1;
        int middle = (start + end) / 2;
        if (nums[middle] == target) return middle;
        else if (nums[middle] > nums[end]) {
            return (target >= nums[start] && middle > 0 && target <= nums[middle - 1])
                    ? search(nums, target, start, middle - 1) : search(nums, target, middle + 1, end);
        } else {
            return (target >= nums[middle + 1] && middle < nums.length - 1 && target <= nums[end])
                    ? search(nums, target, middle + 1, end) : search(nums, target, start, middle - 1);
        }
    }
}
