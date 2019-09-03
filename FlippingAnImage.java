package Array;

import java.util.Arrays;

/*
 * 832. Flipping an Image
 * https://leetcode.com/problems/flipping-an-image/description/
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * Example 1: Input: [[1,1,0],[1,0,1],[0,0,0]]; Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]]. Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2: Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]; Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]. 
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes: 1 <= A.length = A[0].length <= 20; 0 <= A[i][j] <= 1
 * Explanation and Code from: https://leetcode.com/problems/flipping-an-image/discuss/130590/C++JavaPython-Reverse-and-Toggle
 * https://leetcode.com/problems/flipping-an-image/solution/
 * Time Complexity: O(N), where N is the total number of elements in A.
 * Space Complexity: O(1) in additional space complexity.
 * Google
 * Easy
 */

public class FlippingAnImage {

	/*
	 * reverse every row.
	 * toggle every value.
	 * In java, I did both steps together.
	 * I compared the i th and n - i - 1 th in a row.
	 * If they are different, we do nothing. Otherwise we toggled both.
	 * 
	 */
	
    public static int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        
        for(int[] row : A) {
        	System.out.println("row: "+Arrays.toString(row));
        	
            for(int i = 0; i * 2 < n; i++) {
            	System.out.println("i: "+i+" row[i]: "+row[i]+" row[n - i - 1]: "+row[n - i - 1]);
            	
            	if (row[i] == row[n - i - 1]) {
                    int tmp = row[i] ^ 1;
                    row[i] = row[n - 1 - i] ^ 1;
                    row[n - 1 - i] = tmp;
                }
            }
            System.out.println("row1: "+Arrays.toString(row));
        }
        return A;
    }
	
	public static void main(String[] args) {
		int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
		System.out.println(flipAndInvertImage(A));
	}

}
