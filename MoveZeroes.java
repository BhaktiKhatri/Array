package Array;

import java.util.Arrays;

/**
 * Leetcode 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 * https://www.youtube.com/watch?v=0jXTju134Hw
 * @author NisuBhakti
 * Time Complexity: O(n) Space Complexity: O(1)
 */

public class MoveZeroes {
	
	public static void moveZeros(int arr[]) {
		if(arr == null || arr.length == 0) {
			return;
		}
		
		System.out.println(Arrays.toString(arr));
		
		int insertPosition = 0;
		
		for(int num: arr) {
			System.out.println("num: "+num+" insertPosition: "+insertPosition+" arr[insertPosition]: "+arr[insertPosition]+" "+Arrays.toString(arr));
		
			if(num != 0) {
				arr[insertPosition] = num;
				insertPosition++;
			}
		}
		System.out.println(Arrays.toString(arr)+" insertPosition: "+insertPosition);
		
		while(insertPosition < arr.length) {
			arr[insertPosition] = 0;
			insertPosition++;
		}
	}
	
	public static void main(String args[]) {
		int[] arr = {0, 1, 0, 3, 12};
		moveZeros(arr);
		System.out.println(Arrays.toString(arr));
	}
}