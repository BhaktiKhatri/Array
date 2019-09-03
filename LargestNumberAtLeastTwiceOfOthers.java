package Array;

/**
 * Leetcode 747. Largest Number At Least Twice of Others
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 * In a given integer array nums, there is always exactly one largest element. Find whether the largest element in the array is at least twice as much as every other number in the array. 
 * If it is, return the index of the largest element, otherwise return -1.
 * Input: nums = [3, 6, 1, 0]; Output: 1; 6 is the largest integer, and for every other number in the array x, 6 is more than twice as big as x. The index of value 6 is 1, so we return 1.
 * @author NisuBhakti
 * Time Complexity: O(N) where N is the length of nums; Space Complexity: O(1), the space used by our int variables.
 */

public class LargestNumberAtLeastTwiceOfOthers {

	/**
	 * Scan through the array to find the unique largest element i, keeping track of it's index maxIndex. 
	 * Scan through the array again. If we find some x != i with i < 2*x, we should return -1. Otherwise, we should return maxIndex.
	 * @param nums: given integer array
	 * @return return the index of the largest element in the array is at least twice as much as every other number in the array, otherwise return -1.
	 */
	public static int dominantIndex(int[] nums) {
		int maxIndex = 0;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] > nums[maxIndex]) {
				maxIndex = i;
			}
		}
		
		for(int i=0; i<nums.length; i++) {
			if(maxIndex != i && nums[maxIndex] < 2 * nums[i])
				return -1;
		}
		
		return maxIndex;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,6};
		System.out.println(dominantIndex(arr));
	}
}
