package Array;

import java.util.Arrays;

/**
 * Leetcode 27. Remove Element
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * https://leetcode.com/problems/remove-element/description/
 * @author NisuBhakti
 * Time Complexity: O(n); Space Complexity: O(1)
 */

public class RemoveElement {

	public static int removeElement(int[] arr, int val) {
		System.out.println("arr: "+Arrays.toString(arr)+" val: "+val);
		
		int i = 0;
		for(int j=0; j<arr.length; j++) {
			System.out.println("i: "+i+" j: "+j+" arr[i]: "+arr[i]+" arr[j]: "+arr[j]);
			if(arr[j] != val) {
				arr[i++] = arr[j];
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
		int arr[] = {3,2,2,3};
		System.out.println(removeElement(arr, 3));
	}

}
