package Array;

import java.util.Arrays;

/**
 * Leetcode 34. Search for a Range; 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/search-for-a-range/description/
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target 
 * value. Your algorithm's runtime complexity must be in the order of O(log n). If the target is not found in the
 * array, return [-1, -1].
 * For example: Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * Example 2: Input: nums = [5,7,7,8,8,10], target = 6; Output: [-1,-1]
 * Explanation and Code from: Approach #2 Binary Search https://leetcode.com/problems/search-for-a-range/solution/
 * Time Complexity: O(log(N)); Space Complexity: O(1)
 * LinkedIn
 * Medium
 */

public class SearchForARange {

	    // returns leftmost (or rightmost) index at which `target` should be
	    // inserted in sorted array `nums` via binary search.
	    public static int extremeInsertionIndex(int[] nums, int target, boolean left) {
	        int low = 0;
	        int high = nums.length;

	        System.out.println("left: "+left);
	        
	        while(low < high) {
	        	System.out.println("low: "+low+" high: "+high);
	            
	        	int mid = (low + high)/2;
	            System.out.println("mid: "+mid+" nums[mid]: "+nums[mid]);
	            
	            if(nums[mid] > target || (left && target == nums[mid])) {
	                high = mid;
	            }
	            else {
	                low = mid+1;
	            }
	        }
	        System.out.println("low: "+low);
	        
	        return low;
	    }

	    public static int[] searchRange(int[] nums, int target) {
	    	System.out.println("nums: "+Arrays.toString(nums)+" target: "+target);
	    	
	    	int[] targetRange = {-1, -1};
	        int leftIdx = extremeInsertionIndex(nums, target, true);

	        System.out.println("leftIdx: "+leftIdx+" nums[leftIdx]: "+nums[leftIdx]);
	        
	        //assert that `leftIdx` is within the array bounds and that `target` is actually in `nums`
	        if(leftIdx == nums.length || nums[leftIdx] != target) {
	            return targetRange;
	        }

	        targetRange[0] = leftIdx;
	        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

	        System.out.println("targetRange: "+Arrays.toString(targetRange));
	        
	        return targetRange;
	    }
	
	public static void main(String[] args) {
		int[] arr = {5, 7, 7, 8, 8, 10};
		int target = 8;
		arr = searchRange(arr, target);
		System.out.println(Arrays.toString(arr));
	}

}
