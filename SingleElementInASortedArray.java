package Array;

import java.util.Arrays;

/*
 * 540. Single Element in a Sorted Array
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 * Example 1: Input: [1,1,2,3,3,4,4,8,8]; Output: 2
 * Example 2: Input: [3,3,7,7,10,11,11]; Output: 10
 * Note: Your solution should run in O(log n) time and O(1) space
 * Code from: https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/100754/Java-Binary-Search-short-(7l)-O(log(n))-w-explanations
 * Explanation from: https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/
 * Medium
 */

public class SingleElementInASortedArray {

	public static int singleNonDuplicate(int[] nums) {
		int result = 0;
		
		for(int i=0; i<nums.length; i++) {
			result = result ^ nums[i];
		}
		
		return result;
	}
	
	// A Binary Search based method to find the element that appears only once
	public static int searchSingleNonDuplicate(int[] nums) {
		System.out.println(Arrays.toString(nums));
		
        int start = 0;
        int end = nums.length - 1;

        System.out.println("start: "+start+" end: "+end);
        
        while (start < end) {
            // We want the first element of the middle pair,
            // which should be at an even index if the left part is sorted.
            // Example:
            // Index: 0 1 2 3 4 5 6
            // Array: 1 1 3 3 4 8 8
            //            ^
            int mid = (start + end) / 2;
            
            System.out.println("mid: "+mid+" mid % 2: "+(mid % 2));
            
            if (mid % 2 == 1) 
            	mid--;

            // We didn't find a pair. The single element must be on the left.
            // (pipes mean start & end)
            // Example: |0 1 1 3 3 6 6|
            //               ^ ^
            // Next:    |0 1 1|3 3 6 6

            System.out.println("mid: "+mid+" nums[mid]: "+nums[mid]+" nums[mid + 1]: "+nums[mid + 1]);
            
            if (nums[mid] != nums[mid + 1]) 
            	end = mid;

            // We found a pair. The single element must be on the right.
            // Example: |1 1 3 3 5 6 6|
            //               ^ ^
            // Next:     1 1 3 3|5 6 6|
            else 
            	start = mid + 2;
            
            System.out.println("start: "+start+" end: "+end);
        }

        // 'start' should always be at the beginning of a pair.
        // When 'start > end', start must be the single element.
        return nums[start];
    }
    
	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3,4,4,8,8};
		System.out.println(searchSingleNonDuplicate(nums));
	}

}
