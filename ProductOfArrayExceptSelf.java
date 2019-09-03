package Array;

import java.util.Arrays;

/**
 * Leetcode 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums
 * except nums[i]. 
 * Solve it without division and in O(n). For example, given [1,2,3,4], return [24,12,8,6].
 * Code and Explanation from: @vinceyuan https://leetcode.com/problems/product-of-array-except-self/discuss/65622
 * Time Complexity: O(n); Space Complexity: O(1)
 * Medium
 * Microsoft, Facebook, Amazon, LinkedIn, Apple
 */

public class ProductOfArrayExceptSelf {

	/*
	 	Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and 
	 	right 5. The product is left*right. We can get lefts and rights:

		Numbers:     2    3    4     5
		Lefts:            2  2*3 2*3*4
		Rights:  3*4*5  4*5    5      
		Let’s fill the empty with 1:
		
		Numbers:     2    3    4     5
		Lefts:       1    2  2*3 2*3*4
		Rights:  3*4*5  4*5    5     1
		We can calculate lefts and rights in 2 loops. The time complexity is O(n).
		
		We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n). To make it O(1), we just need to store
		it in a variable which is right in @lycjava3’s code.
	*/
	public static int[] productExceptSelf(int[] nums) {
		System.out.println(Arrays.toString(nums));
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate lefts and store in result
        int left = 1;
        for(int i=0; i<n; i++) {
            if (i > 0) {
            	System.out.println("i: "+i+" nums[i - 1]: "+nums[i - 1]+" left: "+left+" result[i]: "+result[i]);
                left = left * nums[i - 1];
            }
            System.out.println("left: "+left);
            result[i] = left;
        }
        System.out.println(Arrays.toString(result));
        
        // Calculate rights and the product from the end of the array
        int right = 1;
        for(int i=n-1; i >= 0; i--) {
            if(i < n - 1) {
            	System.out.println("i: "+i+" nums[i + 1]: "+nums[i + 1]+" right: "+right+" result[i]: "+result[i]);
                right = right * nums[i + 1];
            }
            System.out.println("i: "+i+" right: "+right+" result[i]: "+result[i]);
            result[i] = result[i] * right;
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,4,5};
		System.out.println(Arrays.toString(nums));
		nums = productExceptSelf(nums);
		System.out.println(Arrays.toString(nums));
	}
}