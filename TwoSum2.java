package Array;

import java.util.Arrays;

/**
 * Leetcode 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * Input: numbers={2, 7, 11, 15}, target=9; Output: index1=1, index2=2
 * @author NisuBhakti
 * Time Complexity: O(logN); Space Complexity: O(1)
 */

public class TwoSum2 {

	public static int[] twoSum(int[] arr, int target) {
		int[] result = new int[2];
		int low = 0, high = arr.length-1;
		
		System.out.println("arr: "+Arrays.toString(arr)+" target: "+target+" low: "+low+" high: "+high);
		
		while(low < high) {
			System.out.println("low: "+low+" high: "+high+" arr[low]: "+arr[low]+" arr[high]: "+arr[high]);
			
			if(arr[low] + arr[high] == target) {
				result[0] = low + 1;
				result[1] = high + 1;
				break;
			}
			else if(arr[low] + arr[high] > target) {
				high--;
			}
			else {
				low++;
			}
		}
		System.out.println("result: "+Arrays.toString(result));
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(arr, target)));
	}

}
