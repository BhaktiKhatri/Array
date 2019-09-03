package Array;

import java.util.Arrays;

/**
 * Leetcode 370. Range Addition
 * https://leetcode.com/problems/range-addition/description/
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex..endIndex] (startIndex and endIndex inclusive) with inc
 * Return the modified array after all k operations were executed.
 * Given: length = 5, updates = [
 * 							        [1,  3,  2],
 * 							        [2,  4,  3],
 * 							        [0,  2, -2]
 * 							    ]
 * Output: [-2, 0, 3, 5, 3]
 * Initial state: [ 0, 0, 0, 0, 0 ]
 * After applying operation [1, 3, 2]: [ 0, 2, 2, 2, 0 ]
 * After applying operation [2, 4, 3]: [ 0, 2, 5, 5, 3 ]
 * After applying operation [0, 2, -2]: [-2, 0, 3, 5, 3 ]
 * Explanation and Code from: https://leetcode.com/problems/range-addition/discuss/84217 
 * Time Complexity: O(K+N), Each of the k update operations is done in constant O(1) time. The final cumulative sum transformation takes O(N) time always.
 * Space complexity : O(1), No extra space required.
 * Google
 * Medium
 */

public class RangeAddition {

	/*
	 	We update the value at start index, because it will be used in the future when we are adding up the values for the sum at each index between 
	 	start index and end index (both inclusive). We update the negative value at the end index + 1, because the positive value of it should be
	 	only added at its previous indices (from start index to end index). Thus, when we accumulate the sum at the end for each index, we will get
	 	the correct values for each index. If the end index is the last index in the resulting array, we don’t have to do the end index + 1 part, 
	 	because there is no more index after the last index and there will be no error when we accumulate the sum.
	 */
	public static int[] getModifiedArray(int length, int[][] updates) {
	    int[] res = new int[length];
	    
	     for(int[] update : updates) {
	    	 System.out.println("update: "+Arrays.toString(update));
	    	 
	        int value = update[2];
	        int start = update[0];
	        int end = update[1];
	        
	        System.out.println("value: "+value+" start: "+start+" end: "+end);
	        System.out.println("res: "+Arrays.toString(res));
	        
	        res[start] = res[start] + value;
	        System.out.println("res[start]: "+res[start]);
	        
	        if(end < length - 1) {
	        	System.out.println("res[end+1]: "+res[end+1]);
	            res[end + 1] = res[end + 1] - value;
	        }
	        System.out.println("res: "+Arrays.toString(res));
	     }
	    
	     System.out.println("res: "+Arrays.toString(res));
	     for(int i=0; i<length-1; i++) {
	    	 System.out.println("i: "+i+" res[i]: " +res[i]+" res[i+1]: "+res[i+1]);
	    	 res[i+1] = res[i+1] + res[i];
	     }
	     System.out.println("res: "+Arrays.toString(res));
	     
	    return res;
	}
	
	public static void main(String[] args) {
		int length = 5;
		int[][] updates = {
		                   {1,  3,  2},
		                   {2,  4,  3},
		                   {0,  2, -2}
						  };
		System.out.println(Arrays.toString(getModifiedArray(length, updates)));
	}

}
