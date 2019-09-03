package Array;

import java.util.Arrays;

/*
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/description/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * Example: Input: [2,3,1,1,4]; Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note: You can assume that you can always reach the last index.
 * Explanation and Code from: https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
 * >Medium
 * Time Complexity: O(n)
 */

public class JumpGame2 {

	/*
	 * The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all
	 * points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest,
	 * then keep the above steps, as the following:
	 */
	public static int jump(int[] nums) {
		int jumps = 0;
		int curEnd = 0;
		int curFarthest = 0;
		
		System.out.println("nums: "+Arrays.toString(nums));
		
		for(int i=0; i<nums.length-1; i++) {
			System.out.println("i: "+i+" nums[i]: "+nums[i]+" (i + nums[i]): "+(i + nums[i])+" curFarthest: "+curFarthest);
		    
			curFarthest = Math.max(curFarthest, i + nums[i]);
		    System.out.println("i: "+i+" curEnd: "+curEnd+" jumps: "+jumps+" curFarthest: "+curFarthest);
		    
		    if(i == curEnd) {
		    	jumps++;
		    	curEnd = curFarthest;
		    	
		    	if (curEnd >= nums.length - 1) {
					break;
				}
		    }
		}
		System.out.println("jumps: "+jumps);
		return jumps;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,2,4,2,0,1,1};							//{2,3,1,1,4};
		System.out.println(jump(nums));
	}

}
