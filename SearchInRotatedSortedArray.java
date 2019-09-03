package Array;

import java.util.Arrays;

/**
 * Leetcode 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1. You may assume no duplicate exists in the array.
 * Example 1: Input: nums = [4,5,6,7,0,1,2], target = 0; Output: 4
 * Example 2: Input: nums = [4,5,6,7,0,1,2], target = 3; Output: -1
 * Explanation and Code from: http://www.ideserve.co.in/learn/find-an-element-in-a-sorted-rotated-array
 * Time Complexity: O(log(N)); Space Complexity: O(1)
 * Medium
 * Microsoft, Facebook, Bloomberg, Uber, LinkedIn
 */

public class SearchInRotatedSortedArray {

	public static int search(int[] nums, int target) {
		if(nums.length == 0)
            return -1;
		
		int start = 0, end = nums.length-1;
		System.out.println(Arrays.toString(nums)+" target: "+target);
		
        while(start < end) {
        	System.out.println("start: "+start+" end: "+end+" nums[start]: "+nums[start]+" nums[end]: "+nums[end]);
        	
        	if(nums[start] < nums[end]) {
        		break;
        	}
        	
            int mid = (start + end)/2;
            System.out.println("start: "+start+" end: "+end+" mid: "+mid+" nums[mid]: "+nums[mid]+" nums[start]: "+nums[start]);
            
            if(nums[mid] >= nums[start]) {
            	start = mid + 1;
            }
            else { 
            	end = mid;
            }
        }
        System.out.println("start: "+start+" end: "+end);
        
        int pivot = start;
        
        if(nums[pivot] == target)
        	return pivot;
        
        if(pivot > 0 && target >= nums[0] && target <= nums[pivot-1]) {
        	start = 0;
        	end = pivot - 1;
        }
        else {
        	start = pivot;
        	end = nums.length-1;
        }
        
        System.out.println("pivot: "+pivot+" start: "+start+" end: "+end);
        
        while(start <= end) {
        	int root = (start + end) / 2;
        	
        	if(nums[root] == target)
        		return root;
        	else if(nums[root] < target) 
        		start = root + 1;
        	else
        		end = root - 1;
        }
        return -1;
	}		
	
	public static void main(String[] args) {
		int[] nums = {5,6,0,1,2,3,4};
		int target = 1;
		System.out.println(search(nums, target));
	}
}