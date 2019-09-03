package Array;

import java.util.Arrays;

/**
 * Leetcode 565. Array Nesting
 * https://leetcode.com/problems/array-nesting/description/
 * Explanation and code from: Approach #3 https://leetcode.com/problems/array-nesting/solution/
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 * Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
 * Input: A = [5,4,0,3,1,6,2], Output: 4; Explanation: A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * One of the longest S[K]: S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * Explanation and Code from: Approach #3 https://leetcode.com/problems/array-nesting/solution/
 * Time Complexity: O(n), Every element of the nums array will be considered at most once. Space Complexity: O(1), Constant Space is used
 * Apple
 * Medium
 */

public class ArrayNesting {

	/*
	 	 Algorithm:
		 In the last approach, the visited array is used just to keep a track of the elements of the array which have already been visited.
		 Instead of making use of a separate array to keep track of the same, we can mark the visited elements in the original array nums itself. 
		 Since, the range of the elements can only be between 1 to 20,000, we can put a very large integer value Integer.MAX_VALUE at the position which has been visited. 
		 The rest process of traversals remains the same as in the last approach.
	*/
	public static int arrayNesting(int[] nums) {
        int result = 0;
        System.out.println("nums: "+Arrays.toString(nums));
        
        for(int i=0; i<nums.length; i++) {
        	System.out.println("i: "+i+" nums[i]: "+nums[i]);
        	
            if(nums[i] != Integer.MAX_VALUE) {
            	
                int start = nums[i], count = 0;
                System.out.println("start: "+start+" nums[start]: "+nums[start]);
                
                while(nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    System.out.println("start: "+start+" nums[start]: "+nums[start]+" temp: "+temp+" nums[temp]: "+nums[temp]+" count: "+count);
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {5,4,0,3,1,6,2};
		System.out.println(arrayNesting(nums));
	}
}