package Array;

/**
 * Leetcode 64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * https://leetcode.com/problems/minimum-path-sum/description/
 * Example 1:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]; Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * Code: Approach #4 https://leetcode.com/problems/minimum-path-sum/solution/
 * Explanation from: https://www.youtube.com/watch?v=lBRtnuxg-gU
 * Time Complexity: O(m*n). We traverse the entire matrix once. Space Complexity: O(1). No extra space is used.
 * Medium
 */

public class MinimumPathSum {
	
	/* A utility function to print a 2D matrix */
    public static void printMatrix(int matrix[][])
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

	public static int minPathSum(int[][] grid) {
		System.out.println("grid.length: "+grid.length+" grid[0].length: "+grid[0].length);
		
        for(int i=grid.length - 1; i >= 0; i--) {
            for(int j=grid[0].length - 1; j >= 0; j--) {
            	
            	System.out.println("i: "+i+" j: "+j+" grid[i][j]: "+grid[i][j]);
            	
                if(i == grid.length - 1 && j != grid[0].length - 1) {	//last row first two elements 
                
                	System.out.println("-----1-----grid[i][j]: "+grid[i][j]+" grid[i][j + 1]: "+grid[i][j + 1]);
                    grid[i][j] = grid[i][j] +  grid[i][j + 1];
                }
                else if(j == grid[0].length - 1 && i != grid.length - 1) {	//middle/first row last element

                	System.out.println("-----2-----grid[i][j]: "+grid[i][j]+" grid[i + 1][j]: "+grid[i + 1][j]);
                	grid[i][j] = grid[i][j] + grid[i + 1][j];
                }
                else if(j != grid[0].length - 1 && i != grid.length - 1) {	//middle row first two elements
                    
                	System.out.println("-----3-----grid[i][j]: "+grid[i][j]+" grid[i + 1][j]: "+grid[i + 1][j]+" grid[i][j + 1]: "+grid[i][j + 1]);
                	grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j],grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }
	
	public static void main(String[] args) {
		int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
		printMatrix(grid);
		System.out.println(minPathSum(grid));
		printMatrix(grid);
	}

}
