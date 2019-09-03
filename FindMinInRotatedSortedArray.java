package Array;

import java.util.Arrays;

/**
 * Leetcode 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * Find the minimum element. You may assume no duplicate exists in the array. 
 * Example 1: Input: [3,4,5,1,2]; Output: 1
 * Example 2: Input: [4,5,6,7,0,1,2]; Output: 0
 * Explanation and Code from: @changhaz https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48493/Compact-and-clean-C++-solution
 * Time Complexity: O(n)
 * Microsoft
 * Medium
 */

public class FindMinInRotatedSortedArray {

	/**
	 * Classic binary search problem.
	 * Looking at subarray with index [start,end]. We can find out that if the first member is less than the last member, there's no rotation in the array. 
	 * So we could directly return the first element in this subarray.
	 * If the first element is larger than the last one, then we compute the element in the middle, and compare it with the first element. 
	 * If value of the element in the middle is larger than the first element, we know the rotation is at the second half of this array.
	 * Else, it is in the first half in the array.
	 */
	public static int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		
		System.out.println(Arrays.toString(nums));
		
		while(start < end) {
			System.out.println("start: "+start+" end: "+end+" nums[start]: "+nums[start]+" nums[end]: "+nums[end]);
			
			if(nums[start] < nums[end]) {
				return nums[start];
			}
			
			int mid = (start + end) / 2;
			System.out.println("start: "+start+" end: "+end+" mid: "+mid+" nums[mid]: "+nums[mid]+" nums[start]: "+nums[start]);
			
			if(nums[mid] >= nums[start]) {//This means that all elements from start to mid are in sorted order.Set start=mid+1 to find pivot in 2nd half of array
				start = mid + 1;
			}
			else {
				end = mid;	//To look for pivot in first half
			}
		}
		System.out.println("start: "+start+" end: "+end+" nums[start]: "+nums[start]+" nums[end]: "+nums[end]);
		return nums[start];
	}
	
	public static int findMax(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		
		System.out.println(Arrays.toString(nums));
		
		while(start < end) {
			if(nums[start] < nums[end]) 
				return nums[end];
			
			int mid = (start + end) / 2;
			System.out.println("start: "+start+" end: "+end+" mid: "+mid+" nums[mid]: "+nums[mid]+" nums[start]: "+nums[start]);
			
			if(nums[mid] >= nums[start]) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return nums[end];
	}
	
	public static void main(String[] args) {
		//int[] arr = {0, 1, 2, 4, 5, 6, 7};
		int[] arr = {4,5,6,7,0,1,2};
		//int[] arr = {5,6,7,0,1,2,3,4};
		//System.out.println(Arrays.toString(arr));
		System.out.println(findMin(arr));
		//System.out.println(findMax(arr));
	}

}
