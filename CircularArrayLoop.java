package Array;

import java.util.Arrays;

/*
 * 457. Circular Array Loop
 * https://leetcode.com/problems/circular-array-loop/description/
 * You are given an array of positive and negative integers. If a number n at an index is positive, then move forward n steps. Conversely, if it's negative (-n),
 * move backward n steps. Assume the first element of the array is forward next to the last element, and the last element is backward next to the first element. 
 * Determine if there is a loop in this array. A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be "forward" 
 * or "backward'.
 * Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.
 * Example 2: Given the array [-1, 2], there is no loop.
 * Note: The given array is guaranteed to contain no element "0".
 * Can you do it in O(n) time complexity and O(1) space complexity?
 * Explanation and Code from: @GrubenM https://leetcode.com/problems/circular-array-loop/discuss/94148/Java-SlowFast-Pointer-Solution
 */

public class CircularArrayLoop {

	public static int len;
    /**
     * Moves the pointer 'i' ahead one iteration.
     */
    private static int advance(int[] nums, int i) {
        i = i + nums[i];
        if (i < 0) 
        	i = i + len;
        else if (i > len - 1) 
        	i = i % len;
        return i;
    }
    
    public static boolean circularArrayLoop(int[] nums) {
    	System.out.println("nums: "+Arrays.toString(nums)+" nums.length: "+nums.length);
    	
        // Handle bad input
        if (nums == null || nums.length < 2) 
        	return false;
        
        len = nums.length;
        
        /**
         * Check every possible start location.
         * We may start at a short-loop, for instance, but the Array
         * may still contain a valid loop.
         */
        for(int i=0; i<len; i++) {
            System.out.println("i: "+i+" nums[i]: "+nums[i]);
        	
        	/**
             * We set elements to 0 which are on known non-loop paths.
             * So, if we encounter a 0, we know we're not on a loop path.
             * So, move to the next start location in the list.
             */
            if(nums[i] == 0) 
            	continue;
            
            // Stagger our starts, so we don't conclude we've found a loop, as we might otherwise when slow == fast.
            int slow = i;
            int fast = advance(nums, slow);
            
            System.out.println("slow: "+slow+" fast: "+fast);
            
            /** 
             * Whether i is positive or negative defines our direction, so if
             * the directions differ, so too will the signs.
             * If the signs differ, we can't be in a 'forward' or a 'backward'
             * loop, so we exit the traverse.
             */
            while(nums[i] * nums[fast] > 0 && nums[i] * nums[advance(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == advance(nums, slow)) 
                    	break; // 1-element loop
                    return true;
                }
                slow = advance(nums, slow);
                fast = advance(nums, advance(nums, fast));
            }
            
            /**
             * If we're here, we didn't find a loop, so we know this path
             * doesn't have a loop, so we re-traverse it until we reverse
             * direction or encounter a '0' element.
             * During the re-traverse, we set each element we see to 0.
             */
            slow = i;
            int sgn = nums[i];
            while (sgn * nums[slow] > 0) {
                int tmp = advance(nums, slow);
                nums[slow] = 0;
                slow = tmp;
            }
        }
        
        // We've tested the whole array and have not found a loop,
        // therefore there isn't one, so return false.
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums = {2, -1, 1, 2, 2};
		
		System.out.println(circularArrayLoop(nums));
	}

}