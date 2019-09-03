package Array;

import java.util.Arrays;

/**
 * Leetcode 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description/
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two 
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the 
 * most water.
 * Explanation and Code from: Approach #2 (Two Pointer Approach) https://leetcode.com/problems/container-with-most-water/solution/
 * https://rekinyz.wordpress.com/2015/01/28/find-container-with-most-water/
 * Time complexity: O(n). Single pass; Space complexity: O(1) Constant space is used.
 * Bloomberg
 * Medium
 */

public class ContainerWithMostWater {

	/**
	 * To simply the question, we can just imagine that we want to build a water container using two walls with different height in a river. 
	 * Because of the gravity, only the lowest wall decides how much water it can retain. Suppose we get the height of the walls in certain order, 
	 * for instance: if the height of the walls are { 9, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1 }, the maximal volume should be 6*3=18 (lowest wall=6, distance=3);
	 * Or if the height of walls are { 1, 2, 8, 9, 1, 1, 1, 1, 1, 1, 2 }, the maximal volume should be 2*9=18 (lowest wall=2, distance=9).
	 * 
	 * The basic idea was that we hope the lowest wall will be as high as possible and the distance between two walls as far as possible. 
	 * So we can put two pointers start at the head and tail of the wall list and let them moving towards. One pointer moves one step forward only when 
	 * it’s height is lower than the other side, say we want to find the highest walls from both side of the river and updating the maximal volume 
	 * each step while they moving towards.
	 * @param height array
	 * @return max area
	 */
	
	public static int maxArea(int[] height) {
		int maxArea = 0, l = 0, r = height.length - 1;
		
		System.out.println("height: "+Arrays.toString(height));
		
		while(l < r) {
			
			System.out.println("l: "+l+" r: "+r+" (r-l): "+(r-l)+" maxArea: "+maxArea+" height[l]: "+height[l]+" height[r]: "+height[r]+" ");
			
			maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r-l));
			
			if(height[l] < height[r]) {
				l++;
			}
			else {
				r--;
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,8,6,2,5,4,8,3,7};	//{1, 5, 4, 3};
		System.out.println(maxArea(arr));
	}

}
