package Array;

import java.util.Arrays;

/**
 * Leetcode 154. Find Minimum in Rotated Sorted Array II
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 * Find Minimum in Rotated Sorted Array. What if duplicates are allowed?
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element. The array may contain duplicates.
 * Example 1: Input: [1,3,5] Output: 1
 * Example 2: Input: [2,2,2,0,1] Output: 0
 * Explanation and Code from: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/48808/My-pretty-simple-code-to-solve-it
 * Time Complexity: O(log(N)); Space Complexity: O(1)
 * Medium
 */

public class FindMinimumInRotatedSortedArray2 {

	/**
	 * When num[mid] == num[hi], we couldn’t sure the position of minimum in mid’s left or right, so just let upper bound reduce one.
	 * @param nums
	 * @return
	 */
	public static int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		
		System.out.println(Arrays.toString(nums));
		
		while(start < end) {
			if(nums[start] < nums[end])
				return nums[start];
			
			//int mid = start + (end - start) / 2;
			int mid = (start + end) / 2;
			System.out.println("start: "+start+" end: "+end+" mid: "+mid+" nums[mid]: "+nums[mid]+" nums[start]: "+nums[start]+" nums[end]: "+nums[end]);
			
			if(nums[mid] > nums[end]) { 
				start = mid + 1;
			}
			else if(nums[mid] < nums[end]) {
				end = mid;
			}
			else {	// when num[mid] and num[end] are same
				end--;
			}
		}
		return nums[start];
	}
	
	public static void main(String[] args) {
		int[] nums = {2,2,2,0,1};
		System.out.println(findMin(nums));
	}

}
