package Array;

 /**
  * Leetcode 695. Max Area of Island 
  * https://leetcode.com/problems/max-area-of-island/description/
  * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
  * @author NisuBhakti
  * Time Complexity: O(mn)
  */

public class MaxAreaOfIsland {

	//The idea is to count the area of each island using dfs. During the dfs, we set the value of each point in the island to 0
	public static int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
            	System.out.println("i: "+i+" j: "+j+" grid[i][j]: "+grid[i][j]);
                if(grid[i][j] == 1) {
                	max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
                }
            }
        }
        return max_area;
    }
    
    public static int AreaOfIsland(int[][] grid, int i, int j) {
    	if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)
    		System.out.println("area i: "+i+" j: "+j+" grid[i][j]: "+grid[i][j]);
    	
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
        	System.out.println("i: "+i+" j: "+j);
        	
        	grid[i][j] = 0;
        	int count = 1;
        	
            count = count + AreaOfIsland(grid, i-1, j);
            count = count + AreaOfIsland(grid, i+1, j);
            count = count + AreaOfIsland(grid, i, j-1);
            count = count + AreaOfIsland(grid, i, j+1);
            
            return count; 
        }
        return 0;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {
		        {1,1,1,1,0},
		        {1,1,0,1,0},
		        {1,1,0,0,0},
		        {0,0,0,0,0},
	        };
		System.out.println(maxAreaOfIsland(matrix));
	}

}
