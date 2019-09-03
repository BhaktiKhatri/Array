package Array;

import java.util.Arrays;

/*
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example: Input: [0,1,0,2,1,0,1,3,2,1,2,1]; Output: 6
 * Code from: Approach #4 Using 2 pointers https://leetcode.com/problems/trapping-rain-water/solution/
 * Explanation from: https://www.youtube.com/watch?v=pq7Xon_VXeU
 * Time complexity: O(n); Single iteration of O(n)
 * Space complexity: O(1) extra space. Only constant space required for left, right, left_max and right_max
 * Google, Amazon, Bloomberg, Twitter, Apple, Airbnb, Zenefits
 * > Medium
 */

public class TrappingRainWater {

	public static int trap(int[] height)
	{
		System.out.println("height: "+Arrays.toString(height));
		
	    int left = 0;
	    int right = height.length - 1;
	    int ans = 0;
	    int left_max = 0, right_max = 0;
	    
	    while(left < right) {
	    	System.out.println("left: "+left+" right: "+right+" height[left]: "+height[left]+" height[right]: "+height[right]);

	    	if(height[left] < height[right]) {
	            System.out.println("left_max: "+left_max+" ans: "+ans+" left: "+left);
	        	
	            if(height[left] >= left_max) {
	            	left_max = height[left];
	        	}
	            else { 
	            	ans = ans + (left_max - height[left]);
	            }
	            left++;
	        }
	        else {
	        	System.out.println("right_max: "+right_max+" ans: "+ans+" left: "+left);
	        	
	            if(height[right] >= right_max) {
	            	right_max = height[right];
	            }
	            else { 
	            	ans = ans + (right_max - height[right]);
	            }
	            right--;
	        }
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}