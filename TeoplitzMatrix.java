package Array;

/*
 * 766. Toeplitz Matrix
 * https://leetcode.com/problems/toeplitz-matrix/description/
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * Example 1: Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: True
 * Explanation: 1234
 * 				5123
 * 				9512
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same,
 * so the answer is True.
 * Example 2: Input: matrix = [[1,2],[2,2]]
 * Output: False
 * Explanation: The diagonal "[1, 2]" has different elements.
 * Note: matrix will be a 2D array of integers. matrix will have a number of rows and columns in range [1, 20]. matrix[i][j] will be integers in range [0, 99].
 * Explanation and Code from: Approach #2: Compare With Top-Left Neighbor https://leetcode.com/problems/toeplitz-matrix/solution/
 * Time Complexity: O(M*N), as defined in the problem statement.
 * Space Complexity: O(1)
 * Google
 * Easy
 */

public class TeoplitzMatrix {
	
	/*
	 * For each diagonal with elements in order a1,a2,a3,…,ak, we can check a1=a2,a2=a3,…,ak−1=ak.
	 * The matrix is Toeplitz if and only if all of these conditions are true for all (top-left to bottom-right) diagonals.
	 * Every element belongs to some diagonal, and it's previous element (if it exists) is it's top-left neighbor. Thus, for the square (r, c),
	 * we only need to check r == 0 OR c == 0 OR matrix[r-1][c-1] == matrix[r][c].
	 */

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for(int r=0; r<matrix.length; r++) {
           for(int c=0; c<matrix[0].length; c++) {
        
        	   if(r > 0 && c > 0) 
        		   System.out.println("r: "+r+" c: "+c+" matrix[r-1][c-1]: "+matrix[r-1][c-1]+" matrix[r][c]: "+matrix[r][c]);
        	   
        	   if(r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    //Refer this
    //code from: @shawngao https://leetcode.com/problems/toeplitz-matrix/discuss/113417/Java-solution-4-liner.
    public static boolean isToeplitzMatrix1(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
            	System.out.println("i: "+i+" j: "+j+" matrix[i][j]: "+matrix[i][j]+" matrix[i+1][j+1]: "+matrix[i+1][j+1]);
                if (matrix[i][j] != matrix[i + 1][j + 1]) 
                	return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {
							{1,2,3,4},
							{5,1,2,3},
							{9,5,1,2}
						 };
		
		System.out.println(isToeplitzMatrix1(matrix));
	}

}
