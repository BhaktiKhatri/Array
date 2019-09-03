package Array;

import java.util.Arrays;

/**
 * Leetcode 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/description/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below). 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Example 1: Input: m = 3, n = 2; Output: 3; Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2: Input: m = 7, n = 3; Output: 28
 * Explanation from: https://www.youtube.com/watch?v=GO5QHC_BmvM
 * Code from: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/NumberOfPathsInMxNMatrix.java
 * http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * Time Complexity: O(m*n)
 * Bloomberg
 * Medium
 */

public class UniquePaths {

	public static int uniquePaths(int m, int n) {
		int[][] count = new int[m][n];
		
		for(int i=0; i<m; i++) {
			count[i][0] = 1;
		}
		
		for(int j=0; j<n; j++) {
			count[0][j] = 1;
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				count[i][j] = count[i-1][j] + count[i][j-1];
			}
		}
		
		return count[m-1][n-1];
	}
	
	
	/*
	 * 		dp[j] = dp[j] + dp[j-1];
	 * 		current dp[j] (for i=1) = previous row dp[j] (for i-1) + current row previous column dp[j-1]
	 * 		dp[j](current loop with i) = dp[j](last loop with i-1) + dp[j-1] (previous col j-1 in current loop with i)  
	 *      https://www.youtube.com/watch?v=RZz5M3iidBI
	 *      O(N) space; N = number of elements in column
	 */
    public static int uniquePaths1(int cols, int rows) {
        int[] dp = new int[cols];
                
        System.out.println("cols: "+cols+" rows: "+rows);
        
        for(int i=0;i<cols;i++) {
            dp[i] = 1;          //1st row; i.e. previous top row-0 for current row-1
        }
        System.out.println("dp: "+Arrays.toString(dp));
        
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
            	System.out.println("i: "+i+" j: "+j+" dp[j]: "+dp[j]+" dp[j-1]: "+dp[j-1]+" dp: "+Arrays.toString(dp));
            	
                dp[j] = dp[j] + dp[j-1];
            }
        } 
        
        System.out.println("dp: "+Arrays.toString(dp));
        
        return dp[cols-1];
    }

	
	public static void main(String[] args) {
		int m = 7;
		int n = 3;
		System.out.println(uniquePaths1(m, n));
	}

}
