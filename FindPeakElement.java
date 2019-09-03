package Array;

import java.util.Arrays;

/**
 * Leetcode 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/description/
 * http://www.ideserve.co.in/learn/find-a-peak-element-in-an-array
 * A peak element is an element that is greater than its neighbors. Given an input array where num[i] ≠ num[i+1], find a peak element
 * and return its index. The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * Example 1: Input: nums = [1,2,3,1]
 * Output: 2 Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2: Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 
 * Explanation: Your function can return either index number 1 where the peak element is 2, 
 * or index number 5 where the peak element is 6.
 * Explanation and Code from: https://www.youtube.com/watch?v=a7D77DdhlFc&t=62s
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * Microsoft, Google
 * Medium
 */

public class FindPeakElement {

	public static int findPeakElement(int[] nums) {
		if(nums == null || nums.length == 0)
			return -1;
		
		System.out.println(Arrays.toString(nums));
		
		int low = 0;
		int high = nums.length - 1;
		
		while(low <= high) {
			System.out.println("low: "+low+" high: "+high);
			
			int mid = (low + high) / 2;
			System.out.println("mid: "+mid);
			
			//if(mid != nums.length-1 || mid != 0) 
				//System.out.println("mid: "+mid+" nums[mid-1]: "+nums[mid-1]+" nums[mid]: "+nums[mid]);
			
			if((mid == 0 || nums[mid-1] <= nums[mid]) && (mid == nums.length-1 || nums[mid] >= nums[mid + 1])) {
				return mid;
			}
			else if(mid != 0 && nums[mid-1] > nums[mid]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		//int[] arr = {1, 2, 3, 1};
		int[] arr = {1,2,1,3,5,6,4}; //{1,2,3,1}; //{1,2};  //{15, 20, 25, 35, 45, 50, 60};
		System.out.println(findPeakElement(arr));
		//System.out.println(getPeakElement(arr));
	}

}
