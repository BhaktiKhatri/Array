package Array;

import java.util.Arrays;

/**
 * Leetcode 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
 * Explanation and Code from: Approach #4 https://leetcode.com/problems/rotate-array/solution/
 * Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * @author NisuBhakti
 * Time Complexity: O(n) Only one pass is used; Space Complexity: O(1) Constant extra space is used
 */

public class RotateArray {

	/**
	 * let a= [1,2,3,4,5,6,7] and k = 3
	 * 1. we have to first reverse the whole array by swapping first element with the last one and so on you will get[7,6,5,4,3,2,1]
	 * 2. reverse the elements from 0 to k-1 reverse the elements 7,6,5 you will get [5,6,7,4,3,2,1]
	 * 3. reverse the elements from k to n-1 reverse the elements 4,3,2,1 you will get[5,6,7,1,2,3,4]
 	 * @param nums: Array to be right rotated
	 * @param k: by k steps
	 * @return rotated array
	 */
	
	public static int[] rotate(int[] nums, int k) {
		k = k % nums.length;		//This is because that sometimes, k is larger than the length of array. For example nums = [1, 2, 3, 4, 5], k = 12, this means we only need to rotate the last two numbers. k = k % nums.length = 2;
		
		reverse(nums,0,nums.length-1);
		System.out.println(Arrays.toString(nums));
		
		reverse(nums,0,k-1);
		System.out.println(Arrays.toString(nums));
		
		reverse(nums, k, nums.length-1);
		System.out.println(Arrays.toString(nums));
		
		return nums;
	}
	
	public static void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int k = 16;
		System.out.println(Arrays.toString(arr));
		int[] result = rotate(arr, k);
		System.out.println(Arrays.toString(result));
	}

}