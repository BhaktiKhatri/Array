package Array;

import java.util.Arrays;

/*
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 * Example 1:Input: [3,1,2,4]; Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * Note: 1 <= A.length <= 5000;0 <= A[i] <= 5000
 * Explanation and Solution: Approach 3: In-Place https://leetcode.com/problems/sort-array-by-parity/solution/
 * Time Complexity: O(N), where N is the length of A. Each step of the while loop makes j-i decrease by at least one. (Note that while quicksort is O(NlogN) normally, this is O(N) because we only need one pass to sort the elements.)
 * Space Complexity: O(1) in additional space complexity. 
 */

public class SortArrayByParity {

	//This will swap if all elements are even which is not required so it is not efficient solution
    public static int[] sortArrayByParity(int[] A) {
    	System.out.println(Arrays.toString(A));
    	
        for(int i=0, j=0; j<A.length; j++) {
        	System.out.println("i: "+i+" j: "+j+" A[i]: "+A[i]+" A[j]: "+A[j]);
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;
            }
        }
        return A;
    }
    
    //Refer this
    public static int[] sortArrayByParity1(int[] A) {
        if(A == null)
            return null;
        
        System.out.println("A: "+Arrays.toString(A));
        
        int i = 0;
        int j = A.length - 1;
        
        System.out.println("i: "+i+" j: "+j);
        
        while(i < j) {
        	System.out.println("i: "+i+" j: "+j+" A[i]: "+A[i]+" A[j]: "+A[j]);
        	
        	if((A[i] % 2) != (A[j] % 2) && A[i]!=0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
            else {
                i++;
            }
        }
        
        return A;
    }
    
    public static int[] sortArrayByParity2(int[] A) {
        if(A == null)
            return null;
        
        System.out.println("A: "+Arrays.toString(A));
        
        int i = 0;
        int j = A.length - 1;
        System.out.println("i: "+i+" j: "+j);
        
        while(i < j) {
        	System.out.println("i: "+i+" j: "+j+" A[i]: "+A[i]+" A[j]: "+A[j]);
        	
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) {
                i++;
            }
            
            if (A[j] % 2 == 1)  { 
                j--;
            }
        }

        return A;
    }
	
	public static void main(String[] args) {
		int[] A = {0,1,2};
		A = sortArrayByParity2(A);
		System.out.println(Arrays.toString(A));
	}
}