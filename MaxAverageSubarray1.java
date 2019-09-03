package Array;

import java.util.Arrays;

/**
 * Leetcode 643. Maximum Average Subarray I
 * https://leetcode.com/problems/maximum-average-subarray-i/discuss/
 * https://www.youtube.com/watch?v=fCGLjlsEsNA
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * Input: [1,12,-5,-6,50,3], k = 4; Output: 12.75; Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * @author NisuBhakti
 * Time Complexity: O(N); Space Complexity: O(1)
 */

public class MaxAverageSubarray1 {

	/**
	 * Algorithm:
	 * We use sliding window strategy for solving this.
	 * Step 1: Find sum of first k elements in the input array. Initialize maxSum to the calculated sum and maxSumStartIndex = 0.
	 * Step 2: Add next element to the sum and subtract first element from the sum. Check if this sum is greater than previous sum and update maxSum and maxSumStartIndex.
	 * Step 3: Keep adding next element to the sum and removing first element from the sum to get sum of current sub array of size k and update maxSum and maxSumStartIndex whenever a greater sum is seen.
	 * Step 4: Finally print k elements starting from maxSumStartIndex.
	 * @param nums
	 * @param k
	 * @return
	 */
	
	public static double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i=0; i<k; i++) 
        	sum = sum + nums[i];
        long max = sum;
        
        for (int i=k; i<nums.length; i++) {
        	System.out.println("i: "+i+" k: "+k+" sum: "+sum+" nums[i]: "+nums[i]+" nums[i-k]: "+nums[i-k]+" max: "+max);
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / 1.0 / k;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,12,-5,-6,50,3};
		System.out.println(Arrays.toString(arr));
		int k = 4;
		System.out.println(findMaxAverage(arr, k));
	}

}
