package Array;

import java.util.Arrays;

/**
 * Leetcode 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too. 
 * You need to find the shortest such subarray and output its length.
 * Input: [2, 6, 4, 8, 10, 9, 15] Output: 5; You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * @author NisuBhakti
 * Time Complexity: O(N); Space Complexity: O(1)
 */

public class ShortestUnsortedContinuousSubarray {

	public static int findUnsortedSubarray(int[] A) {
	    int n=A.length;
	    int start = -1;
	    int end = -2;
	    int min = A[n-1];
	    int max = A[0];
	    
	    for(int i=1;i<n;i++) {
	    	int x = A[i];
	    	int y = A[n-1-i];
	    	max = Math.max(max, x);
	    	min = Math.min(min, y);
	    	System.out.println("x: "+x+" y: "+y+" min: "+min+" max: "+max);
	    	if (x < max) 
	    		end = i;
	    	if (y > min) 
	    		start = n-1-i; 
	    	System.out.println("beg: "+start+" end: "+end);
	    }
	    return end - start + 1;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 6, 4, 8, 10, 9, 15};
		System.out.println(Arrays.toString(arr));
		System.out.println(findUnsortedSubarray(arr));
	}

}
