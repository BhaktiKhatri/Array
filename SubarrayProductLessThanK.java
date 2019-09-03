package Array;

import java.util.Arrays;

/**
 * Leetcode 713. Subarray Product Less Than K
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 * https://www.geeksforgeeks.org/number-subarrays-product-less-k/
 * Explanation and code from: Approach #2 https://leetcode.com/problems/subarray-product-less-than-k/solution/
 * Your are given an array of positive integers nums. Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * Input: nums = [10, 5, 2, 6], k = 100; Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]. 
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Explanation and Code from: @alexander https://leetcode.com/problems/subarray-product-less-than-k/discuss/108861/JavaC++-Clean-Code-with-Explanation
 * Time Complexity: O(N), where N is the length of nums. left can only be incremented at most N times. 
 * Space Complexity: O(1), the space used by prod, left, and ans.
 * Yatra
 * Medium 
 */

public class SubarrayProductLessThanK {

	/*
	 * The idea is always keep an max-product-window less than K;
	 * Every time shift window by adding a new number on the right(j), if the product is greater than k, then try to reduce numbers on the left(i), until the subarray product fit less than k again, (subarray could be empty);
	 * Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
	 * example: for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))
	 *         (6)
	 *      (2, 6)
	 *   (5, 2, 6)
	 * 
	 */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) 
        	return 0;
        
        int cnt = 0;
        int pro = 1;
        
        System.out.println("nums: "+Arrays.toString(nums)+" k: "+k);
        
        for(int i=0, j=0; j<nums.length; j++) {
        	System.out.println("i: "+i+" nums[i]: "+nums[i]+" j: "+j+" nums[j]: "+nums[j]+" pro: "+pro);
        	
            pro = pro * nums[j];
            System.out.println("pro: "+pro);
            
            while(i <= j && pro >= k) {
                pro = pro / nums[i];
                i++;
            }
            cnt = cnt + j - i + 1;
            System.out.println("cnt: "+cnt);
        }
        return cnt;        
    }
	
	public static void main(String[] args) {
		int[] nums = {10, 5, 2, 6};
		int k = 100;
		System.out.println(numSubarrayProductLessThanK(nums, k));
	}

}
