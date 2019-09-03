package Array;

import java.util.Arrays;

/**
 * Leetcode 280. Wiggle Sort
 * https://leetcode.com/problems/wiggle-sort/description/
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3].... 
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * Explanation and code from: @StefanPochmann https://leetcode.com/problems/wiggle-sort/discuss/71692/Java-O(N)-solution 
 * https://discuss.leetcode.com/topic/23871/java-o-n-solution
 * Time Complexity: O(n), In the worst case we swap at most n/2 times. An example input is [2,1,3,1,4,1]; Space Complexity: O(1).
 * Google
 * Medium
 */

public class WiggleSort {

	/*
	 * We want a number to be larger than the previous (nums[i] > previous) if and only if it's at an 
	 * odd index (i%2 == 1). With == it's effectively "if and only if", but I want to swap when that's
	 * violated i.e when it's at an even index, so I negate to != here
	 * A&&B: A==true and B==true; A==B: (A==true and B==true) ||(A==false and B==false)
	 * nums[0] <= nums[1] >= nums[2] <= nums[3]
	 * even <= odd >= even <= odd
	 */
	public static void wiggleSort(int[] nums) {
		System.out.println("nums: "+Arrays.toString(nums));
		
	    for(int i=1; i<nums.length; i++) {
	    	System.out.println("i: "+i+" nums[i]: "+nums[i]+" nums: "+Arrays.toString(nums));
	    	
	    	int previous = nums[i-1];
	    	System.out.println("i: "+i+" nums[i]: "+nums[i]+" previous: "+previous);
	    	
	    	//if (number is greater than previous and it is at even index) OR (number is less than previous and it is at odd index) then swap
	    	if((nums[i] > previous && i % 2 == 0) || (nums[i] < previous && i % 2 != 0)) {
	            nums[i-1] = nums[i];
	            nums[i] = previous;
	        }
	    }
	}
	//if((nums[i] > previous) == (i % 2 == 0)) {	//&&
	
	public static void main(String[] args) {
		int[] arr = {3,5,2,1,6,4}; //{2,1}; // {3,5,2,1,6,4};
		System.out.println(Arrays.toString(arr));
		wiggleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
