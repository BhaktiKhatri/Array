package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order
 * @author NisuBhakti
 * For example, Given the following matrix:
 * 	[
 * 	 [ 1, 2, 3 ],
 * 	 [ 4, 5, 6 ],
 * 	 [ 7, 8, 9 ]
 * 	]
 * You should return [1,2,3,6,9,8,7,4,5]
 * Example 2: Input:
 * 	[
 * 	  [1, 2, 3, 4],
 * 	  [5, 6, 7, 8],
 * 	  [9,10,11,12]
 * 	]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * Time Complexity: O(N), where N is the total number of elements in the input matrix. We add every element in the matrix to our final answer.
 * Space Complexity: O(N), the information stored in ans
 * Microsoft, Google, Uber
 * Medium
 */

public class SpiralMatrix {

	    public static List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> ans = new ArrayList<Integer>();
	        if (matrix.length == 0)
	            return ans;
	        
	        int r1 = 0, r2 = matrix.length - 1;
	        int c1 = 0, c2 = matrix[0].length - 1;
	        
	        while(r1 <= r2 && c1 <= c2) {
	            
	        	for(int c=c1; c<=c2; c++) {
	        		System.out.println("matrix[r1][c]: "+matrix[r1][c]+" ans: "+ans);
	        		ans.add(matrix[r1][c]);					//1,2,3	//1,2,3,6,9,8,7,4,5
	        	}
	        	
	            for(int r=r1+1; r<=r2; r++) { 				//1,2,3,6,9
	            	System.out.println("matrix[r][c2]: "+matrix[r][c2]+" ans: "+ans);
	            	ans.add(matrix[r][c2]);
	            }
	            
	            if(r1 < r2 && c1 < c2) {
	            	System.out.println("r1: "+r1+" r2: "+r2+" c1: "+c1+" c2: "+c2);
	            	
	            	for(int c=c2-1; c>c1; c--) {
	            		System.out.println("matrix[r2][c]: "+matrix[r2][c]+" ans: "+ans);
	            		ans.add(matrix[r2][c]);				//1,2,3,6,9,8
	            	}
	            
	            	for(int r=r2; r>r1; r--) {
	            		System.out.println("matrix[r][c1]: "+matrix[r][c1]+" ans: "+ans);
	            		ans.add(matrix[r][c1]);				//1,2,3,6,9,8,7,4
	            	}
	            }
	            r1++;
	            r2--;
	            c1++;
	            c2--;
	        }
	        return ans;
	    }
	
	public static void main(String[] args) {
//		int[][] matrix = {  { 1, 2, 3 },
//							{ 4, 5, 6 },
//							{ 7, 8, 9 } 
//						 };
		
		int[][] matrix = {{3},{2}};

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println(spiralOrder(matrix));
	}
}