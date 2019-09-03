package Array;

import java.util.HashSet;

/**
 * Leetcode 548. Split Array with Equal Sum
 * https://leetcode.com/problems/split-array-with-equal-sum/description/
 * Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions: 0 < i, i + 1 < j, j + 1 < k < n - 1
 * Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal, where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
 * Input: [1,2,1,2,1,2,1], Output: True
 * Explanation and Code from: https://leetcode.com/problems/split-array-with-equal-sum/solution/
 * Time complexity : O(n^2), One outer loop and two inner loops are used; Space complexity : O(n), HashSet size can go up to n.
 */

public class SplitArrayWithEqualSum {

	public static boolean splitArray(int[] nums) {
        if (nums.length < 7)
            return false;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        for (int j=3; j<nums.length-3; j++) {
            HashSet<Integer> set = new HashSet<> ();
            for (int i=1; i<j-1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i])
                    set.add(sum[i - 1]);
            }
            for (int k = j + 2; k < nums.length - 1; k++) {
                if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[j] && set.contains(sum[k - 1] - sum[j]))
                    return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,1,2,1,2,1};
		System.out.println(splitArray(nums));
	}

}
