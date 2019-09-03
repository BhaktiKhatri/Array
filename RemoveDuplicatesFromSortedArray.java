package Array;

import java.util.Arrays;

/**
 * Leetcode 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Example 1: Given nums = [1,1,2]
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * Example 2: Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * Time complexity : O(n). Assume that n is the length of array. Each of i and j traverses at most n steps; Space complexity : O(1)
 * Microsoft, Facebook, Bloomberg
 * Easy
 */

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		
		System.out.println(Arrays.toString(arr));
		
		int i = 0;
		for(int j=1; j<arr.length; j++) {
			
			System.out.println("i: "+i+" j: "+j+" arr[i]: "+arr[i]+" arr[j]: "+arr[j]);
			
			if(arr[j] != arr[i]) {
				i++;
				arr[i] = arr[j];
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		return i+1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,2,4,5};
		System.out.println(removeDuplicates(arr));
	}

}
