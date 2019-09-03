package Array;

import java.util.Arrays;

/**
 * Leetcode 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/discuss/7873/
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 * Explanation and Code from: https://www.sigmainfy.com/blog/3sum-closest-problem-analysis.html
 * https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference
 * Time Complexity: O(N^2); Space complexity: O(1)
 * Bloomberg
 * Medium
 */

public class ThreeSumClosest {

	/**
	 * The idea is very simple and if you have read the 3sum problem post, the solution would be quite straightforward and it is simpler here because 
	 * exactly one solution is assumed. The basic idea is as follows:
	 * Basically we need to minimize the absolute value of (target – (A[i] + A[j] + A[k]). We follow exactly the same procedure as in 3sum problem by
	 * first sorting the whole array and (copyright @sigmainfy) linear scan the rest of the array to find two sum.
	 * If the sum of the triplet is greater than the target, it is obvious that we need to reduce the sum, so set k = k – 1. Similarly if sum of the 
	 * triplet is less than the target, then we set j = j + 1, at the same time if we got a sum closer to the target, we keep record of it.
	 * @param nums given array
	 * @param target: target sum
	 * @return triplet sum that is closest to the target sum
	 */
	
	/*
	 * Similar to 3 Sum problem, use 3 pointers to point current element, next element and the last element. If the sum is less than target,
	 * it means we have to add a larger element so next element move to the next. If the sum is greater, it means we have to add a smaller element
	 * so last element move to the second last element. Keep doing this until the end. Each time compare the difference between sum and target, if it
	 * is less than minimum difference so far, then replace result with it, otherwise keep iterating.
	 */
	
	public static int threeSumClosest(int[] nums, int target) {
		int min = Integer.MAX_VALUE;
		int result = 0;
	 
		Arrays.sort(nums);
		System.out.println("nums: "+Arrays.toString(nums)+" target: "+target);
		int sum=0;
		
		for(int i=0; i<nums.length; i++) {
			System.out.println("i: "+i+" nums[i]: "+nums[i]);
			
			int low = i + 1;
			int high = nums.length - 1;
			System.out.println("low: "+low+" high: "+high);
			
			while(low < high) {
				System.out.println("nums[low]: "+nums[low]+" nums[high]: "+nums[high]);
				sum = nums[i] + nums[low] + nums[high];
				System.out.println("sum: "+sum+" target: "+target);
				
				int diff = Math.abs(sum - target);
				System.out.println("diff: "+diff+" min: "+min+" result: "+result);
				
				if(diff == 0) {
					return sum;
				}
	 
				if(diff < min) {
					min = diff;
					result = sum;	//return the sum when diff is min; so store sum here in result
					
					if (sum <= target)
						low++;
					else
						high--;
				}
				else if (sum <= target) {
					low++;
				} 
				else {
					high--;
				}
			}
		}
		System.out.println("result: "+result+" sum: "+sum);
		return result;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,0}; //{-1, 2, 1, -4};
		System.out.println(Arrays.toString(arr));
		System.out.println(threeSumClosest(arr, -100));
	}

}