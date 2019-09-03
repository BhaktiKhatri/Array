package Array;

import java.util.Arrays;

/**
 * Leetcode 55. Jump Game
 * https://leetcode.com/problems/jump-game/description/
 * Code from: https://leetcode.com/problems/jump-game/discuss/20917
 * Given an array of non-negative integers, you are initially positioned at the first index of the array. 
 * Each element in the array represents your maximum jump length at that position. Determine if you are able to reach the last index.
 * A = [2,3,1,1,4], return true; A = [3,2,1,0,4], return false.
 * Time Complexity: O(N)
 * Microsoft
 * Medium
 */

public class JumpGame {

	//I just iterate and update the maximal index that I can reach
	public static boolean canJump(int[] nums) {
		int distance = 0;
		System.out.println("nums: "+Arrays.toString(nums)+" nums.length-1: "+(nums.length-1));
		
		for(int i=0; i<=distance; i++) {
			System.out.println("i: "+i+" nums[i]: "+nums[i]+" distance: "+distance);
			
			distance = Math.max(distance, i + nums[i]);
			System.out.println("distance: "+distance);
			
			if(distance >= nums.length-1) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,1,1,4}; //{2,3,1,1,4};
		System.out.println(canJump(arr));
	}
}