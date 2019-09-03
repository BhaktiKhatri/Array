package Array;

import java.util.Arrays;

/*
 * 334. Increasing Triplet Subsequence
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should: Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * Examples: Given [1, 2, 3, 4, 5], return true
 * Given [5, 4, 3, 2, 1], return false
 * Explanation and Code from: https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79004/Concise-Java-solution-with-comments.
 * Facebook
 * Medium
 */

public class IncreasingTripletSubsequence {

	/*
	   Think about [3, 4, 2, 1, 5], 5 is the element we want, but at the time we reach 5, small = 1, big = 4. But the sequence is not 1 4 5, it's 3 4 5.
	   So I think here the condition is, if you find any element greater than big, it can be regarded as the third element in sequence. But in order to update
	   the big variable, to give you bigger range for the third element, you need to update the small variable, which gives you bigger range for the new "big"
	   variable.
	 */
	public static boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        
        System.out.println(Arrays.toString(nums));
        System.out.println("small: "+small+" big: "+big);
        
        for(int n: nums) {
        	System.out.println("n: "+n+" small: "+small+" big: "+big);
            if(n <= small) { 			// update small if n is smaller than both
            	small = n; 
            } 
            else if(n <= big) {			// update big only if greater than small but smaller than big 
            	big = n; 
            }
            else {
            	System.out.println("n: "+n+" small: "+small+" big: "+big);
            	return true; 			// return if you find a number bigger than both
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,0,3}; //{1, 2, 3, 4, 5};
		System.out.println(increasingTriplet(nums));
	}

}