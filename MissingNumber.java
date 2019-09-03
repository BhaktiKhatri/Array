package Array;

import java.util.Arrays;

/**
 * Leetcode 268. Missing Number
 * https://leetcode.com/problems/missing-number/solution/
 * https://www.geeksforgeeks.org/find-the-missing-number/
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * @author NisuBhakti
 * Time complexity : O(n). Assuming that XOR is a constant-time operation, this algorithm does constant work on n iterations, so the runtime is overall linear.
 * Space complexity : O(1). This algorithm allocates only constant additional space
 */

public class MissingNumber {

	/**
	 * The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
	 * In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers, 
	 * the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number. 
	 * @param nums
	 * @return
	 */
	
	public static int missingNumber(int[] nums) {
		System.out.println("nums: "+Arrays.toString(nums));
		int xor = 0, i = 0;
		for(i=0; i<nums.length; i++) {
			System.out.println("xor: "+xor+" i: "+i+" nums[i]: "+nums[i]);
			xor = xor ^ i ^ nums[i];
		}
		return xor^i;
	}
	
	public static int missingNumber1(int[] nums) {
	    int sum = nums.length;
	    System.out.println("nums: "+Arrays.toString(nums)+" sum: "+sum);
	    
	    for(int i = 0; i < nums.length; i++) {
	    	System.out.println("i: "+i+" nums[i]: "+nums[i]+" sum: "+sum);
	        sum = sum + i - nums[i];
	    }
	    System.out.println("nums: "+Arrays.toString(nums)+" sum: "+sum);
	    return sum;
	}
	
	//Refer this
	//Approach 4: https://leetcode.com/problems/missing-number/solution/
	public static int missingNumber2(int[] nums) {
		System.out.println("nums: "+Arrays.toString(nums)+" nums.length: "+nums.length);
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        System.out.println("expectedSum: "+expectedSum);
        
        for(int num: nums) { 
        	System.out.println("num: "+num+" actualSum: "+actualSum);
        	actualSum = actualSum + num;
        }
        System.out.println("expectedSum: "+expectedSum+" actualSum: "+actualSum);
        return expectedSum - actualSum;
    }
	
	
	public static void main(String[] args) {
		int[] arr = {3,0,1};
		System.out.println(missingNumber2(arr));
	}
}