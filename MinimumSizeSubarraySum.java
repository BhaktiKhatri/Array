package Array;

import java.util.Arrays;

/**
 * Leetcode 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
 * Explanation and Code from: Approach #4 Using 2 pointers https://leetcode.com/problems/minimum-size-subarray-sum/solution/
 * https://www.youtube.com/watch?v=gHSoIwnERF0
 * Time complexity: O(n), Single iteration of O(n). Each element can be visited at most twice, once by the right pointer(i) and (at most) once by the left pointer.
 * Space complexity: O(1) extra space. Only constant space required for left, sum, ans and i.
 * Facebook
 * Medium
 */

public class MinimumSizeSubarraySum {

	/*
	  Intuition: 
	  we could move the starting index of the current subarray as soon as we know that no better could be done with this index as the starting index. 
	  We could keep 2 pointer,one for the start and another for the end of the current subarray, and make optimal moves so as to keep the sum greater
	  than s as well as maintain the lowest size possible.
	  
	  Algorithm:
	  Initialize left pointer to 0 and sum to 0
	  Iterate over the nums:
		Add nums[i] to sum
		While sum is greater than or equal to s:
			Update ans=min(ans,i+1−left), where i+1−left is the size of current subarray
			It means that the first index can safely be incremented, since, the minimum subarray starting with this index with sum≥s has been achieved
			Subtract nums[left] from sum and increment left
	 */
	
	public static int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
	    int ans = Integer.MAX_VALUE;
	    int left = 0;
	    int sum = 0;

	    System.out.println("nums: "+Arrays.toString(nums)+" s: "+s);
	    
	    for(int i=0; i<n; i++) {
	    	
	    	System.out.println("i: "+i+" nums[i]: "+nums[i]+" sum: "+sum);
	    	
	        sum = sum + nums[i];
	        System.out.println("sum: "+sum+" s: "+s);
	        
	        while(sum >= s) {
	            System.out.println("ans: "+ans+" i: "+i+" (i + 1 - left): "+(i + 1 - left));
	        	ans = Math.min(ans, i + 1 - left);
	            sum = sum - nums[left];
	            left++;
	        }
	    }
	    return (ans != Integer.MAX_VALUE) ? ans : 0;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));
	}

}
