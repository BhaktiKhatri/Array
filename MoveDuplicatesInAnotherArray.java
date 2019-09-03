package Array;

import java.util.Arrays;

/**
 * Given an array of integers, how would you move the duplicate integers into a different array? What is the efficiency of your algorithm?  
 * http://www.geeksforgeeks.org/remove-duplicates-sorted-array/
 * @author NisuBhakti
 * Time Complexity: O(n); Space Complexity: O(n)
 */

public class MoveDuplicatesInAnotherArray {

	public static int[] moveDuplicates(int[] arr) {
		if(arr.length == 0 || arr.length == 1)
			return arr;
		
		int j=0;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] != arr[i+1]) {
				arr[j++] = arr[i];
			}
		}
		
		arr[j++] = arr[arr.length-1];
		int[] res = new int[j];
		
		for(int i=0; i<j; i++) {
			res[i] = arr[i];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,2,4,3,3,5,6,7,7,7};
		int[] result = moveDuplicates(arr);
		System.out.println(Arrays.toString(result));
	}

}
