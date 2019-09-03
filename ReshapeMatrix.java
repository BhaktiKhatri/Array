package Array;

/**
 * Leetcode 566. Reshape the Matrix
 * https://leetcode.com/problems/reshape-the-matrix/description/
 * @author NisuBhakti
 * Time Complexity: O(m*n). We traverse the entire matrix of size m*n once only. Here, m and n refers to the number of rows and columns in the given matrix
 * Space complexity : O(m*n). The resultant matrix of size m*n is used.
 */

public class ReshapeMatrix {

	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int n = nums.length, m = nums[0].length;
		if(r*c != n*m)
			return nums;
		
		int[][] result = new int[r][c];
		for(int i=0; i<r*c; i++) {
			System.out.println("i/c: "+(i/c)+" i%c: "+(i%c)+" i/m: "+(i/m)+" i%m: "+(i%m));
			result[i/c][i%c] = nums[i/m][i%m];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,2},{3,4}};
		arr = matrixReshape(arr, 1, 4);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
		}
		
	}

}
