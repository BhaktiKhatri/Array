package Array;

/**
 * Leetcode 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right. The first integer of each row is greater than the last integer of the previous row.
 * For example, Consider the following matrix:
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
 * Given target = 3, return true.
 * Explanation from: https://www.youtube.com/watch?v=ZhG1M_FzxgI
 * Code from: https://www.ideserve.co.in/learn/search-a-sorted-matrix
 * Time Complexity is O(n); Space Complexity is O(1)
 * Medium
 */

public class Search2DMatrix {

	//rows and columns are sorted
	//stair search - start from top right and check if element is greater than matrix element then move down 
	//else if element is less than matrix element then move left
	public static boolean searchMatrix(int matrix[][], int element) {
		if(matrix.length == 0 || matrix[0].length == 0)
            return false;
		
		int n = matrix.length;
		System.out.println("n: "+n);
		
		if(element < matrix[0][0] || element > matrix[matrix.length-1][matrix[0].length-1]) 
			return false;
		
		int r = 0; 			// row
		int c = matrix[0].length-1;		// column
		
		System.out.println("r: "+r+" c: "+c+" element: "+element);
		
		while(r <= n-1 && c >= 0) {
			
			System.out.println("r: "+r+" c: "+c+" matrix[r][c]: "+matrix[r][c]+" element: "+element);
			
			if(element > matrix[r][c]) { 
				r++;
			}
			else if(element < matrix[r][c]) {
				c--;
			}
			else {
				return true;
			}
		}
		return false;
	}

	//Time Complexity: O(logmn)
	//Refer this: @chase1991 https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
	//https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        System.out.println("rows: "+rows+" cols: "+cols);

        int start = 0;
        int end = rows * cols - 1;
        System.out.println("start: "+start+" end: "+end+" target: "+target);
        
        while(start <= end) {
        	System.out.println("start: "+start+" end: "+end);
        	
            int mid = (start + end) / 2;
            System.out.println("mid: "+mid+" mid/cols: "+(mid/cols)+" mid % cols: "+(mid % cols)+" matrix[mid / cols][mid % cols]: "+matrix[mid / cols][mid % cols]);
            
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            } 
            else if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }
        return false;
    }

	
	
	public static void main(String[] args) {
		int[][] matrix = {  {1,   3,  5,  7},
				  			{10, 11, 16, 20},
				  			{23, 30, 34, 50} 
				  		};
		int target = 3;
		boolean ans = searchMatrix1(matrix, target);
		System.out.println(ans);
	}
}