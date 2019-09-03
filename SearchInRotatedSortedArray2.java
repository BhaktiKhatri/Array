package Array;

import java.util.Arrays;

/**
 * Leetcode 81. Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * Example 1: Input: nums = [2,5,6,0,0,1,2], target = 0; Output: true
 * Example 2: Input: nums = [2,5,6,0,0,1,2], target = 3; Output: false
 * Follow up: This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates. Would this affect the run-time complexity? How and why?
 * Explanation and Code from: @ggyc1993 https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28194/C++-concise-log(n)-solution
 * Time Complexity: O(log(N)); Space Complexity: O(1)
 * Medium
 */

public class SearchInRotatedSortedArray2 {

	public static boolean search(int[] nums, int target) {
		if(nums.length == 0 || nums == null)
			return false;
		
        int start = 0, end = nums.length - 1;
        int mid = 0;
        
        System.out.println(Arrays.toString(nums)+" target: "+target);
        
        while(start < end) {
              mid = (start + end)/2;
              System.out.println("start: "+start+" end: "+end+" mid: "+mid+" nums[mid]: "+nums[mid]+" nums[start]: "+nums[start]+" nums[end]: "+nums[end]);
              
              if(nums[mid] == target)
                  return true;
            
              if(nums[mid] > nums[end]) {
                  if(nums[mid] > target && nums[start] <= target) 
                      end = mid;
                  else 
                      start = mid + 1;
              }
              else if(nums[mid] < nums[end]) {
                  if(nums[mid] < target && nums[end] >= target) 
                      start = mid + 1;
                  else 
                      end = mid;
              }
             else {
                  end--;
              }
        }
        return nums[start] == target ? true : false;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,5,6,0,0,1,2};
		int target = 6;
		System.out.println(search(nums, target));
	}

}
