package Array;

import java.util.Arrays;

/**
 * Leetcode 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.
 * Example 1: Input: [1,3,5,6], 5; Output: 2
 * @author NisuBhakti
 * Time Complexity: O(N) as we are using binary search
 */

public class SearchInsertPosition {

	public static int searchInsert(int[] A, int target) {
		int low = 0, high = A.length - 1;
		System.out.println("A: "+Arrays.toString(A)+" low: "+low+" high: "+high+" target: "+target);
		
		while(low <= high) {
			int mid = (low + high) / 2;
			System.out.println("mid: "+mid+" low: "+low+" high: "+high);
			
			if(A[mid] == target) 
				return mid;
			else if(A[mid] > target)
				high = mid - 1;
			else 
				low = mid + 1;
		}
		System.out.println("low: "+low);
		return low;
	}
	
	public static int searchInsert1(int[] A, int target) {
		int low = 0, high = A.length;
		System.out.println("A: "+Arrays.toString(A)+" low: "+low+" high: "+high+" target: "+target);
		
		while(low < high) {
			int mid = low + (high - low) / 2; // low<=mid, mid<high
			System.out.println("mid: "+mid+" low: "+low+" high: "+high);

			if(A[mid] == target) {
				return mid;
			}
			else if(A[mid] > target) {
				high = mid; // high always decreases (even high-low==1)
			}
			else {
				low = mid + 1; // low always increases
			}
		}
		System.out.println("low: "+low);
		return low;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,6};
		System.out.println(searchInsert(arr, 2));
	}

}
