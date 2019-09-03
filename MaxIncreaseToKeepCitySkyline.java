package Array;

import java.util.Arrays;

/*
 * 807. Max Increase to Keep City Skyline
 * In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any 
 * number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well. 
 * At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the 
 * original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.
 * What is the maximum total sum that the height of the buildings can be increased?
 * Example:Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]] Output: 35
 * Explanation: 
 * The grid is:
	[ [3, 0, 8, 4], 
	  [2, 4, 5, 7],
	  [9, 2, 6, 3],
	  [0, 3, 1, 0] ]

	The skyline viewed from top or bottom is: [9, 4, 8, 7]
	The skyline viewed from left or right is: [8, 7, 9, 3]

	The grid after increasing the height of buildings without affecting skylines is:

	gridNew = [ [8, 4, 8, 7],
	            [7, 4, 7, 7],
	            [9, 4, 8, 7],
	            [3, 3, 3, 3] ]
 * Time Complexity: O(N^2), where N is the number of rows (and columns) of the grid. We iterate through every cell of the grid.
 * Space Complexity: O(N), the space used by row_maxes and col_maxes.
 * Code from: https://leetcode.com/problems/max-increase-to-keep-city-skyline/discuss/120681/C%2B%2BJavaPython-Easy-and-Concise-Solution
 * Explanation from: https://www.youtube.com/watch?v=kSHqmx0jltI  https://leetcode.com/problems/max-increase-to-keep-city-skyline/solution/
 */

public class MaxIncreaseToKeepCitySkyline {
	
	/*
	 * The skyline looking from the top is col_maxes = [max(column_0), max(column_1), ...]. Similarly, the skyline from the left is 
	 * row_maxes [max(row_0), max(row_1), ...]
	 * In particular, each building grid[r][c] could become height min(max(row_r), max(col_c)), and this is the largest such height. 
	 * If it were larger, say grid[r][c] > max(row_r), then the part of the skyline row_maxes = [..., max(row_r), ...] would change.
	 * These increases are also independent (none of them change the skyline), so we can perform them independently.
	 * 
	 * 
	 * Idea: For grid[i][j], it can't be higher than the maximun of its row nor the maximum of its col.
	 * So the maximum increasing height for a building at (i, j) is min(row[i], col[j]) - grid[i][j]
	 * Codes: row: maximum for every row; col: maximum for every col
	 * The fisrt loop of grid calcule maximum for every row and every col.
	 * The second loop calculate the maximum increasing height for every building.
	 */

	public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] col = new int[m];
        int[] row = new int[n];
        
        System.out.println("n: "+n);
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
            	
            	System.out.println("i: "+i+" j: "+j+" row[i]: "+row[i]+" col[j]: "+col[j]+" grid[i][j]: "+grid[i][j]);
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        
        System.out.println("row: "+Arrays.toString(row)+" col: "+Arrays.toString(col));
        
        int res = 0;
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
            	System.out.println("i: "+i+" j: "+j+" row[i]: "+row[i]+" col[j]: "+col[j]+" grid[i][j]: "+grid[i][j]+" res: "+res);
                res = res + Math.min(row[i], col[j]) - grid[i][j];
            }
        }
        System.out.println("res: "+res);
        
        return res;
    }
	
	public static void main(String[] args) {
		int[][] grid = { {3, 0, 8, 4}, 
		                 {2, 4, 5, 7},
		                 {9, 2, 6, 3},
		                 {0, 3, 1, 0} };
		
		System.out.println(maxIncreaseKeepingSkyline(grid));
	}
}