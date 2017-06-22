package dp;

/**
 * Created by sudharti on 6/21/17.
 */
public class LongestIncreasingSubsequence {
	public int longestSeq(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			max = Math.max(max, 1 + longestSeq(arr, arr[i], i + 1));
		}

		return max;
	}

	private int longestSeq(int[] arr, int prev, int index) {
		if (index == arr.length) {
			return 0;
		}

		if (arr[index] < prev) {
			return longestSeq(arr, prev, index + 1);
		} else {
			return Math.max(1 + longestSeq(arr, arr[index], index + 1), longestSeq(arr, prev, index + 1));
		}
	}

	public int longestSeqDP(int[] arr) {
		int[] memo = new int[arr.length];
		int[] trace = new int[arr.length];
		int j = 1;
		while (j < arr.length) {
			for (int i = 0; i < j; i++) {
				if ((arr[i] < arr[j]) && (memo[i] + 1 > memo[j])) {
					memo[j] = memo[i] + 1;
					trace[j] = i;
				}
			}
			j++;
		}

		int max = memo[0];
		for (int i = 1; i < memo.length; i++) {
			max = Math.max(max, memo[i]);
		}

		return max + 1;
	}
}
