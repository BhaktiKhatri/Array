package Array;

import java.util.Arrays;

/**
 * Leetcode 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/description/
 * Explanation and Code from https://leetcode.com/problems/unique-paths-ii/discuss/23250/
 * Follow up for "Unique Paths": Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *	[
 *	  [0,0,0],
 *	  [0,1,0],
 *	  [0,0,0]
 *	]
 * The total number of unique paths is 2
 * Explanation and Code from: @tusizi https://leetcode.com/problems/unique-paths-ii/discuss/23250/Short-JAVA-solution?page=2
 * https://blog.csdn.net/linhuanmars/article/details/22135231
 * Time Complexity: O(N^2)
 * Bloomberg
 * Medium
 */

public class UniquePaths2 {

	/* A utility function to print a 2D matrix */
    public static void printMatrix(int matrix[][])
    {
        int i, j;
        for (i=0; i<matrix.length; i++)
        {
            for(j=0; j<matrix[0].length; j++)
            {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
	
	/*
		 dp[j] += dp[j - 1]; is dp[j] = dp[j] + dp[j - 1];
		 which is new dp[j] = old dp[j] + dp[j-1]
		 which is current cell = top cell + left cell
		 
		 Array dp stores the number of paths which passing this point. The whole algorithm is to sum up the paths from left grid and up grid. 
		 'if (row[j] == 1) dp[j] = 0; means if there is an obstacle at this point. All the paths passing this point will no longer valid. 
		 In other words, the grid right of the obstacle can be reached only by the grid which lies up to it.

		This question is very similar to Unique Paths , except that this question adds hurdles to the robot, not every time there are 
		two choices ( Right, down). Because of this condition, the last method of direct combination in Unique Paths does not apply. 
		The best solution here is to use dynamic programming. Recursion is still the same as Unique Paths , but each time we have to 
		judge whether it is an obstacle, if yes, then res[i][j]=0, otherwise it is res[i][j]=res[i-1] [j]+res[i][j-1]. 
		In the implementation still only need a one-dimensional array, because the information needed when updating is enough. 
		This space complexity is O(n) (as analyzed in Unique Paths . 
		If we want to be more rigorous, we can go to the row and column of the small one, and then put the small one in the inner loop. 
		The space complexity is O(min). (m,n)) The time complexity is still O(m*n).
	
		dp[j] is the paths number to column j in the current row
	 */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    int width = obstacleGrid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    
	    System.out.println("dp: "+Arrays.toString(dp));
	    
	    for(int[] row: obstacleGrid) {
	    	System.out.println("row: "+Arrays.toString(row));
	    	
	        for(int j=0; j<width; j++) {
	            
	        	System.out.println("j: "+j+" row[j]: "+row[j]);
	        	
	        	if(row[j] == 1) {
	                dp[j] = 0;
	            }
	            else if(j > 0) {
	            	
	            	System.out.println("j: "+j+" dp[j]: "+dp[j]+" dp[j-1]: "+dp[j-1]);
	                dp[j] = dp[j] + dp[j - 1];
	            }
	        }
	    }
	    
	    System.out.println("dp: "+Arrays.toString(dp));
	    return dp[width - 1];
	}
	
	//https://www.youtube.com/watch?v=AmRvCR6B5no
	//http://www.goodtecher.com/leetcode-63-unique-paths-ii/
	public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        int[][] paths = new int[rows][cols];
        
        // first column
        for(int i=0; i<rows; i++) {
            System.out.println("i: "+i+" obstacleGrid[i][0]: "+obstacleGrid[i][0]);
        	
        	if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } 
            else {
                break;
            }
        }
        
        // first row
        for(int j=0; j<cols; j++) {
        	System.out.println("j: "+j+" obstacleGrid[0][j]: "+obstacleGrid[0][j]);
            
        	if(obstacleGrid[0][j] != 1) {
                paths[0][j] = 1;
            } 
            else {
                break;
            }
        }
        
        // for spaces not at first row or first column
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
            	System.out.println("i: "+i+" j: "+j+" obstacleGrid[i][j]: "+obstacleGrid[i][j]);
            	
            	if(obstacleGrid[i][j] != 1) {
            		System.out.println("paths[i - 1][j]: "+paths[i - 1][j]+" paths[i][j - 1]: "+paths[i][j - 1]);
                    
            		paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }                
            }
        }
        
        return paths[rows - 1][cols - 1];
    }
	
	public static void main(String[] args) {
		int[][] grid = {
		                {0,0,0},
		                {0,1,0},
		                {0,0,0}
					   };
		
		printMatrix(grid);
		System.out.println(uniquePathsWithObstacles1(grid));
		printMatrix(grid);
	}

}
