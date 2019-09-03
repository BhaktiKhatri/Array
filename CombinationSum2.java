package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/description/
 * Code from https://leetcode.com/problems/combination-sum/discuss/16502
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. 
 * Each number in C may only be used once in the combination.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, A solution set is: [[1, 7], [1, 2, 5], [2, 6], [1, 1, 6]]
 * Time Complexity: O(N)
 * Snapchat
 * Medium
 */

public class CombinationSum2 {

	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}
	
	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if(remain < 0) 
			return;
	    else if(remain == 0) 
	    	list.add(new ArrayList<>(tempList));
	    else {
	        for(int i=start; i<nums.length; i++){
	            if(i > start && nums[i] == nums[i-1]) 
	            	continue; // skip duplicates
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i + 1);
	            tempList.remove(tempList.size() - 1); 
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] candidate = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		System.out.println(combinationSum(candidate, target));
	}
}