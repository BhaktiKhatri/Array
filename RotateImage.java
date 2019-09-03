package Array;

/**
 * Leetcode 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/description/
 * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
 * Given input matrix = 
	[
	  [1,2,3],
	  [4,5,6],
	  [7,8,9]
	],
	
	rotate the input matrix in-place such that it becomes:
	[
	  [7,4,1],
	  [8,5,2],
	  [9,6,3]
	]
 * Explanation and Code from: https://leetcode.com/problems/rotate-image/discuss/18872?page=1
 * Time Complexity: O(N^2); Space Complexity: O(1)
 * Medium
 * Microsoft, Amazon, Apple
 */

public class RotateImage {
		
	public static void antiRotate(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			int s = 0;
			int e = matrix.length - 1;
			
			while(s < e) {
		        int temp = matrix[i][s];
		        matrix[i][s] = matrix[i][e];
		        matrix[i][e] = temp;
		        s++;
		        e--;
		        System.out.println("s: "+s+" e: "+e);
		    }
		}
		
	    System.out.println();
	    printMatrix(matrix);
	    
		for(int i = 0; i < matrix.length; i++) {
	        for(int j = i+1; j < matrix[i].length; j++) {
	        	System.out.println("i: "+i+" j: "+j+" matrix[i][j]: "+matrix[i][j]+" matrix[j][i]: "+matrix[j][i]);
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }
	}
	
	//Refer this
	public static void rotate1(int[][] matrix) {
	    int s = 0, e = matrix.length - 1;
	    while(s < e) {
	        int[] temp = matrix[s];
	        matrix[s] = matrix[e];
	        matrix[e] = temp;
	        s++; 
	        e--;
	        System.out.println("s: "+s+" e: "+e);
	    }
	    
	    printMatrix(matrix);
	  
	    for(int i=0; i<matrix.length; i++) {
	        for(int j=i+1; j< matrix[i].length; j++) {
	        	System.out.println("i: "+i+" j: "+j+" matrix[i][j]: "+matrix[i][j]+" matrix[j][i]: "+matrix[j][i]);
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }
	}
	
	public static void rotate(int[][] matrix) {
	    int s = 0, e = matrix.length - 1;
	    while(s < e) {
	        int[] temp = matrix[s];
	        matrix[s] = matrix[e];
	        matrix[e] = temp;
	        s++;
	        e--;
	        System.out.println("s: "+s+" e: "+e);
	    }
	    
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix[i].length; j++) {
	        	System.out.print(matrix[i][j]+" ");
	        }
	        System.out.println();
	     }

	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = i+1; j < matrix[i].length; j++) {
	        	System.out.println("i: "+i+" j: "+j+" matrix[i][j]: "+matrix[i][j]+" matrix[j][i]: "+matrix[j][i]);
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }
	    
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix[i].length; j++) {
	        	System.out.print(matrix[i][j]+" ");
	        }
	        System.out.println();
	     }
	}
	
	
	public static char[][] mirrorImage(char[][] image) {
		printMatrix1(image);
		
		int r = image.length-1;
		int c = image[0].length-1;

		System.out.println("r: "+r+" c: "+c);
		
		for(int i=0; i<=r; i++) {
			for(int j=0; j<c; j++) {
				System.out.println("i: "+i+" j: "+j+" image[i][j]: "+image[i][j]);
				char temp = image[i][j];
				image[i][j] = image[i][j+1];
				image[i][j+1] = temp;
			}
		}
		printMatrix1(image);
		
		return image;
	}

	public static char[][] mirrorImage1(char[][] image) {
		printMatrix1(image);
		
		int r = image.length;
		int c = image[0].length;

		System.out.println("r: "+r+" c: "+c);
		
		for(int i=0; i<r; i++) {
			int s = 0;
			int e = image.length - 1;
			
			for(int j=s; j<e;) {
				//System.out.println("i: "+i+" j: "+j+" image[i][j]: "+image[i][j]);
				
				char temp = image[i][j];
				image[i][j] = image[i][j+1];
				image[i][j+1] = temp;
				s++;
				j--;
			}
		}
		
		for(int i=0; i<image.length; i++) {
			int s = 0;
			int e = image.length - 1;
			
			while(s < e) {
		        char temp = image[i][s];
		        image[i][s] = image[i][e];
		        image[i][e] = temp;
		        s++;
		        e--;
		        System.out.println("s: "+s+" e: "+e);
		    }
		}
		printMatrix1(image);
		
		return image;
	}

	
	public static void main(String[] args) {
		int[][] matrix = {
			                 {1,2,3},
			                 {4,5,6},
			                 {7,8,9}
		                 };
		
		
		rotate1(matrix);
		System.out.println();
		//antiRotate(matrix);
		
		//System.out.println();
		printMatrix(matrix);
		
		char[][] arr = {
						{'a','c'},
						{'f','g'}
					   };
		
		//System.out.println(mirrorImage(arr));
		
		char[][] arr1 = {
				{'a','c','d'},
				{'f','g','h'},
				{'i','j','k'}
			   };
		
		//System.out.println(mirrorImage1(arr1));
	}
	
	public static void printMatrix1(char[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
	        for(int j=0; j<matrix[i].length; j++) {
	        	System.out.print(matrix[i][j]+" ");
	        }
	        System.out.println();
	     }
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
	        for(int j=0; j<matrix[i].length; j++) {
	        	System.out.print(matrix[i][j]+" ");
	        }
	        System.out.println();
	     }
	}
}
