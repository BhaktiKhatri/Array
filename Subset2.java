package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/description/
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example: Input: [1,2,2]
 * Output:
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
 * Explanation and Code from: https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 * Facebook
 * Medium
 */

public class Subset2 {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		
		System.out.println("nums: "+Arrays.toString(nums));
		
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}
	
	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		System.out.println("start: "+start+" tempList: "+tempList);
		
		list.add(new ArrayList<>(tempList));
		
		for(int i=start; i<nums.length; i++) {
			System.out.println("i: "+i+" nums[i]: "+nums[i]+" tempList: "+tempList);
			
			if(i > start && nums[i] == nums[i-1]) 
				continue;
			
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i+1);
			
			System.out.println("i: "+i+" nums[i]: "+nums[i]+" start: "+start+" tempList: "+tempList);
			
			tempList.remove(tempList.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,2};
		System.out.println(subsetsWithDup(nums));
	}

}
