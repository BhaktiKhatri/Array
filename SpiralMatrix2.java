package Array;

import java.util.Arrays;

/**
 * Leetcode 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 * Code from https://leetcode.com/problems/spiral-matrix-ii/discuss/22289
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example, Given n = 3, You should return the following matrix:
 *	[
 *	 [ 1, 2, 3 ],
 *	 [ 8, 9, 4 ],
 *	 [ 7, 6, 5 ]
 *	]
 * @author NisuBhakti
 * Time Complexity: O(N)
 */

public class SpiralMatrix2 {

	public static int[][] generateMatrix(int n) {
        // Declaration
        int[][] matrix = new int[n][n];
        
        // Edge Case
        if (n == 0) {
            return matrix;
        }
        
        System.out.println("n: "+n);
        
        // Normal Case
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; //change
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
        	
        	System.out.println("rowStart: "+rowStart+" rowEnd: "+rowEnd+" colStart: "+colStart+" colEnd: "+colEnd);
        	
            for(int i=colStart; i<=colEnd; i++) {		//1,2,3; 9
            	System.out.println("i: "+i+" matrix[rowStart][i]: "+matrix[rowStart][i]+" num: "+num);
                
            	matrix[rowStart][i] = num++; 	//change
            }
            rowStart++;
            
            System.out.println("rowStart: "+rowStart+" rowEnd: "+rowEnd+" colStart: "+colStart+" colEnd: "+colEnd);
            
            for(int i=rowStart; i<=rowEnd; i++) {		//4,5
            	System.out.println("i: "+i+" matrix[i][colEnd]: "+matrix[i][colEnd]+" num: "+num);
                
            	matrix[i][colEnd] = num++; 		//change
            }
            colEnd--;
            
            System.out.println("rowStart: "+rowStart+" rowEnd: "+rowEnd+" colStart: "+colStart+" colEnd: "+colEnd);
            
            for(int i=colEnd; i>=colStart; i--) {		//6,7,8
                
            	System.out.println("i: "+i+" matrix[rowEnd][i]: "+matrix[rowEnd][i]+" num: "+num);
            	
            	if(rowStart <= rowEnd) {
                    matrix[rowEnd][i] = num++; //change
            	}
            }
            rowEnd--;
            
            System.out.println("rowStart: "+rowStart+" rowEnd: "+rowEnd+" colStart: "+colStart+" colEnd: "+colEnd);
            
            for(int i=rowEnd; i>=rowStart; i--) {		//9
                
            	System.out.println("i: "+i+" matrix[i][colStart]: "+matrix[i][colStart]+" num: "+num);
            	
            	if(colStart <= colEnd) {
                    matrix[i][colStart] = num++; //change
                }
            }
            colStart++;
            
            System.out.println("rowStart: "+rowStart+" rowEnd: "+rowEnd+" colStart: "+colStart+" colEnd: "+colEnd);
        }
        
        return matrix;
    }
	
	/* A utility function to print a 2D matrix */
    public static void printMatrix(int matrix[][])
    {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
	
	public static void main(String[] args) {
		int[][] arr = generateMatrix(3);
		printMatrix(arr);
	}

}
