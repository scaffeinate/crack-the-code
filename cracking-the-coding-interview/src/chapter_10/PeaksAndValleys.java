package chapter_10;

/**
 * Question 10.11: Peaks And Valleys
 */
public class PeaksAndValleys {
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (((i % 2) == 0 && nums[i] < nums[i + 1]) || ((i % 2) != 0 && nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
