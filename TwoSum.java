package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * @author NisuBhakti
 * Time complexity : O(n). We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
 */
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();	//key-array element; value-index
		int complement = 0;
		
		System.out.println("nums: "+Arrays.toString(nums)+" target: "+target);
		
		for(int i=0; i<nums.length; i++) {
			complement = target - nums[i];
			if(map.containsKey(complement)) {
				result[0] = map.get(complement);
				result[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 12, 11, 7};
		int[] result = TwoSum.twoSum(arr, 9);
		
		System.out.println("ans: "+Arrays.toString(result));
	}
}
