package Array;

import java.util.Arrays;

/**
 * Leetcode 724. Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/solution/
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * Explanation from: https://leetcode.com/problems/find-pivot-index/solution/
 * Code from: https://leetcode.com/problems/find-pivot-index/solution/
 * @author NisuBhakti
 * Time Complexity: O(N), where N is the length of the array nums; Space Complexity: O(1), the space used by leftsum and sum.
 */

public class FindPivotIndex {

	/**
	 * Let's say we knew S as the sum of the numbers, and we are at index i. If we knew the sum of numbers leftsum that
	 * are to the left of index i,
	 * then the other sum to the right of the index would just be S - nums[i] - leftsum.
	 * @param nums: array whose pivot is to be found
	 * @return pivot index whose left sum is equal to the right sum
	 */
	
	public static int pivotIndex(int[] nums) {
		int sum = 0, leftSum = 0;
		
		System.out.println(Arrays.toString(nums));
		
		for(int n: nums) {
			sum = sum + n;
		}
		
		System.out.println("sum: "+sum);
		
		for(int i=0; i<nums.length; i++) {
			System.out.println("i: "+i+" nums[i]: "+nums[i]);
			
			if(i != 0) {
				System.out.println("i: "+i+" nums[i-1]: "+nums[i-1]);
				leftSum = leftSum + nums[i-1];
			}
			
			System.out.println("sum: "+sum+" nums[i]: "+nums[i]+" leftSum: "+leftSum);
			int rightSum = sum - nums[i] - leftSum;
			
			System.out.println("rightSum: "+rightSum+" i: "+i);
			
			if(rightSum == leftSum) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 7, 3, 6, 5, 6};
		
		System.out.println(pivotIndex(nums));
	}

}
