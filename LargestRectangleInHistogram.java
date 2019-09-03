package Array;

import java.util.Arrays;
import java.util.Stack;

/*
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * Example: Input: [2,1,5,6,2,3]; Output: 10
 * Explanation and Code from: Approach #5 (Using Stack) https://leetcode.com/problems/largest-rectangle-in-histogram/solution/
 * https://www.youtube.com/watch?v=ZmnqCZp9bBs&t=9s
 * Time complexity : O(n); n numbers are pushed and popped
 * Space complexity : O(n); Stack is used
 * Medium
 */

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        System.out.println("heights: "+Arrays.toString(heights));
        int maxarea = 0;
        
        for(int i=0; i<heights.length; i++) {

        	System.out.println("i: "+i+" heights[i]: "+heights[i]+" stack: "+stack+" stack.peek(): "+stack.peek()+" maxarea: "+maxarea);
        	while(stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        
        System.out.println("maxarea: "+maxarea+" stack.peek(): "+stack.peek());

        while(stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        }
        
        System.out.println("maxarea: "+maxarea);
        return maxarea;
    }

	
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(heights));
	}

}
