package Array;

import java.util.Arrays;

/*
 * 498. Diagonal Traverse
 * https://leetcode.com/problems/diagonal-traverse/
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * Example: Input:
			[
			 [ 1, 2, 3 ],
			 [ 4, 5, 6 ],
			 [ 7, 8, 9 ]
			]
	Output:  [1,2,4,7,5,3,6,8,9]
	Note: The total number of elements of the given matrix will not exceed 10,000
 * Explanation and Code from: @yuxiangmusic https://leetcode.com/problems/diagonal-traverse/discuss/97711/Java-15-lines-without-using-boolean
 */

public class DiagonalTraverse {

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) { 
        	return new int[0];
        }
        
        int r = 0;
        int c = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int arr[] = new int[m * n];
        
        System.out.println("m: "+m+" n: "+n);
        
        for(int i=0; i<arr.length; i++) {
        	System.out.println("i: "+i+" r: "+r+" c: "+c+" r + c: "+(r+c));
        	
            arr[i] = matrix[r][c];
            System.out.println("arr[i]: "+arr[i]+" (r + c) % 2: "+((r + c) % 2));
            
            if((r + c) % 2 == 0) { 	// moving up; when moving up in image row-- and col++
                if(c == n - 1) { 	//when in last col then last up-diagonal is 8-9 so move row from 3-6-9 so row++ 
                	r++; 			//{r,c}: {0,2}=3,{2,2}=9
                }
                else if(r == 0) { 	//if row=0 then cannot decrease row so just do col++
                	c++; 			//{r,c}: {0,0}=1
                }
                else { 
                	r--; 			//when moving up in image row-- and col++
                	c++; 			//{r,c}: {2,0}=7,{2,2}=5
                }
            } 
            else {                	// moving down; when moving down in image row++ and col--
                if(r == m - 1) {  	//when in last row then down-diagonal increases col from 4-7;8-9 so do col++
                	c++; 			//{r,c}: {2,1}=6
                }
                else if(c == 0) {	//if col=0 then cannot decrease col so just do row++
                	r++; 			//{r,c}: {1,0}=4,
                }
                else { 				// when moving down in image row++ and col--
                	r++; 			//{r,c}: {0,1}=2,{1,2}=6
                	c--; 
                }
            }   
        }   
        System.out.println("arr: "+Arrays.toString(arr));
        
        return arr;
    }

	
	public static void main(String[] args) {
		int[][] matrix = {
							{ 1, 2, 3 },
							{ 4, 5, 6 },
							{ 7, 8, 9 }
						 };
		printMatrix(matrix);
		int[] result = findDiagonalOrder(matrix);
		System.out.println("result: "+Arrays.toString(result));
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}
	}
	

}
