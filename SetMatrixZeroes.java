package Array;

import java.util.Arrays;

/**
 * Leetcode 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Explanation and Code from: https://www.geeksforgeeks.org/a-boolean-matrix-question/
 * https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
 * Time Complexity: O(M*N), Auxiliary Space: O(1)
 * Microsoft, Amazon
 * Medium
 */

public class SetMatrixZeroes {
	    
    /* A utility function to print a 2D matrix */
    public static void printMatrix(int matrix[ ][ ], int R, int C)
    {
        int i, j;
        for (i = 0; i < R; i++)
        {
            for (j = 0; j < C; j++)
            {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
    
    public static void modifyMatrix(int matrix[][])
    {
    	int R = matrix.length;
    	int C = matrix[0].length;

    	int row[]= new int[R];
        int col[]= new int[C];
        int i, j;
     
        /* Initialize all values of row[] as 1 */
        for(i=0; i<R; i++)
        {
        	row[i] = 1;
        }
     
        /* Initialize all values of col[] as 1 */
        for(i=0; i<C; i++)
        {
        	col[i] = 1;
        }
     
        /* Store the rows and columns to be marked as 1 in row[] and col[] arrays respectively */
        for(i=0; i<R; i++)
        {
            for (j=0; j<C; j++)
            {
            	System.out.println("i: "+i+" j: "+j+" matrix[i][j]: "+matrix[i][j]);
                if(matrix[i][j] == 0)
                {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
     
        System.out.println("row: "+Arrays.toString(row));
        System.out.println("col: "+Arrays.toString(col));
        
        /* Modify the input matrix matrix[] using the above constructed row[] and col[] arrays */
        for(i=0; i<R; i++)
        {
            for(j=0; j<C; j++)
            {
            	System.out.println("i: "+i+" row[i]: "+row[i]+" j: "+j+" col[j]: "+col[j]+" matrix[i][j]: "+matrix[i][j]);
                if(row[i] == 0 || col[j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
	public static void main(String[] args) {		
		int matrix[][] =   { 	{0, 1, 2, 0},
			                {3, 4, 5, 2},
			                {1, 3, 1, 5}
			            };
           
      System.out.println("Matrix Intially");
      printMatrix(matrix, 3, 4);
   
      modifyMatrix(matrix);
      System.out.println("Matrix after modification");
      printMatrix(matrix, 3, 4);
	}
}
