package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * @author NisuBhakti
 * Time Complexity: O(n); Space Complexity: O(n)
 */

public class NumbersDisappearedInArray {
	
	/**
	 * The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1]. 
	 * In this way all the numbers that we have seen will be marked as negative. 
	 * In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, so just add it to the return list.
	 * @param nums: given array
	 * @return: list of disappeared numbers
	 */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			System.out.println("i: "+i+" val: "+val+" nums[val]: "+nums[val]);
			if(nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}
		System.out.println(Arrays.toString(nums));
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > 0) {
				result.add(i+1);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {4,3,2,7,8,2,3,1};
		System.out.println(Arrays.toString(arr));
		System.out.println(findDisappearedNumbers(arr));
	}

}
