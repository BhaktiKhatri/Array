package Array;

import java.util.Arrays;

/*
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/description/
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Example 1: Input: [3,2,3]; Output: 3
 * Example 2: Input: [2,2,1,1,1,2,2]; Output: 2
 * Explanation and Code from: https://www.youtube.com/watch?v=zOyOwDEF1Rc
 * Time complexity: {O}(n)
 * Boyer-Moore performs constant work exactly n times, so the algorithm runs in linear time.
 * Space complexity: O(1); Boyer-Moore allocates only constant additional memory.
 * Zenefits, Adobe
 * Medium
 */

public class MajorityElement {

    public static int majorityElement(int[] nums) {
    	if(nums.length == 0 || nums == null) {
    		return -1;
    	}
    	
    	System.out.println(Arrays.toString(nums));
    	
    	int candidate = 0;
    	int count = 0;
    	
    	for(int num: nums) {
    		System.out.println("num: "+num+" count: "+count+" candidate: "+candidate);
    		if(count == 0) {
    			candidate = num;
    			count = 1;
    		}
    		else {
    			if(candidate == num) {
    				count++;
    			}
    			else {
    				count--;
    			}
    		}
    	}
    	
    	System.out.println("count: "+count+" candidate: "+candidate);
    	
    	if(count == 0)
    		return -1;
    	
    	count = 0;
    	for(int num: nums) {
    		if(candidate == num) {
    			count++;
    		}
    	}
    	
    	System.out.println("count: "+count+" candidate: "+candidate+" num.length: "+nums.length);
    	
    	return (count > nums.length/2) ? candidate : -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		System.out.println(majorityElement(nums));
	}

}
