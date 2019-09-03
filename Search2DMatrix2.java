package Array;

/*
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right. Integers in each column are sorted in ascending from top to bottom.
 * Consider the following matrix:
 * 	[
 * 	  [1,   4,  7, 11, 15],
 * 	  [2,   5,  8, 12, 19],
 * 	  [3,   6,  9, 16, 22],
 * 	  [10, 13, 14, 17, 24],
 * 	  [18, 21, 23, 26, 30]
 * 	]
 * Example 1: Input: matrix, target = 5; Output: true
 * Example 2: Input: matrix, target = 20; Output: false
 * Time Complexity is O(n); Space Complexity is O(1)
 * Google, Amazon, Apple
 * Medium
 */

public class Search2DMatrix2 {

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

		public static void main(String[] args) {
			int[][] matrix = {  {1,   3,  5,  7},
					  			{10, 11, 16, 20},
					  			{23, 30, 34, 50} 
					  		};
			int target = 13;
			boolean ans = searchMatrix(matrix, target);
			System.out.println(ans);
		}
}
