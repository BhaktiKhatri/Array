package Array;

import java.util.Arrays;
import java.util.Stack;

/*
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/description/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * Example: Input:
 * [
 *	  ["1","0","1","0","0"],
 *	  ["1","0","1","1","1"],
 *	  ["1","1","1","1","1"],
 *	  ["1","0","0","1","0"]
 * ]
 * Output: 6
 * Explanation from: https://www.youtube.com/watch?v=g8bSdXCG-lA
 * Code from: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MaximumRectangularSubmatrixOf1s.java
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/stackqueue/MaximumHistogram.java
 * https://leetcode.com/problems/largest-rectangle-in-histogram/solution/
 * Facebook
 * > Medium
 */

public class MaximalRectangle {

    public static int maximalRectangle(int[][] matrix) {
        if(matrix.length == 0)
            return 0;
        
        int temp[] = new int[matrix[0].length];
        int maxArea = 0;
        int area = 0;
        
        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < temp.length; j++) {
            	//System.out.println("i: "+i+" j: "+j+" matrix[i][j]: "+matrix[i][j]);
            	
                if(matrix[i][j] == 0) {
                    temp[j] = 0;
                }
                else {
                    temp[j] = temp[j] + matrix[i][j];
                }
            }
        }
        
        area = largestRectangleArea(temp);
        if(area > maxArea) {
            maxArea = area;
        }
        return maxArea;
    }

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
//		char[][] matrix = {
//								{'1','0','1','0','0'},
//								{'1','0','1','1','1'},
//								{'1','1','1','1','1'},
//								{'1','0','0','1','0'}
//						 };
		
		int[][] matrix = 	{
									{1,0,1,0,0},
									{1,0,1,1,1},
									{1,1,1,1,1},
									{1,0,0,1,0}
							 };

		System.out.println(maximalRectangle(matrix));
	}
}
